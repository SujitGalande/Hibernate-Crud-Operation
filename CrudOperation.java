package com.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudOperation {

	private static Session getSessionObject() {

		// Creating Configuration Object
		Configuration configuration = new Configuration();

		// Loading hibernate.cfg.xml file
		configuration.configure("hibernate.cfg.xml");

		// Creating SessionFactory Object
		SessionFactory sessionfactory = configuration.buildSessionFactory();

		// Creating Session object
		Session session = sessionfactory.openSession();

		// returning created session Object
		return session;
	}

	public static void insertRecord() {

		// calling getSessioObject method and storing the returned session object
		Session session = getSessionObject();

		Employee employee = new Employee();

		Scanner scanner1 = new Scanner(System.in);

		System.out.println("Enter the Employee Name:");

		String empname = scanner1.nextLine();
		employee.setEmpname(empname);

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Enter Employee City:");

		String city = scanner2.nextLine();
		employee.setCity(city);

		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter Employee Mobile Number:");

		String mobnum = scanner3.nextLine();
		employee.setMob(mobnum);

		session.save(employee);
		session.beginTransaction().commit();

		System.out.println("Record Inserted Successfully");
		session.close();
		scanner1.close();
		scanner2.close();
		scanner3.close();
	}

	public static void deleteRecord() {

		// calling getSessioObject method and storing the
		// returned session object
		Session session = getSessionObject();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please Enter a Employee Id to delete");

		int id = scanner.nextInt();

		Employee employee = (Employee) session.get(Employee.class, id);

		if (employee == null) {
			System.out.println("Employee Record does not Exits");

		} else {
			session.delete(employee);
			session.beginTransaction().commit();
			session.close();
			scanner.close();

			System.out.println("Employee Record deleted Successfully");
		}
	}

	public static void updateRecord() {
		// calling getSessioObject method and storing the
		// returned session object
		Session session = getSessionObject();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter a Employee Id to update");

		int id = scanner.nextInt();

		Employee employee = (Employee) session.get(Employee.class, id);

		System.out.println("Existing Data Is : " + employee);

		if (employee == null) {
			System.out.println("Employee Record does not Exits");
			System.out.println("Please Enter Valid Employee Id");
			updateRecord();
		} else {
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Enter Employee Name:");

			String empname = scanner1.nextLine();
			employee.setEmpname(empname);

			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter Employee City:");

			String city = scanner2.nextLine();
			employee.setCity(city);

			Scanner scanner3 = new Scanner(System.in);
			System.out.println("Enter Employee Mobile Number:");

			String mobnum = scanner3.nextLine();
			session.update(employee);

			session.beginTransaction().commit();

			session.close();
			scanner.close();
			scanner1.close();
			scanner2.close();
			scanner3.close();

			System.out.println("Employee Data Updated Successfully");
		}
	}

	public static void retrieveRecord() {
		// calling getSessioObject method and storing the returned session object

		Session session = getSessionObject();

		// retrieving all the database data for Employee Table and

		Query query = session.createQuery("from Employee");

		// storing into Query
		List<Employee> emplist = query.list();

		// converting Query into list for Iteration

		for (Employee e : emplist) {

			// using For Each loop for printing every record in
			// the List emplist

			System.out.println(e); // Printing the record
		}
	}

}
