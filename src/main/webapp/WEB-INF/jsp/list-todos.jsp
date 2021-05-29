<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Todos of ${name}</title></head>
<body>
<h1>Todos of ${name}</h1><br>

<table>
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
</table><br>
<a href="/add-todo">Add Todo</a>
</body>
</html>