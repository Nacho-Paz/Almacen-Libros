/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DataBase;
import model.Fecha;
import model.Libro;
import view.VistaModificar;

/**
 *
 * @author ignac
 */
public class ModificarController {
    
    public static VistaModificar ventana = new VistaModificar();   
    public static void ocultar(){ventana.setVisible(false);}
    private static int codigo;
    private static int codigoLibro;
    
    public static void mostrar(int cod){
        ListaLibroController.ocultar();
        codigo = cod;
        ventana.setVisible(true);
        DataBase db = new DataBase();
        Libro libro = db.findLibro(cod);
        codigoLibro = libro.getFechaPub().getIdFecha();
        
        ventana.getTxtNombre().setText(libro.getNombre());
        ventana.getTxtAutor().setText(libro.getAutor());
        ventana.getTxtEditorial().setText(libro.getEditorial());
        ventana.getTxtISBN().setText(String.valueOf(libro.getISBN()));
        ventana.getTxtDia().setText(String.valueOf(libro.getFechaPub().getDia()));
        ventana.getTxtMes().setText(String.valueOf(libro.getFechaPub().getMes()));
        ventana.getTxtAnio().setText(String.valueOf(libro.getFechaPub().getAnio()));
        ventana.getComboxGenero().setSelectedItem(libro.getGenero());
    }
    
    public static void modificarLibro(){
        DataBase db = new DataBase();
        Libro libro = new Libro();
        
        libro.setNombre(ventana.getTxtNombre().getText());
        libro.setAutor(ventana.getTxtAutor().getText());
        libro.setEditorial(ventana.getTxtEditorial().getText());
        libro.setGenero((String) ventana.getComboxGenero().getSelectedItem());
        libro.setISBN(Integer.parseInt(ventana.getTxtISBN().getText()));
        libro.setIdLibro(codigo);
        
        Fecha fecha = new Fecha(codigoLibro, 
                Integer.parseInt(ventana.getTxtDia().getText()), 
                Integer.parseInt(ventana.getTxtMes().getText()), 
                Integer.parseInt(ventana.getTxtAnio().getText()));
        
        libro.setFechaPub(fecha);
        
        db.updateLibro(libro);
        
        System.out.println("Modificación del libro realizada con exito.");
        ListaLibroController.mostrar();
    }
    
    public static void btnVolver(){
        ocultar();
        ListaLibroController.mostrar();
    }
}
