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
package at.struct.wasbugs.wasbug13.be;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@Lock(value = LockType.WRITE)
public class BrokenSingleton {

    private static final Logger log = Logger.getLogger(BrokenSingleton.class.getName());


    private @Inject TimerMonitor monitor;

    private @Resource TimerService timerService;


    @PostConstruct
    public void init() {
        timerService.createIntervalTimer(0, TimeUnit.MINUTES.toMillis(1), new TimerConfig());
    }


    @Timeout
    public void doSomething(Timer timer)
    {
        monitor.setTimer(timer.getNextTimeout());
        log.log(Level.INFO, "Hey, seems WAS is not broken anymore -> congratulation you've fixed it");
    }



}
