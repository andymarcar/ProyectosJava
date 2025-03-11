package com.mycompany.facturacion_grande;

import java.util.Scanner;

public class Facturacion_Grande {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        String duc, duc2, duc3;
        double cam, can, cam_NIVA, sub_T, res, IVA, nIVA;
        double cam2, can2, cam_NIVA2, sub_T2, res2, IVA2, nIVA2;
        double cam3, can3, cam_NIVA3, sub_T3, res3, IVA3, nIVA3;
        double sub_TF, IVAF, resF;
        
        System.out.print("Articulos Mercado");
        System.out.println("-----------------------------------------------------");
        
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
        System.out.println("");
        
        
        System.out.print("Ingrese el producto que quiere: ");
        duc2 = teclado.next();
        System.out.println("");
        
        System.out.print("Ingrese el valor del producto " + duc2 + " con IVA incluido: ");
        cam2 = teclado.nextDouble();
        System.out.println("");
        
        System.out.print("Ingrese el valor del IVA sin el porcentaje: ");
        IVA2 = teclado.nextDouble();
        System.out.println("");
    
        System.out.print("Ingrese la cantidad que necesita: ");
        can2 = teclado.nextDouble();
        System.out.println("");
        
        nIVA2= (IVA2/100)+1; 
    
        cam_NIVA2 = cam2/nIVA2;
    
        sub_T2 = cam_NIVA2*can2;
    
        res2 = cam2 * can2;
    
        System.out.println("-----------------------------------------------------");
        System.out.println("El subtotal de tu compra es:" + String.format("%.2f", sub_T2));
        System.out.println("-----------------------------------------------------");
        System.out.println("El IVA de la prenda es del " + IVA2 + "%");
        System.out.println("-----------------------------------------------------");
        System.out.println("El valor total es de: " + res2);
        System.out.println("");
        
        System.out.print("Ingrese el producto que quiere: ");
        duc3 = teclado.next();
        System.out.println("");
        
        System.out.print("Ingrese el valor del producto " + duc3 + " con IVA incluido: ");
        cam3 = teclado.nextDouble();
        System.out.println("");
        
        System.out.print("Ingrese el valor del IVA sin el porcentaje: ");
        IVA3 = teclado.nextDouble();
        System.out.println("");
    
        System.out.print("Ingrese la cantidad que necesita: ");
        can3 = teclado.nextDouble();
        System.out.println("");
        
        nIVA3= (IVA3/100)+1; 
    
        cam_NIVA3 = cam3/nIVA3;
    
        sub_T3 = cam_NIVA3*can3;
    
        res3 = cam3 * can3;
    
        System.out.println("-----------------------------------------------------");
        System.out.println("El subtotal de tu compra es:" + String.format("%.2f", sub_T3));
        System.out.println("-----------------------------------------------------");
        System.out.println("El IVA de la prenda es del " + IVA3 + "%");
        System.out.println("-----------------------------------------------------");
        System.out.println("El valor total es de: " + res3);
        System.out.println("");
        System.out.println("");
        
        sub_TF = sub_T+sub_T2+sub_T3;
        resF = res + res2 + res3;
        IVAF = (sub_TF*100)/res;
        
        System.out.println("El subtotal de los tres productos es: " + String.format("%.2f",sub_TF));
        System.out.println("El IVA de los tres productos es: " + String.format("%.0f",IVAF)+ "%");
        System.out.println("El total de los tres productos es: " + String.format("%.1f",resF));
        
        
        
             
    }
}