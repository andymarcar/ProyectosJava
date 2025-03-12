package com.mycompany.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("¿Desea calcular el salario de los obreros? (s/n): ");
            char respuesta = scanner.next().charAt(0);
            
            if (respuesta == 's' || respuesta == 'S') {
                System.out.print("Ingrese el número total de obreros: ");
                int n = scanner.nextInt();
                
                for (int i = 0; i < n; i++) {
                    System.out.print("Ingrese las horas trabajadas del obrero " + (i + 1) + ": ");
                    int horas = scanner.nextInt();
                    
                    double salario;
                    if (horas <= 40) {
                        salario = horas * 20;
                    } else {
                        salario = 40 * 20 + (horas - 40) * 25;
                    }
                    
                    System.out.println("El salario del obrero " + (i + 1) + " es: $" + salario);
                }
            } else {
                System.out.println("Programa terminado.");
            }
        }
    }
}
