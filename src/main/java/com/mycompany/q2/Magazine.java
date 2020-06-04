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
 * class for magazine information and supplements
 */
public class Magazine {

    private String Name;
    private float WeeklyCost = 0;
    private final ArrayList<Supplement> Supplements;

    public final void checkName() {
        boolean check;
        Scanner input = new Scanner(System.in);

        do {
            if (Name.length() <= 1) {
                System.out.println("Magazine name must be longer than one character \nEnter a name:");
                this.Name = input.nextLine().toLowerCase();
                check = false;
            } else if (Name.equalsIgnoreCase("Not Set")) {
                System.out.println("Magazine name is required \nEnter a name:");
                this.Name = input.nextLine().toLowerCase();
                check = false;
            } else {
                check = true;
            }
        } while (check == false);
    }

    public Magazine() {
        this.Name = "Not Set";
        checkName();
        this.Supplements = new ArrayList<>();
    }

    public Magazine(String Name) {
        this.Name = Name.toLowerCase();
        checkName();
        this.Supplements = new ArrayList<>();
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

    public ArrayList<Supplement> getSupplements() {
        return Supplements;
    }
    
    public void addSupplement(Supplement s) {
        if (this.Supplements.contains(s)) {
            System.out.println("Supplement has already been added");
        } else {
            this.Supplements.add(s);
        }
    }

    public void removeSupplement(Supplement s) {
        if (this.Supplements.contains(s)) {
            this.Supplements.remove(s);
        } else {
            System.out.print("Associate was not found");
        }
    }

    public void clearAllSupplements() {
        this.Supplements.clear();
    }
}
