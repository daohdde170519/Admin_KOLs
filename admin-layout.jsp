<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Layout</title>
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
    <div>
        <jsp:include page="/admin/admin-template/sidebar.jsp"></jsp:include>
    </div>
    <div class="main-content">
        <jsp:include page="${viewName}.jsp"></jsp:include>
    </div>
</body>
</html>
