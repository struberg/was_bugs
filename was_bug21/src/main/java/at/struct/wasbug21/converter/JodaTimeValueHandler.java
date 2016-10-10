/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package at.struct.wasbug21.converter;

import org.apache.openjpa.jdbc.meta.strats.AbstractValueHandler;
import org.apache.openjpa.jdbc.identifier.DBIdentifier;
import org.apache.openjpa.jdbc.kernel.JDBCStore;
import org.apache.openjpa.jdbc.meta.ValueMapping;
import org.apache.openjpa.jdbc.schema.Column;
import org.apache.openjpa.jdbc.schema.ColumnIO;
import org.apache.openjpa.meta.JavaTypes;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import java.util.Calendar;
import java.util.Date;


/**
 * As reported in early 2013 and fixed in 2015:
 * see https://issues.apache.org/jira/browse/OPENJPA-2341
 *
 * @author rsandtner@apache.org
 */
public class JodaTimeValueHandler extends AbstractValueHandler {

    public Column[] map(ValueMapping valueMapping, String name, ColumnIO columnIO, boolean b) {
        Column column = new Column();
        column.setIdentifier(DBIdentifier.newColumn(name));

        if (valueMapping.getType() == LocalDate.class || valueMapping.getType() == LocalTime.class) {
            column.setJavaType(JavaTypes.DATE);
        }
        else if (valueMapping.getType() == LocalDateTime.class) {
            column.setJavaType(JavaTypes.CALENDAR);
        }

        return new Column[]{column};
    }

    @Override
    public Object toDataStoreValue(ValueMapping vm, Object val, JDBCStore store) {
        if (vm.getType() == LocalTime.class) {
            return ((LocalTime) val).toDateTimeToday().toLocalDateTime().toDate();
        }
        else if (vm.getType() == LocalDate.class) {
            return ((LocalDate) val).toDate();
        }
        else if (vm.getType() == LocalDateTime.class) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(((LocalDateTime) val).toDate());

            return instance;
        }

        throw new IllegalStateException("only LocalTime, LocalDate and LocalDateTime can be handled with this ValueHandler");
    }

    @Override
    public Object toObjectValue(ValueMapping vm, Object val) {
        if (vm.getType() == LocalTime.class) {
            return LocalTime.fromDateFields((Date) val);
        }
        else if (vm.getType() == LocalDate.class) {
            return LocalDate.fromDateFields((Date) val);
        }
        else if (vm.getType() == LocalDateTime.class)
        {
            return LocalDateTime.fromCalendarFields((Calendar) val);
        }

        throw new IllegalStateException("only LocalTime, LocalDate and LocalDateTime can be handled with this ValueHandler");
    }
}
