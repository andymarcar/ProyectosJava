package modelo;

import java.util.ArrayList;

public class Ejercicio2 {
    private final ArrayList<Double> ventas;
    
    public Ejercicio2() {
        ventas = new ArrayList<>();
    }
    
    public void reiniciarVentas() {
        ventas.clear();
    }
    
    public void registrarVenta(double monto) {
        ventas.add(monto);
    }
    
    public int getNumeroClientes() {
        return ventas.size();
    }
    
    public double getMontoTotal() {
        double total = 0;
        for (Double venta : ventas) {
            total += venta;
        }
        return total;
    }
    
    public ArrayList<Double> getVentas() {
        return ventas;
    }
}