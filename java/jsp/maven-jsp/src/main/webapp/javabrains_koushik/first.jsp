<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <%
        out.println("testing JSP");
    %>

    <%!
        public int add(int a, int b){
                return (a+b);
        }
    %>
    <br />

    sum of 1+2 is <%=add(1, 2)%>
    <br />

    <%
        int a = 3;
        int b = 4;
        int k = a+b;
    %>
    value of k is <%=k%>
    <br />

    <%
        for(int i = 0; i<5; i++){
            %>
            <%=i%>
            <%
        }
    %>
</body>
</html>
