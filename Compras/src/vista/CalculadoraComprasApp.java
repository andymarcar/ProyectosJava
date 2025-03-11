package vista;

import modulo.Carrito;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculadoraComprasApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Carrito carrito = new Carrito();
            String respuesta;
            DecimalFormat df = new DecimalFormat("#.##");
            
            // Mostrar información del autor
            System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
            
            do {
                System.out.println("\nDESEA CONTINUAR? (Si/No): ");
                respuesta = scanner.nextLine().toLowerCase();
                
                if (respuesta.equals("si") || respuesta.equals("sí") ||
                        respuesta.equals("s") || respuesta.equals("si")) {
                    
                    // Limpiar el carrito para una nueva sesión de compras
                    carrito.limpiarCarrito();
                    
                    System.out.println("\n=== CALCULADORA DE COMPRAS DE SUPERMERCADO ===");
                    boolean seguirComprando = true;
                    
                    while (seguirComprando) {
                        System.out.print("\nIngrese el nombre del artículo (o 'fin' para terminar): ");
                        String nombre = scanner.nextLine();
                        
                        if (nombre.equalsIgnoreCase("fin")) {
                            seguirComprando = false;
                        } else {
                            System.out.print("Ingrese el precio del artículo: $");
                            double precio = scanner.nextDouble();
                            
                            System.out.print("Ingrese la cantidad: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea
                            
                            carrito.agregarArticulo(nombre, precio, cantidad);
                            
                            double subtotal = precio * cantidad;
                            System.out.println("Subtotal para " + nombre + ": $" + df.format(subtotal));
                            System.out.println("Total acumulado: $" + df.format(carrito.getTotal()));
                        }
                    }
                    
                    // Mostrar resumen de la compra
                    System.out.println("\n=== RESUMEN DE LA COMPRA ===");
                    
                    System.out.println("Artículos en el carrito:");
                    for (int i = 0; i < carrito.getNumeroArticulos(); i++) {
                        Carrito.Articulo articulo = carrito.getArticulos().get(i);
                        System.out.println(articulo.getNombre() + " - " +
                                articulo.getCantidad() + " x $" +
                                df.format(articulo.getPrecio()) + " = $" +
                                df.format(articulo.getSubtotal()));
                    }
                    
                    System.out.println("\nCantidad total de artículos: " + carrito.getCantidadTotal());
                    System.out.println("Total a pagar: $" + df.format(carrito.getTotal()));
                    
                } else if (!respuesta.equals("no") && !respuesta.equals("n")) {
                    System.out.println("Respuesta no válida. Por favor, ingrese Si o No.");
                }
                
            } while (respuesta.equals("si") || respuesta.equals("sí") ||
                    respuesta.equals("s") || respuesta.equals("si"));
            
            System.out.println("\n¡Gracias por utilizar la calculadora de compras! ¡Hasta pronto!");
        }
    }
}