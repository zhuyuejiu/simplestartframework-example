<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  --用户信息--
  <table border="1">
      <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>生日</th>
      </tr>
     <c:forEach var="user" items="${requestScope.users }">
	     <tr>
	        <td>${user.user_id }</td>
	        <td>${user.user_name}</td>
	        <td>${user.password }</td>
	        <td>${user.birthday }</td>
	      </tr>
      </c:forEach>
  </table>
</body>
</html>