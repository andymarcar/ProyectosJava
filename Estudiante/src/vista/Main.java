package vista;

import modelo.Estudiante;

public class Main {
    
    public static void main(String[] args) {
        
        //Crear una variable de tipo estudainte
        Estudiante estudiante1 = new Estudiante("Andres", 10);
        
        //Ingresar notas
        estudiante1.IngresarNota(100);
        estudiante1.IngresarNota(90);
        estudiante1.IngresarNota(80);
        
        //Calcular y mostras el promedio por consola
        System.out.println(estudiante1.CalcularPromedio());
        
        //Mostrar nombre estudainte
        System.out.println(estudiante1.getNombre());
    } 
    
}
