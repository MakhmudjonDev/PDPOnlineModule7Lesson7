package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.online.bootcamp.jpql_with_lesson5.service.StudentService;

import java.io.IOException;

@WebServlet(name = "StudentAddServlet", value = "/student/add")
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/create.jsp");
//        req.setAttribute("books", bookList);
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int groupID = Integer.parseInt(req.getParameter("groupid"));
        HttpSession session = req.getSession();
        int id = Integer.parseInt((String)session.getAttribute("ID"));
        int age = Integer.parseInt(req.getParameter("age"));
        StudentService studentService = new StudentService();
        if (studentService.save(name, groupID, age, id)) {
            System.out.println("Successfully inserted!");
        }

        resp.sendRedirect("/");
    }
}
