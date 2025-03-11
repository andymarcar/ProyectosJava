package modelo;

/**
 * Clase que modela el curso con todos sus estudiantes
 * @author Andres
 * @version 1.0
 */
public class Curso {
    
    private String nombre;
    private String indicativo;
    private Estudiante[] estudiantes;
    private int numestudiantes; //Estudianes registrados en el curso

    public Curso(String nombre, String indicativo, int capacidad) {
        this.nombre = nombre;
        this.indicativo = indicativo;
        this.estudiantes = new Estudiante [capacidad];
        this.numestudiantes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }
    
    
    
}
