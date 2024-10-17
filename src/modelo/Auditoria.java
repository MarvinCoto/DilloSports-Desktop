/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.frmAuditoria;
import vista.frmNoticias;

/**
 *
 * @author marvi
 */
public class Auditoria {
    
    //Parametros
    private String usuario;
    private String accion;
    private String tabla;
    private String fecha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void MostrarAuditoria(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloNoticias = new DefaultTableModel();
        modeloNoticias.setColumnIdentifiers(new Object[]{"Usuario", "Acción", "Nombre_Tabla", "Fecha_Hora"});
        try {
         
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select * from tbAuditoria");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloNoticias.addRow(new Object[]{rs.getString("Usuario"), 
                    rs.getString("Acción"), 
                    rs.getString("Nombre_Tabla"), 
                    rs.getString("Fecha_Hora")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloNoticias);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void cargarDatosTabla(frmAuditoria vistaAuditoria) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vistaAuditoria.jtbAuditoria.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String Usuario = vistaAuditoria.jtbAuditoria.getValueAt(filaSeleccionada, 0).toString();
            String Accion = vistaAuditoria.jtbAuditoria.getValueAt(filaSeleccionada, 1).toString();
            String Tabla = vistaAuditoria.jtbAuditoria.getValueAt(filaSeleccionada, 2).toString();
            String Fecha = vistaAuditoria.jtbAuditoria.getValueAt(filaSeleccionada, 3).toString();

            
            
        }
    }
    
}
