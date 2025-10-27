/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ignac
 */
public class DataBase {
    
    Connection c;
    String cadenaConexion = "jdbc:mysql://localhost/almacenLibro?serverTimezone=UTC";
    String user = "root";
    String clave = ""; 
    /*Completar correspondientemente estos campos*/
    
    public DataBase(){
        try {
            c = DriverManager.getConnection(cadenaConexion, user, clave);
            System.out.println("Conexion establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexion con la DataBase: " + e.getMessage());
        }
    }
    
    public Fecha addFecha (Fecha fecha){
        Fecha f = new Fecha();
        try {
            PreparedStatement s = c.prepareStatement("INSERT INTO fecha (dia,mes,anio) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            s.setInt(1, fecha.getDia());
            s.setInt(2, fecha.getMes());
            s.setInt(3, fecha.getAnio());
            
            s.executeUpdate();
            System.out.println("Fecha agregada correctamente.");
            
            ResultSet generateKey = s.getGeneratedKeys();
            int idGenerated; 
            if(generateKey.next()){
                idGenerated = generateKey.getInt(1);
                System.out.println("ID de la Fecha almacenado.");
            } else {
                throw new Exception("No se genero ningun ID de Fecha.");
            }
            
            f.setIdFecha(idGenerated);
            f.setDia(fecha.getDia());
            f.setMes(fecha.getMes());
            f.setAnio(fecha.getAnio());
            
        } catch (Exception e) {
            System.out.println("Error al agregar Fecha: " + e.getMessage());
        }
        
        return f;
    }
    
    public void addLibro(Libro libro){
        try {
            PreparedStatement s = c.prepareStatement("INSERT INTO libro (isbn,nombre,autor,editorial,genero,fechaPub) values (?,?,?,?,?,?)");
            s.setInt(1, libro.getISBN());
            s.setString(2, libro.getNombre());
            s.setString(3, libro.getAutor());
            s.setString(4, libro.getEditorial());
            s.setString(5, libro.getGenero());
            s.setInt(6, libro.getFechaPub().getIdFecha());
            
            s.executeUpdate();
            System.out.println("Libro agregado correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al agregar el Libro: " + e.getMessage());
        }
    }
    
    private void updateFecha(Fecha fecha){
        try {
            PreparedStatement s = c.prepareStatement("UPDATE fecha SET dia=?,mes=?,anio=? WHERE idFecha = ?");
            s.setInt(1, fecha.getDia());
            s.setInt(2, fecha.getMes());
            s.setInt(3, fecha.getAnio());
            s.setInt(4, fecha.getIdFecha());
            
            s.executeUpdate();
            System.out.println("Modificacion de la Fecha realizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar la Fecha: " + e.getMessage());
        }
    }
    
    public void updateLibro(Libro libro){
        try {
            PreparedStatement s = c.prepareStatement("UPDATE libro SET isbn=?,nombre=?,autor=?,editorial=?,genero=? WHERE idLibro=?");
            s.setInt(1, libro.getISBN());
            s.setString(2, libro.getNombre());
            s.setString(3, libro.getAutor());
            s.setString(4, libro.getEditorial());
            s.setString(5, libro.getGenero());
            s.setInt(6, libro.getIdLibro());
            
            updateFecha(libro.getFechaPub());
            
            s.executeUpdate();
            System.out.println("Modificacion del Libro realizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar el Libro: " + e.getMessage());
        }
    }
    
    public void deleteLibro(int idlibro, int idfec){
        Statement s;
        try {
            s = c.createStatement();
            
            s.executeUpdate("DELETE FROM libro WHERE idLibro=" + idlibro);
            System.out.println("Eliminacion de Libro realizada correctamente.");
            
            s.executeUpdate("DELETE FROM fecha WHERE idFecha=" + idfec);
            System.out.println("Eliminacion de Fecha realizada correctamente.");
        
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
    
    public ArrayList<Libro> listLibros(){
        ArrayList<Libro> lista = new ArrayList<>();
        
        try {
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM libro ORDER BY idLibro");
            
            while(res.next()){
                Libro libro = new Libro();
                
                int idfec = res.getInt("fechaPub");
                Fecha fecha = fechaInToLibro(idfec);
                
                libro.setIdLibro(res.getInt("idLibro"));
                libro.setNombre(res.getString("nombre"));
                libro.setAutor(res.getString("autor"));
                libro.setEditorial(res.getString("editorial"));
                libro.setGenero(res.getString("genero"));
                libro.setISBN(res.getInt("isbn"));
                libro.setFechaPub(fecha);
                
                lista.add(libro);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al traer la Lista de Libros: " + e.getMessage());
        }
        
        return lista;
    }
    
    private Fecha fechaInToLibro(int idfec){
        Fecha fecha = new Fecha();
        
        try {
            PreparedStatement s = c.prepareStatement("SELECT dia FROM fecha WHERE idFecha = " + idfec);
            ResultSet rs = s.executeQuery();
            
            int dia = 0;
            if(rs.next()){
                dia = rs.getInt("dia");
            } else{
                throw new Exception("Problemas al cargar el dia.");
            }
            
            s = c.prepareStatement("SELECT mes FROM fecha WHERE idFecha = " + idfec);
            rs = s.executeQuery();
            
            int mes = 0;
            if(rs.next()){
                mes = rs.getInt("mes");
            } else{
                throw new Exception("Problemas al cargar el mes.");
            }
            
            s = c.prepareStatement("SELECT anio FROM fecha WHERE idFecha = " + idfec);
            rs = s.executeQuery();
            
            int anio = 0;
            if(rs.next()){
                anio = rs.getInt("anio");
            } else{
                throw new Exception("Problemas al cargar el anio.");
            }
            
            fecha.setIdFecha(idfec);
            fecha.setDia(dia);
            fecha.setMes(mes);
            fecha.setAnio(anio);
            
        } catch (Exception e) {
            System.out.println("Problemas al traer la Fecha: " + e.getMessage());
        }
        
        return fecha;
    }
    
    public Libro findLibro(int cod){
        Libro libro = new Libro();
        
        try {
            PreparedStatement s = c.prepareStatement("SELECT * FROM libro WHERE idLibro = " + cod);
            ResultSet rs = s.executeQuery();
            
            if(rs.next()){
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setGenero(rs.getString("genero"));
                libro.setISBN(rs.getInt("isbn"));
                Fecha fecha = fechaInToLibro(rs.getInt("fechaPub"));
                libro.setFechaPub(fecha);
                
            }else{
                throw new Exception("No se encuentra libro con esa ID.");
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar el Libro: " + e.getMessage());
        }
        
        return libro;
    }
}
