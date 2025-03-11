package vista;

import modelo.CajaRegistradora;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SupermercadoApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CajaRegistradora caja = new CajaRegistradora();
            String respuesta;
            DecimalFormat df = new DecimalFormat("#.##");
            
            // Mostrar información del autor
            System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
            
            do {
                System.out.println("\nDESEA CONTINUAR? (Si/No): ");
                respuesta = scanner.nextLine().toLowerCase();
                
                if (respuesta.equals("si") || respuesta.equals("sí") ||
                        respuesta.equals("s") || respuesta.equals("si")) {
                    
                    // Reiniciar la caja para un nuevo día
                    caja.reiniciarCaja();
                    
                    System.out.println("\n=== CAJA REGISTRADORA DE SUPERMERCADO ===");
                    boolean seguirRegistrando = true;
                    int numeroCliente = 1;
                    
                    while (seguirRegistrando) {
                        System.out.println("\n--- Cliente #" + numeroCliente + " ---");
                        
                        // Crear un nuevo cliente
                        CajaRegistradora.Cliente cliente = new CajaRegistradora.Cliente(numeroCliente);
                        
                        boolean seguirAgregandoArticulos = true;
                        int numeroArticulo = 1;
                        
                        while (seguirAgregandoArticulos) {
                            System.out.print("Ingrese el nombre del artículo #" + numeroArticulo + " (o 'fin' para terminar): ");
                            String nombreArticulo = scanner.nextLine();
                            
                            if (nombreArticulo.equalsIgnoreCase("fin")) {
                                seguirAgregandoArticulos = false;
                            } else {
                                System.out.print("Ingrese el precio del artículo: $");
                                double precioArticulo = scanner.nextDouble();
                                scanner.nextLine(); // Consumir el salto de línea
                                
                                cliente.agregarArticulo(nombreArticulo, precioArticulo);
                                numeroArticulo++;
                                
                                System.out.println("Artículo agregado: " + nombreArticulo + " - $" + df.format(precioArticulo));
                            }
                        }
                        
                        // Mostrar el total a pagar por el cliente
                        System.out.println("\nTotal a pagar para Cliente #" + cliente.getNumero() + ": $" + df.format(cliente.getMontoTotal()));
                        System.out.println("Cantidad de artículos: " + cliente.getCantidadArticulos());
                        
                        // Registrar el cliente en la caja
                        caja.registrarCliente(cliente);
                        
                        // Preguntar si hay más clientes
                        System.out.print("\n¿Hay más clientes? (Si/No): ");
                        String respuestaCliente = scanner.nextLine().toLowerCase();
                        
                        if (!respuestaCliente.equals("si") && !respuestaCliente.equals("sí") &&
                                !respuestaCliente.equals("s") && !respuestaCliente.equals("si")) {
                            seguirRegistrando = false;
                        } else {
                            numeroCliente++;
                        }
                    }
                    
                    // Mostrar el resumen del día
                    System.out.println("\n=== RESUMEN DEL DÍA ===");
                    System.out.println("Número total de clientes atendidos: " + caja.getNumeroClientes());
                    System.out.println("Monto total cobrado: $" + df.format(caja.getTotalDelDia()));
                    
                    // Reporte detallado
                    System.out.println("\n=== REPORTE DETALLADO ===");
                    for (CajaRegistradora.Cliente cliente : caja.getClientes()) {
                        System.out.println("Cliente #" + cliente.getNumero() + " - Total: $" + df.format(cliente.getMontoTotal()) +
                                " - Artículos: " + cliente.getCantidadArticulos());
                    }
                    
                } else if (!respuesta.equals("no") && !respuesta.equals("n")) {
                    System.out.println("Respuesta no válida. Por favor, ingrese Si o No.");
                }
                
            } while (respuesta.equals("si") || respuesta.equals("sí") ||
                    respuesta.equals("s") || respuesta.equals("si"));
            
            System.out.println("\n¡Gracias por utilizar la caja registradora! ¡Hasta pronto!");
        }
    }
}