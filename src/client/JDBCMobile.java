package client;

import java.sql.SQLException;
import java.util.Scanner;

import sat.model.Customer;
import sat.service.CustomerService;

public class JDBCMobile {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		@SuppressWarnings("resource")
		Scanner insert = new Scanner(System.in);
		CustomerService custData = new CustomerService();
		
		while(true) {
			System.out.println("Menu");
			System.out.println("1, Insert Customer");
			System.out.println("2, Update Customer");
			System.out.println("3, Delete Customer");
			System.out.println("4, Display Customer");
			System.out.println("5, Exit");
			System.out.println("ENter your coice");
			
			int choice = insert.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter ID:-");
				int id = insert.nextInt();
				insert.nextLine();
				System.out.println("ENter Customer Name:-");
				String name = insert.nextLine();
				System.out.println("Enter Customer Address:-");
				String address = insert.nextLine();
				Customer cust = new Customer(id, name, address);
				custData.insertCustomer(cust);
				System.out.println("Data Added Successfully.");
				break;
			case 2:
				System.out.println("ENter ID to update:-");
				int updateid = insert.nextInt();
				insert.nextLine();
				System.out.println("Enter Updated Customer name");
				String updatename = insert.nextLine();
				System.out.println("ENter Updated Address");
				String updateaddress = insert.nextLine();
				Customer updatedcust = new Customer(updateid,updatename,updateaddress);
				System.out.println("User updated Successfully.");
				custData.updateCustomer(updatedcust);
				System.out.println("User updated Successfully.");
				break;
			case 3:
				System.out.println("Enter ID to Delete:-");
				int deleteCustomer = insert.nextInt();
				custData.deleteCustomer(deleteCustomer);
				System.out.println("Data Deleted Sccessfully.");
				break;
			case 4:
				custData.displayCustomer();
				break;
			case 5:
				System.out.println("Exit");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice . please enter a valid option .");
				}
		}
		
	}

}
