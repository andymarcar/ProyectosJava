package vista;

import modulo.VentasCompu;
import java.util.Scanner;

public class RegistroVentasApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            VentasCompu registro = new VentasCompu();
            String respuesta;
            
            // Mostrar información del autor
            System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
            
            do {
                System.out.println("\nDESEA CONTINUAR? (Si/No): ");
                respuesta = scanner.nextLine().toLowerCase();
                
                if (respuesta.equals("si") || respuesta.equals("sí") ||
                        respuesta.equals("s") || respuesta.equals("s")) {
                    
                    // Reiniciar registro para un nuevo día de ventas
                    registro.reiniciarVentas();
                    
                    System.out.println("\n=== REGISTRO DE VENTAS DEL DÍA ===");
                    boolean continuarRegistrando = true;
                    
                    while (continuarRegistrando) {
                        System.out.print("Ingrese el monto de la compra (o -1 para finalizar el día): ");
                        double monto = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        
                        if (monto == -1) {
                            continuarRegistrando = false;
                        } else if (monto >= 0) {
                            registro.registrarVenta(monto);
                            System.out.println("Venta registrada: $" + monto);
                        } else {
                            System.out.println("Error: El monto no puede ser negativo.");
                        }
                    }
                    
                    // Mostrar resumen del día
                    System.out.println("\n=== RESUMEN DEL DÍA ===");
                    System.out.println("Número de clientes atendidos: " + registro.getNumeroClientes());
                    System.out.println("Monto total de ventas: $" + registro.getMontoTotal());
                    
                } else if (!respuesta.equals("no") && !respuesta.equals("n")) {
                    System.out.println("Respuesta no válida. Por favor, ingrese Si o No.");
               }
                
            } while (respuesta.equals("si") || respuesta.equals("sí") ||
                    respuesta.equals("s") || respuesta.equals("s"));
            
            System.out.println("\n¡Gracias por utilizar el sistema de registro de ventas! ¡Hasta pronto!");
        }
    }
}