package com.jspiders.CarManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CarJDBC {

	private  Connection connection;
	private  PreparedStatement preparedStatement;
	private  ResultSet resultSet;
   private  String query;
	
	
		public void addCar(Car car) {
			try {
				connection=openConnection();
				query="Insert into car values(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt( 1,car.getId());
				preparedStatement.setString(2,car.getName());
				preparedStatement.setString(3,car.getBrand());
				preparedStatement.setString( 4,car.getFueltype());
				preparedStatement.setInt( 5,car.getPrice());
				
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
		public List<Car> getAllCars(){
			ArrayList<Car> list = new ArrayList<>();
		
			try {
				connection=openConnection();
				query ="Select* from car";
				preparedStatement = connection.prepareStatement(query);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					Car car = new Car();
					car.setId(resultSet.getInt( 1));
					car.setName(resultSet.getString( 2));
					car.setBrand(resultSet.getString( 3));
					car.setFueltype(resultSet.getString( 4));
					car.setPrice(resultSet.getInt( 5));
					list.add(car);
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
		public Car getCarById(int id) {
			
			Car car = new  Car ();
			try {
				connection=openConnection();
				query="Select* from car where id=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt( 1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					 car.setId( resultSet.getInt(1));
					 car.setName(resultSet.getString(2));
					 car.setBrand(resultSet.getString(3));
					 car.setFueltype(resultSet.getString(4));
					 car.setPrice(resultSet.getInt(5));
				}
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  car;
			
		}
		public Car getCarByName( String name) {
			
			Car car = new  Car ();
			try {
				connection=openConnection();
				query="Select* from car where name=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString( 1,name);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					 car.setId( resultSet.getInt(1));
					 car.setName(resultSet.getString(2));
					 car.setBrand(resultSet.getString(3));
					 car.setFueltype(resultSet.getString(4));
					 car.setPrice(resultSet.getInt(5));
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  car;
			
		}
public Car getCarByBrand( String brand) {
	
	Car car = new  Car ();
	try {
		connection=openConnection();
		query="Select* from car where id=?";
		preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString( 1,brand);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			 car.setId( resultSet.getInt(1));
			 car.setName(resultSet.getString(2));
			 car.setBrand(resultSet.getString(3));
			 car.setFueltype(resultSet.getString(4));
			 car.setPrice(resultSet.getInt(5));
	}
		
		
		
} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return  car;
	
}
public Car getCarByFuelType( String fueltype) {
	
	Car car = new  Car ();
	try {
		connection=openConnection();
		query="Select* from car where id=?";
		preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString( 1,fueltype);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			 car.setId( resultSet.getInt(1));
			 car.setName(resultSet.getString(2));
			 car.setBrand(resultSet.getString(3));
			 car.setFueltype(resultSet.getString(4));
			 car.setPrice(resultSet.getInt(5));
	}
		
		
		
} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return  car;
	
}
		public void deleteCar(int id) {

         try {
			connection = openConnection();
			query = "DELETE FROM car WHERE id = ?";
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


