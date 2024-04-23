package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets.group;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Group;
import uz.pdp.online.bootcamp.jpql_with_lesson5.service.GroupService;

import java.io.IOException;

@WebServlet(name = "GroupDeleteServlet", urlPatterns = "/group/delete/*")
public class GroupDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);
        resp.getWriter().println(id);

        GroupService groupService = new GroupService();
        Group group = groupService.get(id);


        req.setAttribute("group", group);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/delete.jsp");
        requestDispatcher.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);

        GroupService groupService = new GroupService();
        if (groupService.delete(id)) {
            System.out.println("Group Successfully Deleted!");
        }

        resp.sendRedirect("/");


    }
}
