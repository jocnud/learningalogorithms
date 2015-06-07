<%@ page language="java" contentType="text/html;charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/portal.js" />"></script>
</head>
<body>

      <form name="loginForm" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="text" name="username" required="required"
                  placeholder="Username"> <input type="password"
                  name="password" placeholder="password" required="required" /> <input
                  type="submit" value="Login">
      </form>


      <c:if test="${param.error != null}">
            <p>Invalid Username and password.</p>
      </c:if>

      <c:if test="${param.logout != null}">
            <p>Successfully logged out.</p>
      </c:if>

</body>
</html>
