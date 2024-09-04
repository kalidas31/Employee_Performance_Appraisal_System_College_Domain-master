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
    <title>HOD Dashboard</title>
    <link rel="stylesheet" type="text/css" href="HDstyles.css">
    <script>
        function showAlert(message) 
        {
            alert(message);
        }
    </script>
</head>
<body>
	<div  class="dashboard-container">
	
	<button><a href="login.html" class="a1">Logout</a></button>
    <h1>Welcome, <%= ((User) session.getAttribute("user")).getUsername() %> <%= ((User)session.getAttribute("user")).getRole() %> of <%= ((User)session.getAttribute("user")).getDepartment() %> Dept.</h1>
    
    <form action="HODDashboard.jsp" method="post">
        <label for="academicYear" >Select Academic Year:</label>
        <select id="academicYear" name="academicYear">
        	<option value="select">Select</option>
            <option value="2023-2024">2023-2024</option>
            <option value="2024-2025">2024-2025</option>
            <option value="2025-2026">2025-2026</option>
            <option value="2026-2027">2026-2027</option>
            <option value="2027-2028">2027-2028</option>
        </select>
        <input  style="margin-left:20px; color:white; background-color: #007bff;  border: none;
    border-radius: 4px; height:20px; width:200px;" type="submit" value="Release Appraisal Form">
    </form>
    
    <br>
    <h2>Pending Appraisals for Review</h2>
    <table border="2">
        <thead>
            <tr>
                <th style="text-align: center;">Faculty Name</th>
                <th style="text-align: center;">Academic Year</th>
                <th style="text-align: center;">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                AppraisalDAO appraisalDAO = new AppraisalDAO();
    		     UserDAO userDAO = new UserDAO();
    		   String ay = request.getParameter("academicYear");
    		   String dept=((User) session.getAttribute("user")).getDepartment();
    			
    			if(ay!=null)
    			{
    				String deptay=dept+ay.substring(0, 4);
    				try
    				{
    					appraisalDAO.insertAppraisalForm(dept, ay,deptay);
    				}
    				catch(Exception e)
    				{
    					String msg="Appraisal forms for this Academic Year already released";
    		%>
    					<script>
        					showAlert("<%= msg %>");
    					</script>
    		<% 
    		
    				}
    				
    			}
    		
                List<Appraisal> appraisals = appraisalDAO.getPendingAppraisalsForHOD(dept);
                for (Appraisal appraisal : appraisals) 
                {
                    User faculty = userDAO.getUserById(appraisal.getUserId());
            %>
            <tr>
                <td><%= faculty.getUsername() %></td>
                <td><%= appraisal.getAcademicyear() %></td>
                <td>
                    <a href="reviewAppraisal.jsp?appraisalId=<%= appraisal.getAppraisalId() %>">Review</a>
 						               
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <h2>Reviewed Appraisals</h2>
    <table border="2">
        <thead>
            <tr>
                <th style="text-align: center;">Faculty Name</th>
                <th style="text-align: center;">Academic Year</th>
                <th style="text-align: center;">Status</th>
                <th style="text-align: center;">View Appraisal</th>
            </tr>
        </thead>
        <tbody>
        <%
        List<Appraisal> appraisals1 = appraisalDAO.getAppraisalsForHOD(dept);
        for (Appraisal appraisal : appraisals1) 
        {
            User faculty = userDAO.getUserById(appraisal.getUserId());
        
        %>
            <tr>
                <td><%= faculty.getUsername() %></td>
                <td><%= appraisal.getAcademicyear() %></td>
                <td><%= appraisal.getStatus() %></td>
                <td>
                  <a href="viewAppraisalForHOD.jsp?appraisalId=<%= appraisal.getAppraisalId() %>">View Appraisal</a>                   
                </td>
            </tr>
             <% } %>
        </tbody>
    </table>
    </div>
</body>
</html>
