<%@ page language="java" contentType="text/html;charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Portal</title>
</head>
<body>
      <h1>Hello ${pageContext.request.userPrincipal.name}!</h1>


      <form class="form-inline" action="/logout" method="post">

            <input type="submit" value="Log out" /> <input type="hidden"
                  name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>



      <h1>${showAdminLink}</h1>
      <c:if test="${showAdminLink == true}">
            <h3>
                  <a href="<c:url value="/admin" />"> Admin Dashboard</a>
            </h3>
      </c:if>


</body>
</html>