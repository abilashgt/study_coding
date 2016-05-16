<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Login successful</h1>
    <%
        String me = (String) session.getAttribute("me");
    %>

    <jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">
        <jsp:setProperty name="user" property="userName" value="NewUser" />
    </jsp:useBean>

    (Session <%=me%>) <br />

    Hello JSTL: <jsp:getProperty name="user" property="userName" />
</body>
</html>
