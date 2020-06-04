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
 * class for paying customer. extends customer.
 */
public class PayingCustomer extends Customer{
    private PaymentMethod PayMethod;
    private final ArrayList<AssociateCustomer> Associates;

    public PayingCustomer() {
        super("Not Set", "Not Set");
        this.PayMethod = new PaymentMethod();
        this.Associates = new ArrayList<>();
        this.IsPaying = true;
    }
    
    public PayingCustomer(String Name){
        super(Name, "Not Set");
        this.PayMethod = new PaymentMethod();
        this.Associates = new ArrayList<>();
        this.IsPaying = true;
    }
    
    public PayingCustomer(String Name, String EmailAddress){
        super(Name, EmailAddress);
        this.PayMethod = new PaymentMethod();
        this.Associates = new ArrayList<>();
        this.IsPaying = true;
    }

    public PayingCustomer(String Name, String EmailAddress, PaymentMethod PayMethod) {
        super(Name, EmailAddress);
        this.PayMethod = PayMethod;
        this.Associates = new ArrayList<>();
        this.IsPaying = true;
    }

    public PaymentMethod getPayMethod() {
        return PayMethod;
    }

    public void setPayMethod(PaymentMethod PayMethod) {
        this.PayMethod = PayMethod;
    }

    public ArrayList<AssociateCustomer> getAssociates() {
        return Associates;
    }
    
    public void addAssociate(AssociateCustomer a) {
        if(this.Associates.contains(a)){
            System.out.println("Associate has already been added");
        }
        else{
            this.Associates.add(a);
        }
    }
    
    public void removeAssociate(AssociateCustomer a) {
        if(this.Associates.contains(a)){
            this.Associates.remove(a);
        }
        else{
            System.out.print("Associate was not found");
        }
    }
    
    public void clearAllAssociates() {
        this.Associates.clear();
    }
}
