package com.mycompany.comisiones2;

import java.util.Scanner;

public class Comisiones2 {
    public static void main(String[] args) {
        // Solicitar el número de vendedores
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar el número de vendedores
            System.out.print("Ingrese el número de vendedores: ");
            int n = scanner.nextInt();
            
            // Solicitar el sueldo base
            System.out.print("Ingrese el sueldo base semanal: ");
            double sueldoBase = scanner.nextDouble();
            
            // Para cada vendedor
            for (int i = 1; i <= n; i++) {
                System.out.println("\nVendedor #" + i);
                double totalVentas = 0;
                
                // Solicitar el monto de las tres ventas
                for (int j = 1; j <= 3; j++) {
                    System.out.print("Ingrese el monto de la venta " + j + ": ");
                    double venta = scanner.nextDouble();
                    totalVentas += venta;
                }
                
                // Calcular comisiones (10% del total de ventas)
                double comisiones = totalVentas * 0.10;
                
                // Calcular sueldo total (sueldo base + comisiones)
                double sueldoTotal = sueldoBase + comisiones;
                
                // Mostrar resultados para este vendedor
                System.out.println("\nResultados para el Vendedor #" + i);
                System.out.println("Total de ventas: $" + String.format("%.2f", totalVentas));
                System.out.println("Comisiones (10%): $" + String.format("%.2f", comisiones));
                System.out.println("Sueldo base: $" + String.format("%.2f", sueldoBase));
                System.out.println("Sueldo total: $" + String.format("%.2f", sueldoTotal));
            }
        }
    }
}