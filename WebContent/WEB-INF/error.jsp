<!--
Jike Li
Andrew ID:jikel
08-600
Homework #9
Date: Nov. 29, 2014
  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Favorite Websites -- Error Page</title>
</head>

<body>

	<h2>Favorite Websites Errors</h2>

	<c:forEach var="error" items="${errors}">
		<h3 style="color: red">${error}</h3>
	</c:forEach>

	<c:choose>
		<c:when test="${ (empty user) }">
				Click <a href="login.do">here</a> to login.
			</c:when>
		<c:otherwise>
				Click <a href="manage.do">here</a> to return to the websites List.
			</c:otherwise>
	</c:choose>

</body>
</html>