package com.mycompany.facturacion_1;

import java.util.Scanner;

public class Facturacion_1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        String duc;
        double cam, can, cam_NIVA, sub_T, res, IVA, nIVA;
        
        System.out.print("Ingrese el producto que quiere: ");
        duc = teclado.next();
        System.out.println("");
        
        System.out.print("Ingrese el valor del producto " + duc + " con IVA incluido: ");
        cam = teclado.nextDouble();
        System.out.println("");
        
        System.out.print("Ingrese el valor del IVA sin el porcentaje: ");
        IVA = teclado.nextDouble();
        System.out.println("");
    
        System.out.print("Ingrese la cantidad que necesita: ");
        can = teclado.nextDouble();
        System.out.println("");
        
        nIVA= (IVA/100)+1; 
    
        cam_NIVA = cam/nIVA;
    
        sub_T = cam_NIVA*can;
    
        res = cam * can;
    
        System.out.println("-----------------------------------------------------");
        System.out.println("El subtotal de tu compra es:" + String.format("%.2f", sub_T));
        System.out.println("-----------------------------------------------------");
        System.out.println("El IVA de la prenda es del " + IVA + "%");
        System.out.println("-----------------------------------------------------");
        System.out.println("El valor total es de: " + res);
             
    }
}
