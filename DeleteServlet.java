package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
            "<html>" +
            "<body style='font-family:Arial;text-align:center;padding-top:100px'>" +
            "<h1>Delete User</h1>" +
            "<p>Please use the Delete User form.</p>" +
            "<a href='Delete.html'>Go to Delete</a>" +
            "</body>" +
            "</html>"
        );
    }

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");

        // Remove user
        boolean deleted = UserStore.users.remove(username) != null;

        if (deleted) {

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<title>User Deleted</title>" +

                "<style>" +

                "body{" +
                "margin:0;" +
                "min-height:100vh;" +
                "display:flex;" +
                "justify-content:center;" +
                "align-items:center;" +
                "font-family:Arial;" +
                "background:linear-gradient(135deg,#141e30,#243b55);" +
                "color:white;" +
                "}" +

                ".card{" +
                "width:420px;" +
                "padding:40px;" +
                "text-align:center;" +
                "background:rgba(255,255,255,0.12);" +
                "border-radius:20px;" +
                "}" +

                ".icon{" +
                "font-size:60px;" +
                "}" +

                "a{" +
                "display:block;" +
                "margin-top:20px;" +
                "padding:12px;" +
                "background:#6c63ff;" +
                "color:white;" +
                "text-decoration:none;" +
                "border-radius:8px;" +
                "}" +

                "</style>" +
                "</head>" +

                "<body>" +

                "<div class='card'>" +

                "<div class='icon'>✓</div>" +

                "<h1>User Deleted</h1>" +

                "<p>User <b>" + username + "</b> has been deleted successfully.</p>" +

                "<a href='Delete.html'>Delete Another User</a>" +

                "</div>" +

                "</body>" +
                "</html>"
            );

        } else {

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<title>User Not Found</title>" +
                "<style>" +

                "body{" +
                "margin:0;" +
                "min-height:100vh;" +
                "display:flex;" +
                "justify-content:center;" +
                "align-items:center;" +
                "font-family:Arial;" +
                "background:linear-gradient(135deg,#141e30,#243b55);" +
                "color:white;" +
                "}" +

                ".card{" +
                "width:420px;" +
                "padding:40px;" +
                "text-align:center;" +
                "background:rgba(255,255,255,0.12);" +
                "border-radius:20px;" +
                "}" +

                "a{" +
                "display:block;" +
                "margin-top:20px;" +
                "padding:12px;" +
                "background:#6c63ff;" +
                "color:white;" +
                "text-decoration:none;" +
                "border-radius:8px;" +
                "}" +

                "</style>" +
                "</head>" +

                "<body>" +

                "<div class='card'>" +

                "<h1>User Not Found</h1>" +

                "<p>No user exists with username <b>" + username + "</b>.</p>" +

                "<a href='Delete.html'>Try Again</a>" +

                "</div>" +

                "</body>" +
                "</html>"
            );
        }
    }
}
