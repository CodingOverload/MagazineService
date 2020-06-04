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
 * Client class is for running the program.
 * The menu and function required for menu options are in this class.
 */
public class Client {

    private final AllCustomers Customers;
    private final Magazine Mag;
    
    /**
     * This method is for displaying my student details
     */
    public void MyDetails(){
        System.out.println("Name: Ryan Draper");
        System.out.println("Student Number: 33152216");
        System.out.println("Enrollment Mode: Internal");
        System.out.println("Tutor: Ferdous");
        System.out.println("Tutorial: Thursday 10:30-11:30am");
        System.out.println();
    }

    /**
     * this is the constructor for the class
     */
    public Client() {
        MyDetails(); //calls method
        
        this.Mag = new Magazine("Foods"); //creates new magazine with name
        Supplement pz = new Supplement("pizza", (float) 2.25); //creates new supplement
        Supplement pi = new Supplement("pie", (float) 1.30);
        Supplement s = new Supplement("soup", (float) 4.82);
        Supplement n = new Supplement("nuggets", (float) 3.00);
        Mag.setWeeklyCost((float)6.50); //sets weekly cost of magazine
        Mag.addSupplement(pz); //adds supplement to magazine
        Mag.addSupplement(pi);
        Mag.addSupplement(s);
        Mag.addSupplement(n);
        
       
        AssociateCustomer a1 = new AssociateCustomer("Lucy", "l@emai.com"); //creates new associate customer with name and email
        a1.addInterestedSupplement(pz); //add supplement to associate customer
        a1.addInterestedSupplement(s);
        a1.addInterestedSupplement(n);
        
        AssociateCustomer a2 = new AssociateCustomer("Bella", "bl@emai.com");
        a2.addInterestedSupplement(pi);
        a2.addInterestedSupplement(n);
        
        AssociateCustomer a3 = new AssociateCustomer("Jake", "jk@emai.com");
        
        AssociateCustomer a4 = new AssociateCustomer("Michael", "m@emai.com");
        a4.addInterestedSupplement(pz);
        
        PayingCustomer p1 = new PayingCustomer("Bob", "b@email.com", new PaymentMethod("card")); //creates new paying customer with name, email and payment method
        p1.addInterestedSupplement(pz); //add supplement to paying customer
        p1.addInterestedSupplement(pi);
        p1.addAssociate(a1); //add associate customer to paying customer
        p1.addAssociate(a2);
        p1.addAssociate(a4);
        
        PayingCustomer p2 = new PayingCustomer("John", "j@email.com", new PaymentMethod("bank"));
        p2.addAssociate(a3);
        
        this.Customers = new AllCustomers(); //new AllCustomers class object
        Customers.addCustomer(p1); //adds customer to AllCustomers
        Customers.addCustomer(p2);
        Customers.addCustomer(a1);
        Customers.addCustomer(a2);
        Customers.addCustomer(a3);
        Customers.addCustomer(a4);
        
        Menu(); //calls menu method
    }

    /**
     * 
     * @param p
     * for adding a supplement to customer
     */
    public void AddSupplement(Customer p) {
        Scanner input = new Scanner(System.in);
        String ans = "";
        int num;

        int count = 0;
        if (Mag.getSupplements().isEmpty()) { //checks if there are no supplements in the magazine
            System.out.println("  There are no supplements to add");
        } else {
            System.out.println("  Supplements:");
            for (int i = 0; i < Mag.getSupplements().size(); i++) { //displays all magazine supplement details
                System.out.println("  Index: " + count + " Supplement: " + Mag.getSupplements().get(i).getName());
                count++;
            }

            do {
                System.out.println("  Please enter the index of supplement to add");
                num = input.nextInt();
            } while (!(num >= 0 && num < Mag.getSupplements().size())); //checks that user input matches the index of a supplement

            p.addInterestedSupplement(Mag.getSupplements().get(num)); // adds supplement to the customer
        }
    }

