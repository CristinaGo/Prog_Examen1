package ejercicio3;

import java.time.LocalDate;

public class Videojuego {
    private int id;
    private String nombre;
    private String plataforma;
    private String genero;
    private String fechaLanzamiento;
    private double precio;
    private boolean stock;
    private int unidades;

    public Videojuego(int id, String nombre, String plataforma, String genero, String fechaLanzamiento, double precio, boolean stock, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.stock = stock;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Plataforma: " + plataforma + " - Genero: " + genero + " - FechaLanzamiento: " + fechaLanzamiento + " - Precio: " + precio + " - Stock: " + stock +
                " - Unidades: " + unidades;
    }
}
