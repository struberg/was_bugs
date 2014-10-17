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
package at.struct.wasbugs.wasbug7;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * WebService which uses a CDI bean to do the actual work.
 *
 * On WAS calling this service first trashes the CDI bean.
 *
 * Otoh, if the {@link WasBug7Servlet}
 * gets invoked first all is fine.
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@Stateless
@WebService(portName="Was7BugPort", serviceName = "Was7BugService", targetNamespace = "http://apache.org/tomee/wasbugws",
            endpointInterface = "at.struct.wasbugs.wasbug7.WasBug7WebService")
public class WasBug7WebServiceImpl implements WasBug7WebService
{
    private @Inject WasBug7CdiService cdiService;

    public String getState()
    {
        return cdiService.doTheRealBusiness();
    }
}
