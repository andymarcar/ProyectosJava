package modelo;

import java.util.ArrayList;

public class Ejercicio1 {
    private final ArrayList<Alumno> alumnos;
    private double calificacionMinima;
    
    public Ejercicio1() {
        alumnos = new ArrayList<>();
        calificacionMinima = 7.0; // Valor por defecto
    }
    
    public void limpiarRegistro() {
        alumnos.clear();
    }
    
    public void setCalificacionMinima(double calificacionMinima) {
        this.calificacionMinima = calificacionMinima;
    }
    
    public void agregarAlumno(String nombre, double[] calificaciones) {
        alumnos.add(new Alumno(nombre, calificaciones));
    }
    
    public int getTotalAlumnos() {
        return alumnos.size();
    }
    
    public int getAlumnosSinDerecho() {
        int count = 0;
        for (Alumno alumno : alumnos) {
            if (!alumno.tieneDerecho(calificacionMinima)) {
                count++;
            }
        }
        return count;
    }
    
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public static class Alumno {
        private final String nombre;
        private final double[] calificaciones;
        
        public Alumno(String nombre, double[] calificaciones) {
            this.nombre = nombre;
            this.calificaciones = calificaciones;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public double getPromedio() {
            double suma = 0;
            for (double calificacion : calificaciones) {
                suma += calificacion;
            }
            return suma / calificaciones.length;
        }
        
        public boolean tieneDerecho(double calificacionMinima) {
            return getPromedio() >= calificacionMinima;
        }
    }
}