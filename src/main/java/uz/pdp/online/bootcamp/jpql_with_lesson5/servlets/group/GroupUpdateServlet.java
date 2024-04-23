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

@WebServlet(name = "GroupUpdateServlet", urlPatterns = "/group/update/*")
public class GroupUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);
        resp.getWriter().println(id);

        GroupService groupService = new GroupService();

        Group group = groupService.get(id);


        req.setAttribute("group", group);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/update.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        int id = Integer.parseInt(pathInfo);

        String name = req.getParameter("name");
        int studentCount = Integer.parseInt(req.getParameter("count"));


        GroupService groupService = new GroupService();
        groupService.update(id, name, studentCount);

        resp.sendRedirect("/");

    }
}
