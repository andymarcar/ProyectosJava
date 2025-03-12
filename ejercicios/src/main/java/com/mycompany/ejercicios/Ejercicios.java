package com.mycompany.ejercicios;

import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Desea ejecutar el programa? (s/n): ");
        char respuesta = scanner.next().charAt(0);

        if (respuesta == 's' || respuesta == 'S') {
            // 1. Pedir el número total de autos (n)
            System.out.print("Ingrese el número total de autos: ");
            int n = scanner.nextInt();

            // 2. Inicializar contadores para cada color
            int amarillo = 0;
            int rosa = 0;
            int roja = 0;
            int verde = 0;
            int azul = 0;

            // 3. Iterar sobre cada auto
            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese el último dígito de la placa del auto " + (i + 1) + ": ");
                int digito = scanner.nextInt();

                // 4. Determinar el color de la calcomanía y contar
                if (digito == 1 || digito == 2) {
                    amarillo++;
                } else if (digito == 3 || digito == 4) {
                    rosa++;
                } else if (digito == 5 || digito == 6) {
                    roja++;
                } else if (digito == 7 || digito == 8) {
                    verde++;
                } else if (digito == 9 || digito == 0) {
                    azul++;
                }
            }

            // 5. Mostrar los resultados
            System.out.println("Autos con calcomanía amarilla: " + amarillo);
            System.out.println("Autos con calcomanía rosa: " + rosa);
            System.out.println("Autos con calcomanía roja: " + roja);
            System.out.println("Autos con calcomanía verde: " + verde);
            System.out.println("Autos con calcomanía azul: " + azul);
        } else {
            System.out.println("Programa terminado.");
        }

        scanner.close();
    }
}