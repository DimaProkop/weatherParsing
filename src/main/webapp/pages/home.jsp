<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dionp
  Date: 07.04.2016
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
    <spring:url value="/resources/js/bootstrap.min.js" var="mainJs" />
    <link href="${mainCss}" rel="stylesheet" />
    <script href="${mainJs}"></script>

    <style type="text/css">

        .modal-footer {
            border-top: 0px;
        }
    </style>
</head>

<body>

<div class="row">
    <div class="col-sm-6 col-sm-offset-4 col-md-7 col-md-offset-3 main">
        <div class="container">
            <div class="row">

                <div class="col-md-8">

                    <div class="alert alert-info">
                        <h3 style="text-align: center"><strong>Please, enter your date..</strong> </h3>
                    </div>
                    <br />
                    <form class="form-horizontal" method="post" action="/weather/list/">
                        <label>Year</label>
                        <input type="text" class="form-control" id="year" name="year" />
                        <label>Month</label>
                        <input type="text" class="form-control" id="month" name="month"/>
                        <label>Day</label>
                        <input type="text" class="form-control" id="day" name="day"/>
                        <br>

                        <button type="submit" class="btn btn-info">Show</button>
                    </form>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
