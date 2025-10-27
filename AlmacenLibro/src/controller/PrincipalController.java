/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.VistaPrincipal;

/**
 *
 * @author ignac
 */
public class PrincipalController {
    
    static VistaPrincipal ventana = new VistaPrincipal();
    
    public static void mostrar(){ventana.setVisible(true);}
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void btnAgregar(){
        ocultar();
        LibroController.mostrar();
    }
    
    public static void btnListar(){
        ocultar();
        ListaLibroController.mostrar();
    }
}
