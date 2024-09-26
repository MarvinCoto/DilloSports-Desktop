/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.tbUsuario;
import vista.frmContrasenaNueva;

/**
 *
 * @author FerOrtiz08
 */
public class ctrlContrasenaNueva implements MouseListener, KeyListener{
    
    private tbUsuario ModelotbusNuevaContra;
    private frmContrasenaNueva VisContrasenaNueva;
    
    public ctrlContrasenaNueva(tbUsuario ModetbContrasenanueva, frmContrasenaNueva VisContrasenaNueva){
        this.ModelotbusNuevaContra = ModetbContrasenanueva;
        this.VisContrasenaNueva =  VisContrasenaNueva;
        
        VisContrasenaNueva.txtNuevaContrasena.addMouseListener(this);
        VisContrasenaNueva.txtConfirmarContrasena.addMouseListener(this);
        VisContrasenaNueva.btnGuardarContrasena.addMouseListener(this);
        VisContrasenaNueva.btnVolverAlLogin.addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == VisContrasenaNueva.btnVolverAlLogin){
            if (ModelotbusNuevaContra.convertirSHA256(VisContrasenaNueva.txtNuevaContrasena.getText()).length() < 8){
                
                JOptionPane.showMessageDialog(VisContrasenaNueva, "La contraseña debe de tener mas de 8 caracteres");
                return;
                
            }
            
            if(ModelotbusNuevaContra.convertirSHA256(VisContrasenaNueva.txtNuevaContrasena.getText()).length() < 8){
                JOptionPane.showMessageDialog(VisContrasenaNueva, "La contraseña debe de tener mas de 8 caracteres");
                return;
            }
        }
        
        vista.frmLogin.initFrmLogin();
        VisContrasenaNueva.dispose();
                
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
 