<%--
  Created by IntelliJ IDEA.
  User: witt
  Date: 2018/5/15
  Time: 05:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>editItems</title>
</head>
<body>
<p>${items.name}</p>
<form action="${pageContext.request.contextPath}/item/editItemsSubmit" method="post">
    <input name="id" type="hidden" value="${items.id}"><br/>
    <input name="name" type="text" value="${items.name}"><br/>
    <input name="price" type="text" value="${items.price}"><br/>
    <input name="detail" type="text" value="${items.detail}"><br/>
    <input name="createtime" type="date" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
