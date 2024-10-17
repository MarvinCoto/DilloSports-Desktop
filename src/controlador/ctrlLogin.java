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
import vista.frmHomeAdminTorneo;
import vista.frmHomeArbitro;
import vista.frmIngresoCorreo;
import vista.frmLogin;
import vista.frmRegistroAdminTorneo;
import vista.frmRegistroArbitros;

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
        vista.btnIrARegistroArbitro.addMouseListener(this);
        vista.btnRecuperar.addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.btnIniciarSesion) {
            
            modelo.setCorreo_Usuario(vista.txtCorreo.getText());
            modelo.setContrasena_Usuario(modelo.convertirSHA256(vista.txtContraseña.getText()));

            boolean comprobar = modelo.iniciarSesion();

    if (comprobar) {
        int rolUsuario = modelo.getRol_Usuario();  // Obtener el rol como int

        if (rolUsuario == 1) { // Asumiendo que 1 es el ID del rol de Administrador
            
            JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso, ¡Bienvenido Administrador!");
            frmHomeAdminTorneo frmAdminTorneo = new frmHomeAdminTorneo();
            frmAdminTorneo.setVisible(true);
            
        } else if (rolUsuario == 2) { // Asumiendo que 2 es el ID del rol de Editor
            
            JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso, ¡Bienvenido Editor!");
            frmHomeArbitro frmHomeArbitro = new frmHomeArbitro();
            frmHomeArbitro.setVisible(true);
            
        } else if (rolUsuario == 3) { // Asumiendo que 3 es el ID del rol de Usuario
            
            JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso, ¡Bienvenido Usuario!");
            frmHome.initHome();
            
        } else {
            JOptionPane.showMessageDialog(vista, "Rol de usuario no reconocido.");
        }

        vista.dispose();

    } else {
        JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
    }
}
        
        
        if (e.getSource() == vista.btnIrARegistro) {
            
            frmRegistroAdminTorneo.initregistro();
        
            vista.dispose();
        
        }
        
        if (e.getSource() == vista.btnIrARegistroArbitro) {
            
            frmRegistroArbitros.initregistroArbitros();
        
            vista.dispose();
        
        }
        
        if (e.getSource() == vista.btnRecuperar) {
            
            frmIngresoCorreo.initFrmIngresoCorreo();
        
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
