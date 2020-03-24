/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensajesapp.mensaje_app;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

/**
 *
 * @author Pro
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query= "INSERT INTO mesajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente"); 
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;  
         try (Connection conexion = db_connect.get_connection()){
             String query = "SELECT * FROM mesajes";
             ps = conexion.prepareStatement(query);
             rs = ps.executeQuery();
             
             while(rs.next()){
                 System.out.println("ID: "+rs.getInt("id_mensaje"));
                 System.out.println("Mensaje: "+rs.getString("mensaje"));
                 System.out.println("Autor: "+rs.getString("autor_mensaje"));
                 System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                 System.out.println("");
             }
        
         }catch (SQLException e) {
                System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(e);
            }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
    
    
}
