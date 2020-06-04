/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.q2;

import java.util.Scanner;

/**
 *
 * @author ryand
 * class for supplement details
 */
public class Supplement {

    private String Name;
    private float WeeklyCost = 0;
    private static int Counter = 0;
    private final String ID;

    /**
     *
     * @return
     */
    public final String generateID() {
        Counter++;
        return "Sup" + Counter;
    }

    /**
     *
     */
    public final void checkName() {
        boolean check;
        Scanner input = new Scanner(System.in);

        do {
            if (Name.equalsIgnoreCase("Not Set")) {
                System.out.println("Supplement name is required \nEnter a name:");
                this.Name = input.nextLine().toLowerCase();
                check = false;
            } else {
                check = true;
            }
        } while (check == false);
    }
    
    public Supplement() {
        this.Name = "Not Set";
        checkName();
        this.WeeklyCost = 0;
        this.ID = generateID();
    }

    public Supplement(String Name) {
        this.Name = Name.toLowerCase();
        checkName();
        this.WeeklyCost = 0;
        this.ID = generateID();
    }
    
    public Supplement(String Name, float WeeklyCost) {
        this.Name = Name.toLowerCase();
        checkName();
        this.WeeklyCost = WeeklyCost;
        this.ID = generateID();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name.toLowerCase();
        checkName();
    }

    public float getWeeklyCost() {
        return WeeklyCost;
    }

    public void setWeeklyCost(float WeeklyCost) {
        this.WeeklyCost = WeeklyCost;
    }

    public static int getCounter() {
        return Counter;
    }

    public String getID() {
        return ID;
    }
    
}
