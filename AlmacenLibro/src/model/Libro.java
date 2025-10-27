/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ignac
 */
public class Libro {
    private int idLibro;
    private int ISBN;
    private String nombre;
    private String autor;
    private String editorial;
    private String genero;
    private Fecha fechaPub;
    
    public Libro(){}

    public Libro(int idLibro, int ISBN, String nombre, String autor, String editorial, String genero, Fecha fechaPub) {
        this.idLibro = idLibro;
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPub = fechaPub;
    }

    public Libro(int ISBN, String nombre, String autor, String editorial, String genero, Fecha fechaPub) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPub = fechaPub;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Fecha getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(Fecha fechaPub) {
        this.fechaPub = fechaPub;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", ISBN=" + ISBN + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + ", fechaPub=" + fechaPub + '}';
    }
    
}
