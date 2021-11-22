/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.Organization;
import Business.Role.DeliverManRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryMan extends Organization{
    private UserAccount DeliveryUser;

      public DeliveryMan() {
        super(Organization.Type.DeliveryMan.getValue());
    }

    public UserAccount getDeliveryUser() {
        return DeliveryUser;
    }

    public void setDeliveryUser(UserAccount DeliveryUser) {
        this.DeliveryUser = DeliveryUser;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliverManRole());
        return roles;
    }
  
}
