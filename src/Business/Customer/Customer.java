/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class Customer {
    private String cName;
    private String cAddress;
    private long cPhoneNumber; 
    private UserAccount userAccount;
   
    public Customer(){
        userAccount = new UserAccount();
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public long getcPhoneNumber() {
        return cPhoneNumber;
    }

    public void setcPhoneNumber(long cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }
    
    @Override
    public String toString(){
        return cName;
    }
}
