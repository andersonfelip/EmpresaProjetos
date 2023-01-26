<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Projetos Portfolio</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"   rel="stylesheet">

</head>
<body>
</body>

<jsp:include page="./shared/nav.jsp" />
<div class="container-fluid">
    <%--@elvariable id="project" type="com.empresaprojetos.portfolio.dto.ProjetoDto"--%>
    <form:form action="/project" method="post" modelAttribute="project">
        <div class="row">
            <div class="form-group col-md-4">
                <form:label path="nome">Name</form:label>
                <form:input type="text" class="form-control" id="name" placeholder="Enter name" path="nome" required="required" />
                <small id="nameHelp" class="form-text text-muted">Enter portfolio name.</small>
            </div>
            <div class="form-group col-md-2">
                <form:label path="dataInicio">Start Date</form:label>
                <form:input  type="date" class="form-control" id="dataInicio" placeholder="Enter Start Date"  path="dataInicio" required="required"/>
            </div>
            <div class="form-group col-md-2">
                <form:label path="dataPrevisaoFim">End Forecast</form:label>
                <form:input type="date" class="form-control" id="dataPrevisaoFim" placeholder="Enter End Forecast" path="dataPrevisaoFim" required="required" />
            </div>
            <div class="form-group col-md-2">
                <form:label for="dataFim" path="dataFim">End Date</form:label>
                <form:input type="date" class="form-control" id="dataFim" placeholder="Enter End Date" path="dataFim" required="required"/>
            </div>
            <div class="form-group col-md-2">
                <form:label for="risk" path="risco">Risk</form:label><br />
                <form:select class="form-select" id="risk" path="risco" required="required">
                    <option value="">Select..</option>
                    <option value="1">low risk</option>
                    <option value="2">medium risk</option>
                    <option value="3">high risk</option>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <form:label for="description" path="descricao">Description</form:label>
                <form:input type="text" class="form-control" id="description" placeholder="Enter the description" path="descricao" required="required" />
                <small id="descriptionHelp" class="form-text text-muted">Enter portfolio description.</small>
            </div>
            <div class="form-group col-md-2">
                <form:label for="status" path="status">Status</form:label><br />
                <form:select class="form-select" id="status" path="status" required="required">
                    <option value="">Select..</option>
                    <option value="1">under review</option>
                    <option value="2">analysis performed</option>
                    <option value="3">approved analysis</option>
                    <option value="4">started</option>
                    <option value="5">planned</option>
                    <option value="6">In progress</option>
                    <option value="7">closed</option>
                    <option value="8">canceled</option>
                </form:select>
            </div>
            <div class="form-group col-md-2">
                <form:label for="budget" path="orcamento">Budget</form:label>
                <form:input type="number" step="0.01" class="form-control" id="budget" placeholder="Enter Budget" path="orcamento" required="required"/>
            </div>
            <div class="form-group col-md-4">
                <form:label for="manager" path="pessoaDto">Manager</form:label><br />
                <form:input type="hidden" path="pessoaDto.id" id="idGerente" />
                <select class="form-select" id="manager" onchange="updateManager(value)" required>
                    <option value="">
                            Select..
                    </option>
                    <c:forEach var="employee" items="${listEmployee}">
                        <option value="${employee.id}"
                                <c:out value="${employee.nome}"> </c:out>>
                                ${employee.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </div>
    </form:form>
</div>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/static/node_modules/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/static/project/project.js"/>"></script>
</html>
