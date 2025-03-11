package vista;

import modulo.ControlCalificaciones;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ControlAlumnosApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ControlCalificaciones control = new ControlCalificaciones();
            String respuesta;
            DecimalFormat df = new DecimalFormat("#.##");
            
            // Mostrar información del autor
            System.out.println("ESTE EJERCICIO FUE REALIZADO POR: Andres Mauricio Martinez Cardona");
            
            do {
                System.out.println("\nDESEA CONTINUAR? (Si/No): ");
                respuesta = scanner.nextLine().toLowerCase();
                
                if (respuesta.equals("si") || respuesta.equals("sí") ||
                        respuesta.equals("s") || respuesta.equals("si")) {
                    
                    // Limpiar el registro para una nueva ejecución
                    control.limpiarRegistro();
                    
                    System.out.println("\n=== CONTROL DE CALIFICACIONES ===");
                    
                    // Establecer la calificación mínima
                    System.out.print("Ingrese la calificación mínima para tener derecho al examen de nivelación: ");
                    double calificacionMinima = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    control.setCalificacionMinima(calificacionMinima);
                    
                    // Definir número de alumnos y unidades
                    int totalAlumnos = 40; // Ajustable según necesidad
                    int totalUnidades = 5;
                    
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
                    for (ControlCalificaciones.Alumno alumno : control.getAlumnos()) {
                        if (!alumno.tieneDerecho(calificacionMinima)) {
                            System.out.println(contador + ". " + alumno.getNombre() +
                                    " - Promedio: " + df.format(alumno.getPromedio()));
                            contador++;
                        }
                    }
                    
                } else if (!respuesta.equals("no") && !respuesta.equals("n")) {
                    System.out.println("Respuesta no válida. Por favor, ingrese Si o No.");
                }
                
            } while (respuesta.equals("si") || respuesta.equals("sí") ||
                    respuesta.equals("s") || respuesta.equals("si"));
            
            System.out.println("\n¡Gracias por utilizar el control de calificaciones! ¡Hasta pronto!");
        }
    }
}