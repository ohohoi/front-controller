<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<div>
    <h1>Login</h1>
    <a href="<%=request.getContextPath()%>/home">홈으로</a>
</div>

<form id="loginForm" action="<%=request.getContextPath()%>/login" method="post">
    <label for="loginId">아이디</label>
    <input type="text" id="loginId" name="loginId" required>

    <button type="submit">로그인</button>
</form>



</body>
</html>