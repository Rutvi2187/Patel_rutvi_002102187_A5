package Business;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        // System Admin
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        
        //Restaurant Management 1
       Employee restMan = system.getEmployeeDirectory().createEmployee("Rest Manager 1");
       UserAccount restuser = system.getUserAccountDirectory().createUserAccount("manager1", "manager1", restMan, new AdminRole());
       Restaurant restaurant = system.getRestaurantDirectory().createRestaurant();
       restaurant.setRestaurentManager(restuser);
      // restuser.setWorkAreaObj(restaurant);
       restaurant.setRestaurentName("Indian Tadka");
       List<String> menu = new ArrayList<>(Arrays.asList("Paneer", "Chicken", "Dosa"));
       restaurant.setMenulist(menu);
       
       //Restaurant Management 2
       Employee restMan1 = system.getEmployeeDirectory().createEmployee(" Rest Manager 2");
       UserAccount  restuser1 = system.getUserAccountDirectory().createUserAccount("manager2", "mng2", restMan1, new AdminRole());
       Restaurant restaurant1 = system.getRestaurantDirectory().createRestaurant();
       restaurant1.setRestaurentManager(restuser);
       //restuser1.setWorkAreaObj(restaurant1);
       restaurant1.setRestaurentName("Mexican Cuisine");
       List<String> menu1 = new ArrayList<>( Arrays.asList("Pasta", "Tacos","Pizza"));
       restaurant1.setMenulist(menu1);
         
        //Customer Management 1
       Employee cust = system.getEmployeeDirectory().createEmployee("customer1");
       UserAccount custuser = system.getUserAccountDirectory().createUserAccount("cust1", "cust1", cust, new CustomerRole());
       Customer customer = system.getCustomerDirectory().createCustomer();
       customer.setCustomerUser(custuser);
       //custuser.setWorkAreaObj(customer);
       
         //Customer Management 2
       Employee cust1 = system.getEmployeeDirectory().createEmployee("customer2");
       UserAccount custuser1 = system.getUserAccountDirectory().createUserAccount("cust2", "cust2", cust1, new CustomerRole());
       Customer customer1 = system.getCustomerDirectory().createCustomer();
       customer1.setCustomerUser(custuser1);
      // custuser1.setWorkAreaObj(customer1);
       
       //Delivery Man Management 1
       Employee delEmp = system.getEmployeeDirectory().createEmployee("delivery man 1");
       UserAccount deluser = system.getUserAccountDirectory().createUserAccount("del1", "del1", delEmp, new DeliverManRole());
       DeliveryMan deliveryMan = system.getDeliveryManDirectory().createDeliveryMan();
       deliveryMan.setDeliveryUser(deluser);
        return system;
    }
    
}