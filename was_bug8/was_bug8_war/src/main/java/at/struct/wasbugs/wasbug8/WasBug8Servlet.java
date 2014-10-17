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

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
@WebServlet(urlPatterns = "/warmup")
public class WasBug8Servlet extends HttpServlet {
    public static final Logger log = Logger.getLogger(WasBug8Servlet.class.getName());

    private @Inject WasBug8CdiExtension wasBug8Extension;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        log.info("\n\n\nSERVLET REQUESSSSTTTTT GOOOOOO!\n\n\n");
        int i=1;
        for (Class c : wasBug8Extension.getClassList()) {
            i++;
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new ServletException(e);
            }
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/html");
        resp.getWriter().append("<html><body>OK</body></html>");
    }
}
