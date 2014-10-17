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
package at.struct.wasbugs.wasbug8;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * A sample extension which really takes a looong time to boot
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class WasBug8CdiExtension implements Extension {
    private static final Logger log = Logger.getLogger(WasBug8CdiExtension.class.getName());

    private List<Class<?>> classList = new ArrayList<Class<?>>();

    public void onInit(@Observes BeforeBeanDiscovery bbd) {
        log.info("We now begin to start the CDI container");
    }


    public void scanMyClasses(@Observes ProcessAnnotatedType pat) throws Exception {
        log.info("scanning class " + pat.getAnnotatedType().getJavaClass().getName());
        Thread.sleep(10L);
        classList.add(pat.getAnnotatedType().getJavaClass());
    }

    public void finished(@Observes AfterDeploymentValidation adv) {
        log.info("We are almost finished with the CDI container boot now...");
    }


    public List<Class<?>> getClassList() {
        return classList;
    }
}
