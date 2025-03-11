package modelo;

import java.util.ArrayList;

public class CajaRegistradora {
    private final ArrayList<Cliente> clientes;
    private double totalDelDia;
    
    public CajaRegistradora() {
        this.clientes = new ArrayList<>();
        this.totalDelDia = 0;
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
    
    public void reiniciarCaja() {
        clientes.clear();
        totalDelDia = 0;
    }
    
    // Clase para representar un cliente
    public static class Cliente {
        private final int numero;
        private final ArrayList<Articulo> articulos;
        
        public Cliente(int numero) {
            this.numero = numero;
            this.articulos = new ArrayList<>();
        }
        
        public void agregarArticulo(String nombre, double precio) {
            articulos.add(new Articulo(nombre, precio));
        }
        
        public int getNumero() {
            return numero;
        }
        
        public int getCantidadArticulos() {
            return articulos.size();
        }
        
        public double getMontoTotal() {
            double total = 0;
            for (Articulo articulo : articulos) {
                total += articulo.getPrecio();
            }
            return total;
        }
        
        public ArrayList<Articulo> getArticulos() {
            return articulos;
        }
    }
    
    // Clase para representar un artículo
    public static class Articulo {
        private final String nombre;
        private final double precio;
        
        public Articulo(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public double getPrecio() {
            return precio;
        }
    }
}