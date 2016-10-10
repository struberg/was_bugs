package at.struct.wasbug21;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/writeIt")
public class DataWriterServlet extends HttpServlet {

    private @Inject SimpleService simpleService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        simpleService.insertData(20);
        resp.sendRedirect("index.jsp?inserted=10");
    }
}
