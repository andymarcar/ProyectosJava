package modulo;

import java.util.ArrayList;

public class VentasCompu {
    private final ArrayList<Double> montoVentas;
    
    public VentasCompu() {
        this.montoVentas = new ArrayList<>();
    }
    
    public void registrarVenta(double monto) {
        montoVentas.add(monto);
    }
    
    public int getNumeroClientes() {
        return montoVentas.size();
    }
    
    public double getMontoTotal() {
        double total = 0;
        for (Double venta : montoVentas) {
            total += venta;
        }
        return total;
    }
    
    public void reiniciarVentas() {
        montoVentas.clear();
    }
}