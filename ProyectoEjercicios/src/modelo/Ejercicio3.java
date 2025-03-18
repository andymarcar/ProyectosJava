package modelo;

import java.util.ArrayList;

public class Ejercicio3 {
    private final ArrayList<Articulo> articulos;
    
    public Ejercicio3() {
        articulos = new ArrayList<>();
    }
    
    public void limpiarCarrito() {
        articulos.clear();
    }
    
    public void agregarArticulo(String nombre, double precio, int cantidad) {
        articulos.add(new Articulo(nombre, precio, cantidad));
    }
    
    public double getTotal() {
        double total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getSubtotal();
        }
        return total;
    }
    
    public int getNumeroArticulos() {
        return articulos.size();
    }
    
    public int getCantidadTotal() {
        int total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getCantidad();
        }
        return total;
    }
    
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    
    public static class Articulo {
        private final String nombre;
        private final double precio;
        private final int cantidad;
        
        public Articulo(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public double getPrecio() {
            return precio;
        }
        
        public int getCantidad() {
            return cantidad;
        }
        
        public double getSubtotal() {
            return precio * cantidad;
        }
    }
}