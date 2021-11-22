/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Organization;
import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Customer extends Organization {
    private UserAccount CustomerUser;
    
      public Customer() {
        super(Organization.Type.Customer.getValue());
    }

    public UserAccount getCustomerUser() {
        return CustomerUser;
    }

    public void setCustomerUser(UserAccount CustomerUser) {
        this.CustomerUser = CustomerUser;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustomerRole());
        return roles;
    }
}