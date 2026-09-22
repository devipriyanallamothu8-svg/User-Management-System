package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get existing session
        HttpSession session = request.getSession(false);

        // Destroy session
        if (session != null) {
            session.invalidate();
        }

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
            "<!DOCTYPE html>" +

            "<html>" +

            "<head>" +

            "<title>Logout</title>" +

            "<style>" +

            "*{box-sizing:border-box;font-family:'Segoe UI',Arial,sans-serif;}" +

            "body{" +
            "margin:0;" +
            "min-height:100vh;" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "background:linear-gradient(135deg,#141e30,#243b55);" +
            "color:white;" +
            "}" +

            ".card{" +
            "width:420px;" +
            "padding:45px;" +
            "text-align:center;" +
            "background:rgba(255,255,255,0.12);" +
            "backdrop-filter:blur(18px);" +
            "border:1px solid rgba(255,255,255,0.25);" +
            "border-radius:25px;" +
            "box-shadow:0 25px 60px rgba(0,0,0,0.35);" +
            "}" +

            ".icon{" +
            "width:80px;" +
            "height:80px;" +
            "margin:0 auto 20px;" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "border-radius:50%;" +
            "font-size:36px;" +
            "background:linear-gradient(135deg,#6c63ff,#00c6ff);" +
            "}" +

            "h1{font-size:30px;margin-bottom:10px;}" +

            "p{" +
            "color:rgba(255,255,255,0.75);" +
            "margin-bottom:28px;" +
            "}" +

            ".btn{" +
            "display:block;" +
            "padding:14px;" +
            "border-radius:11px;" +
            "background:linear-gradient(135deg,#6c63ff,#00c6ff);" +
            "color:white;" +
            "text-decoration:none;" +
            "font-weight:bold;" +
            "}" +

            "</style>" +

            "</head>" +

            "<body>" +

            "<div class='card'>" +

            "<div class='icon'>✓</div>" +

            "<h1>Logged Out Successfully</h1>" +

            "<p>You have been safely logged out of the system.</p>" +

            "<a class='btn' href='login.html'>Login Again →</a>" +

            "</div>" +

            "</body>" +

            "</html>"
        );
    }

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
