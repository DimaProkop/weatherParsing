<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--
  Created by IntelliJ IDEA.
  User: dionp
  Date: 10.04.2016
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InfoWeathers</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <spring:url value="/resources/css/bootstrap.min.css" var="css"/>
    <link href="${css}" rel="stylesheet" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bjs"/>
    <script href="${bjs}"></script>
    <spring:url value="/resources/css/dashboard.css" var="dash"/>
    <link href="${dash}" rel="stylesheet" />
    <spring:url value="/resources/js/jquery.min.js" var="js"/>
    <script href="${js}"></script>
</head>
<body>


<div class="row">
    <div class="col-sm-7 col-sm-offset-5 col-md-7 col-md-offset-3 main">
        <div class="container">


                <a href="/">

                    <button type="button" class="btn btn-lg btn-warning">
                        HOME PAGE
                    </button>
                </a>
            </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Type</th>
                    <th>Temp (min/max)</th>
                    <th>Overcast</th>
                    <th>Pressure (min/max)</th>
                    <th>Humidity (min/max)</th>
                    <th>Speed (min/max)</th>
                    <th>Direction</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="answer" items="${answers}">
                    <tr style="width: 1500px">
                        <td>${answer.getTypeDay()}</td>
                        <td>${answer.getTemperature()}</td>
                        <td>${answer.getOvercast()}</td>
                        <td>${answer.getPressure()}</td>
                        <td>${answer.getHumidity()}</td>
                        <td>${answer.getSpeed()}</td>
                        <td>${answer.getDirection()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>


    </div>


</body>
</html>
