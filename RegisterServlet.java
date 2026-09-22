package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Get data from Register.html
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        String address = request.getParameter("address");

        // Check for empty username/password
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            out.println("<h2>Username and Password are required.</h2>");
            out.println("<a href='Register.html'>Go Back</a>");
            return;
        }

        username = username.trim();

        // Check if UserStore is initialized
        if (UserStore.users == null) {
            out.println("<h2>UserStore is not initialized.</h2>");
            out.println("<p>Please check UserStore.java.</p>");
            return;
        }

        // Check whether username already exists
        if (UserStore.users.containsKey(username)) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Failed</title>");

            out.println("<style>");
            out.println("body{");
            out.println("font-family:Arial;");
            out.println("background:linear-gradient(135deg,#141e30,#243b55);");
            out.println("color:white;");
            out.println("text-align:center;");
            out.println("padding-top:100px;");
            out.println("}");

            out.println(".card{");
            out.println("width:420px;");
            out.println("margin:auto;");
            out.println("padding:40px;");
            out.println("background:rgba(255,255,255,0.12);");
            out.println("border-radius:20px;");
            out.println("}");

            out.println("a{");
            out.println("display:inline-block;");
            out.println("padding:12px 25px;");
            out.println("background:#6c63ff;");
            out.println("color:white;");
            out.println("text-decoration:none;");
            out.println("border-radius:8px;");
            out.println("}");

            out.println("</style>");
            out.println("</head>");

            out.println("<body>");

            out.println("<div class='card'>");

            out.println("<h1>Username Already Exists</h1>");

            out.println("<p>Please choose another username.</p>");

            out.println("<a href='Register.html'>Register Again</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

            return;
        }

        // Save username and password
        UserStore.users.put(username, password);

        // Registration successful
        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<title>Registration Successful</title>");

        out.println("<style>");

        out.println("*{");
        out.println("box-sizing:border-box;");
        out.println("font-family:'Segoe UI',Arial,sans-serif;");
        out.println("}");

        out.println("body{");
        out.println("margin:0;");
        out.println("min-height:100vh;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("background:linear-gradient(135deg,#141e30,#243b55);");
        out.println("color:white;");
        out.println("}");

        out.println(".card{");
        out.println("width:500px;");
        out.println("padding:45px;");
        out.println("text-align:center;");
        out.println("background:rgba(255,255,255,0.12);");
        out.println("backdrop-filter:blur(18px);");
        out.println("border:1px solid rgba(255,255,255,0.25);");
        out.println("border-radius:25px;");
        out.println("box-shadow:0 25px 60px rgba(0,0,0,0.35);");
        out.println("}");

        out.println(".icon{");
        out.println("width:80px;");
        out.println("height:80px;");
        out.println("margin:0 auto 20px;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("border-radius:50%;");
        out.println("font-size:38px;");
        out.println("background:linear-gradient(135deg,#00c853,#64dd17);");
        out.println("}");

        out.println("h1{");
        out.println("font-size:30px;");
        out.println("margin-bottom:10px;");
        out.println("}");

        out.println("p{");
        out.println("color:rgba(255,255,255,0.8);");
        out.println("}");

        out.println(".details{");
        out.println("text-align:left;");
        out.println("margin:25px 0;");
        out.println("padding:20px;");
        out.println("background:rgba(0,0,0,0.15);");
        out.println("border-radius:15px;");
        out.println("}");

        out.println(".details p{");
        out.println("margin:12px 0;");
        out.println("}");

        out.println(".btn{");
        out.println("display:block;");
        out.println("padding:14px;");
        out.println("margin-top:12px;");
        out.println("border-radius:11px;");
        out.println("background:linear-gradient(135deg,#6c63ff,#00c6ff);");
        out.println("color:white;");
        out.println("text-decoration:none;");
        out.println("font-weight:bold;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<div class='icon'>✓</div>");

        out.println("<h1>Registration Successful!</h1>");

        out.println("<p>Your account has been created successfully.</p>");

        out.println("<div class='details'>");

        out.println("<p><b>Username:</b> " + username + "</p>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Phone:</b> " + phone + "</p>");
        out.println("<p><b>Gender:</b> " + gender + "</p>");
        out.println("<p><b>Course:</b> " + course + "</p>");
        out.println("<p><b>Address:</b> " + address + "</p>");

        out.println("</div>");

        out.println("<a class='btn' href='login.html'>Login Now →</a>");

        out.println("<a class='btn' href='index.html'>Go to Dashboard →</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}