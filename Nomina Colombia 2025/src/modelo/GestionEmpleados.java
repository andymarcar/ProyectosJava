package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    private final List<Empleado> empleados;
    
    public GestionEmpleados() {
        this.empleados = new ArrayList<>();
    }
    
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public void eliminarEmpleado(String identificacion) {
        empleados.removeIf(e -> e.getIdentificacion().equals(identificacion));
    }
    
    public Empleado buscarEmpleado(String identificacion) {
        return empleados.stream()
                .filter(e -> e.getIdentificacion().equals(identificacion))
                .findFirst()
                .orElse(null);
    }
    
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados); // Devolvemos una copia para proteger la lista original
    }
    
    public int getCantidadEmpleados() {
        return empleados.size();
    }
}