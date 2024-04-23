package uz.pdp.online.bootcamp.jpql_with_lesson5.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter
public class SecurityFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        HttpServletRequest servletRequest1 = (HttpServletRequest)servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        HttpSession session = servletRequest1.getSession();
        String id = (String) session.getAttribute("ID");
        System.out.println("id = " + id);
        String requestURI = servletRequest1.getRequestURI();
        System.out.println(requestURI);
        if (!requestURI.equals("/login") && id==null){
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        } else{
            filterChain.doFilter(servletRequest1,servletResponse1);
        }

    }

}
