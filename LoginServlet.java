package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Get stored password
        String storedPassword = UserStore.users.get(username);

        // Check username and password
        if (storedPassword != null && storedPassword.equals(password)) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Login Successful</title>" +

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
                "font-size:38px;" +
                "background:linear-gradient(135deg,#00c853,#64dd17);" +
                "}" +

                "h1{font-size:30px;margin-bottom:10px;}" +

                "p{" +
                "color:rgba(255,255,255,0.8);" +
                "margin-bottom:28px;" +
                "}" +

                ".btn{" +
                "display:block;" +
                "padding:14px;" +
                "margin-top:12px;" +
                "border-radius:11px;" +
                "background:linear-gradient(135deg,#6c63ff,#00c6ff);" +
                "color:white;" +
                "text-decoration:none;" +
                "font-weight:bold;" +
                "transition:0.3s;" +
                "}" +

                ".btn:hover{" +
                "transform:translateY(-3px);" +
                "}" +

                "</style>" +
                "</head>" +

                "<body>" +

                "<div class='card'>" +

                "<div class='icon'>✓</div>" +

                "<h1>Login Successful!</h1>" +

                "<p>Welcome, " + username + "! You have successfully logged in.</p>" +

                "<a class='btn' href='index.html'>Go to Dashboard →</a>" +

                "<a class='btn' href='logout'>Logout</a>" +

                "</div>" +

                "</body>" +
                "</html>"
            );

        } else {

            // Invalid username/password

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<title>Login Failed</title>" +

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
                "font-size:38px;" +
                "background:linear-gradient(135deg,#ff416c,#ff4b2b);" +
                "}" +

                "h1{font-size:30px;margin-bottom:10px;}" +

                "p{" +
                "color:rgba(255,255,255,0.8);" +
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

                "<div class='icon'>✕</div>" +

                "<h1>Invalid Credentials</h1>" +

                "<p>Username or password is incorrect.</p>" +

                "<a class='btn' href='login.html'>Try Again →</a>" +

                "</div>" +

                "</body>" +
                "</html>"
            );
        }
    }
}
