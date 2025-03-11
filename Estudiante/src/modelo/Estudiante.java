package modelo;

/**
 * Clase que modela a un estudiante y sus notas
 * @author Andres
 * @version 1.0
 */

public class Estudiante { 
    
  private String nombre;
  private final double[] notas;
  private int notasingresadas;
  
  /**
   * @param nombre es un string que representa el nombre del estudiante
   * @param limitenotas, un entero positivo para establecer la cantidad max. de notas
   */

    public Estudiante(String nombre, int limitenotas) {
        this.nombre = nombre;
        this.notas = new double [limitenotas];//El new sirve para abrir espacio en la memoria
        this.notasingresadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo que nos calcula el promedio del estudiante con las notas ingresadas
     * @return double que nos calcula el promedio de notas
     */
  
    public double CalcularPromedio() {
        
        double sum =0;
        for (int i=0; i<notasingresadas ; i++) {// int i=0 se ejecuta una vez, despues mira si la condicion se cumple y por ultimo hace la sumatoria
            sum += notas[i];  
        }
        
        
        return sum/notasingresadas;
    }
    
    public void IngresarNota(double nota) {
        notas[notasingresadas] = nota;
        notasingresadas++;
    }
  
}