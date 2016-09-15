import DTO.News;
import DTO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        if (userDAO.checkUser(login, password)) {
            User user = userDAO.findUserByLogin(login);
            request.setAttribute("name", user.getName());
            request.setAttribute("surname", user.getSurname());
            NewsDAO newsDAO = new NewsDAO();
            List<News> allNews = newsDAO.findAll();
            request.setAttribute("allNews", allNews);
            request.getRequestDispatcher("news.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
