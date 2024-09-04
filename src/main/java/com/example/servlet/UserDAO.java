package com.example.servlet;
import java.sql.*;

public class UserDAO 
{
    private Connection connection;

    public UserDAO() throws ClassNotFoundException, SQLException 
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

	public User authenticate(String username, String password) {
        try {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setDepartment(resultSet.getString("department"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int userId) 
    {
        try {
            String query = "SELECT * FROM Users WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setDepartment(resultSet.getString("department"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
