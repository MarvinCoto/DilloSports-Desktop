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
import vista.frmArbitros2;
import vista.frmTorneos;

/**
 *
 * @author marvi
 */
public class Arbitros2 {
    
    //Parametros
    private String UUID_Arbitro;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;

    public String getUUID_Arbitro() {
        return UUID_Arbitro;
    }

    public void setUUID_Arbitro(String UUID_Arbitro) {
        this.UUID_Arbitro = UUID_Arbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //3- Métodos (select, insert, update, delete)

    //Ingresar
    public void GuardarArbitro() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addArbitro = conexion.prepareStatement("INSERT INTO tbArbitros(UUID_Arbitro, Nombre_Arbitro, Apellido_Arbitro, Edad_Arbitro, Telefono_Arbitro) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addArbitro.setString(1, UUID.randomUUID().toString());
            addArbitro.setString(2, getNombre());
            addArbitro.setString(3, getApellido());
            addArbitro.setInt(4, getEdad());
            addArbitro.setString(5, getTelefono());
 
            //Ejecutar la consulta
            addArbitro.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void MostrarArbitro(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloArbitros = new DefaultTableModel();
        modeloArbitros.setColumnIdentifiers(new Object[]{"UUID_Arbitro", "Nombre_Arbitro", "Apellido_Arbitro", "Edad_Arbitro", "Telefono_Arbitro"});
        try {
         
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select UUID_Arbitro, Nombre_Arbitro, Apellido_Arbitro, Edad_Arbitro, Telefono_Arbitro FROM tbArbitros");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloArbitros.addRow(new Object[]{rs.getString("UUID_Arbitro"), 
                    rs.getString("Nombre_Arbitro"), 
                    rs.getString("Apellido_Arbitro"), 
                    rs.getString("Edad_Arbitro"), 
                    rs.getString("Telefono_Arbitro")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloArbitros);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void EliminarArbitro(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbArbitros where UUID_Arbitro = ?";
            PreparedStatement deleteArbitro = conexion.prepareStatement(sql);
            deleteArbitro.setString(1, miId);
            deleteArbitro.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void ActualizarArbitro(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbArbitros set Nombre_Arbitro = ?, Apellido_Arbitro = ?, Edad_Arbitro = ?, Telefono_Arbitro = ? where UUID_Arbitro = ?";
                PreparedStatement updateNoticia = conexion.prepareStatement(sql);

                updateNoticia.setString(1, getNombre());
                updateNoticia.setString(2, getApellido());
                updateNoticia.setInt(3, getEdad());
                updateNoticia.setString(4, getTelefono());
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
        modelo.setColumnIdentifiers(new Object[]{"UUID_Arbitro", "Nombre_Arbitro", "Apellido_Arbitro", "Edad_Arbitro", "Telefono_Arbitro"});
        try {
            String sql = "SELECT * FROM tbArbitros WHERE Nombre_Arbitro LIKE ? || '%'";
            PreparedStatement searchNoticia = conexion.prepareStatement(sql);
            searchNoticia.setString(1, miTextField.getText());
            ResultSet rs = searchNoticia.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Arbitro"), rs.getString("Nombre_Arbitro"), rs.getString("Apellido_Arbitro"), rs.getString("Edad_Arbitro"), rs.getString("Telefono_Arbitro")});
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
    
    
    public void limpiar(frmArbitros2 vistaArbitros) {
        vistaArbitros.txtNombre.setText("");
        vistaArbitros.txtApellido.setText("");
        vistaArbitros.txtEdad.setText("");
        vistaArbitros.txtTelefono.setText("");
    }

    public void cargarDatosTabla(frmArbitros2 vistaArbitros) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vistaArbitros.jtbArbitros.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vistaArbitros.jtbArbitros.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vistaArbitros.jtbArbitros.getValueAt(filaSeleccionada, 1).toString();
            String ApellidoDeTB = vistaArbitros.jtbArbitros.getValueAt(filaSeleccionada, 2).toString();
            String EdadDeTb = vistaArbitros.jtbArbitros.getValueAt(filaSeleccionada, 3).toString();
            String TelefonoDeTB = vistaArbitros.jtbArbitros.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vistaArbitros.txtNombre.setText(NombreDeTB);
            vistaArbitros.txtApellido.setText(ApellidoDeTB);
            vistaArbitros.txtEdad.setText(EdadDeTb);
            vistaArbitros.txtTelefono.setText(TelefonoDeTB);
        }
    }
    
}
