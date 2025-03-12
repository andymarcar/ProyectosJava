package com.mycompany.promedio_peso;

import java.util.Scanner;

public class Promedio_peso {
    public static void main(String[] args) {
        // Contadores para cada categoría
        try (Scanner scanner = new Scanner(System.in)) {
            // Contadores para cada categoría
            int contadorNinos = 0;
            int contadorJovenes = 0;
            int contadorAdultos = 0;
            int contadorViejos = 0;
            
            // Acumuladores de peso para cada categoría
            double pesoTotalNinos = 0;
            double pesoTotalJovenes = 0;
            double pesoTotalAdultos = 0;
            double pesoTotalViejos = 0;
            
            // Realizar el muestreo para 50 personas
            for (int i = 1; i <= 50; i++) {
                System.out.println("Persona #" + i);
                
                // Solicitar la edad
                System.out.print("Ingrese la edad: ");
                int edad = scanner.nextInt();
                
                // Solicitar el peso
                System.out.print("Ingrese el peso (kg): ");
                double peso = scanner.nextDouble();
                
                // Clasificar según la categoría de edad
                if (edad >= 0 && edad <= 12) {
                    // Niños (0-12 años)
                    contadorNinos++;
                    pesoTotalNinos += peso;
                } else if (edad >= 13 && edad <= 29) {
                    // Jóvenes (13-29 años)
                    contadorJovenes++;
                    pesoTotalJovenes += peso;
                } else if (edad >= 30 && edad <= 59) {
                    // Adultos (30-59 años)
                    contadorAdultos++;
                    pesoTotalAdultos += peso;
                } else if (edad >= 60) {
                    // Viejos (60 en adelante)
                    contadorViejos++;
                    pesoTotalViejos += peso;
                } else {
                    System.out.println("Edad no válida. No se contabilizará esta persona.");
                    i--; // Repetir esta iteración
                }
                
                System.out.println(); // Línea en blanco para separar cada entrada
            }
            
            // Calcular promedios
            double promedioNinos = contadorNinos > 0 ? pesoTotalNinos / contadorNinos : 0;
            double promedioJovenes = contadorJovenes > 0 ? pesoTotalJovenes / contadorJovenes : 0;
            double promedioAdultos = contadorAdultos > 0 ? pesoTotalAdultos / contadorAdultos : 0;
            double promedioViejos = contadorViejos > 0 ? pesoTotalViejos / contadorViejos : 0;
            
            // Mostrar resultados
            System.out.println("\n--- RESULTADOS DEL MUESTREO ---");
            System.out.println("Categoría\tCantidad\tPromedio de Peso (kg)");
            System.out.println("Niños (0-12)\t" + contadorNinos + "\t\t" + String.format("%.2f", promedioNinos));
            System.out.println("Jóvenes (13-29)\t" + contadorJovenes + "\t\t" + String.format("%.2f", promedioJovenes));
            System.out.println("Adultos (30-59)\t" + contadorAdultos + "\t\t" + String.format("%.2f", promedioAdultos));
            System.out.println("Viejos (60+)\t" + contadorViejos + "\t\t" + String.format("%.2f", promedioViejos));
            
            // Calcular promedio general
            int totalPersonas = contadorNinos + contadorJovenes + contadorAdultos + contadorViejos;
            double pesoTotal = pesoTotalNinos + pesoTotalJovenes + pesoTotalAdultos + pesoTotalViejos;
            double promedioGeneral = totalPersonas > 0 ? pesoTotal / totalPersonas : 0;
            
            System.out.println("\nPromedio general de peso: " + String.format("%.2f", promedioGeneral) + " kg");
        }
    }
}