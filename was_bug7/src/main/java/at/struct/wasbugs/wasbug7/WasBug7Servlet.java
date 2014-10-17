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

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;

/**
 * WebService which uses a CDI bean to do the actual work.
 *
 * On WAS calling {@link at.struct.wasbugs.wasbug7.WasBug7WebService} first trashes the CDI bean.
 *
 * Otoh, all is perfectly fine if this servlet gets invoked first.
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@WebServlet(urlPatterns = "/warmup")
public class WasBug7Servlet extends HttpServlet
{
    private @Inject UserTransaction userTransaction;

    private @Inject WasBug7CdiService cdiService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String status;
        try
        {
            userTransaction.begin();
            status = cdiService.doTheRealBusiness();
            userTransaction.rollback();
        }
        catch (Exception e)
        {
            throw new ServletException(e);
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/html");
        resp.getWriter().append("<html><body>Status is " + status + "</body></html>");
    }
}
