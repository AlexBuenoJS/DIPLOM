package org.example.springboot.html;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String location = req.getParameter("Рязань");
        String type = req.getParameter("Апартоменты");
        if(Objects.equals(location, "Рязань") && Objects.equals(type, "Апартоменты")) {
            req.setAttribute("Рязань", location);
            req.setAttribute("Апартоменты", type);
            RequestDispatcher dispatcher = req.getRequestDispatcher("result.html");
            dispatcher.forward(req, resp);
        }else
        {
            if (Objects.equals(location, "Москва") && Objects.equals(type, "Апартоменты"))
            {
                req.setAttribute("Рязань", location);
                req.setAttribute("Апартоменты", type);
                RequestDispatcher dispatcher = req.getRequestDispatcher("result2.html");
                dispatcher.forward(req, resp);
            }
        }
    }
}