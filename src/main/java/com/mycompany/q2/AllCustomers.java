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
 * Class for holding all customers in the magazine program
 */
public class AllCustomers {

    private final ArrayList<Customer> AllCustomers;

    public AllCustomers() {
        this.AllCustomers = new ArrayList<>();
    }

    public ArrayList<Customer> getAllCustomers() {
        return AllCustomers;
    }

    public void addCustomer(Customer c) {
        if (this.AllCustomers.contains(c)) {
            System.out.println("Customer has already been added");
        } else {
            this.AllCustomers.add(c);
        }
    }

    public void removeCustomer(Customer c) {
        if (this.AllCustomers.contains(c)) {
            this.AllCustomers.remove(c);
        } else {
            System.out.print("Customer was not found");
        }
    }

    public void clearAllCustomers() {
        this.AllCustomers.clear();
    }
}
