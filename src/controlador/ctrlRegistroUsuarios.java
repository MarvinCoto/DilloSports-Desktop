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
import vista.registro;

/**
 *
 * @author Estudiante
 */
public class ctrlRegistroUsuarios implements MouseListener{
    tbUsuario modeloUsuario;
    registro vista;
    
    public ctrlRegistroUsuarios(tbUsuario modeloUsuario, registro vista){
        this.modeloUsuario = modeloUsuario;
        this.vista = vista;
        
        vista.btnRegistrar.addMouseListener(this);
        vista.btnIrALogin.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //2-Validar correos
            if(!vista.txtCorreoR.getText().contains("@") || !vista.txtCorreoR.getText().contains(".com")){
                JOptionPane.showMessageDialog(vista, "Ingrese un correo valido");
            }
            
            //3-Validar que la contraseña tenga mas de 6 caracteres
            if(vista.txtContrasena.getText().length() < 6){
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener mas de 6 caracteres");
            }
            
            
        
        
        if (e.getSource() == vista.btnRegistrar) {
            
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
            
            modeloUsuario.GuardarUsuario();
            
            JOptionPane.showMessageDialog(vista, "Usuario creado con Exito!");
            
    
            
            }
        }
        
        if (e.getSource() == vista.btnIrALogin) {
            
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
