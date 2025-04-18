<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Students</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<div class="container py-4">
    <!-- Header with Back Button -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="mb-0">Student List</h2>
        <a href="index.jsp" class="btn btn-outline-secondary">
            <i class="bi bi-arrow-left-circle"></i> Back to Home
        </a>
    </div>

    <!-- Add Student Button -->
    <a href="addStudent.jsp" class="btn btn-success mb-3">
        <i class="bi bi-plus-circle"></i> Add New Student
    </a>

    <!-- Student Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped shadow-sm">
            <thead class="table-dark text-center">
                <tr>
                    <th>Roll No</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Course</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (students != null && !students.isEmpty()) {
                        for (Student s : students) {
                %>
                <tr class="text-center align-middle">
                    <td><%= s.getRollno() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getCourse() %></td>
                    <td>
                        <a href="StudentServlet?action=edit&id=<%= s.getId() %>" class="btn btn-warning btn-sm">
                            <i class="bi bi-pencil-square"></i> Edit
                        </a>
                        <a href="StudentServlet?action=delete&id=<%= s.getId() %>" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this student?');">
                            <i class="bi bi-trash3"></i> Delete
                        </a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="text-center text-muted">No students found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
