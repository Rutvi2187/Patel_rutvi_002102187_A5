/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    private ArrayList<Customer> cList;
    
     public CustomerDirectory() {
        cList = new ArrayList<>();
    }

    public ArrayList<Customer> getcList() {
        return cList;
    }

    public void setcList(ArrayList<Customer> cList) {
        this.cList = cList;
    }
    public Customer createCustomer(String name, String address, long phoneNumber, UserAccount userAccount){
        Customer c = new Customer();
        c.setcName(name);
        c.setcAddress(address);
        c.setcPhoneNumber(phoneNumber);
        c.setUserAccount(userAccount);
        cList.add(c);  
        return c;
    }
    
     public void deleteCustomer(Customer customer) {
        cList.remove(customer);
    }
}
