package modulo;

import java.util.ArrayList;

public class ControlCalificaciones {
    private final ArrayList<Alumno> alumnos;
    private double calificacionMinima;
    
    public ControlCalificaciones() {
        this.alumnos = new ArrayList<>();
        this.calificacionMinima = 70.0; // Suponemos que 70 es la calificación mínima para tener derecho
    }
    
    public void setCalificacionMinima(double calificacionMinima) {
        this.calificacionMinima = calificacionMinima;
    }
    
    public void agregarAlumno(String nombre, double[] calificaciones) {
        Alumno alumno = new Alumno(nombre, calificaciones);
        alumnos.add(alumno);
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
    
    public void limpiarRegistro() {
        alumnos.clear();
    }
    
    // Clase interna para representar un alumno
    public class Alumno {
        private final String nombre;
        private final double[] calificaciones;
        
        public Alumno(String nombre, double[] calificaciones) {
            this.nombre = nombre;
            this.calificaciones = calificaciones;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public double[] getCalificaciones() {
            return calificaciones;
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
