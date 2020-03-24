/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensajesapp.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pro
 */


public class Conexion {
    private static Connection myConnection;
    public static Connection getConnection(){
        if(myConnection == null) {
            try {
                myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "adiaz", "");
            } catch (SQLException e) {
            }
        }
        return myConnection;
    }

    Connection get_connection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}