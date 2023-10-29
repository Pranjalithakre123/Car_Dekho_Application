package com.jspiders.CarManagement;

import java.util.List;
import java.util.Scanner;

public class CarMain {
	
		public static void main(String[] args) {
            CarJDBC jdbc = new CarJDBC();
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter 1 to add car.\nEnter 2 to getall carss.\nEnter 3 get car by id .\nEnter 4 delete car by id.\nEnter 5 get car by name.\n Enter 6 Get Car  by Brand.\n Enter 7 get Car by FuelType");
			
			
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				Car car = new Car();
				System.out.println("Enter Car id");
				car.setId(scanner.nextInt());
				scanner.nextLine();
				
				System.out.println("Enter car name");
				car.setName(scanner.nextLine());
				
				System.out.println("Enter car   Brand");
				car.setBrand(scanner.nextLine());
				
				System.out.println("Enter car fueltype");
				car.setFueltype(scanner.nextLine());
				
				System.out.println("Enter price");
				car.setPrice(scanner.nextInt());
				
				jdbc.addCar(car);
				break;
				
			case 2:
				List<Car> cars = jdbc.getAllCars();
				for(Car c :cars) {
					System.out.println(c);
				}
				break;
			case 3 :
				System.out.println("Enter car id.");
				Car c = jdbc.getCarById(scanner.nextInt());
				System.out.println(c);
				break;
			case 4:
				System.out.println("Enter car id.");
				jdbc.deleteCar(scanner.nextInt());
				break;
			case 5:
				System.out.println("Enter car  name");
				Car c1 = jdbc.getCarByName( scanner.nextLine());
				System.out.println(c1);
				break;
			
			case 6:
				System.out.println("Enter car brand");
				 Car c2=jdbc.getCarByName( scanner.nextLine());
				 System.out.println(c2);
				 
			case 7:
				System.out.println("Enter car fuel type");
				 Car c3=jdbc.getCarByFuelType( scanner.nextLine());
				 System.out.println(c3);
			}	
			scanner.close();
		}

	
      
		
		
		
}

