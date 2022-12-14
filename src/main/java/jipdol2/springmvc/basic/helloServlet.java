package jipdol2.springmvc.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="helloServlet",urlPatterns = "/hello")
public class helloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //http response header 에 삽입
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //http response body 에 삽입
        response.getWriter().write("hello "+username);
    }
}
