<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="${pageContext.request.contextPath }/add.jsp">增加用户</a><br/>
  --用户信息--
  <table border="1">
      <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>创建日期</th>
        <th>操作</th>
      </tr>
     <c:forEach var="user" items="${requestScope.users}">
	     <tr>
	        <td>${user.user_id }</td>
	        <td>${user.user_name}</td>
	        <td>${user.password }</td>
	        <td>${user.create_date }</td>
	        <td><a href="${pageContext.request.contextPath }/user/delete.do?id=${user.user_id}">[删除]</a> <a href="${pageContext.request.contextPath }/user/to_update.do?id=${user.user_id}">[更新]</a></td>
	      </tr>
      </c:forEach>
  </table>
</body>
</html>