package com.example.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = null;
		try 
		{
			userDAO = new UserDAO();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        User user = userDAO.authenticate(username, password);

        if (user != null) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if ("faculty".equals(user.getRole())) 
            {
                response.sendRedirect("facultyDashboard.jsp");
            } 
            else if ("HOD".equals(user.getRole())) 
            {
                response.sendRedirect("HODDashboard.jsp");
            } 
            else if ("Principal".equals(user.getRole())) 
            {
                response.sendRedirect("PrincipalDashboard.jsp");
            }
        } 
        else 
        {
            response.sendRedirect("login.html?error=1");
        }
    }
}
