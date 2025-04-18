<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Student Management System</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4 w-100" style="max-width: 500px;">
        <div class="card-body text-center">
            <h2 class="card-title mb-4">
                <i class="bi bi-mortarboard-fill text-primary" style="font-size: 2.5rem;"></i><br>
                Student Management System
            </h2>

            <p class="text-muted mb-4">
                Welcome, <strong><%= username %></strong>
            </p>

            <div class="d-grid gap-3">
                <a href="StudentServlet?action=view" class="btn btn-primary btn-lg">
                    <i class="bi bi-table me-2"></i> View All Students
                </a>

                <a href="addStudent.jsp" class="btn btn-success btn-lg">
                    <i class="bi bi-person-plus-fill me-2"></i> Add New Student
                </a>

                <a href="LogoutServlet" class="btn btn-danger btn-lg">
                    <i class="bi bi-box-arrow-right me-2"></i> Logout
                </a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
