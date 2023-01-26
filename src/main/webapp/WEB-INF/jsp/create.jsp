<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Projetos Portfolio</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
    rel="stylesheet">

</head>
<body>
</body>

<jsp:include page="./shared/nav.jsp" />
<div class="container-fluid">
    <form>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" placeholder="Enter name">
                <small id="nameHelp" class="form-text text-muted">Enter portfolio name.</small>
            </div>
            <div class="form-group col-md-4">
                <label for="startDate">Start Date</label>
                <input type="date" class="form-control" id="startDate" placeholder="Enter Start Date">
            </div>
            <div class="form-group col-md-4">
                <label for="endForecast">End Forecast</label>
                <input type="date" class="form-control" id="endForecast" placeholder="Enter End Forecast">
            </div>


        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <a class="btn btn-primary" href="./create" role="button">Create</a>
            </div>
        </div>
    </form>
</div>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>
