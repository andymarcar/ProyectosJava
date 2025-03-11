package com.mycompany.aleatorio;

import java.util.Scanner;
import java.util.Random;

public class Aleatorio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int ns; // Número secreto
        int in = 0; // Contador de intentos
        int n; // Número introducido por el usuario
        int op; // Opción del menú
        int lm; // Límite máximo según el nivel de dificultad
        
        System.out.println("¡Bienvenido al Juego de Adivinar el Número!");
        System.out.println("Selecciona el nivel de dificultad:");
        System.out.println("1. Fácil (0-10)");
        System.out.println("2. Medio (0-100)");
        System.out.println("3. Difícil (0-1000)");
        System.out.print("Introduce tu opción (1-3): ");
        
        op = teclado.nextInt();
        
        // Establecer el límite máximo según la dificultad seleccionada
        switch (op) {
            case 1:
                lm = 10;
                System.out.println("Has seleccionado el nivel FÁCIL (0-10)");
                break;
            case 2:
                lm = 100;
                System.out.println("Has seleccionado el nivel MEDIO (0-100)");
                break;
            case 3:
                lm = 1000;
                System.out.println("Has seleccionado el nivel DIFÍCIL (0-1000)");
                break;
            default:
                lm = 100; // Por defecto, nivel medio
                System.out.println("Opción no válida. Estableciendo nivel MEDIO (0-100) por defecto");
                break;
        }
        
        // Generar número aleatorio según el límite establecido
        ns = random.nextInt(lm + 1);
        
        System.out.println("He pensado en un número entre 0 y " + lm + ". ¡Intenta adivinarlo!");
        
        do {
            System.out.print("Introduce tu número: ");
            n = teclado.nextInt();
            
            if (n < 0 || n > lm) {
                System.out.println("Por favor, introduce un número entre 0 y " + lm + ".");
                continue;
            }
            
            in++;
                
            if (n < ns) {
                System.out.println("El número es mayor. Sigue intentando");
            } else if (n > ns) {
                System.out.println("El número es menor. Sigue intentando");
            } else {
                System.out.println("¡Felicidades! Has adivinado el número " + ns + " en " + in + " intentos.");
            }
        } while (n != ns);
        
        System.out.println("¡Gracias por jugar!");
        teclado.close();
    }
}