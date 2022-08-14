<%--
  Created by IntelliJ IDEA.
  User: Cristian Rodriguez Rodriguez
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<c:redirect url="/consultar"/>
</body>
</html>