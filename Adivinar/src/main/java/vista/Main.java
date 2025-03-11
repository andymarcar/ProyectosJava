package vista;

import java.util.Scanner;
import modelo.Adivinar;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Adivinar juego = new Adivinar();
        
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Estoy pensando en un número entre 0 y 1000.");
        
        // Ciclo del juego
        while (!juego.isConocido()) {
            System.out.print("Introduce tu intento: ");
            int intento = scanner.nextInt();
            
            String resultado = juego.verificar(intento);
            System.out.println(resultado);
        }
        
        System.out.println("Juego terminado en " + juego.getIntentos() + " intentos. ¡Gracias por jugar!");
        scanner.close();
    }
}