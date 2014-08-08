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
package at.struct.wasbugs.wasbug6;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Demonstrate a bug in WAS which does also pass in the handled
 * Annotation class itself to onStartup!
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@HandlesTypes(MyHandledAnnotation.class)
public class MyServletContainerInitializer implements ServletContainerInitializer
{
    private static final Logger log = Logger.getLogger(MyServletContainerInitializer.class.getName());

    private static Integer nrClasses = null;

    public static Integer getNrClasses()
    {
        return nrClasses;
    }

    @Override
    public void onStartup(Set<Class<?>> handledClasses, ServletContext ctx) throws ServletException
    {
        log.info("Got " + handledClasses.size() + " classes to handle. Should be exactly 1");

        if (handledClasses == null || handledClasses.isEmpty())
        {
            throw new ServletException("Got no handled classes at all! ");
        }

        if (handledClasses.size() != 1)
        {
            throw new ServletException("Expected only 1 class but got " + handledClasses.size() +
                                       ". Classes are: " + Arrays.toString(handledClasses.toArray()));
        }

        nrClasses = handledClasses.size();
    }
}
