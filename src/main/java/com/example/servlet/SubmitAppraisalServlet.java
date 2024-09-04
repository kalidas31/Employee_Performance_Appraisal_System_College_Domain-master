package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.servlet.AppraisalDAO;
import com.example.servlet.Appraisal;
import com.example.servlet.User;


public class SubmitAppraisalServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) 
        {
            response.sendRedirect("login.html");
            return;
        }

        int syllabusCovered = Integer.parseInt(request.getParameter("syllabusCovered"));
        int unitsCompleted = Integer.parseInt(request.getParameter("unitsCompleted"));
        int periodsConducted = Integer.parseInt(request.getParameter("periodsConducted"));
        int universityPeriods = Integer.parseInt(request.getParameter("universityPeriods"));
        int passPercentage = Integer.parseInt(request.getParameter("passPercentage"));
        int failPercentage = Integer.parseInt(request.getParameter("failPercentage"));
        String extraCoaching = request.getParameter("extraCoaching");
        String innovativeMethods = request.getParameter("innovativeMethods");
        int labSessions = Integer.parseInt(request.getParameter("labSessions"));
        int experimentsCompleted = Integer.parseInt(request.getParameter("experimentsCompleted"));
        String sponsorships = request.getParameter("sponsorships");
        String seminars = request.getParameter("seminars");
        String papers = request.getParameter("papers");
        String otherAssignments = request.getParameter("otherAssignments");
        String appreciation = request.getParameter("appreciation");
        String disciplinaryActions = request.getParameter("disciplinaryActions");
        String otherActivities = request.getParameter("otherActivities");
        String leavePeriod = request.getParameter("leavePeriod");
        String leaveDate = request.getParameter("leaveDate");
        int noOfDays = Integer.parseInt(request.getParameter("noOfDays"));
        String proficiency = request.getParameter("proficiency");
        String academicYear=request.getParameter("academicYear");

        Appraisal appraisal = new Appraisal();
        String dept=user.getDepartment();
        appraisal.setDepartment(dept);
        appraisal.setUserId(user.getUserId());
        appraisal.setSyllabusCovered(syllabusCovered);
        appraisal.setUnitsCompleted(unitsCompleted);
        appraisal.setPeriodsConducted(periodsConducted);
        appraisal.setUniversityPeriods(universityPeriods);
        appraisal.setPassPercentage(passPercentage);
        appraisal.setFailPercentage(failPercentage);
        appraisal.setExtraCoaching(extraCoaching);
        appraisal.setInnovativeMethods(innovativeMethods);
        appraisal.setLabSessions(labSessions);
        appraisal.setExperimentsCompleted(experimentsCompleted);
        appraisal.setSponsorships(sponsorships);
        appraisal.setSeminars(seminars);
        appraisal.setPapers(papers);
        appraisal.setOtherAssignments(otherAssignments);
        appraisal.setAppreciation(appreciation);
        appraisal.setDisciplinaryActions(disciplinaryActions);
        appraisal.setOtherActivities(otherActivities);
        appraisal.setLeavePeriod(leavePeriod);
        appraisal.setLeaveDate(leaveDate);
        appraisal.setNoOfDays(noOfDays);
        appraisal.setProficiency(proficiency);
        appraisal.setStatus("submitted");
        appraisal.setAcademicyear(academicYear);

        AppraisalDAO appraisalDAO;
		try 
		{
			appraisalDAO = new AppraisalDAO();
			appraisalDAO.insertAppraisal(appraisal);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
        response.sendRedirect("facultyDashboard.jsp");
    }
}