    /**
     * 
     * @param p 
     * for adding an associate customer to a paying customer
     */
    public void AddExistingAssociate(PayingCustomer p) {
        Scanner input = new Scanner(System.in);
        String ans = "";
        int num;

        ArrayList<Customer> IDs = new ArrayList<>();
        for (int i = 0; i < Customers.getAllCustomers().size(); i++) {
            if (!Customers.getAllCustomers().get(i).isIsPaying()) {
                IDs.add(Customers.getAllCustomers().get(i)); //adds paying customers to the IDs arraylist
            }
        }

        if (IDs.isEmpty()) { //if there are no associates for the paying customer
            System.out.println("  There are no associates");
        } else {
            int count = 0;
            System.out.println("  Associate Customers");
            for (int i = 0; i < Customers.getAllCustomers().size(); i++) { //displays all associate details
                if (!Customers.getAllCustomers().get(i).isIsPaying()) {
                    System.out.println("  index: " + count + " Customer ID: " + Customers.getAllCustomers().get(i).getID() + " Customers Name: " + Customers.getAllCustomers().get(i).getName());
                }
                count++;
            }
            do {
                System.out.println("  Please enter the index of Associate to add");
                num = input.nextInt();
            } while (!(num >= 0 && num < IDs.size())); //checks that user input matches an associate customer index

            p.addAssociate((AssociateCustomer) IDs.get(num)); //adds an associate customer to paying customer

        }
    }

    /**
     * function for adding a paying customer
     */
    public void AddPaying() {
        Scanner input = new Scanner(System.in);
        String ans;
        int num;
        String n, e, py;

        System.out.println("  Please enter customers name: ");
        n = input.nextLine();
        System.out.println("  Please enter customers email: ");
        e = input.nextLine();
        System.out.println("  Please enter customers payment method (card/bank): ");
        py = input.nextLine();
        PayingCustomer p = new PayingCustomer(n, e, new PaymentMethod(py)); //adds new paying customer with name, email and payment method

        System.out.println("  Add Interested Supplement y/n");
        ans = input.nextLine().toLowerCase();
        while (ans.equals("y")) { //loops asking to add supplement and while input is y, calls the function for adding supplements
            AddSupplement(p);
            System.out.println("  Add another Interested Supplement y/n");
            ans = input.nextLine().toLowerCase();
        }

        System.out.println("  Add Associate y/n");
        ans = input.nextLine().toLowerCase();
        while (ans.equals("y")) { //loops asking to add associate and while input is y, calls the function for adding associates
            AddExistingAssociate(p);
            System.out.println("  Add another associate y/n");
            ans = input.nextLine().toLowerCase();
        }

        Customers.addCustomer(p); //adds the new paying customer to the list of all customers
    }

    /**
     * for adding a non paying customer
     */
    public void AddAssociate() {
        Scanner input = new Scanner(System.in);
        String n, e, ans;

        System.out.println("  Please enter customers name: ");
        n = input.nextLine();
        System.out.println("  Please enter customers email: ");
        e = input.nextLine();
        AssociateCustomer as = new AssociateCustomer(n, e); // creates new associate customer with name and email
        System.out.println("  Add Interested Supplement y/n");
        ans = input.nextLine().toLowerCase();
        while (ans.equals("y")) { //loops asking to add supplement and while input is y, calls the function for adding supplements
            AddSupplement(as);
            System.out.println("  Add another Interested Supplement y/n");
            ans = input.nextLine().toLowerCase();
        }
        Customers.addCustomer(as); //adds the new associate customer to the list of all customers
    }

    /**
     * for adding a new customer to the magazine service
     */
    public void AddNewCustomer() {
        Scanner input = new Scanner(System.in);
        String ans = "";

        do {
            System.out.println("  Is customer a paying customer? y/n");
            ans = input.nextLine().toLowerCase();
        } while (!ans.equals("y") && !ans.equals("n")); //checks if customer is a paying customer

        if (ans.equals("y")) { //calls function for paying customer if y otherwise calls function for associate customer
            AddPaying();
        } else {
            AddAssociate();
        }
    }

