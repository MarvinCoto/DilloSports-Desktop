/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.ctrlIngresoCorreo.codigoRecuperacion;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.EnviarCorreo;
import modelo.tbUsuario;
import vista.frmIngresoCodigo;
import vista.frmIngresoContrasena;
import vista.frmIngresoCorreo;

/**
 *
 * @author marvi
 */
public class ctrlIngresoCodigo implements MouseListener{
    
    private tbUsuario modelo;
    private frmIngresoCodigo vista;
    public static String correoGlobal;
    
    public ctrlIngresoCodigo(tbUsuario modelo, frmIngresoCodigo vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnVerificarCodigo.addMouseListener(this);
        
        
    }

        public void verificarCodigo(int codigoIngresado) {
        // Compara el código ingresado con el código guardado en el primer controlador
        if (codigoIngresado == ctrlIngresoCorreo.codigoRecuperacion) {
            // Si el código es correcto, redirigir a la ventana de actualización de contraseña
            frmIngresoContrasena.initFrmIngresoContrasena();  // Abre la ventana para actualizar la contraseña
            vista.dispose();  // Cierra la ventana actual
        } else {
            // Código incorrecto, mostrar un mensaje de error
            JOptionPane.showMessageDialog(vista, "El código ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnVerificarCodigo){
        
             // Obtener el código ingresado por el usuario
                try {
                    int codigoIngresado = Integer.parseInt(vista.txtCodigo.getText());
                    verificarCodigo(codigoIngresado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Por favor, ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
