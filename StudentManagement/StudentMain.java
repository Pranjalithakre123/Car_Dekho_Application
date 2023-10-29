package com.jspiders.jdbc.StudentManagement;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		StudentJDBC jdbc = new StudentJDBC();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter 1 to add student.\nEnter 2 to getall students.\nEnter 3 get student by id .\nEnter 4 delete student by id4");
		
		
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			Student student = new Student();
			System.out.println("Enter student id");
			student.setId(scanner.nextInt());
			scanner.nextLine();
			
			System.out.println("Enter student name");
			student.setName(scanner.nextLine());
			
			System.out.println("Enter student email");
			student.setEmail(scanner.nextLine());
			
			System.out.println("Enter student age");
			student.setAge(scanner.nextInt());
			
			System.out.println("Enter student fees");
			student.setFees(scanner.nextDouble());
			
			jdbc.addStudent(student);
			break;
			
		case 2:
			List<Student> students = jdbc.getAllStudents();
			for(Student s :students) {
				System.out.println(s);
			}
			break;
		case 3 :
			System.out.println("Enter student id.");
			Student s = jdbc.getStudentById(scanner.nextInt());
			System.out.println(s);
			break;
		case 4:
			System.out.println("Enter student id.");
			jdbc.deleteStudent(scanner.nextInt());
			break;
		}
		scanner.close();
	}

}
