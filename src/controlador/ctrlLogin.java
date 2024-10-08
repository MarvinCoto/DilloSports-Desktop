/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.tbUsuario;
import static oracle.sql.NUMBER.e;
import vista.frmHome;
import vista.frmLogin;
import vista.registro;

/**
 *
 * @author FerOrtiz08
 */
public class ctrlLogin implements MouseListener {
    
    tbUsuario modelo;
    frmLogin vista;
    
    public ctrlLogin(tbUsuario modelo, frmLogin vista ) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnIrARegistro.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.btnIniciarSesion) {
            
            modelo.setCorreo_Usuario(vista.txtCorreo.getText());
            modelo.setContrasena_Usuario(modelo.convertirSHA256(vista.txtContraseña.getText()));
            
            //Creo una variable llamada comprobar 
            //que guardará el resultado de ejecutar el método iniciarSesion()
            boolean comprobar = modelo.iniciarSesion();
            
            //Si la variable es true significa que si existe el usuario
            if (comprobar) {
                     JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso, ¡Bienvenido!");
                     
                     frmHome.initHome();
                     vista.dispose();
                     
            } else {
               JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        
        }
        
        if (e.getSource() == vista.btnIrARegistro) {
            
            registro.initregistro();
        
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