    /**
     * function for removing a customer
     */
    public void RemoveCustomer() {
        int count = 0;
        Scanner input = new Scanner(System.in);
        int num;

        if (Customers.getAllCustomers().isEmpty()) { //checks if there are customers
            System.out.println("  There are no customers");
        } else {
            System.out.println("  Existing Customers");
            for (int i = 0; i < Customers.getAllCustomers().size(); i++) { //displays all existing customers
                System.out.println("  index: " + count + " Customer ID: " + Customers.getAllCustomers().get(i).getID() + " Customers Name: " + Customers.getAllCustomers().get(i).getName());
                count++;
            }
        }

        do {
            System.out.println("  Please enter a valid customers index to remove them");
            num = input.nextInt();
        } while (!(num >= 0 && num < Customers.getAllCustomers().size())); //checks that user input matches the index of a customer

        Customer c = Customers.getAllCustomers().get(num);

        Customers.removeCustomer(c); //removes the customer

    }

    /**
     * function for displaying all customers
     */
    public void showCustomers() {
        if (Customers.getAllCustomers().isEmpty()) { //checks if there are customers
            System.out.println("  There are no customers");
        } else {
            for (int i = 0; i < Customers.getAllCustomers().size(); i++) { //displays all customers
                System.out.println("  Customer ID: " + Customers.getAllCustomers().get(i).getID() + " Customer Name: " + Customers.getAllCustomers().get(i).getName());
            }
        }
    }

    /**
     * function for displaying all supplements
     */
    public void showSupplements() {
        if (Mag.getSupplements().isEmpty()) { //checks if there are supplements
            System.out.println("  There are no supplements");
        } else {
            for (int i = 0; i < Mag.getSupplements().size(); i++) { //displays all supplements
                System.out.println("  Supplement ID: " + Mag.getSupplements().get(i).getID() + " Supplement Name: " + Mag.getSupplements().get(i).getName());
            }
        }
    }

    /**
     * function for showing all customers weekly email
     */
    public void getWeeklyEmail() {
        System.out.println();
        if (Customers.getAllCustomers().isEmpty()) { //checks for customers
            System.out.println(" ---------------------------------------- ");
            System.out.println("  There are no customers");
            System.out.println(" ---------------------------------------- ");
        } else {
            for (int i = 0; i < Customers.getAllCustomers().size(); i++) { //generates email for all customers
                System.out.println(" ---------------------------------------- ");
                System.out.println("  Sent to " + Customers.getAllCustomers().get(i).getEmailAddress() + "  ID: " + Customers.getAllCustomers().get(i).getID());
                System.out.println(" ---------------------------------------- ");
                System.out.println("  Dear " + Customers.getAllCustomers().get(i).getName() + ",");
                System.out.println("  " + Mag.getName() + " magazine is ready to view.");
                if (Customers.getAllCustomers().get(i).getInterestedSupplements().isEmpty()) {
                    System.out.println("  You don't have any supplements.");
                } else {
                    System.out.println("  Your supplements are:");
                    for (int j = 0; j < Customers.getAllCustomers().get(i).getInterestedSupplements().size(); j++) {
                        System.out.println("   -" + Customers.getAllCustomers().get(i).getInterestedSupplements().get(j).getName());
                    }
                }
                System.out.println(" ---------------------------------------- ");
            }
        }
        System.out.println();
    }

