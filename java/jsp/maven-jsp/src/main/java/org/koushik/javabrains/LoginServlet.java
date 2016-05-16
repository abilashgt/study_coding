package org.koushik.javabrains;

// used the editor to generate the servlet

import org.koushik.javabrains.dto.User;
import org.koushik.javabrains.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/javabrains_koushik/mvc/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenicate(userId, password);

        if(result){
            User user  = loginService.getUser(userId);
            request.getSession().setAttribute("me", "abilash"); //can pass any object
            request.setAttribute("user",user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
            return;
        }
        else{
            response.sendRedirect("login.jsp");
            return;
        }
    }
}
