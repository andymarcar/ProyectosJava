package com.mycompany.factorial2;

import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        // Solicitar al usuario que ingrese un número
        try ( // Crear un objeto Scanner para leer la entrada del usuario
                Scanner scanner = new Scanner(System.in)) {
            // Solicitar al usuario que ingrese un número
            System.out.print("Introduce un número para calcular su factorial: ");
            int numero = scanner.nextInt();
            // Calcular el factorial
            long factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }   // Mostrar el resultado
            System.out.println("Factorial " + numero + " es " + factorial);
            // Cerrar el scanner
        }
    }
}