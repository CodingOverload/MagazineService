/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.q2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author ryand
 * Class for basic details of all paying and associate customers
 */
public abstract class Customer {

    protected String Name;
    protected String EmailAddress;
    protected boolean IsPaying = false;
    private static int Counter = 0;
    protected String ID;
    protected ArrayList<Supplement> InterestedSupplements;

    /**
     *
     * @return
     */
    public final String generateID() {
        Counter++;
        return "Cust" + Counter;
    }

    public final void checkName() {
        boolean check;
        Scanner input = new Scanner(System.in);

        do {
            if (Name.length() <= 1) {
                System.out.println("Customer name must be longer than one character \nEnter a name:");
                this.Name = input.nextLine().toLowerCase();
                check = false;
            } 
            else if(Name.equalsIgnoreCase("Not Set")){
                System.out.println("Customer name is required \nEnter a name:");
                this.Name = input.nextLine().toLowerCase();
                check = false;  
            }
            else {
                check = true;
            }
        } while (check == false);
    }

    public final void checkEmail() {
        boolean check;
        Scanner input = new Scanner(System.in);
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        do{
            Matcher match = pattern.matcher(this.EmailAddress);
            if(!match.matches()){
                System.out.println("Invalid email \nPlease enter an email address:");
                this.EmailAddress = input.nextLine();
                check = false;
            }
            else{
                check = true;
            }
        }while(check == false);
    }
    
    public Customer(String Name, String EmailAddress) {
        this.Name = Name;
        checkName();
        this.EmailAddress = EmailAddress;
        checkEmail();
        this.ID = generateID();
        this.InterestedSupplements = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name.toLowerCase();
        checkName();
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
        checkEmail();
    }

    public boolean isIsPaying() {
        return IsPaying;
    }

    public static int getCounter() {
        return Counter;
    }

    public String getID() {
        return ID;
    }
    
    public ArrayList<Supplement> getInterestedSupplements() {
        return InterestedSupplements;
    }

    public void addInterestedSupplement(Supplement s) {
        if (this.InterestedSupplements.contains(s)) {
            System.out.println("Supplement has already been added");
        } else {
            this.InterestedSupplements.add(s);
        }
    }

    public void removeInterestedSupplement(Supplement s) {
        if (this.InterestedSupplements.contains(s)) {
            this.InterestedSupplements.remove(s);
        } else {
            System.out.print("Associate was not found");
        }
    }

    public void clearAllInterestedSupplements() {
        this.InterestedSupplements.clear();
    }
}
