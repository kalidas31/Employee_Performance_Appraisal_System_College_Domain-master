package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ReviewServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && ("HOD".equals(user.getRole()) || "Principal".equals(user.getRole()))) 
        {
            int appraisalId = Integer.parseInt(request.getParameter("appraisalId"));
            AppraisalDAO appraisalDAO = null;
			try {
				appraisalDAO = new AppraisalDAO();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Appraisal appraisal = appraisalDAO.getAppraisalById(appraisalId);

            if ("HOD".equals(user.getRole())) 
            {
                 appraisal.setHodRemarks(request.getParameter("hodRemarks"));
                 appraisal.setStatus("reviewed");
            } 
            else if ("Principal".equals(user.getRole())) 
            {
                appraisal.setPrincipalRemarks(request.getParameter("principalRemarks"));
                 appraisal.setStatus("finalized");
            }
            appraisalDAO.updateAppraisal(appraisal);
            response.sendRedirect(user.getRole() + "Dashboard.jsp?status=reviewed");
        } 
        else 
        {
            response.sendRedirect("login.html");
        }
    }
}
