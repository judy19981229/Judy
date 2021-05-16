<%--
  Created by IntelliJ IDEA.
  User: judy
  Date: 2021/5/14
  Time: 11:16 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    <h1>${user.age}</h1>
    <h1>${user.name}</h1>
</body>
</html>
