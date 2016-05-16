<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">
        <jsp:setProperty name="user" property="userName" param="userName" />
        <!-- not need to specify params since they are the same -->
        <!-- if all the properties matches, then below is enough
        jsp:setProperty property="*"
        -->
    </jsp:useBean>

    User Name: <jsp:getProperty name="user" property="userName" />
</body>
</html>
