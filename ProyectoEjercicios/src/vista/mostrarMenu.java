package vista;

import java.util.Scanner;
import modelo.Ejercicio1;
import modelo.Ejercicio2;
import modelo.Ejercicio3;
import modelo.Ejercicio4;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class mostrarMenu {
    private final Scanner scanner;
    private final DecimalFormat df;
    
    public mostrarMenu() {
        this.scanner = new Scanner(System.in);
        this.df = new DecimalFormat("#.##");
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("Estos ejercicios fueron realizados por Andres Martinez, Daniel Orozco y David");
            System.out.println("1. Calcular el salario de obreros");
            System.out.println("2. Programa de calcomanías para autos");
            System.out.println("3. Calcular área máxima (problema X)");
            System.out.println("4. Calcular factorial de un número");
            System.out.println("5. Caja registradora de supermercado");
            System.out.println("6. Control de calificaciones");
            System.out.println("7. Registro de ventas");
            System.out.println("8. Calculadora de compras de supermercado");
            System.out.println("9. Salir");
            System.out.print("\nSeleccione una opción (1-9): ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1 -> calcularSalarioObreros();
                case 2 -> programaCalcomanias();
                case 3 -> calcularAreaMaxima();
                case 4 -> calcularFactorial();
                case 5 -> ejecutarCajaRegistradora();
                case 6 -> ejecutarControlCalificaciones();
                case 7 -> ejecutarRegistroVentas();
                case 8 -> ejecutarCalculadoraCompras();
                case 9 -> {
                    salir = true;
                    System.out.println("Programa finalizado. ¡Hasta pronto!");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private void calcularSalarioObreros() {
        System.out.println("\n=== CÁLCULO DE SALARIO DE OBREROS ===");
        System.out.print("Ingrese el número total de obreros: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese las horas trabajadas del obrero " + (i + 1) + ": ");
            int horas = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            double salario;
            if (horas <= 40) {
                salario = horas * 20;
            } else {
                salario = 40 * 20 + (horas - 40) * 25;
            }
            
            System.out.println("El salario del obrero " + (i + 1) + " es: $" + salario);
        }
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void programaCalcomanias() {
        System.out.println("\n=== PROGRAMA DE CALCOMANÍAS PARA AUTOS ===");
        System.out.print("Ingrese el número total de autos: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        // Inicializar contadores para cada color
        int amarillo = 0;
        int rosa = 0;
        int roja = 0;
        int verde = 0;
        int azul = 0;
        
        // Iterar sobre cada auto
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el último dígito de la placa del auto " + (i + 1) + ": ");
            int digito = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            // Determinar el color de la calcomanía y contar
            switch (digito) {
                case 1, 2 -> amarillo++;
                case 3, 4 -> rosa++;
                case 5, 6 -> roja++;
                case 7, 8 -> verde++;
                case 9, 0 -> azul++;
                default -> {
                }
            }
        }
        
        // Mostrar los resultados
        System.out.println("Autos con calcomanía amarilla: " + amarillo);
        System.out.println("Autos con calcomanía rosa: " + rosa);
        System.out.println("Autos con calcomanía roja: " + roja);
        System.out.println("Autos con calcomanía verde: " + verde);
        System.out.println("Autos con calcomanía azul: " + azul);
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void calcularAreaMaxima() {
        System.out.println("\n=== CÁLCULO DE ÁREA MÁXIMA ===");
        
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
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void calcularFactorial() {
        System.out.println("\n=== CÁLCULO DE FACTORIAL ===");
        System.out.print("Introduce un número para calcular su factorial: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        // Calcular el factorial
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        
        // Mostrar el resultado
        System.out.println("Factorial " + numero + " es " + factorial);
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void ejecutarCajaRegistradora() {
        System.out.println("\n=== CAJA REGISTRADORA DE SUPERMERCADO ===");
        System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
        
        Ejercicio4 caja = new Ejercicio4();
        caja.reiniciarCaja();
        
        boolean seguirRegistrando = true;
        int numeroCliente = 1;
        
        while (seguirRegistrando) {
            System.out.println("\n--- Cliente #" + numeroCliente + " ---");
            
            // Crear un nuevo cliente
            Ejercicio4.Cliente cliente = new Ejercicio4.Cliente(numeroCliente);
            
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
        for (Ejercicio4.Cliente cliente : caja.getClientes()) {
            System.out.println("Cliente #" + cliente.getNumero() + " - Total: $" + df.format(cliente.getMontoTotal()) +
                    " - Artículos: " + cliente.getCantidadArticulos());
        }
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void ejecutarControlCalificaciones() {
        System.out.println("\n=== CONTROL DE CALIFICACIONES ===");
        System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
        
        Ejercicio1 control = new Ejercicio1();
        control.limpiarRegistro();
        
        // Establecer la calificación mínima
        System.out.print("Ingrese la calificación mínima para tener derecho al examen de nivelación: ");
        double calificacionMinima = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        control.setCalificacionMinima(calificacionMinima);
        
        // Definir número de alumnos y unidades
        System.out.print("Ingrese el número de alumnos a registrar: ");
        int totalAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.print("Ingrese el número de unidades a evaluar: ");
        int totalUnidades = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.println("\nRegistrando calificaciones para " + totalAlumnos + " alumnos en " + totalUnidades + " unidades:");
        
        for (int i = 1; i <= totalAlumnos; i++) {
            System.out.println("\nAlumno #" + i);
            System.out.print("Nombre del alumno: ");
            String nombre = scanner.nextLine();
            
            double[] calificaciones = new double[totalUnidades];
            for (int j = 0; j < totalUnidades; j++) {
                System.out.print("Calificación unidad " + (j+1) + ": ");
                calificaciones[j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Consumir el salto de línea
            
            control.agregarAlumno(nombre, calificaciones);
        }
        
        // Mostrar resultados
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Total de alumnos: " + control.getTotalAlumnos());
        System.out.println("Alumnos sin derecho al examen de nivelación: " + control.getAlumnosSinDerecho());
        
        // Mostrar detalles de los alumnos
        System.out.println("\nDetalle de alumnos sin derecho al examen:");
        int contador = 1;
        for (var alumno : control.getAlumnos()) {
            if (!alumno.tieneDerecho(calificacionMinima)) {
                System.out.println(contador + ". " + alumno.getNombre() +
                        " - Promedio: " + df.format(alumno.getPromedio()));
                contador++;
            }
        }
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }
    
    private void ejecutarRegistroVentas() {
        System.out.println("\n=== REGISTRO DE VENTAS DE TIENDA ===");
        System.out.println("ESTE EJERCICIO FUE REALIZADO POR: [TUS NOMBRES Y APELLIDOS COMPLETOS]");
        
        Ejercicio2 control = new Ejercicio2();
        control.reiniciarVentas();
        
        
        System.out.println("\nDESEA CONTINUAR? (Si/No): ");
        String respuesta = scanner.nextLine().toLowerCase();
        
        if (respuesta.equals("si") || respuesta.equals("sí") || 
            respuesta.equals("s") || respuesta.equals("si")) {
            
            ArrayList<Double> ventas = new ArrayList<>();
            
            System.out.println("\n=== REGISTRO DE VENTAS DEL DÍA ===");
            boolean continuarRegistrando = true;
            
            while (continuarRegistrando) {
                System.out.print("Ingrese el monto de la compra (o -1 para finalizar el día): ");
                try {
                    double monto = Double.parseDouble(scanner.nextLine());
                    
                    if (monto == -1) {
                        continuarRegistrando = false;
                    } else if (monto >= 0) {
                        ventas.add(monto);
                        System.out.println("Venta registrada: $" + monto);
                    } else {
                        System.out.println("Error: El monto no puede ser negativo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un monto válido.");
                }
            }
            
            // Calcular total
            double totalVentas = 0;
            for (Double venta : ventas) {
                totalVentas += venta;
            }
            
            // Mostrar resumen del día
            System.out.println("\n=== RESUMEN DEL DÍA ===");
            System.out.println("Número de clientes atendidos: " + ventas.size());
            System.out.println("Monto total de ventas: $" + String.format("%.2f", totalVentas));
        }
    }
    private void ejecutarCalculadoraCompras() {
        System.out.println("\n=== CAJA REGISTRADORA DE SUPERMERCADO ===");
        System.out.println("ESTE EJERCICIO FUE REALIZADO POR: [TUS NOMBRES Y APELLIDOS COMPLETOS]");
                
        Ejercicio3 control = new Ejercicio3();
        control.limpiarCarrito();
        
        System.out.println("\nDESEA CONTINUAR? (Si/No): ");
        String respuesta = scanner.nextLine().toLowerCase();
        
        if (respuesta.equals("si") || respuesta.equals("sí") || 
            respuesta.equals("s") || respuesta.equals("si")) {
            
            DecimalFormat fd = new DecimalFormat("#.##");
            
            // Estructuras para almacenar la información de las ventas
            ArrayList<Integer> clientesIds = new ArrayList<>();
            ArrayList<Double> clientesTotales = new ArrayList<>();
            ArrayList<Integer> clientesNumArticulos = new ArrayList<>();

            
            System.out.println("\n=== CAJA REGISTRADORA DE SUPERMERCADO ===");
            boolean seguirRegistrando = true;
            int numeroCliente = 1;
            
            while (seguirRegistrando) {
                System.out.println("\n--- Cliente #" + numeroCliente + " ---");
                
                double totalCliente = 0;
                int numArticulos = 0;
                boolean seguirAgregandoArticulos = true;
                int numeroArticulo = 1;
                
                while (seguirAgregandoArticulos) {
                    System.out.print("Ingrese el nombre del artículo #" + numeroArticulo + " (o 'fin' para terminar): ");
                    String nombreArticulo = scanner.nextLine();
                    
                    if (nombreArticulo.equalsIgnoreCase("fin")) {
                        seguirAgregandoArticulos = false;
                    } else {
                        System.out.print("Ingrese el precio del artículo: $");
                        double precioArticulo = Double.parseDouble(scanner.nextLine());
                        
                        totalCliente += precioArticulo;
                        numArticulos++;
                        numeroArticulo++;
                        
                        System.out.println("Artículo agregado: " + nombreArticulo + " - $" + fd.format(precioArticulo));
                    }
                }
                
                // Guardar información del cliente
                clientesIds.add(numeroCliente);
                clientesTotales.add(totalCliente);
                clientesNumArticulos.add(numArticulos);
                
                // Mostrar el total a pagar por el cliente
                System.out.println("\nTotal a pagar para Cliente #" + numeroCliente + ": $" + fd.format(totalCliente));
                System.out.println("Cantidad de artículos: " + numArticulos);
                
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
            
            // Calcular total del día
            double totalDelDia = 0;
            for (Double total : clientesTotales) {
                totalDelDia += total;
            }
            
            // Mostrar el resumen del día
            System.out.println("\n=== RESUMEN DEL DÍA ===");
            System.out.println("Número total de clientes atendidos: " + clientesIds.size());
            System.out.println("Monto total cobrado: $" + fd.format(totalDelDia));
            
            // Reporte detallado
            System.out.println("\n=== REPORTE DETALLADO ===");
            for (int i = 0; i < clientesIds.size(); i++) {
                System.out.println("Cliente #" + clientesIds.get(i) + 
                                  " - Total: $" + fd.format(clientesTotales.get(i)) + 
                                  " - Artículos: " + clientesNumArticulos.get(i));
            }
        }
    }

}
