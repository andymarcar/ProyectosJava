package modelo;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class CalculadoraNomina {
    // Constantes 2025
    public static final double SALARIO_MINIMO = 1423500;
    public static final double AUXILIO_TRANSPORTE = 200000;
    public static final double SALARIO_INTEGRAL = 18505500;
    public static final double PORCENTAJE_SALUD = 0.04;
    public static final double PORCENTAJE_PENSION = 0.04;
    public static final int DIAS_ANIO = 360;
    
    // Calcular salario total incluyendo auxilio de transporte
    public double calcularSalarioTotal(Empleado empleado) {
        double salarioBase = empleado.getSalarioBase();
        int diasTrabajados = empleado.getDiasTrabajados();
        
        // Salario base proporcional a días trabajados
        double salarioProporcional = salarioBase * diasTrabajados / 30;
        
        // Auxilio de transporte (si aplica)
        double auxilioTransporte = 0;
        if (empleado.isRecibeAuxilioTransporte() && !empleado.isRecibeSalarioIntegral()) {
            auxilioTransporte = AUXILIO_TRANSPORTE * diasTrabajados / 30;
        }
        
        return salarioProporcional + auxilioTransporte;
    }
    
    // Calcular aporte a salud
    public double calcularAporteSalud(Empleado empleado) {
        double base = empleado.getSalarioBase();
        if (empleado.isRecibeSalarioIntegral()) {
            base = base * 0.7; // Para salario integral, la base es el 70%
        }
        return base * PORCENTAJE_SALUD;
    }
    
    // Calcular aporte a pensión
    public double calcularAportePension(Empleado empleado) {
        double base = empleado.getSalarioBase();
        if (empleado.isRecibeSalarioIntegral()) {
            base = base * 0.7; // Para salario integral, la base es el 70%
        }
        return base * PORCENTAJE_PENSION;
    }
    
    // Calcular total deducciones
    public double calcularDeducciones(Empleado empleado) {
        return calcularAporteSalud(empleado) + calcularAportePension(empleado);
    }
    
    // Calcular salario neto
    public double calcularSalarioNeto(Empleado empleado) {
        return calcularSalarioTotal(empleado) - calcularDeducciones(empleado);
    }
    
    // Calcular prima de servicios (semestral)
    public double calcularPrima(Empleado empleado, int semestre) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngreso = empleado.getFechaIngreso();
        
        LocalDate inicioPeriodo, finPeriodo;
        if (semestre == 1) {
            inicioPeriodo = LocalDate.of(fechaActual.getYear(), Month.JANUARY, 1);
            finPeriodo = LocalDate.of(fechaActual.getYear(), Month.JUNE, 30);
        } else {
            inicioPeriodo = LocalDate.of(fechaActual.getYear(), Month.JULY, 1);
            finPeriodo = LocalDate.of(fechaActual.getYear(), Month.DECEMBER, 31);
        }
        
        // Si el empleado ingresó después del inicio del periodo, ajustamos
        if (fechaIngreso.isAfter(inicioPeriodo)) {
            inicioPeriodo = fechaIngreso;
        }
        
        // Calculamos los días trabajados en el semestre
        int diasEnPeriodo = 0;
        if (!fechaIngreso.isAfter(finPeriodo)) {
            Period periodo = Period.between(inicioPeriodo, 
                                           (fechaActual.isBefore(finPeriodo) ? fechaActual : finPeriodo));
            diasEnPeriodo = periodo.getDays() + periodo.getMonths() * 30 + periodo.getYears() * 360;
        }
        
        // Fórmula de la prima: (Salario + Auxilio de transporte) * días trabajados / 360
        double salarioMensual = empleado.getSalarioBase();
        double auxilioTransporte = empleado.isRecibeAuxilioTransporte() ? AUXILIO_TRANSPORTE : 0;
        
        return (salarioMensual + auxilioTransporte) * diasEnPeriodo / 180;
    }
    
    // Calcular cesantías anuales
    public double calcularCesantias(Empleado empleado) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngreso = empleado.getFechaIngreso();
        LocalDate inicioPeriodo = LocalDate.of(fechaActual.getYear(), Month.JANUARY, 1);
        
        // Si el empleado ingresó después del inicio del periodo, ajustamos
        if (fechaIngreso.isAfter(inicioPeriodo)) {
            inicioPeriodo = fechaIngreso;
        }
        
        // Calculamos los días trabajados en el año
        int diasEnPeriodo = 0;
        Period periodo = Period.between(inicioPeriodo, fechaActual);
        diasEnPeriodo = periodo.getDays() + periodo.getMonths() * 30 + periodo.getYears() * 360;
        
        // Cesantías: (Salario + Auxilio de transporte) * días trabajados / 360
        double salarioMensual = empleado.getSalarioBase();
        double auxilioTransporte = empleado.isRecibeAuxilioTransporte() ? AUXILIO_TRANSPORTE : 0;
        
        return (salarioMensual + auxilioTransporte) * diasEnPeriodo / 360;
    }
    
    // Calcular intereses de cesantías (12% anual)
    public double calcularInteresesCesantias(Empleado empleado) {
        return calcularCesantias(empleado) * 0.12;
    }
    
    // Calcular vacaciones (15 días hábiles por año trabajado)
    public double calcularVacaciones(Empleado empleado) {
        double salarioDiario = empleado.getSalarioBase() / 30;
        return salarioDiario * 15;
    }
}