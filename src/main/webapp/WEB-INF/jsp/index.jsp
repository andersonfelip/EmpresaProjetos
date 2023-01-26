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
                <button type="submit" class="btn btn-primary">Search</button>
                <a class="btn btn-primary" href="./project" role="button">Create</a>
            </div>
        </div>
    </form>
</div>
<div class="container-fluid">
    <table class="table table-bordered">
        <caption>Portfolio results</caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Forecast</th>
                <th>End Date</th>
                <th>Description</th>
                <th>Status</th>
                <th>Budget</th>
                <th>Risk</th>
                <th>Manager</th>
            </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${listProjects.size()==0}">
                <tr>
                    <td colspan="10">No data</td>
                </tr>
            </c:when>
        </c:choose>
        <c:forEach var="project" items="${listProjects}">
            <tr>
                <td><c:out value="${project.id}" /></td>
                <td><c:out value="${project.nome}" /></td>
                <td><c:out value="${project.dataInicio}" /></td>
                <td><c:out value="${project.dataPrevisaoFim}" /></td>
                <td><c:out value="${project.dataFim}" /></td>
                <td><c:out value="${project.descricao}" /></td>
                <td><c:out value="${project.status}" /></td>
                <td><c:out value="${project.orcamento}" /></td>
                <td><c:out value="${project.risco}" /></td>
                <td><c:out value="${project.pessoaDto.nome}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/static/node_modules/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/static/project/project.js"/>"></script>
</body>
</html>

