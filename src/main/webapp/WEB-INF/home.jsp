<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

<div>
    <h1>Home</h1>
    <a href="<%=request.getContextPath()%>/login">로그인</a>
</div>

<%= request.getAttribute("homeMsg") %>

</body>
</html>