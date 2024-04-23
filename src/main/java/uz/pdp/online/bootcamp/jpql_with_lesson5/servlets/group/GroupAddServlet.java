package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets.group;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.online.bootcamp.jpql_with_lesson5.service.GroupService;

import java.io.IOException;

@WebServlet(name = "GroupAddServlet", value = "/group/add")
public class GroupAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/create.jsp");
//        req.setAttribute("books", bookList);
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupName = req.getParameter("name");
        int studentCount = Integer.parseInt(req.getParameter("count"));
        HttpSession session = req.getSession();
        int id = Integer.parseInt((String)(session.getAttribute("ID")));
        GroupService groupService = new GroupService();



        groupService.save(groupName, studentCount, id);

        resp.sendRedirect("/");
    }
}
