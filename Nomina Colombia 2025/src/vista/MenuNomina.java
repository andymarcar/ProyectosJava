package vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import modelo.*;

public class MenuNomina {
    private final Scanner scanner;
    private final GestionEmpleados gestionEmpleados;
    private final CalculadoraNomina calculadora;
    
    public MenuNomina() {
        scanner = new Scanner(System.in);
        gestionEmpleados = new GestionEmpleados();
        calculadora = new CalculadoraNomina();
    }
    
    public void iniciar() {
        try (scanner) {
            boolean salir = false;
            
            while (!salir) {
                mostrarMenuPrincipal();
                int opcion = leerOpcion();
                
                switch (opcion) {
                    case 1 -> registrarEmpleado();
                    case 2 -> mostrarEmpleados();
                    case 3 -> calcularNomina();
                    case 4 -> calcularPrima();
                    case 5 -> calcularCesantias();
                    case 6 -> eliminarEmpleado();
                    case 7 -> mostrarDetallesEmpleado();
                    case 0 -> {
                        salir = true;
                        System.out.println("¡Gracias por usar el sistema de nómina!");
                    }
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n==== SISTEMA DE NÓMINA 2025 ====");
        System.out.println("1. Registrar nuevo empleado");
        System.out.println("2. Mostrar lista de empleados");
        System.out.println("3. Calcular nómina");
        System.out.println("4. Calcular prima");
        System.out.println("5. Calcular cesantías e intereses");
        System.out.println("6. Eliminar empleado");
        System.out.println("7. Mostrar detalles de empleado");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna una opción inválida
        }
    }
    
    private void registrarEmpleado() {
        System.out.println("\n==== REGISTRO DE EMPLEADO ====");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Identificación: ");
        String identificacion = scanner.nextLine();
        
        // Verificar si ya existe un empleado con esa identificación
        if (gestionEmpleados.buscarEmpleado(identificacion) != null) {
            System.out.println("¡Error! Ya existe un empleado con esa identificación.");
            return;
        }
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        
        double salarioBase = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Salario base: ");
            try {
                salarioBase = Double.parseDouble(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
            }
        }
        
        boolean recibeAuxilioTransporte = false;
        if (salarioBase < CalculadoraNomina.SALARIO_MINIMO * 2) {
            System.out.print("¿Recibe auxilio de transporte? (S/N): ");
            String respuesta = scanner.nextLine();
            recibeAuxilioTransporte = respuesta.equalsIgnoreCase("S");
        }
        
        int diasTrabajados = 30; // Por defecto
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Días trabajados en el mes (1-30): ");
            try {
                diasTrabajados = Integer.parseInt(scanner.nextLine());
                if (diasTrabajados >= 1 && diasTrabajados <= 30) {
                    entradaValida = true;
                } else {
                    System.out.println("El número de días debe estar entre 1 y 30.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
            }
        }
        
        LocalDate fechaIngreso = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Fecha de ingreso (DD/MM/YYYY): ");
            try {
                String fechaStr = scanner.nextLine();
                fechaIngreso = LocalDate.parse(fechaStr, formatter);
                entradaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use DD/MM/YYYY.");
            }
        }
        
        Empleado nuevoEmpleado = new Empleado(nombre, apellido, identificacion, cargo, 
                                             salarioBase, recibeAuxilioTransporte, 
                                             diasTrabajados, fechaIngreso);
        
        gestionEmpleados.agregarEmpleado(nuevoEmpleado);
        System.out.println("¡Empleado registrado con éxito!");
    }
    
    private void mostrarEmpleados() {
        System.out.println("\n==== LISTA DE EMPLEADOS ====");
        List<Empleado> listaEmpleados = gestionEmpleados.getEmpleados();
        
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        
        System.out.printf("%-20s %-20s %-15s %-20s %-15s\n", 
                         "Nombre", "Apellido", "Identificación", "Cargo", "Salario Base");
        System.out.println("------------------------------------------------------------------------------");
        
        for (Empleado emp : listaEmpleados) {
            System.out.printf("%-20s %-20s %-15s %-20s $%-15.2f\n", 
                             emp.getNombre(), emp.getApellido(), emp.getIdentificacion(),
                             emp.getCargo(), emp.getSalarioBase());
        }
    }
    
    private void calcularNomina() {
        System.out.println("\n==== CÁLCULO DE NÓMINA ====");
        
        Empleado empleado = seleccionarEmpleado();
        if (empleado == null) {
            return;
        }
        
        double salarioTotal = calculadora.calcularSalarioTotal(empleado);
        double aporteSalud = calculadora.calcularAporteSalud(empleado);
        double aportePension = calculadora.calcularAportePension(empleado);
        double salarioNeto = calculadora.calcularSalarioNeto(empleado);
        
        System.out.println("\nRESULTADOS DE NÓMINA:");
        System.out.println("---------------------");
        System.out.printf("Empleado: %s %s\n", empleado.getNombre(), empleado.getApellido());
        System.out.printf("Salario Base: $%.2f\n", empleado.getSalarioBase());
        
        if (empleado.isRecibeAuxilioTransporte()) {
            System.out.printf("Auxilio de Transporte: $%.2f\n", 
                             CalculadoraNomina.AUXILIO_TRANSPORTE * empleado.getDiasTrabajados() / 30);
        }
        
        System.out.printf("Días Trabajados: %d\n", empleado.getDiasTrabajados());
        System.out.printf("Salario Total (con auxilio): $%.2f\n", salarioTotal);
        System.out.printf("Aporte a Salud (4%%): $%.2f\n", aporteSalud);
        System.out.printf("Aporte a Pensión (4%%): $%.2f\n", aportePension);
        System.out.printf("Total Deducciones: $%.2f\n", aporteSalud + aportePension);
        System.out.printf("SALARIO NETO A PAGAR: $%.2f\n", salarioNeto);
    }
    
    private void calcularPrima() {
        System.out.println("\n==== CÁLCULO DE PRIMA DE SERVICIOS ====");
        
        Empleado empleado = seleccionarEmpleado();
        if (empleado == null) {
            return;
        }
        
        int semestre = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Semestre (1 o 2): ");
            try {
                semestre = Integer.parseInt(scanner.nextLine());
                if (semestre == 1 || semestre == 2) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, ingrese 1 o 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
            }
        }
        
        double prima = calculadora.calcularPrima(empleado, semestre);
        
        System.out.println("\nRESULTADOS DE PRIMA DE SERVICIOS:");
        System.out.println("--------------------------------");
        System.out.printf("Empleado: %s %s\n", empleado.getNombre(), empleado.getApellido());
        System.out.printf("Semestre: %d\n", semestre);
        System.out.printf("Valor de Prima: $%.2f\n", prima);
    }
    
    private void calcularCesantias() {
        System.out.println("\n==== CÁLCULO DE CESANTÍAS E INTERESES ====");
        
        Empleado empleado = seleccionarEmpleado();
        if (empleado == null) {
            return;
        }
        
        double cesantias = calculadora.calcularCesantias(empleado);
        double intereses = calculadora.calcularInteresesCesantias(empleado);
        
        System.out.println("\nRESULTADOS DE CESANTÍAS E INTERESES:");
        System.out.println("-----------------------------------");
        System.out.printf("Empleado: %s %s\n", empleado.getNombre(), empleado.getApellido());
        System.out.printf("Cesantías: $%.2f\n", cesantias);
        System.out.printf("Intereses de Cesantías (12%%): $%.2f\n", intereses);
    }
    
    private void eliminarEmpleado() {
        System.out.println("\n==== ELIMINAR EMPLEADO ====");
        
        System.out.print("Ingrese la identificación del empleado a eliminar: ");
        String identificacion = scanner.nextLine();
        
        Empleado empleado = gestionEmpleados.buscarEmpleado(identificacion);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con esa identificación.");
            return;
        }
        
        System.out.printf("¿Está seguro de eliminar al empleado %s %s? (S/N): ",
                         empleado.getNombre(), empleado.getApellido());
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("S")) {
            gestionEmpleados.eliminarEmpleado(identificacion);
            System.out.println("Empleado eliminado con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
    
    private void mostrarDetallesEmpleado() {
        System.out.println("\n==== DETALLES DE EMPLEADO ====");
        
        Empleado empleado = seleccionarEmpleado();
        if (empleado == null) {
            return;
        }
        
        System.out.println("\nINFORMACIÓN DETALLADA:");
        System.out.println("---------------------");
        System.out.printf("Nombre completo: %s %s\n", empleado.getNombre(), empleado.getApellido());
        System.out.printf("Identificación: %s\n", empleado.getIdentificacion());
        System.out.printf("Cargo: %s\n", empleado.getCargo());
        System.out.printf("Salario Base: $%.2f\n", empleado.getSalarioBase());
        System.out.printf("Fecha de Ingreso: %s\n", empleado.getFechaIngreso());
        System.out.printf("Días Trabajados: %d\n", empleado.getDiasTrabajados());
        System.out.printf("Recibe Auxilio de Transporte: %s\n", 
                         empleado.isRecibeAuxilioTransporte() ? "Sí" : "No");
        System.out.printf("Tipo de Salario: %s\n", 
                         empleado.isRecibeSalarioIntegral() ? "Integral" : 
                         empleado.isRecibeSalarioMinimo() ? "Mínimo" : "Normal");
    }
    
    private Empleado seleccionarEmpleado() {
        List<Empleado> listaEmpleados = gestionEmpleados.getEmpleados();
        
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return null;
        }
        
        System.out.println("Empleados disponibles:");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado emp = listaEmpleados.get(i);
            System.out.printf("%d. %s %s (%s)\n", 
                             i+1, emp.getNombre(), emp.getApellido(), emp.getIdentificacion());
        }
        
        int indice = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Seleccione un empleado (número): ");
            try {
                indice = Integer.parseInt(scanner.nextLine()) - 1;
                if (indice >= 0 && indice < listaEmpleados.size()) {
                    entradaValida = true;
                } else {
                    System.out.println("Número fuera de rango. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        return listaEmpleados.get(indice);
    }
}