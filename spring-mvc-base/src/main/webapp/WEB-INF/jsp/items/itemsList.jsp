<%--
  Created by IntelliJ IDEA.
  User: witt
  Date: 2018/5/14
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>items</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
    查询:
    <table width="100%" border="1">
        <tr>
            <td>
                <input type="submit" value="查询"/>
            </td>
        </tr>
    </table>
</form>
列表：
<table width="100%" border="1">
    <tr>
        <td>name</td>
        <td>price</td>
        <td>date</td>
        <td>notice</td>
        <td>operation</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${item.detail}</td>
            <td><a href="${pageContext.request.contextPath}/item/editItem.action?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
