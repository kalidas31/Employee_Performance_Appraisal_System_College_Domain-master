<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlet.Appraisal" %>
<%@ page import="com.example.servlet.AppraisalDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Finalize Appraisal</title>
    <link rel="stylesheet" type="text/css" href="RAstyles.css">
</head>
<body>
<div class="appraisal-container">
    <h1>Finalize Appraisal</h1>
    <%
        int appraisalId = Integer.parseInt(request.getParameter("appraisalId"));
        AppraisalDAO appraisalDAO = new AppraisalDAO();
       Appraisal appraisals = appraisalDAO.getAppraisalById(appraisalId);
      
    %>
    <form action="ReviewServlet" method="post">
        <input type="hidden" name="appraisalId" value="<%= appraisals.getAppraisalId() %>">
        <h3>Academic Works</h3>
        <table border="1">
            <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
       
        <tr>
            <td>Syllabus Covered</td>
            <td><%= appraisals.getSyllabusCovered() %></td>
        </tr>
        <tr>
            <td>Units Completed</td>
            <td><%= appraisals.getUnitsCompleted() %></td>
        </tr>
        <tr>
            <td>Periods Conducted</td>
            <td><%= appraisals.getPeriodsConducted() %></td>
        </tr>
        <tr>
            <td>University Periods</td>
            <td><%= appraisals.getUniversityPeriods() %></td>
        </tr>
        <tr>
            <td>Pass Percentage</td>
            <td><%= appraisals.getPassPercentage() %></td>
        </tr>
        <tr>
            <td>Fail Percentage</td>
            <td><%= appraisals.getFailPercentage() %></td>
        </tr>
        <tr>
            <td>Extra Coaching</td>
            <td><%= appraisals.getExtraCoaching() %></td>
        </tr>
        <tr>
            <td>Innovative Methods</td>
            <td><%= appraisals.getInnovativeMethods() %></td>
        </tr>
        <tr>
            <td>Lab Sessions</td>
            <td><%= appraisals.getLabSessions() %></td>
        </tr>
        <tr>
            <td>Experiments Completed</td>
            <td><%= appraisals.getExperimentsCompleted() %></td>
        </tr>
        <tr>
            <td>Sponsorships</td>
            <td><%= appraisals.getSponsorships() %></td>
        </tr>
        <tr>
            <td>Seminars</td>
            <td><%= appraisals.getSeminars() %></td>
        </tr>
        <tr>
            <td>Papers</td>
            <td><%= appraisals.getPapers() %></td>
        </tr>
        <tr>
            <td>Other Assignments</td>
            <td><%= appraisals.getOtherAssignments() %></td>
        </tr>
        <tr>
            <td>Appreciation</td>
            <td><%= appraisals.getAppreciation() %></td>
        </tr>
        <tr>
            <td>Disciplinary Actions</td>
            <td><%= appraisals.getDisciplinaryActions() %></td>
        </tr>
        <tr>
            <td>Other Activities</td>
            <td><%= appraisals.getOtherActivities() %></td>
        </tr>
        <tr>
            <td>Leave Period</td>
            <td><%= appraisals.getLeavePeriod() %></td>
        </tr>
        <tr>
            <td>Leave Date</td>
            <td><%= appraisals.getLeaveDate() %></td>
        </tr>
        <tr>
            <td>No of Days</td>
            <td><%= appraisals.getNoOfDays() %></td>
        </tr>
        <tr>
            <td>Proficiency</td>
            <td><%= appraisals.getProficiency() %></td>
        </tr>
        <tr>
            <td>HOD Remarks</td>
            <td><%= appraisals.getHodRemarks() %></td>
        </tr>
        
             </table>
       
        
        <fieldset>
            <legend>Principal Remarks</legend>
            <textarea id="principalRemarks" name="principalRemarks"><%= appraisals.getPrincipalRemarks() %></textarea>
        </fieldset>
        
        <input type="submit" value="Finalize Appraisal">
    </form>
    <br>
    <a href="PrincipalDashboard.jsp" class="a1">Back to Dashboard</a>
    </div>
</body>
</html>
            
