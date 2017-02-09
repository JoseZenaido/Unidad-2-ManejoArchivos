/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String  precio;
    private String existencia;

    public Producto(int id, String nombre, String precio,String existencia) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia=existencia;
    }
    public Producto()
    {
        this(0,"","","");
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencia=" + existencia + '}';
    }
    
    
    
    
    
}
