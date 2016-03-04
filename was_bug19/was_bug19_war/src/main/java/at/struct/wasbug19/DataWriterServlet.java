package at.struct.wasbug19;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/writeIt")
public class DataWriterServlet extends HttpServlet {

    private @Inject SimpleService simpleService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        simpleService.insertData(1000);
        resp.sendRedirect("index.jsp?inserted=1000");
    }
}
