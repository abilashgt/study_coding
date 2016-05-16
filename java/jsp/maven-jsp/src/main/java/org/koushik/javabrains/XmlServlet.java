package org.koushik.javabrains;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XmlServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("XML servlet called!");
        response.getWriter().println("XML Servlet GET method - on the page");
        response.getWriter().println("Init Params 1: " + this.getServletConfig().getInitParameter("initparam1"));
    }
}
