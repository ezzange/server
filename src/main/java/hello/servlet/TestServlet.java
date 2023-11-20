package hello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * http://localhost:8080/test
 * 순수 서블릿으로 동작하는 웹 애플리케이션
 * 웹 서버를 통해 이 서블릿이 실행
 */
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet.service");
        resp.getWriter().println("test");

    }
}
