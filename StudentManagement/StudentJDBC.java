package com.jspiders.jdbc.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentJDBC {
	
	private  Connection connection;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
   private  String query;
	
	
		public void addStudent(Student student) {
			try {
				connection=openConnection();
				query="Insert into student1 values(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt( 1,student.getId());
				preparedStatement.setString(2,student.getName());
				preparedStatement.setString(3,student.getEmail());
				preparedStatement.setInt( 4,student.getAge());
				preparedStatement.setDouble( 5,student.getFees());
				
			   int 	row=preparedStatement.executeUpdate();
			   System.out.println(row+"rows affected");
			   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public List<Student> getAllStudents(){
			ArrayList<Student> list = new ArrayList<>();
		
			try {
				connection=openConnection();
				query ="Select* from student1";
				preparedStatement = connection.prepareStatement(query);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					Student student = new Student();
					student.setId(resultSet.getInt( 1));
					student.setName(resultSet.getString( 2));
					student.setEmail(resultSet.getString( 3));
					student.setAge(resultSet.getInt( 4));
					student.setFees(resultSet.getDouble( 5));
					list.add(student);
				}
				
	         } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		public Student getStudentById(int id) {
			
			Student student = new  Student();
			try {
				connection=openConnection();
				query="Select* from student1 where id=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt( 1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					student.setId( resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setEmail(resultSet.getString(3));
					student.setAge(resultSet.getInt(4));
					student.setFees(resultSet.getDouble(5));
				}
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return student;
			
		}
		public void deleteStudent(int id) {

         try {
			connection = openConnection();
			query = "DELETE FROM student1 WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " row(s) affected.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
   private static Connection openConnection() throws SQLException,ClassNotFoundException {
	  Class.forName( "com.mysql.cj.jdbc.Driver");
	  return DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eepractice","root","root");
	  	

}
   private void closeConnection() throws SQLException {
	if(resultSet != null)
	{
		resultSet.close();
	}
	if(preparedStatement!= null)
	{
		preparedStatement.close();
	}
	if(connection != null)
	{
       connection.close();

	}
	
	
	
	
	
	
	
	

}
}
