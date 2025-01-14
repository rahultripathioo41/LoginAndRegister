package controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import dao.CustomerDao;
import entity.Customer;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/LoginAndRegister")
public class MyController {

    public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public MyController() {
        System.out.println("MyController initialized");
    }
    
    private CustomerDao customerDao;

    @GetMapping("/register")
    public String goToRegisterPage() {
        System.out.println("Handling /register request");
        
        return "register";
    }
    
    @GetMapping("/registerDetails")
    public String goToProfile(@ModelAttribute Customer customer, Model model) {
        System.out.println("Customer Name: " + customer.getName());
        customerDao.insertCustomer(customer);
        model.addAttribute("customer", customer); // Add the customer object to the model
        return "Profile";
    }
    
    @GetMapping("/loginHere")
    public String goToLoginPage() {
        System.out.println("Handling /loginHere request");
        
        return "login";
    }

    @GetMapping("/login")
    public String gotoProfile(@ModelAttribute Customer customer ,Model  m) {
    	System.out.println("Handling /login1 request");
    	customer=customerDao.verifyLogin(customer.getEmail(),customer.getPassword());
    	
    	m.addAttribute("customer",customer);
    	System.out.println("checking whether customer exist or not");
        if(customer!=null)
        {
        	System.out.println("customer exist but now now  checking you are admin or not");
        	
        	if (customer.getEmail().equals("rahultripathioo41@gmail.com") && customer.getPassword().equals("hola")) 
        	{
        	    return "admin";
        	}

        	else 
        	{
        		System.out.println("you are not  the admin");
        		return "Profile";
        	}
        }
        else {
        	return "error";
        }
        
    }
}
