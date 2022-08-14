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
    <title>Registrar</title>
</head>
<body>
<jsp:include page="../templates/navbar.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Registro de persona</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form
                                    class="needs-validation"
                                    novalidate
                                    action="crear"
                                    method="POST"
                                    autocomplete="off"
                            >
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="name">name</label>
                                            <input
                                                    type="text"
                                                    class="form-control"
                                                    id="name"
                                                    name="name"
                                                    placeholder=".."
                                                    required
                                            />
                                            <div class="invalid-feedback">
                                                Debes llenar este campo
                                            </div>
                                        </div>
                                        <di class="col">
                                            <label class="fw-bold" for="surname">surname</label>
                                            <input
                                                    type="text"
                                                    class="form-control"
                                                    id="surname"
                                                    name="surname"
                                                    placeholder=".."
                                                    required
                                            />
                                            <div class="invalid-feedback">
                                                Debes llenar este campo
                                            </div>
                                        </di>

                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="curp">CURP</label>
                                            <input
                                                    type="text"
                                                    class="form-control"
                                                    id="curp"
                                                    name="curp"
                                                    placeholder=".."
                                                    required
                                                    minlength="18"
                                                    maxlength="18"
                                            />
                                            <div class="invalid-feedback">
                                                Debes llenar este campo con 18 caracteres
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label  class="fw-bold" for="birthday">birthday</label>
                                            <input
                                                    type="date"
                                                    class="form-control"
                                                    id="birthday"
                                                    name="birthday"
                                                    placeholder=".."
                                                    required
                                            />
                                            <div class="invalid-feedback">
                                                Debes llenar este campo
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button class="btn btn-primary bg-gradient" type="reset">
                                                Limpiar <span class="fa fa-eraser"></span>
                                            </button>
                                            <a href="consultar" class="btn btn-danger bg-gradient"
                                            >Cancelar <span class="fa fa-arrow-left"></span
                                            ></a>
                                            <button class="btn btn-success bg-gradient" type="submit">
                                                Registrar <span class="fa fa-paper-plane"></span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
