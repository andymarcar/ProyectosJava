package com.mycompany.problema_resuelto;

import java.util.Scanner;
public class Problema_Resuelto {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
        int lado,perimetro; 
        
        System.out.print("Ingrese el lado del cuadrado:"); 
        
        lado=teclado.nextInt(); 
        perimetro=lado * 4; 
        
        System.out.print("El perímetro del cuadrado es:");
        System.out.print(perimetro);
               
    }
}
