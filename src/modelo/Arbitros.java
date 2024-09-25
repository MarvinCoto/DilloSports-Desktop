/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.frmArbitros;



/**
 *
 * @author Estudiante
 */
public class Arbitros {
    //PARAMETROS 
    private String UUID_Arbitro;
    private String Nombre_Arbitro;
    private String Apellido_Arbitro;
    private String Edad_Arbitro;
    private String Telefono_Arbitro;

    public String getUUID_Arbitro() {
        return UUID_Arbitro;
    }

    public void setUUID_Arbitro(String UUID_Arbitro) {
        this.UUID_Arbitro = UUID_Arbitro;
    }

    public String getNombre_Arbitro() {
        return Nombre_Arbitro;
    }

    public void setNombre_Arbitro(String Nombre_Arbitro) {
        this.Nombre_Arbitro = Nombre_Arbitro;
    }

    public String getApellido_Arbitro() {
        return Apellido_Arbitro;
    }

    public void setApellido_Arbitro(String Apellido_Arbitro) {
        this.Apellido_Arbitro = Apellido_Arbitro;
    }

    public String getEdad_Arbitro() {
        return Edad_Arbitro;
    }

    public void setEdad_Arbitro(String Edad_Arbitro) {
        this.Edad_Arbitro = Edad_Arbitro;
    }

    public String getTelefono_Arbitro() {
        return Telefono_Arbitro;
    }

    public void setTelefono_Arbitro(String Telefono_Arbitro) {
        this.Telefono_Arbitro = Telefono_Arbitro;
    }
    
    public void GuardarArbitro(){
        Connection conexion = ClaseConexion.getConexion();
        try {
            PreparedStatement addArbitro = conexion.prepareStatement("INSERT INTO tbArbitros(UUID_Arbitro, Nombre_Arbitro, Apellido_Arbitro, Edad_Arbitro, Telefono_Arbitro) VALUES (?, ?, ?, ?, ?)");
            addArbitro.setString(1, UUID_Arbitro.randomUUID().toString());
            addArbitro.setString(2, getNombre_Arbitro());
            addArbitro.setString(3, getApellido_Arbitro());
            addArbitro.setString(4, getEdad_Arbitro());
            addArbitro.setString(5, getTelefono_Arbitro());
            
            addArbitro.executeUpdate();
        } catch (SQLException e) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
    public void MostrarArbitro(JTable table) {
        Connection conexion = ClaseConexion.getConexion();
        
        DefaultTableModel modeloArbitros = new DefaultTableModel();
        modeloArbitros.setColumnIdentifiers(new Object[]{"UUID_Arbitro, Nombre_Arbitro, Apellido_Arbitro, Edad_Arbitro, Telefono_Arbitro"});
        try {
            Statement statemnet = conexion.createStatement();
            ResultSet rs = statemnet.executeQuery("select UUID_Arbitro, Nombre_Arbitro, Apellido_Arbitro, Edad_Arbitro, Telefono_Arbitro");
            
            while (rs.next()) {
                modeloArbitros.addRow(new Object[]{rs.getString("UUID_Arbitro"),
                rs.getString("Nombre_Arbitro"),
                rs.getString("Apellido_Arbitro"),
                rs.getString("Edad_Arbitro"),
                rs.getString("Telefono_Arbitro")});
               
            }
            
            table.setModel(modeloArbitros);
            
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
        
        public void ActualizarArbitro (JTable table){
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = table.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = table.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbNoticias set Titulo_Noticia = ?, Descripcion_Noticia = ?, Fecha_Noticia = ?, Imagen_Noticia = ? where UUID_Noticia = ?";
                PreparedStatement updateNoticia = conexion.prepareStatement(sql);

                updateNoticia.setString(1, getNombre_Arbitro());
                updateNoticia.setString(2, getApellido_Arbitro());
                updateNoticia.setString(3, getEdad_Arbitro());
                updateNoticia.setString(4, getTelefono_Arbitro());
                updateNoticia.setString(5, miUUId);
                updateNoticia.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
        
        public void Buscar(JTable tabla, JTextField miTextField) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_Noticia", "Titulo_Noticia", "Descripcion_Noticia", "Fecha_Noticia", "Imagen_Noticia"});
        try {
            String sql = "SELECT * FROM tbNoticias WHERE Titulo_Noticia LIKE ? || '%'";
            PreparedStatement searchNoticia = conexion.prepareStatement(sql);
            searchNoticia.setString(1, miTextField.getText());
            ResultSet rs = searchNoticia.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Noticia"), rs.getString("Titulo_Noticia"), rs.getString("Descripcion_Noticia"), rs.getString("Fecha_Noticia"), rs.getString("Imagen_Noticia")});
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
        public void LimpiarArbitro (frmArbitros vistaArbitros){
            vistaArbitros.txtNombreArbitro.setText("");
            vistaArbitros.txtApellidoArbitro.setText("");
            vistaArbitros.txtEdadArbitro.setText("");
            vistaArbitros.telefonoArbitro.setText("");
        }
        
        public void CargarArbitros (frmArbitros vistaArbitros){
            int filaSeleccionada = vistaArbitros.jtbArbitro.getSelectedRow();
            
            if (filaSeleccionada != -1){
                String UUIDtb = vistaArbitros.jtbArbitro.getValueAt(filaSeleccionada, 0).toString();
                String Nombre_Arbitro = vistaArbitros.jtbArbitro.getValueAt(filaSeleccionada, 1).toString();
                String Apellido_Arbitro = vistaArbitros.jtbArbitro.getValueAt(filaSeleccionada, 2).toString();
                String Edad_Arbitro = vistaArbitros.jtbArbitro.getValueAt(filaSeleccionada, 3).toString();
                String Telefono_Arbitro = vistaArbitros.jtbArbitro.getValueAt(filaSeleccionada, 4).toString();
                
                
            }
        }
        
        
            
        
    }


   
     
     
     
     
    

