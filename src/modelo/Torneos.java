/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.frmNoticias;
import vista.frmTorneos;

/**
 *
 * @author marvi
 */
public class Torneos {
    
    //Parametros
    private String UUID_Torneo;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String logo;

    public String getUUID_Torneo() {
        return UUID_Torneo;
    }

    public void setUUID_Torneo(String UUID_Torneo) {
        this.UUID_Torneo = UUID_Torneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    //3- Métodos (select, insert, update, delete)

    //Ingresar
    public void GuardarTorneo() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addNoticia = conexion.prepareStatement("INSERT INTO tbTorneos(UUID_Torneo, Nombre_Torneo, Ubicacion_Torneo, Descripcion_Torneo, Logo_Torneo) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addNoticia.setString(1, UUID.randomUUID().toString());
            addNoticia.setString(2, getNombre());
            addNoticia.setString(3, getUbicacion());
            addNoticia.setString(4, getDescripcion());
            addNoticia.setString(5, getLogo());
 
            //Ejecutar la consulta
            addNoticia.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void MostrarTorneo(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloTorneos = new DefaultTableModel();
        modeloTorneos.setColumnIdentifiers(new Object[]{"UUID_Torneo", "Nombre_Torneo", "Ubicacion_Torneo", "Descripcion_Torneo", "Logo_Torneo"});
        try {
         
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select UUID_Torneo, Nombre_Torneo, Ubicacion_Torneo, Descripcion_Torneo, Logo_Torneo FROM tbTorneos");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloTorneos.addRow(new Object[]{rs.getString("UUID_Torneo"), 
                    rs.getString("Nombre_Torneo"), 
                    rs.getString("Ubicacion_Torneo"), 
                    rs.getString("Descripcion_Torneo"), 
                    rs.getString("Logo_Torneo")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloTorneos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void EliminarTorneo(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbTorneos where UUID_Torneo = ?";
            PreparedStatement deleteTorneo = conexion.prepareStatement(sql);
            deleteTorneo.setString(1, miId);
            deleteTorneo.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void ActualizarTorneo(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbTorneos set Nombre_Torneo = ?, Ubicacion_Torneo = ?, Descripcion_Torneo = ?, Logo_Torneo = ? where UUID_Torneo = ?";
                PreparedStatement updateNoticia = conexion.prepareStatement(sql);

                updateNoticia.setString(1, getNombre());
                updateNoticia.setString(2, getUbicacion());
                updateNoticia.setString(3, getDescripcion());
                updateNoticia.setString(4, getLogo());
                updateNoticia.setString(5, miUUId);
                updateNoticia.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
    
    public void Buscar(JTable tabla, JTextField miTextField) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_Torneo", "Nombre_Torneo", "Ubicacion_Torneo", "Descripcion_Torneo", "Logo_Torneo"});
        try {
            String sql = "SELECT * FROM tbTorneos WHERE Nombre_Torneo LIKE ? || '%'";
            PreparedStatement searchNoticia = conexion.prepareStatement(sql);
            searchNoticia.setString(1, miTextField.getText());
            ResultSet rs = searchNoticia.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Torneo"), rs.getString("Nombre_Torneo"), rs.getString("Ubicacion_Torneo"), rs.getString("Descripcion_Torneo"), rs.getString("Logo_Torneo")});
            }

            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
    
    
    public void limpiar(frmTorneos vistaTorneos) {
        vistaTorneos.txtNombreTorneo.setText("");
        vistaTorneos.txtUbicacionTorneo.setText("");
        vistaTorneos.txtDescripcionTorneo.setText("");
        vistaTorneos.txtLogoTorneo.setText("");
    }

    public void cargarDatosTabla(frmTorneos vistaTorneos) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vistaTorneos.jtbTorneos.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vistaTorneos.jtbTorneos.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vistaTorneos.jtbTorneos.getValueAt(filaSeleccionada, 1).toString();
            String UbicacionDeTB = vistaTorneos.jtbTorneos.getValueAt(filaSeleccionada, 2).toString();
            String DescripcionDeTb = vistaTorneos.jtbTorneos.getValueAt(filaSeleccionada, 3).toString();
            String LogoDeTB = vistaTorneos.jtbTorneos.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vistaTorneos.txtNombreTorneo.setText(NombreDeTB);
            vistaTorneos.txtUbicacionTorneo.setText(UbicacionDeTB);
            vistaTorneos.txtDescripcionTorneo.setText(DescripcionDeTb);
            vistaTorneos.txtLogoTorneo.setText(LogoDeTB);
        }
    }
    
}
