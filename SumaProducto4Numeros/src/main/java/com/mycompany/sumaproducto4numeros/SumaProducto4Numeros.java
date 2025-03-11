
package com.mycompany.sumaproducto4numeros;

import java.util.Scanner;
public class SumaProducto4Numeros { 
     
     public static void main(String[] ar) { 
         Scanner teclado=new Scanner(System.in);
         
         int num1,num2,num3,num4,suma,producto;
         
         System.out.print("Ingrese primer valor:");
         num1=teclado.nextInt();
         
         System.out.print("Ingrese segundo valor:");
         num2=teclado.nextInt();
         
         System.out.print("Ingrese tercer valor:");
         num3=teclado.nextInt();
         
         System.out.print("Ingrese cuarto valor:");
         num4=teclado.nextInt();
         
         suma=num1 + num2;
         producto=num3 * num4;
         
         System.out.print("La suma de los dos primero valores es:");
         System.out.println(suma);
         System.out.print("El producto del tercer y cuarto valor es:");
         System.out.print(producto);
    }
}
