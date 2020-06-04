/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.q2;

import java.util.*;

/**
 *
 * @author ryand
 * Class for a non paying customer. extends customer
 */
public class AssociateCustomer extends Customer{

    public AssociateCustomer() {
        super("Not Set", "Not Set");
        this.IsPaying = false;
    }
    
    public AssociateCustomer(String Name) {
        super(Name, "Not Set");
        this.IsPaying = false;
    }
    
    public AssociateCustomer(String Name, String EmailAddress) {
        super(Name, EmailAddress);
        this.IsPaying = false;
    }  
}
