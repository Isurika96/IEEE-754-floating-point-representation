/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieee;

import java.util.Scanner;
public class IEEE {
    
    public static void main(String[] args) {
        float floa;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a floating point number");
        floa = sc.nextFloat();
        int no,sign;
        no = (int)floa;//get the number before the decimal point
        String a = Integer.toBinaryString(no); //convert the number before the decimal point to binary
        String sub= a.substring(1, a.length());
        
        //get the Sign of the given decimal number
        if(floa < 0)
        {
            sign =1;
            
        }
        else
        {
            sign =0;
        }
        System.out.println("Sign : " + sign);
        
        //get the Exponent of the given decimal number
        int exp = a.length()-1; // power of 2
        int E = 127 + exp;// get the value of E
        String Exponent = Integer.toBinaryString(E);
        System.out.print("Exponent : " + Exponent);
        
        //get the Mantissa of the given decimal number
        int loop = 23-exp;
        float floatpart = floa - no; //get the float part of given decimal number
        //convert float part to binary [array]
        int q[] = new int[24];
        for(int i=1, j=0; i<=loop; i++, j++)
        {
          q[j] = (int)(floatpart*2);
          floatpart = floatpart*2;
          if(q[j] ==1)
          {
              floatpart = floatpart -1;
          }
        }
        System.out.println();
       System.out.print("Mantissa : ");
       System.out.print(sub);
       for(int k=0; k<q.length; k++)
           System.out.print(q[k]);
       System.out.println();
       System.out.println("IEEE754 Format is : ");
       System.out.print(sign + " " + Exponent + " ");
       System.out.print(sub);
       
       for(int k= 0; k<q.length;k++)
           System.out.print(q[k]);
       
    }
    
}
