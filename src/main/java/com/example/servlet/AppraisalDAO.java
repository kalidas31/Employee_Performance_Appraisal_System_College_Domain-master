package com.example.servlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AppraisalDAO 
{
    private Connection connection;

    public AppraisalDAO() throws ClassNotFoundException, SQLException 
    {
    	initializeConnection();
    }

    

    private void initializeConnection() throws ClassNotFoundException, SQLException 
    {
    	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "system"; 
        String password = "system"; 

        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);	
	}

	public List<Appraisal> getPendingAppraisalsForHOD(String dept) 
	{
        List<Appraisal> appraisals = new ArrayList<Appraisal>();
        try 
        {
            String query = "SELECT * FROM Appraisal WHERE status = ? AND department= ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "submitted");
            statement.setString(2,dept);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) 
            {
                Appraisal appraisal = new Appraisal();
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisals.add(appraisal);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }

    public List<Appraisal> getPendingAppraisalsForPrincipal() 
    {
        List<Appraisal> appraisals = new ArrayList<Appraisal>();
        try 
        {
            String query = "SELECT * FROM Appraisal WHERE status = 'reviewed'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) 
            {
                Appraisal appraisal = new Appraisal();
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setHodRemarks(resultSet.getString("hodRemarks"));
                appraisal.setPrincipalRemarks(resultSet.getString("principalRemarks"));
                appraisal.setStatus(resultSet.getString("status"));
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisals.add(appraisal);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }

    public Appraisal getAppraisalById(int appraisalId) 
    {
    	Appraisal appraisal = new Appraisal();
        try 
        {
            String query = "SELECT * FROM Appraisal WHERE appraisalId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, appraisalId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setLeavePeriod(resultSet.getString("leavePeriod"));
                appraisal.setLeaveDate(resultSet.getString("leaveDate"));
                appraisal.setNoOfDays(resultSet.getInt("noOfDays"));
                appraisal.setProficiency(resultSet.getString("proficiency"));
                appraisal.setHodRemarks(resultSet.getString("hodRemarks"));
                appraisal.setPrincipalRemarks(resultSet.getString("principalRemarks"));
                appraisal.setStatus(resultSet.getString("status"));
                
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisal;
    }

    public void updateAppraisal(Appraisal appraisal) 
    {
        try 
        {
            String query = "UPDATE Appraisal SET syllabusCovered = ?, unitsCompleted = ?, periodsConducted = ?, universityPeriods = ?, passPercentage = ?, failPercentage = ?, extraCoaching = ?, innovativeMethods = ?, labSessions = ?, experimentsCompleted = ?, sponsorships = ?, seminars = ?, papers = ?, otherAssignments = ?, appreciation = ?, disciplinaryActions = ?, otherActivities = ?, leavePeriod = ?, leaveDate = ?, noOfDays = ?, proficiency = ?, hodRemarks = ?, principalRemarks = ?, status = ? WHERE appraisalId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ((Appraisal) appraisal).getSyllabusCovered());
            statement.setInt(2, ((Appraisal) appraisal).getUnitsCompleted());
            statement.setInt(3, ((Appraisal) appraisal).getPeriodsConducted());
            statement.setInt(4, ((Appraisal) appraisal).getUniversityPeriods());
            statement.setInt(5, ((Appraisal) appraisal).getPassPercentage());
            statement.setInt(6, ((Appraisal) appraisal).getFailPercentage());
            statement.setString(7, ((Appraisal) appraisal).getExtraCoaching());
            statement.setString(8, ((Appraisal) appraisal).getInnovativeMethods());
            statement.setInt(9, ((Appraisal) appraisal).getLabSessions());
            statement.setInt(10, ((Appraisal) appraisal).getExperimentsCompleted());
            statement.setString(11, ((Appraisal) appraisal).getSponsorships());
            statement.setString(12, ((Appraisal) appraisal).getSeminars());
            statement.setString(13, ((Appraisal) appraisal).getPapers());
            statement.setString(14, ((Appraisal) appraisal).getOtherAssignments());
            statement.setString(15, ((Appraisal) appraisal).getAppreciation());
            statement.setString(16, ((Appraisal) appraisal).getDisciplinaryActions());
            statement.setString(17, ((Appraisal) appraisal).getOtherActivities());
            statement.setString(18, ((Appraisal) appraisal).getLeavePeriod());
            statement.setString(19, ((Appraisal) appraisal).getLeaveDate());
            statement.setInt(20, ((Appraisal) appraisal).getNoOfDays());
            statement.setString(21, ((Appraisal) appraisal).getProficiency());
            statement.setString(22, ((Appraisal) appraisal).getHodRemarks());
            statement.setString(23, ((Appraisal) appraisal).getPrincipalRemarks());
            statement.setString(24, ((Appraisal) appraisal).getStatus());
            statement.setInt(25, ((Appraisal) appraisal).getAppraisalId());
            statement.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }



	public void insertAppraisal(Appraisal appraisal) 
	{
		try 
		{
            String query = "INSERT INTO Appraisal (userId, syllabusCovered, unitsCompleted, periodsConducted, universityPeriods, passPercentage, failPercentage, extraCoaching, innovativeMethods, labSessions, experimentsCompleted, sponsorships, seminars, papers, otherAssignments, appreciation, disciplinaryActions, otherActivities, leavePeriod, leaveDate, noOfDays, proficiency, status, department,academicyear) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, appraisal.getUserId());
            statement.setInt(2, appraisal.getSyllabusCovered());
            statement.setInt(3, appraisal.getUnitsCompleted());
            statement.setInt(4, appraisal.getPeriodsConducted());
            statement.setInt(5, appraisal.getUniversityPeriods());
            statement.setInt(6, appraisal.getPassPercentage());
            statement.setInt(7, appraisal.getFailPercentage());
            statement.setString(8, appraisal.getExtraCoaching());
            statement.setString(9, appraisal.getInnovativeMethods());
            statement.setInt(10, appraisal.getLabSessions());
            statement.setInt(11, appraisal.getExperimentsCompleted());
            statement.setString(12, appraisal.getSponsorships());
            statement.setString(13, appraisal.getSeminars());
            statement.setString(14, appraisal.getPapers());
            statement.setString(15, appraisal.getOtherAssignments());
            statement.setString(16, appraisal.getAppreciation());
            statement.setString(17, appraisal.getDisciplinaryActions());
            statement.setString(18, appraisal.getOtherActivities());
            statement.setString(19, appraisal.getLeavePeriod());
            statement.setString(20, appraisal.getLeaveDate());
            statement.setInt(21, appraisal.getNoOfDays());
            statement.setString(22, appraisal.getProficiency());
            statement.setString(23, appraisal.getStatus());
            statement.setString(24, appraisal.getDepartment());
            statement.setString(25, appraisal.getAcademicyear());
            

            statement.executeUpdate();
        } 
		catch (SQLException e) 
		{
            e.printStackTrace();
        }
		
	}
	public List<Appraisal> getAppraisalByUsername(int uid) 
    {
        List<Appraisal> appraisals = new ArrayList<Appraisal>();
        try 
        {
        	String query = "SELECT * FROM Appraisal WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, uid);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                Appraisal appraisal = new Appraisal();
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setHodRemarks(resultSet.getString("hodRemarks"));
                appraisal.setPrincipalRemarks(resultSet.getString("principalRemarks"));
                appraisal.setStatus(resultSet.getString("status"));
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisals.add(appraisal);
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }
	
	public void insertAppraisalForm(String dept,String academicYear, String deptay) throws SQLException
	{
		
		String query = "INSERT INTO appraisalforms (department,academicyear,released,deptay) values(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, dept);
        statement.setString(2, academicYear);
        statement.setString(3, "yes");
        statement.setString(4, deptay);
        statement.executeUpdate();
        
	}
	
	public List<AppraisalForms> getPendingAppraisals() 
    {
        List<AppraisalForms> appraisals = new ArrayList<AppraisalForms>();
        try 
        {
            String query = "SELECT * FROM appraisalforms";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) 
            {
                AppraisalForms appraisal = new AppraisalForms();
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisal.setDepartment(resultSet.getString("department"));
                appraisal.setReleased(resultSet.getString("released"));
                appraisals.add(appraisal);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }
	
	public String getStatus(String ay,int userid) throws SQLException
	{
		
	
		String query = "SELECT * FROM Appraisal WHERE userId = ? AND academicyear = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userid);
        statement.setString(2, ay);
        ResultSet resultSet = statement.executeQuery();
        String status=null;
        while (resultSet.next()) 
        {
        	status=resultSet.getString("status");
        }
    
    
    return status;
		
	}
	
	public List<Appraisal> getAppraisalsForHOD(String dept) 
	{
        List<Appraisal> appraisals = new ArrayList<Appraisal>();
        try 
        {
            String query = "SELECT * FROM Appraisal WHERE (status = ? OR status = ?) AND department = ? ";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setString(1, "reviewed");
            statement.setString(2, "finalized");
            statement.setString(3,dept);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) 
            {
                Appraisal appraisal = new Appraisal();
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisal.setStatus(resultSet.getString("status"));
                appraisals.add(appraisal);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }
	
	public List<Appraisal> getAppraisalsForPrincipal() 
    {
        List<Appraisal> appraisals = new ArrayList<Appraisal>();
        try 
        {
            String query = "SELECT * FROM Appraisal WHERE status = 'finalized'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) 
            {
                Appraisal appraisal = new Appraisal();
                appraisal.setAppraisalId(resultSet.getInt("appraisalId"));
                appraisal.setUserId(resultSet.getInt("userId"));
                appraisal.setSyllabusCovered(resultSet.getInt("syllabusCovered"));
                appraisal.setUnitsCompleted(resultSet.getInt("unitsCompleted"));
                appraisal.setPeriodsConducted(resultSet.getInt("periodsConducted"));
                appraisal.setUniversityPeriods(resultSet.getInt("universityPeriods"));
                appraisal.setPassPercentage(resultSet.getInt("passPercentage"));
                appraisal.setFailPercentage(resultSet.getInt("failPercentage"));
                appraisal.setExtraCoaching(resultSet.getString("extraCoaching"));
                appraisal.setInnovativeMethods(resultSet.getString("innovativeMethods"));
                appraisal.setLabSessions(resultSet.getInt("labSessions"));
                appraisal.setExperimentsCompleted(resultSet.getInt("experimentsCompleted"));
                appraisal.setSponsorships(resultSet.getString("sponsorships"));
                appraisal.setSeminars(resultSet.getString("seminars"));
                appraisal.setPapers(resultSet.getString("papers"));
                appraisal.setOtherAssignments(resultSet.getString("otherAssignments"));
                appraisal.setAppreciation(resultSet.getString("appreciation"));
                appraisal.setDisciplinaryActions(resultSet.getString("disciplinaryActions"));
                appraisal.setOtherActivities(resultSet.getString("otherActivities"));
                appraisal.setHodRemarks(resultSet.getString("hodRemarks"));
                appraisal.setPrincipalRemarks(resultSet.getString("principalRemarks"));
                appraisal.setStatus(resultSet.getString("status"));
                appraisal.setAcademicyear(resultSet.getString("academicyear"));
                appraisals.add(appraisal);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return appraisals;
    }





	
}
