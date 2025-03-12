package modelo;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String cargo;
    private double salarioBase;
    private boolean recibeSalarioMinimo;
    private boolean recibeSalarioIntegral;
    private boolean recibeAuxilioTransporte;
    private int diasTrabajados;
    private LocalDate fechaIngreso;

    // Constructor
    public Empleado(String nombre, String apellido, String identificacion, String cargo, 
                    double salarioBase, boolean recibeAuxilioTransporte, int diasTrabajados,
                    LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.recibeAuxilioTransporte = recibeAuxilioTransporte;
        this.diasTrabajados = diasTrabajados;
        this.fechaIngreso = fechaIngreso;
        this.recibeSalarioMinimo = (salarioBase <= 1423500);
        this.recibeSalarioIntegral = (salarioBase >= 18505500);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
        this.recibeSalarioMinimo = (salarioBase <= 1423500);
        this.recibeSalarioIntegral = (salarioBase >= 18505500);
    }

    public boolean isRecibeSalarioMinimo() {
        return recibeSalarioMinimo;
    }

    public boolean isRecibeSalarioIntegral() {
        return recibeSalarioIntegral;
    }

    public boolean isRecibeAuxilioTransporte() {
        return recibeAuxilioTransporte;
    }

    public void setRecibeAuxilioTransporte(boolean recibeAuxilioTransporte) {
        this.recibeAuxilioTransporte = recibeAuxilioTransporte;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salarioBase=" + salarioBase +
                ", diasTrabajados=" + diasTrabajados +
                '}';
    }
}

