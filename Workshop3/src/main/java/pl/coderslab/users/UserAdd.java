package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/addUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();

        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        User user = new User(userEmail, userName, userPassword);
        userDAO.create(user);
        response.sendRedirect(request.getContextPath() + "/user/list");

    }
}