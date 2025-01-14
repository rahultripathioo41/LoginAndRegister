package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import entity.Customer;

public class CustomerDao {
	
	
	 public Customer verifyLogin(String email, String password) {
	        Transaction transaction = null;
	        Session session = null;

	        try {
	            // Step 1: Create Configuration
	            Configuration configuration = new Configuration();
	            configuration.configure("config/hibernate.cfg.xml");

	            // Step 2: Build SessionFactory
	            SessionFactory sessionFactory = configuration.buildSessionFactory();

	            // Step 3: Open Session
	            session = sessionFactory.openSession();

	            // Step 4: Begin Transaction
	            transaction = session.beginTransaction();
	            
	            

	            // Step 5: Query to verify login
	            Customer customer = (Customer) session.createQuery("FROM Customer WHERE email = :email AND password = :password")
	                    .setParameter("email", email)
	                    .setParameter("password", password)
	                    .uniqueResult();

	            transaction.commit();

	            // Step 6: Return result
	            if (customer != null) {
	                System.out.println("Login successful");
	                return customer; // Login successful
	            } else {
	                System.out.println("Invalid credentials");
	                return null; // Login failed
	            }
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return null; // Login failed due to exception
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	    }

    // Method to insert a customer record
    public void insertCustomer(Customer customer) {
        Transaction transaction = null;
        Session session = null; // Declare session outside try block for clarity

        try {
            // Step 1: Create a Configuration object
            Configuration configuration = new Configuration();
            configuration.configure("config/hibernate.cfg.xml"); // Load configuration

            // Step 2: Build a SessionFactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Step 3: Open a Session
            session = sessionFactory.openSession();

            // Step 4: Begin a Transaction
            transaction = session.beginTransaction();

            // Step 5: Save the customer object to the database
            session.save(customer);

            // Step 6: Commit the Transaction
            transaction.commit();

            System.out.println("Customer record inserted successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction if an error occurs
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
    }
}
