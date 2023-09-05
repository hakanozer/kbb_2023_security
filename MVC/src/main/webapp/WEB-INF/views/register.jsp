<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <form method="post" action="/register">
                <h2>Register</h2>
                <c:if test="${errors != null}">
                    <c:forEach items="${errors}" var="item" >
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong><c:out value="${item.getField()}"></c:out>!</strong> <c:out value="${item.getDefaultMessage()}"></c:out>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:forEach>
                </c:if>
                <div class="mb-3">
                    <input name="name" class="form-control" type="text" placeholder="Name" />
                </div>
                <div class="mb-3">
                    <input name="email" class="form-control" type="email" placeholder="E-Mail" />
                </div>
                <div class="mb-3">
                    <input name="password" class="form-control" type="password" placeholder="Password" />
                </div>
                <button class="btn btn-success">Send</button>
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>
</body>
</html>