package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import model.User;
import service.AuthService;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AuthService authService = new AuthService();
        User user = authService.login(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("views/auth/login.jsp?error=1");
        }
    }
}