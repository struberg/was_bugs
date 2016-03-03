package at.struct.wasbug19;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/loadIt")
public class LoadServlet extends HttpServlet {

    private @Inject LoadService loadService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Report> reports = loadService.loadData();

        resp.setContentType("text/plain");
        resp.getWriter().append("Loaded ").append(String.valueOf(reports.size())).append(" items!").append(System.getProperty("line.separator"));
        resp.getWriter().append("Everything is fine!");

    }
}
