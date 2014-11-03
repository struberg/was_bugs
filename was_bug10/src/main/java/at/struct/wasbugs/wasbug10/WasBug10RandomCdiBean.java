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
package at.struct.wasbugs.wasbug10;

import javax.enterprise.context.RequestScoped;

/**
 * Just a random CDI bean which gets invoked in
 * {@link at.struct.wasbugs.wasbug10.WasBug10StartupSingleton}s
 * PostConstruct init method.
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@RequestScoped
public class WasBug10RandomCdiBean
{
    public static boolean initialized = false;

    public int getMeaningOfLife()
    {
        initialized = true;
        return 42;
    }
}
