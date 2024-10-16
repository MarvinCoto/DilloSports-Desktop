/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author marvi
 */
public class Deportes {
    
    private String UUID_Deporte;
    private String Nombre;

    public String getUUID_Deporte() {
        return UUID_Deporte;
    }

    public void setUUID_Deporte(String UUID_Deporte) {
        this.UUID_Deporte = UUID_Deporte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    //Extras para el ComboBox
    public Deportes(){
        
    }
    
    public Deportes(String uuid, String nombre)
    {
        this.UUID_Deporte = uuid;
        this.Nombre = nombre;
    }
    
      @Override
    public String toString()
    {
        return Nombre;
    }
    
    
    //Metodo para cargar los valores en el ComboBox
    public void CargarComboDeportes(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from tbTipoDeporte");
            while (rs.next()) {
                String uuid = rs.getString("UUID_Tipo_Deporte");
                String nombre = rs.getString("Nombre_Tipo_Deporte");
                comboBox.addItem(new Deportes(uuid,nombre));                
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
    }
    
}
