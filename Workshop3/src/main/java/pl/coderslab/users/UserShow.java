package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);
        UserDAO userDAO = new UserDAO();
        request.setAttribute("user", userDAO.read(idNumber));
        getServletContext().getRequestDispatcher("/users/showUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}