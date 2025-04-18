package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.StudentDAO;
import bean.Student;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/StudentServlet", "/viewStudents"})
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO(); // DAO handles MongoDB connection
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if (action == null || action.equals("view")) {
                List<Student> students = studentDAO.getAllStudents();
                request.setAttribute("students", students);
                request.getRequestDispatcher("viewStudents.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                String id = request.getParameter("id");
                studentDAO.deleteStudent(id);
                response.sendRedirect("StudentServlet?action=view");
            } else {
                response.sendRedirect("index.jsp"); // fallback
            }
        } catch (Exception e) {
            throw new ServletException("Error retrieving or deleting students", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                String rollno = request.getParameter("rollno");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String course = request.getParameter("course");
                int marks = Integer.parseInt(request.getParameter("marks"));

                Student student = new Student(rollno, name, email, course, marks);
                studentDAO.addStudent(student);

            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                studentDAO.deleteStudent(id);
            }

            // Redirect to view updated list
            response.sendRedirect("StudentServlet?action=view");

        } catch (Exception e) {
            throw new ServletException("Error processing student data", e);
        }
    }
}
