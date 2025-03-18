package modelo;

import java.util.ArrayList;

public class Ejercicio4 {
    private final ArrayList<Cliente> clientes;
    private double totalDelDia;
    
    public Ejercicio4() {
        clientes = new ArrayList<>();
        totalDelDia = 0;
    }
    
    public void reiniciarCaja() {
        clientes.clear();
        totalDelDia = 0;
    }
    
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        totalDelDia += cliente.getMontoTotal();
    }
    
    public int getNumeroClientes() {
        return clientes.size();
    }
    
    public double getTotalDelDia() {
        return totalDelDia;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public static class Cliente {
        private final int numero;
        private final ArrayList<String> nombresArticulos;
        private final ArrayList<Double> preciosArticulos;
        private double montoTotal;
        
        public Cliente(int numero) {
            this.numero = numero;
            this.nombresArticulos = new ArrayList<>();
            this.preciosArticulos = new ArrayList<>();
            this.montoTotal = 0;
        }
        
        public void agregarArticulo(String nombre, double precio) {
            nombresArticulos.add(nombre);
            preciosArticulos.add(precio);
            montoTotal += precio;
        }
        
        public int getNumero() {
            return numero;
        }
        
        public double getMontoTotal() {
            return montoTotal;
        }
        
        public int getCantidadArticulos() {
            return nombresArticulos.size();
        }
    }
}