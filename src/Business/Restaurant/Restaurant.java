/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Restaurant  extends Organization{
    
        private String restaurentName;
    private String restaurentManager;
    private Long phoneNumber;
    private String address;
    private ArrayList<String> menulist;
    private UserAccount userAccount;
    
      public Restaurant() {
        super(Organization.Type.RestaurantAdmin.getValue());
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

    public String getRestaurentManager() {
        return restaurentManager;
    }

    public void setRestaurentManager(String restaurentManager) {
        this.restaurentManager = restaurentManager;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getMenulist() {
        return menulist;
    }

    public void setMenulist(ArrayList<String> menulist) {
        this.menulist = menulist;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

   
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminRole());
        return roles;
    }

}