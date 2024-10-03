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
import vista.frmEquipos;
import vista.frmNoticias;

/**
 *
 * @author marvi
 */
public class Equipos {
    
    //Parametros
    private String UUID_Equipo;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String logo;

    public String getUUID_Equipo() {
        return UUID_Equipo;
    }

    public void setUUID_Equipo(String UUID_Equipo) {
        this.UUID_Equipo = UUID_Equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    //3- Métodos (select, insert, update, delete)

    //Ingresar
    public void GuardarEquipo() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addEquipo = conexion.prepareStatement("INSERT INTO tbEquipos(UUID_Equipo, Nombre_Equipo, Descripcion_Equipo, Ubicacion_Equipo, Logo_Equipo) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addEquipo.setString(1, UUID.randomUUID().toString());
            addEquipo.setString(2, getNombre());
            addEquipo.setString(3, getDescripcion());
            addEquipo.setString(4, getUbicacion());
            addEquipo.setString(5, getLogo());
 
            //Ejecutar la consulta
            addEquipo.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void MostrarEquipo(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloEquipo = new DefaultTableModel();
        modeloEquipo.setColumnIdentifiers(new Object[]{"UUID_Equipo", "Nombre_Equipo", "Descripcion_Equipo", "Ubicacion_Equipo", "Logo_Equipo"});
        try {
         
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select UUID_Equipo, Nombre_Equipo, Descripcion_Equipo, Ubicacion_Equipo, Logo_Equipo FROM tbEquipos");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloEquipo.addRow(new Object[]{rs.getString("UUID_Equipo"), 
                    rs.getString("Nombre_Equipo"), 
                    rs.getString("Descripcion_Equipo"), 
                    rs.getString("Ubicacion_Equipo"), 
                    rs.getString("Logo_Equipo")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloEquipo);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void EliminarEquipo(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbEquipos where UUID_Equipo = ?";
            PreparedStatement deleteEquipo = conexion.prepareStatement(sql);
            deleteEquipo.setString(1, miId);
            deleteEquipo.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void ActualizarEquipo(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbEquipos set Nombre_Equipo = ?, Descripcion_Equipo = ?, Ubicacion_Equipo = ?, Logo_Equipo = ? where UUID_Equipo = ?";
                PreparedStatement updateNoticia = conexion.prepareStatement(sql);

                updateNoticia.setString(1, getNombre());
                updateNoticia.setString(2, getDescripcion());
                updateNoticia.setString(3, getUbicacion());
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
        modelo.setColumnIdentifiers(new Object[]{"UUID_Equipo", "Nombre_Equipo", "Descripcion_Equipo", "Ubicacion_Equipo", "Logo_Equipo"});
        try {
            String sql = "SELECT * FROM tbEquipo WHERE Nombre_Equipo LIKE ? || '%'";
            PreparedStatement searchNoticia = conexion.prepareStatement(sql);
            searchNoticia.setString(1, miTextField.getText());
            ResultSet rs = searchNoticia.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Equipo"), rs.getString("Nombre_Equipo"), rs.getString("Descripcion_Noticia"), rs.getString("Ubicacion_Equipo"), rs.getString("Logo_Equipo")});
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
    
    
    public void limpiar(frmEquipos vistaEquipos) {
        vistaEquipos.txtNombre.setText("");
        vistaEquipos.txtDescripcion.setText("");
        vistaEquipos.txtUbicacion.setText("");
        vistaEquipos.txtLogo.setText("");
    }

    public void cargarDatosTabla(frmEquipos vistaEquipos) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vistaEquipos.jtbEquipos.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vistaEquipos.jtbEquipos.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vistaEquipos.jtbEquipos.getValueAt(filaSeleccionada, 1).toString();
            String DescripcionDeTb = vistaEquipos.jtbEquipos.getValueAt(filaSeleccionada, 2).toString();
            String UbicacionDeTB = vistaEquipos.jtbEquipos.getValueAt(filaSeleccionada, 3).toString();
            String LogoDeTB = vistaEquipos.jtbEquipos.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vistaEquipos.txtNombre.setText(NombreDeTB);
            vistaEquipos.txtDescripcion.setText(DescripcionDeTb);
            vistaEquipos.txtUbicacion.setText(UbicacionDeTB);
            vistaEquipos.txtLogo.setText(LogoDeTB);
        }
    }
    
}
