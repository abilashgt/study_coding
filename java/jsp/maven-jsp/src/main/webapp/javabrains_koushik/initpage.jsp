<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%!
        public void jspInit(){
            ServletConfig config = getServletConfig();
            ServletContext context = getServletConfig().getServletContext();

            String initparam1 = config.getInitParameter("initparam1");

            context.setAttribute("initparam2", initparam1 + " param 2 in jsp");
        }
    %>

    InitParam1 = <%=getServletConfig().getInitParameter("initparam1")%> <br />
    InitParam2 = <%=getServletConfig().getServletContext().getAttribute("initparam2")%>
</body>
</html>
