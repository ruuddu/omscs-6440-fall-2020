<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Hypertension Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="/resources/css/shared.css" rel="stylesheet">
    <link href="/resources/css/home.css" rel="stylesheet">
</head>
<body>
  <div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Hypertension Management App</a>
                </div>

                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li><a>${pageContext.request.userPrincipal.name}</a></li>
                    <li>
                        <a id="logout-btn" onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="grid-container">
            <div class="grid-item"><a href="/dietEntryPage">Diet Entry</a></div>
            <div class="grid-item"><a href="/dietEntryHistory">Diet History</a></div>
            <div class="grid-item">Exercise Entry</div>
            <div class="grid-item">Exercise History</div>
        </div>

    </c:if>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>