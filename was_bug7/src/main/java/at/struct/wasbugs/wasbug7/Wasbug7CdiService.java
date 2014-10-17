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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.logging.Logger;

/**
 * This CDI Service should do the actual work.
 * It might get used by the GUI (e.g. JSF backing bean)
 * or by WebServices.
 *
 * In production the transaction are handled via DeltaSipke &#064;Transactional
 * We simulate this by directly injecting a UserTransaction.
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@ApplicationScoped
public class WasBug7CdiService
{
    private static Logger log = Logger.getLogger(WasBug7CdiService.class.getName());

    private @Resource UserTransaction userTransaction;

    // oh and btw, private postconstruct methods do work neither on WAS :(
    @PostConstruct
    public void init()
    {
        log.info("CDI service initialisation. userTransaction is " + userTransaction);
    }

    public String doTheRealBusiness()
    {
        log.info("start with doTheRealBusiness");
        if (userTransaction == null)
        {
            throw new IllegalStateException("Whoops BUG found - UserTransaction did not get injected!");
        }

        try
        {
            if (userTransaction.getStatus() != Status.STATUS_ACTIVE)
            {
                throw new IllegalStateException("Whoops, seems like the Transaction is not active!");
            }
        }
        catch (SystemException e)
        {
            throw new RuntimeException(e);
        }

        return "looksGood";
    }
}
