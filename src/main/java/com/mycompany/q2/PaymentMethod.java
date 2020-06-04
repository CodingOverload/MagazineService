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
 * class for paying customer payment method
 */
public class PaymentMethod {
    private String Type;
    
    public final void checkInput(){
        while(!this.Type.equalsIgnoreCase("card") && !this.Type.equalsIgnoreCase("bank")){
            System.out.println("Payment method is required. \nPlease enter a payment method (card or bank):");
            Scanner input = new Scanner(System.in);
            this.Type = input.nextLine().toLowerCase();
        }
    }

    public PaymentMethod() {
        this.Type = "Not Set";
        checkInput();
    }

    
    public PaymentMethod(String Type) {
        this.Type = Type.toLowerCase();
        checkInput();
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type.toLowerCase();
        checkInput();
    }
}
