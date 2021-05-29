<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Todo - Login</title>
    <link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<br>
<div class="container">
    <form method="post">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">User ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter user id">
            </div>
        </div><br>
        <div class="form-group row">
            <label for="password"  class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
            </div>
        </div><br>
        <center><button type="submit" class="btn btn-primary">Submit</button></center>
    </form>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>