<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.example.servlet.Appraisal"%>
<%@page import="com.example.servlet.AppraisalDAO"%>
<%@page import="com.example.servlet.AppraisalForms"%>
<%@page import="com.example.servlet.User"%>
<%@page import="com.example.servlet.UserDAO"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty_Dashboard</title>
    <link rel="stylesheet" type="text/css" href="FDstyles.css">
    <style>
    	#naf
    	{
    		display:none;
    	}
    	
    	#dys
    	{
    		display:none;
    	}
    </style>
</head>
<body>

<div  class="dashboard-container">
	<button><a href="login.html" class="a1">Logout</a></button>
    <h1>Welcome, <%= ((User)session.getAttribute("user")).getUsername() %> of <%= ((User)session.getAttribute("user")).getDepartment() %> Dept.</h1>
    <h2>Your Appraisals</h2>
    <table border="1">
        <thead>
            <tr>
                <th style="text-align: center;">Academic year</th>
                <th style="text-align: center;">Appraisal Form</th>
            </tr>
        </thead>
        <tbody>
       			<%
       			
       			AppraisalDAO appraisalDAO = new AppraisalDAO();
       			int userid=((User)session.getAttribute("user")).getUserId();
       			String udept=((User)session.getAttribute("user")).getDepartment();
       			List<AppraisalForms> appraisals =appraisalDAO.getPendingAppraisals(); 
       			for (AppraisalForms appraisal : appraisals) 
                {
       				String afdept=appraisal.getDepartment();
       				String academicyear=appraisal.getAcademicyear();
       				String status=appraisalDAO.getStatus(academicyear, userid);
       				if(udept.equals(afdept))
       				{
       			%>
            <tr>
                <td><%= appraisal.getAcademicyear() %></td>
                
                <td>
                
             	<% 
             	if(status==null)
             	{
             		out.println("<a id='naf' style='display:block;' href='newAppraisalForm.jsp'>Submit New Appraisal</a>");
             	}
             	else if(status!=null)
             	{
             	 %>
             	    <p id="dys" style="display:block;"><%=status %></p>
             	 
             <%	 
             	}
                %>
                </td>
            </tr>
            
          
             <% } 
       				} %>
        </tbody>
    </table>
   
   
    
</div>
</body>
</html>
