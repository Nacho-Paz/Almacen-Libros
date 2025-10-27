/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DataBase;
import model.Fecha;
import model.Libro;
import view.VistaListaLibros;

/**
 *
 * @author ignac
 */
public class ListaLibroController {

    public static VistaListaLibros ventana = new VistaListaLibros();

    public static void ocultar() {
        ventana.setVisible(false);
    }
    
    public static void mostrar() {
        VistaListaLibros.cod = 0;
        ventana.setVisible(true);

        DataBase db = new DataBase();
        ArrayList<Libro> lista = db.listLibros();
        DefaultTableModel model = (DefaultTableModel) ventana.getTablaLibros().getModel();

        model.setNumRows(0);

        for (Libro libro : lista) {
            Object[] fila = new Object[7];
            fila[0] = libro.getIdLibro();
            fila[1] = libro.getNombre();
            fila[2] = libro.getAutor();
            fila[3] = libro.getEditorial();
            fila[4] = libro.getGenero();
            fila[5] = libro.getISBN();
            fila[6] = libro.getFechaPub();

            model.addRow(fila);
        }
    }

    public static void eleminarLibro(int cod, Fecha fecha) {
        DataBase db = new DataBase();
        db.deleteLibro(cod, fecha.getIdFecha());

        mostrar();
    }

    public static void btnVolver() {
        ocultar();
        PrincipalController.mostrar();
    }

    public static boolean btnBuscar(String busqueda) {
        VistaListaLibros.cod = 0;
        DataBase db = new DataBase();
        ArrayList<Libro> lista = db.listLibros();
        DefaultTableModel model = (DefaultTableModel) ventana.getTablaLibros().getModel();
        int validadorHasLibro = 0;

        model.setNumRows(0);

        for (Libro libro : lista) {
            if (libro.getNombre().trim().toLowerCase().contains(busqueda) || libro.getAutor().trim().toLowerCase().contains(busqueda)
                    || libro.getEditorial().trim().toLowerCase().contains(busqueda) || libro.getGenero().trim().toLowerCase().contains(busqueda)) {

                Object[] fila = new Object[7];
                fila[0] = libro.getIdLibro();
                fila[1] = libro.getNombre();
                fila[2] = libro.getAutor();
                fila[3] = libro.getEditorial();
                fila[4] = libro.getGenero();
                fila[5] = libro.getISBN();
                fila[6] = libro.getFechaPub();

                model.addRow(fila);
                validadorHasLibro = 1;
            }
        }

        return validadorHasLibro != 0;
        /*if (validadorHasLibro == 0) {
            return false;
        } else {
            return true;
        }*/
    }

}
