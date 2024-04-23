package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Student;
import uz.pdp.online.bootcamp.jpql_with_lesson5.service.StudentService;

import java.io.IOException;

@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/student/delete/*")
public class StudentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);
        resp.getWriter().println(id);

        StudentService studentService = new StudentService();
        Student student = studentService.get(id);

        req.setAttribute("student", student);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/delete.jsp");
        requestDispatcher.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);

        StudentService studentService = new StudentService();
        if (studentService.delete(id)) {

            System.out.println("Student Account Successfully Deleted!");
        }

        resp.sendRedirect("/");


    }
}