    /**
     * function for showing all paying customers monthly email
     */
    public void getMonthlyEmail() {
        ArrayList<PayingCustomer> paying = new ArrayList<>();
        float totalcost=0;
        float assocost=0;
        
        for (int i = 0; i < Customers.getAllCustomers().size(); i++) {
            if (Customers.getAllCustomers().get(i).isIsPaying()) {
                paying.add((PayingCustomer) Customers.getAllCustomers().get(i)); //adds paying customers to the paying arraylist
            }
        }

        if (paying.isEmpty()) { //checks for paying customers
            System.out.println(" ---------------------------------------- ");
            System.out.println("  There are no paying customers");
            System.out.println(" ---------------------------------------- ");
        } else {
            for (int i = 0; i < paying.size(); i++) { //generates email details about paying customer and associate costs
                System.out.println(" ---------------------------------------- ");
                System.out.println("  Sent to " + paying.get(i).getEmailAddress() + "  ID: " + paying.get(i).getID());
                System.out.println(" ---------------------------------------- ");
                System.out.println("  Dear " + paying.get(i).getName() + ",");
                System.out.println("  Here is your monthly email cost review.");
                System.out.println("  Your expenses: ");
                System.out.println("  -" + Mag.getName() + " magazine    $" + Mag.getWeeklyCost());
                totalcost += Mag.getWeeklyCost();
                for (int j = 0; j < paying.get(i).getInterestedSupplements().size(); j++) {
                    System.out.println("  -" + paying.get(i).getInterestedSupplements().get(j).getName() + "    $" + paying.get(i).getInterestedSupplements().get(j).getWeeklyCost());
                    totalcost += paying.get(i).getInterestedSupplements().get(j).getWeeklyCost();
                }
                System.out.println("  Your cost:    $" + totalcost);
                System.out.println();
                if (!paying.get(i).getAssociates().isEmpty()) {
                    for (int j = 0; j < paying.get(i).getAssociates().size(); j++) {
                        System.out.println("  " + paying.get(i).getAssociates().get(j).getName() + "'s expenses: ");
                        System.out.println("  -" + Mag.getName() + " magazine    $" + Mag.getWeeklyCost());
                        assocost += Mag.getWeeklyCost();
                        for(int k=0; k<paying.get(i).getAssociates().get(j).getInterestedSupplements().size(); k++){
                            System.out.println("  -" + paying.get(i).getAssociates().get(j).getInterestedSupplements().get(k).getName() + "    $" + paying.get(i).getAssociates().get(j).getInterestedSupplements().get(k).getWeeklyCost());
                            assocost += paying.get(i).getAssociates().get(j).getInterestedSupplements().get(k).getWeeklyCost();
                        }
                        System.out.println("  " + paying.get(i).getAssociates().get(j).getName() + "'s cost:    $" + assocost);
                        totalcost += assocost;
                        assocost = 0;
                        System.out.println();
                    }
                }
                System.out.println("  Total cost charged to your " + paying.get(i).getPayMethod().getType() + " for this month:    $" + totalcost);
                System.out.println(" ---------------------------------------- ");
            }
        }

        System.out.println();

        System.out.println();
    }

    /**
     * function for displaying all menu options
     */
    public void DisplayMenu() {
        System.out.println(" ---------------------------------------- ");
        System.out.println("  Option a:  Add a new customer");
        System.out.println("  Option b:  Remove a customer");
        System.out.println("  Option c:  Display all customers");
        System.out.println("  Option d:  Display all supplements");
        System.out.println("  Option e:  Display all customers weekly emails");
        System.out.println("  Option f:  Display all paying customers monthly emails");
        System.out.println("  Enter 'q' to quit");
        System.out.println(" ---------------------------------------- ");
    }

    /**
     * menu function for running the functions depending on user choice
     */
    public void Menu() {
        String opt;
        Scanner input = new Scanner(System.in);
        do {
            DisplayMenu();
            System.out.print("  Enter option: ");
            opt = input.nextLine().toLowerCase();
            switch (opt) {
                case "a":
                    AddNewCustomer();
                    break;

                case "b":
                    RemoveCustomer();
                    break;

                case "c":
                    showCustomers();
                    break;

                case "d":
                    showSupplements();
                    break;

                case "e":
                    getWeeklyEmail();
                    break;

                case "f":
                    getMonthlyEmail();
                    break;

                case "q":
                    System.out.println("  You quit the program, goodbye.");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!opt.equals("q"));
    }

}
