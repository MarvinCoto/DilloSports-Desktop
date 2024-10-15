/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.tbUsuario;
import vista.frmLogin;
import vista.frmRegistroAdminTorneo;
import vista.frmRegistroArbitros;

/**
 *
 * @author marvi
 */
public class ctrlRegistroArbitros implements MouseListener{
    
    tbUsuario modeloUsuario;
    frmRegistroArbitros vista;
    
    public ctrlRegistroArbitros(tbUsuario modeloUsuario, frmRegistroArbitros vista){
        this.modeloUsuario = modeloUsuario;
        this.vista = vista;
        
        vista.btnRegistrarArbitro.addMouseListener(this);
        vista.btnIrALoginArbitro.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.btnRegistrarArbitro) {
            
            if (vista.txtNombreR.getText().isEmpty() || vista.txtApellidoR.getText().isEmpty() || vista.txtUsernameR.getText().isEmpty()
                || vista.txtContrasena.getText().isEmpty() || vista.txtCorreoR.getText().isEmpty() || vista.txtGeneroReg.getText().isEmpty()
                || vista.txtFnacimientoR.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            modeloUsuario.setNombre_Usuario(vista.txtNombreR.getText());
            modeloUsuario.setApellido_Usuario(vista.txtApellidoR.getText());
            modeloUsuario.setUser_name(vista.txtUsernameR.getText());
            modeloUsuario.setContrasena_Usuario(modeloUsuario.convertirSHA256(vista.txtContrasena.getText()));
            modeloUsuario.setCorreo_Usuario(vista.txtCorreoR.getText());
            modeloUsuario.setGenero_Usuario(vista.txtGeneroReg.getText());
            modeloUsuario.setFNacimiento_Usuario(vista.txtFnacimientoR.getText());
            
            modeloUsuario.GuardarArbitro();
            
            JOptionPane.showMessageDialog(vista, "Usuario creado con Exito!");
            
    
            
            }
        }
        
        if (e.getSource() == vista.btnIrALoginArbitro) {
            
            frmLogin.initFrmLogin();
            
            vista.dispose();
        
        
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
