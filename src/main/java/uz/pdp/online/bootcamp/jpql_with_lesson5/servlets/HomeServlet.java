package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Group;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
//        System.out.println("hello");
        List<Student> studentList;
        List<Group> groups;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        studentList = entityManager.createQuery("select a from Student a", Student.class).getResultList();
        groups = entityManager.createQuery("select a from Group a", Group.class).getResultList();


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        req.setAttribute("students", studentList);
        req.setAttribute("groups", groups);
        requestDispatcher.forward(req,resp);




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
