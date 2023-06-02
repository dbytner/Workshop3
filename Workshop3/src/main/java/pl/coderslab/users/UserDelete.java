package pl.coderslab.users;

import pl.coderslab.utils.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);
        UserDAO userDAO = new UserDAO();
        userDAO.delete(idNumber);
        response.sendRedirect(request.getContextPath() + "/user/list");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}