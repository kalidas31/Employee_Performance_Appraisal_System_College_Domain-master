<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlet.Appraisal" %>
<%@ page import="com.example.servlet.AppraisalDAO" %>
<%@ page import="com.example.servlet.User" %>
<%@ page import="com.example.servlet.UserDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Principal Dashboard</title>
    <link rel="stylesheet" type="text/css" href="PDstyles.css">
</head>
<body>
<div  class="dashboard-container">
<button><a href="login.html" class="a1">Logout</a></button>
    <h1>Welcome, <%= ((User) session.getAttribute("user")).getUsername() %> <%= ((User)session.getAttribute("user")).getRole() %> of VVIT</h1>
    <h2>Pending Appraisals for Finalization</h2>
    <table border="2">
        <thead>
            <tr>
                <th style="text-align: center;">Faculty Name</th>
                <th style="text-align: center;">Department</th>
                <th style="text-align: center;">Academic Year</th>
                <th style="text-align: center;">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                AppraisalDAO appraisalDAO = new AppraisalDAO();
    		    UserDAO userDAO = new UserDAO();
                List<Appraisal> appraisals = appraisalDAO.getPendingAppraisalsForPrincipal();
                for (Appraisal appraisal : appraisals) 
                {
                	User faculty = userDAO.getUserById(appraisal.getUserId());
            %>
            <tr>
                <td><%= faculty.getUsername() %></td>
                <td><%= faculty.getDepartment()  %></td>
                <td><%= appraisal.getAcademicyear() %></td>
                <td>
                    <a href="finalizeAppraisal.jsp?appraisalId=<%= appraisal.getAppraisalId() %>">Finalize</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <h2>Reviewed Appraisals </h2>
    
    <table border="2">
        <thead>
            <tr>
                <th style="text-align: center;">Faculty Name</th>
                <th style="text-align: center;">Department</th>
                <th style="text-align: center;">Academic Year</th>
                <th style="text-align: center;">Status</th>
                <th style="text-align: center;">View Appraisal</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Appraisal> appraisals1 = appraisalDAO.getAppraisalsForPrincipal();
                for (Appraisal appraisal : appraisals1) 
                {
                	User faculty = userDAO.getUserById(appraisal.getUserId());
            %>
            <tr>
                <td><%= faculty.getUsername() %></td>
                <td><%= faculty.getDepartment()  %></td>
                <td><%= appraisal.getAcademicyear() %></td>
                <td><%= appraisal.getStatus() %></td>
                <td>
                    <a href="viewAppraisalForPrincipal.jsp?appraisalId=<%= appraisal.getAppraisalId() %>">View Appraisal</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    
    </div>
</body>
</html>
