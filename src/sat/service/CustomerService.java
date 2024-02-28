package sat.service;

import java.sql.SQLException;

import sat.dao.CustomerDao;
import sat.model.Customer;

public class CustomerService {
	CustomerDao dao = new CustomerDao();
	
	public void insertCustomer(Customer customer) throws SQLException,ClassNotFoundException{
		dao.insertCustomer(customer);
	}
	
	public void updateCustomer(Customer customer) throws SQLException,ClassNotFoundException{
		dao.updateCustomer(customer);
	}
	public void deleteCustomer(int id) throws SQLException, ClassNotFoundException{
		dao.deleteCustomer(id);
	}
	public void displayCustomer() throws SQLException, ClassNotFoundException{
		dao.displayCustomer();
	}

}
