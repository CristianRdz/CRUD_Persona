<%--
  Created by IntelliJ IDEA.
  User: Cristian Rodriguez Rodriguez
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <jsp:include page="../templates/head.jsp"/>
    <title>Consultar</title>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12 mt-5">
            <c:if test="${param['result']}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <c:out value="${param['message']}"></c:out>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:if test="${param['result']==false}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <c:out value="${param['message']}"></c:out>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">Personas</div>
                        <div class="col-6 text-end">
                            <a href="registrar" class="btn btn-outline-success btn-sm">
                                Registrar persona
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-sm table-hover">
                            <thead class="bg-success bg-gradient text-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">name</th>
                                <th scope="col">surname</th>
                                <th scope="col">curp</th>
                                <th scope="col">birthday</th>
                                <th scope="col" class="nosort">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="persona" items="${personas}" varStatus="status">
                                <tr>
                                    <td>
                                        <c:out value="${persona.id}"/>
                                    </td>
                                    <td>
                                        <c:out value="${persona.name}"/>
                                    </td>
                                    <td>
                                        <c:out value="${persona.surname}"/>
                                    </td>
                                    <td>
                                        <c:out value="${persona.curp}"/>
                                    </td>
                                    <td>
                                        <c:out value="${persona.birthday}"/>
                                    </td>
                                    <td>
                                        <a href="modificar?id=${persona.id}" class="btn btn-warning bg-gradient btn-sm m-1"><i
                                                class='fa fa-pencil-square-o'></i></a>
                                        <button class="btn btn-danger bg-gradient btn-sm m-1 eliminarPersona"
                                                onclick="swEliminar('${persona.id}')"><i
                                                class='fa fa-trash'></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
