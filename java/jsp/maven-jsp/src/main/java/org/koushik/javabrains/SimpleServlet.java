package org.koushik.javabrains;

import com.sun.org.apache.bcel.internal.generic.ILOAD;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Simple Servlet", urlPatterns = {"/SimpleServlet"},
        initParams = {@WebInitParam(name = "initparam1", value = "default User")}
)
public class SimpleServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Hello from Servlet GET method");

        //get parameter
        String name = request.getParameter("name");

        //session
        HttpSession session = request.getSession();
        if(name!=null && name!=""){
            session.setAttribute("name", name);
        }

        PrintWriter out = response.getWriter();
        out.println("Hello from Servlet GET method - on the page");
        out.println("Hi " + session.getAttribute("name"));
        out.println("Init Params 1: " + this.getServletConfig().getInitParameter("initparam1"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Hello from Servlet GET method");

        //Post parameters
        String name = request.getParameter("name");
        String locations[] = request.getParameterValues("location");

        //session
        HttpSession session = request.getSession();
        if(name!=null && name!=""){
            session.setAttribute("name", name);
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("Hello from Servlet GET method - on the page");
        out.println("Hi " + name + "( session - " + session.getAttribute("name") + ")");

        if(locations!=null) {
            out.println("Locations:");
            for (String location : locations) {
                out.print(location + ",");
            }
        }
        out.print("");
    }
}
