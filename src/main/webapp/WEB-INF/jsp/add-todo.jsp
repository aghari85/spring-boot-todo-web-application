<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<html>
<head><title>Add TodoP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="h1">Add todo for ${name}</h1>

    <form:form method="post" modelAttribute="todo">
        <form:label path="id" name="id"/>
        <div class="form-group row">
            <form:label path="description">Description</form:label>
            <div class="col-sm-10">
                <form:input type="text" path="description" name="description" class="text-input" required="true"/>
                <form:errors path="description" cssClass="text-warning"/>
            </div>
        </div>
        <div class="form-group row">
            <form:label path="targetDate">Target Date</form:label>
            <div class="col-sm-10">
                <form:input type="text" path="targetDate" name="targetDate" class="text-input" required="true"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </div>
        </div>
        <form:button type="submit" class="btn btn-primary">Submit</form:button>
    </form:form>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
        src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
    $('#targetDate').datepicker({
        format : 'dd/mm/yyyy'
    });
</script>
</body>
</html>