package com.mycompany.ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Variables para almacenar el valor óptimo de X y el área máxima
        int mejorX = 0;
        double areaMaxima = 0;
        
        System.out.println("Valor de X\tarea");
        System.out.println("-----------------");
        
        // Probar cada valor entero de X entre 10 y 15
        for (int x = 10; x <= 15; x++) {
            // Calcular el area según la fórmula X*(15-X)
            double area = x * (15 - x);
            
            // Mostrar el valor actual
            System.out.println(x + "\t\t" + area);
            
            // Verificar si este valor produce un área mayor
            if (area > areaMaxima) {
                areaMaxima = area;
                mejorX = x;
            }
        }
        
        // Mostrar el resultado final
        System.out.println("\nEl area maxima es: " + areaMaxima);
        System.out.println("Se obtiene cuando X = " + mejorX);
    }
}