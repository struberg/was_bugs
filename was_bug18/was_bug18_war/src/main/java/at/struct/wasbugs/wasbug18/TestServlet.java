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
package at.struct.wasbugs.wasbug18;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private @Inject EjbHolder ejbHolder;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();
        writer.append("cdiInjectedEmptyEjb=").append(ejbHolder.getCdiInjectedEmptyEjb().getState()).append("\n");
        writer.append("ejbInjectedEmptyEjb=").append(ejbHolder.getEjbInjectedEmptyEjb().getState()).append("\n\n");

        writer.append("cdiInjectedSessionContextEjb=").append(ejbHolder.getCdiInjectedSessionContextEjb().getState()).append("\n");
        writer.append("cdiInjectedSessionContextEjb sessionContext=").append(ejbHolder.getCdiInjectedSessionContextEjb().getSessionContext().toString()).append("\n\n");

        writer.append("ejbInjectedSessionContextEjb=").append(ejbHolder.getEjbInjectedSessionContextEjb().getState()).append("\n");
        writer.append("ejbInjectedSessionContextEjb sessionContext=").append(ejbHolder.getEjbInjectedSessionContextEjb().getSessionContext().toString()).append("\n\n");
    }
}
