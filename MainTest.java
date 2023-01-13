package com.test;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		System.out.println("Welcome>>");

		Scanner scanner = new Scanner(System.in);
		// Creating Scanner object for dynamic input

		System.out.println("1. Insert / Create Employee Record :");

		System.out.println("2. Update Employee Record :");

		System.out.println("3. Delete Employee Record :");

		System.out.println("4. View Employee Record :");

		System.out.println("Please Select your choice :");

		int choice = 0; // local variable
		choice = scanner.nextInt(); // Scanning user input and storing

		switch (choice) {

		case 1:
			CrudOperation.insertRecord(); // calling Insert Record Method
			break;

		case 2:
			CrudOperation.updateRecord(); // calling Update Record method
			break;

		case 3:
			CrudOperation.deleteRecord(); // calling Delete Record method
			break;

		case 4:
			CrudOperation.retrieveRecord(); // calling Retrieve Record method
			break;

		default:
			System.out.println("Please select a valid Option");
		}
	}

}
