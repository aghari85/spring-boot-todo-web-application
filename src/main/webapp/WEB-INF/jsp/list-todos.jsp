<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Todos of ${name}</title>
    <link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Todos of ${name}</h1><br>

    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is it done?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <a class="btn btn-primary" href="/add-todo">Add Todo</a>
    </div>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>