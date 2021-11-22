/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Organization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
     private ArrayList<Organization> organizationList;
     private ArrayList<Restaurant> restaurentList;

    public RestaurantDirectory() {
        restaurentList = new ArrayList<>();
    }

    public ArrayList<Restaurant> getRestaurentList() {
        return restaurentList;
    }

    public void setRestaurentList(ArrayList<Restaurant> restaurentList) {
        this.restaurentList = restaurentList;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.RestaurantAdmin.getValue())){
            organization = new Restaurant();
            organizationList.add(organization);
        }
        return organization;
    }
    
        public Organization searchOrganization(String organizationName){
        for (Organization organization: organizationList) {
            if (organization.getName().equals(organizationName)) {
                return organization;
            }
        }
        return null;
    }

    public Restaurant createRestaurant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

