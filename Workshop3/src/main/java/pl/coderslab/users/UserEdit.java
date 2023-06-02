package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);
        UserDAO userDAO = new UserDAO();
        request.setAttribute("user", userDAO.read(idNumber));
        getServletContext().getRequestDispatcher("/users/editUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);
        User user = new User(userEmail, userName, userPassword);
        user.setId(idNumber);
        userDAO.update(user);
        response.sendRedirect(request.getContextPath() + "/user/list");



    }
}