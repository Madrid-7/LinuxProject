<%@ page import="com.zxf.User" %><%--
  Created by IntelliJ IDEA.
  User: distance
  Date: 2021/3/25
  Time: 上午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        // 用户未登录
        response.sendRedirect("/login.html");
        return;
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>发表文章</h1>
    <a href="/logout">退出</a>
    <form method="post" action="/publish" enctype="multipart/form-data">
        <div>
            <label>图片:</label>
            <input type="file" name="image">
        </div>
        <div>
            <label>头图:</label>
            <input type="text" name="title">
        </div>
        <div>
            <label>正文:</label>
            <textarea name="body"></textarea>
        </div>
        <div>
            <button type="submit">发表</button>
        </div>
    </form>
</body>
</html>
