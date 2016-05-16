<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        // request
        // session
        // application //context
        String name = request.getParameter("name");

        if(name != null){
            //session.setAttribute("name", name);
            //application.setAttribute("name", name);
            pageContext.setAttribute("name", name);
            pageContext.setAttribute("name", name, pageContext.SESSION_SCOPE);
            pageContext.setAttribute("name", name, pageContext.APPLICATION_SCOPE);
        }

        String age = request.getParameter("age");
        // or //pageContext.setAttribute("age", age, pageContext.APPLICATION_SCOPE);
        pageContext.setAttribute("age", age, pageContext.SESSION_SCOPE);
    %>
    <p>name in request object = <%=name%> </p>
    <p>age in request object = <%=age%> </p>
    <p>name in session object = <%=session.getAttribute("name")%> </p>
    <p>name in application object = <%=application.getAttribute("name")%> </p>
    <p>name in page context object = <%=pageContext.getAttribute("name")%> </p>
    <p>age in page context object's find attribute method = <%=(String) pageContext.findAttribute("age")%> </p>
</body>
</html>
