<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="tr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Yapılacaklar Listesi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Yapılacaklar Listesi</h1>
<small>webapp</small>
<div class="container">
    <ul class="list-group">
        <c:forEach items="${todos}" var="todo">
        <li class="list-group-item d-flex justify-content-between align-items-center">
            ${todo.content}
            <span class="badge bg-danger rounded-pill">Sil</span>
        </li>
        </c:forEach>
    </ul>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
