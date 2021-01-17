<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 16.01.2021
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>

<html>
<head>
    <title>Title</title>

</head>
<body background="black">
<div>
    <h1>Welcome to Spring Boot Access Denied Error Page</h1>

    <h2>You are in Spring Boot Access Denied Error page</h2>
    <br><a href="/">home</a>
    <br><br>
    <%
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            out.println("User '" + auth.getName() + "' attempted to access the protected URL: ");
            out.println("<br>auth : "+auth.isAuthenticated());
            out.println("<br>Role : "+auth.getAuthorities());
        }
    %>

</div>

</body>
</html>
