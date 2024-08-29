/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alanbrito
 */
public class funLogyRegistrar {
   
    public static boolean InsertUser(tbUsuario x){
        
        Connection conexion=ClaseConexion.getConexion();
        PreparedStatement ps=null;
        String sql= "insert into tbUsuarioss(UUID_Usuario, Nombre_Usuario, Apellido_Usuario, User_name, Contrasena_Usuario, Genero_Usuario, FNacimiento_Usuario) values (?, ?,?, ?, ?, ?,?,?,)";
        
        try{
            ps=conexion.prepareStatement (sql);
            ps.setString (1,x.UUID.randomUUID().toString());
            ps.setString (2,x.getNombre_Usuario());
            ps.setString (3,x.getApellido_Usuario());
            ps.setString (4,x.getUser_name());
            ps.setString (5,x.getContrasena());
            ps.setString (6,x.getCorreo_Usuario());
            ps.setString (7,x.getGenero_Usuario(sql));
            ps.setString (8,x.getFNacimiento_Usuario(sql));
            ps.execute();
            conexion.close();
            
            return true;
            
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
        
    }
    
    
}


