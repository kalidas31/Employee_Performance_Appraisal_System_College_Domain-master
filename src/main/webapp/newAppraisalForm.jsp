<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Appraisal Form</title>
    <link rel="stylesheet" href="NAstyles.css">
</head>
<body>
	<div class="new-Appraisal">
    <h2>Submit New Appraisal</h2>
    <form action="SubmitAppraisalServlet" method="post">
    	<label for="academicYear" >Select Academic Year:</label>
        <select style="width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 2px solid #ddd;
    border-radius: 4px;
    font-size: 14px;" name="academicYear">
        	<option value="select">Select</option>
            <option value="2023-2024">2023-2024</option>
            <option value="2024-2025">2024-2025</option>
            <option value="2025-2026">2025-2026</option>
            <option value="2026-2027">2026-2027</option>
            <option value="2027-2028">2027-2028</option>
        </select>
        <label>Syllabus Covered:</label>
        <input type="number" name="syllabusCovered" required><br>
        <label>Units Completed:</label>
        <input type="number" name="unitsCompleted" required><br>
        <label>Periods Conducted:</label>
        <input type="number" name="periodsConducted" required><br>
        <label>University Periods:</label>
        <input type="number" name="universityPeriods" required><br>
        <label>Pass Percentage:</label>
        <input type="number" name="passPercentage" required><br>
        <label>Fail Percentage:</label>
        <input type="number" name="failPercentage" required><br>
        <label>Extra Coaching:</label>
        <input type="text" name="extraCoaching" required><br>
        <label>Innovative Methods:</label>
        <input type="text" name="innovativeMethods" required><br>
        <label>Lab Sessions:</label>
        <input type="number" name="labSessions" required><br>
        <label>Experiments Completed:</label>
        <input type="number" name="experimentsCompleted" required><br>
        <label>Sponsorships:</label>
        <input type="text" name="sponsorships" required><br>
        <label>Seminars:</label>
        <input type="text" name="seminars" required><br>
        <label>Papers:</label>
        <input type="text" name="papers" required><br>
        <label>Other Assignments:</label>
        <input type="text" name="otherAssignments" required><br>
        <label>Appreciation:</label>
        <input type="text" name="appreciation" required><br>
        <label>Disciplinary Actions:</label>
        <input type="text" name="disciplinaryActions" required><br>
        <label>Other Activities:</label>
        <input type="text" name="otherActivities" required><br>
        <label>Leave Period:</label>
        <input type="text" name="leavePeriod" required><br>
        <label>Leave Date:</label>
        <input type="text" name="leaveDate" required><br>
        <label>No of Days:</label>
        <input type="number" name="noOfDays" required><br>
        <label>Proficiency:</label>
        <input type="text" name="proficiency" required><br>
        <input type="submit" value="Submit">
    </form>
    <center><a href="facultyDashboard.jsp">Back to Dashboard</a></center>
    </div>
</body>
</html>
