package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.postgresql.Driver;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        System.out.println("fullname: "+fullname);
        HttpSession session = req.getSession();

        Student student = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student1 = entityManager.createQuery("select a from Student a where fullName = \'"+fullname+"\'", Student.class).getSingleResult();

        if (student1!=null) {
            session.setAttribute("ID", String.valueOf(student1.getId()));
            Cookie cookie = new Cookie("ID", String.valueOf(student1.getId()));

            cookie.setMaxAge(60*60);
            resp.sendRedirect("/");
        } else{
            PrintWriter writer = resp.getWriter();
            writer.println("Given fullname is not present in the database!");
        }



    }
}
