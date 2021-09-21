package com.example.helloworld;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");try
        {
            Connection con = DriverManager.getConnection("jdbc:h2:~/tdb", "talha", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Profession</th><tr>");
            while (rs.next())
            {
                int a = rs.getInt("id");
                String b = rs.getString("name");
                String c = rs.getString("email");
                String d = rs.getString("profession");
                out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();
        }
        catch (Exception e)
        {
            out.println("error");
        }
    }

    public void destroy() {
    }
}