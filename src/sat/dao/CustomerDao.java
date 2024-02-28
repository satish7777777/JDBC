package sat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sat.model.Customer;

public class CustomerDao {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Satish@123");
		return connection;
	}
	
	public void insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = this.getConnection();
		PreparedStatement pst = connection.prepareStatement("insert into customerdetails(id,name,address) values(?,?,?)");
		
		int id = customer.getId();
		String name = customer.getName();
		String address = customer.getAddress();
		
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, address);
		
		pst.executeUpdate();
		connection.close();
	}
	public void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = this.getConnection();
		PreparedStatement pst = connection.prepareStatement("insert into customerdetails(id,name,address) values(?,?,?)");
		
		int id = customer.getId();
		String name = customer.getName();
		String address = customer.getAddress();
		
		pst.setInt(1,id);
		pst.setString(2, name);
		pst.setString(3, address);
		
		pst.executeUpdate();
		connection.close();
	}
	public void deleteCustomer(int id)throws ClassNotFoundException,SQLException {
		Connection connection = this.getConnection();
		PreparedStatement pst = connection.prepareStatement("delete from customerdetails where id=?");
		
		pst.setInt(1,id);
		
	    pst.executeUpdate();
	    connection.close();
	    }
	public void displayCustomer() throws ClassNotFoundException, SQLException{
		Connection connection = this.getConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from customerdetails");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}

}
