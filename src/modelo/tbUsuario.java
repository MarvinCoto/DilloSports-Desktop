/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.UUID;
import java.sql.*;



/**
 *
 * @author alanbrito
 */
public class tbUsuario {
    private String UUID_Usuario ;
    private String Nombre_Usuario; 
    private String Apellido_Usuario; 
    private String User_name ;
    private String Contrasena; 
    private String Correo_Usuario; 
    private String Genero_Usuario;
    private String FNacimiento_Usuario; 
    

    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return Apellido_Usuario;
    }

    public void setApellido_Usuario(String Apellido_Usuario) {
        this.Apellido_Usuario = Apellido_Usuario;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String Correo_Usuario) {
        this.Correo_Usuario = Correo_Usuario;
    }

    public String getGenero_Usuario() {
        return Genero_Usuario;
    }

    public void setGenero_Usuario(String Genero_Usuario) {
        this.Genero_Usuario = Genero_Usuario;
    }

    public String getFNacimiento_Usuario() {
        return FNacimiento_Usuario;
    }

    public void setFNacimiento_Usuario(String FNacimiento_Usuario) {
        this.FNacimiento_Usuario = FNacimiento_Usuario;
    }
    
    public void GuardarUsuario(){
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            PreparedStatement addUsuario = conexion.prepareStatement("INSERT INTO tbUsuarios(UUID_Usuario, Nombre_Usuario, Apellido_Usuario, User_name, Contrasena_Usuario, Correo_Usuario, Genero_Usuario, FNacimiento_Usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            addUsuario.setString(1, UUID.randomUUID().toString());
            addUsuario.setString(2, getNombre_Usuario());
            addUsuario.setString(3, getApellido_Usuario());
            addUsuario.setString(4, getUser_name());
            addUsuario.setString(5, getContrasena());
            addUsuario.setString(6, getCorreo_Usuario());
            addUsuario.setString(7, getGenero_Usuario());
            addUsuario.setString(8, getFNacimiento_Usuario());
            
            addUsuario.executeUpdate();
                    System.out.println("Usuario creado exitosamente");
           
        } catch (SQLException ex) {
            System.out.println("Este es el error en el modelo: metodo guardar"+ ex);
        }
    }
}
