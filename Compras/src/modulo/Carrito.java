package modulo;

import java.util.ArrayList;

public class Carrito {
    private final ArrayList<Articulo> articulos;
    
    public Carrito() {
        this.articulos = new ArrayList<>();
    }
    
    public void agregarArticulo(String nombre, double precio, int cantidad) {
        Articulo articulo = new Articulo(nombre, precio, cantidad);
        articulos.add(articulo);
    }
    
    public double getSubtotalArticulo(int indice) {
        if (indice >= 0 && indice < articulos.size()) {
            return articulos.get(indice).getSubtotal();
        }
        return 0;
    }
    
    public int getNumeroArticulos() {
        return articulos.size();
    }
    
    public double getTotal() {
        double total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getSubtotal();
        }
        return total;
    }
    
    public int getCantidadTotal() {
        int cantidadTotal = 0;
        for (Articulo articulo : articulos) {
            cantidadTotal += articulo.getCantidad();
        }
        return cantidadTotal;
    }
    
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    
    public void limpiarCarrito() {
        articulos.clear();
    }
    
    // Clase interna para representar un artículo
    public class Articulo {
        private String nombre;
        private double precio;
        private int cantidad;
        
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