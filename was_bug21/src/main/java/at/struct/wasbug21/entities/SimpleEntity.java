/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.struct.wasbug21.entities;

import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "SIMPLE_ENTITY")
public class SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMPLE_ENTITY_SQ")
    @SequenceGenerator(name = "SIMPLE_ENTITY_SQ", sequenceName = "SIMPLE_ENTITY_SQ", allocationSize = 1, initialValue = 104000000)
    @Column(name = "ID_")
    private Long id;

    @Version
    private int version;

    @Column(name = "NAME_", nullable = false, length = 100)
    private String name;

    @Column(name = "INTEGER_", nullable = false)
    private Integer aInteger;

    @Column(name = "DOUBLE_", nullable = false)
    private Double aDouble;

    @Column(name = "LOCALDATE_", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private LocalDate aLocalDate;

    protected SimpleEntity() {
    }


    public SimpleEntity(String name, Integer aInteger, Double aDouble, LocalDate aLocalDate) {
        this.name = name;
        this.aInteger = aInteger;
        this.aDouble = aDouble;
        this.aLocalDate = aLocalDate;
    }


    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public LocalDate getaLocalDate() {
        return aLocalDate;
    }
}
