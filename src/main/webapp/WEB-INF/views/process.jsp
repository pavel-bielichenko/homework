<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Welcome page</title>
  <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css' />"  rel="stylesheet"/>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
  <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
</head>
<body>
<div id="mainWrapper">
  <div class="login-container">
    <div class="login-card">
      <div class="login-form">
      ${greeting}

<c:url var="requestLoanURL" value="/requestLoan" />
<form action="${requestLoanURL}" method="post" class="form-horizontal">
  <c:if test="${param.error != null}">
    <div class="alert alert-danger">
      <p>Sorry, but you request loan with a maximum amount in time range between 00:00 - 06:00
        or the maximum number of loan applications from your IP today has been exceeded</p>
    </div>
  </c:if>
  <c:if test="${param.success != null}">
    <div class="alert alert-success">
      <p>Your loan request has been approved!</p>
    </div>
  </c:if>

  <div class="input-group input-sm">
    <label class="input-group-addon" for="loan_amount"><i class="fa fa-btc" aria-hidden="true"></i></label>
    <input type="text" class="form-control" id="loan_amount" name="loan_amount" placeholder="Enter loan" required>
  </div>

  <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

  <div class="loan_form-actions">
    <input type="submit"
           class="btn btn-block btn-primary btn-default" value="send loan application">
  </div>
</form>
        </div>
          </div>
            </div>
</div>
</body>
</html>