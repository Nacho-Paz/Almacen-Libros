/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DataBase;
import model.Fecha;
import model.Libro;
import view.VistaLibro;

/**
 *
 * @author ignac
 */
public class LibroController {
    
    static VistaLibro ventana = new VistaLibro();
    
    public static void mostrar(){ventana.setVisible(true);};
    public static void ocultar(){ventana.setVisible(false);};
    
    public static void addLibro(){
        String nombre = ventana.getTxtNombre().getText();
        String autor = ventana.getTxtAutor().getText();
        String editorial = ventana.getTxtEditorial().getText();
        int isbn = Integer.parseInt(ventana.getTxtISBN().getText());
        String genero = (String) ventana.getComboxGenero().getSelectedItem();
        int dia = Integer.parseInt(ventana.getTxtDia().getText());
        int mes = Integer.parseInt(ventana.getTxtMes().getText());
        int anio = Integer.parseInt(ventana.getTxtAnio().getText());
        
        Fecha fecha1 = new Fecha(dia, mes, anio);
        DataBase db = new DataBase();
        fecha1 = db.addFecha(fecha1);
        
        Libro libro = new Libro(isbn, nombre, autor, editorial, genero, fecha1);
        db.addLibro(libro);
        
    }
    
    public static void btnVolver(){
        ocultar();
        PrincipalController.mostrar();
    }
}
