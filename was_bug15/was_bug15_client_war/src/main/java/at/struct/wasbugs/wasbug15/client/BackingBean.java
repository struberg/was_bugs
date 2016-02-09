/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package at.struct.wasbugs.wasbug15.client;

import at.struct.wasbugs.wasbug15.remote.RemoteConnector;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Sample backing bean
 */
@RequestScoped
@Named
public class BackingBean {
    private final static Logger LOGGER = Logger.getLogger(BackingBean.class.toString());

    private @Inject TestService testService;
    private @Inject RemoteConnector remoteConnector;

    public String getMeaningOfLife() {
        LOGGER.info("Call RemoteEJB");
        String s = "Call RemoteEJB: -> ";
        try {
            s = remoteConnector.testConn();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("call @Injected Services");
        return s + " now add @Injected Services: " + testService.testwrite();
    }

    public String testVwpArchiv() {
        try {
            LOGGER.info("Call VWP EJB");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("call @Injected Services");
        return testService.testwrite();
    }
}
