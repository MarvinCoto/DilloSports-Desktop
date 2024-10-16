/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ClaseConexion;
import modelo.tbUsuario;
import vista.frmIngresoContrasena;
import vista.frmIngresoCorreo;
import java.sql.*;

/**
 *
 * @author marvi
 */
public class ctrlIngresoContrasena implements MouseListener {
    
    private tbUsuario modelo;
    private frmIngresoContrasena vista;
    
    
    public ctrlIngresoContrasena(tbUsuario modelo, frmIngresoContrasena vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnActualizarContrasena.addMouseListener(this);
        
        
    }
    
    
    private void actualizarContrasena() {
        String nuevaContrasena = vista.txtNuevaContrasena.getText();
        String confirmarContrasena = vista.txtConfirmarContrasena.getText();

        if (nuevaContrasena.equals(confirmarContrasena)) {
            // Llamar al método para actualizar la contraseña en la base de datos
            if (actualizarContrasenaEnBaseDeDatos(nuevaContrasena)) {
                JOptionPane.showMessageDialog(vista, "Contraseña actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.dispose();  // Cierra la ventana de actualización
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar la contraseña. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean actualizarContrasenaEnBaseDeDatos(String nuevaContrasena) {
    // Suponiendo que tu ClaseConexion tiene un método getConexion que retorna una conexión
    String consulta = "UPDATE tbUsuarios SET Contrasena_Usuario = ? WHERE Correo_Usuario = ?";
    
    try (Connection conexion = ClaseConexion.getConexion(); // Usa tu clase de conexión
         PreparedStatement stmt = conexion.prepareStatement(consulta)) {

        
        // Establecer los parámetros
        stmt.setString(1, modelo.convertirSHA256(nuevaContrasena)); // Nueva contraseña
        stmt.setString(2, ctrlIngresoCorreo.correoUsuario); // Correo del usuario

        // Ejecutar la actualización
        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0; // Retorna true si se actualizó al menos una fila

    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de errores
        return false; // Retorna false si hubo un error
    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnActualizarContrasena){
        
             actualizarContrasena();
             
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
