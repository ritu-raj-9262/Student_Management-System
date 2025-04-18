<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Dashboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="bg-light">

    <div class="container py-5">
        <div class="card shadow-sm border-0 mb-4">
            <div class="card-body text-center">
                <h2 class="mb-3">Welcome, <span class="text-primary"><%= username %></span></h2>
                <p class="lead text-muted">Manage student records using the options below.</p>
            </div>
        </div>

        <div class="d-flex justify-content-center gap-3 flex-wrap">
            <a href="addStudent.jsp" class="btn btn-success btn-lg">
                <i class="bi bi-person-plus-fill me-2"></i>Add Student
            </a>
            <a href="StudentServlet?action=view" class="btn btn-info btn-lg text-white">
                <i class="bi bi-card-list me-2"></i>View Students
            </a>
            <a href="LogoutServlet" class="btn btn-danger btn-lg">
                <i class="bi bi-box-arrow-right me-2"></i>Logout
            </a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
