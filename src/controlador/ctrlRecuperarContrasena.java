/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import modelo.EnviarCorreos;
import modelo.tbUsuario;
import vista.frmRecuperacionContrasena;

/**
 *
 * @author FerOrtiz08
 */
public class ctrlRecuperarContrasena implements MouseListener, KeyListener {
    
    private tbUsuario modelotbUsuario;
    private frmRecuperacionContrasena vistaRecuContrasena; 
    
    public ctrlRecuperarContrasena(tbUsuario ModeUsRecuperarContrasena, frmRecuperacionContrasena VisRecuperarContrasena){
        this.modelotbUsuario = ModeUsRecuperarContrasena;
        this.vistaRecuContrasena = VisRecuperarContrasena;
        
        VisRecuperarContrasena.txtRecuperacion.addMouseListener(this);
        VisRecuperarContrasena.btnRestablecer.addMouseListener(this);
        VisRecuperarContrasena.btnRegresarLogin.addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vistaRecuContrasena.btnRestablecer){
            Random random = new Random();
            
            int numeroAleatorio = 1000 + random.nextInt(9000);
            
            String recipient = vistaRecuContrasena.txtRecuperacion.getText();
            String subject = "!Recuperacion de Contraseña DilloSports!";
            String content = "Recuerda guardar tu Contraseña"
                    + "para no olvidarla en un futuro."
                    +""
                    +"Tu codigo de Verificacion es: " + numeroAleatorio;
            
            EnviarCorreos.enviarCorreo(recipient, subject, content); 
            vista.frmCodigoRecu.initfrmCodigoveri();
            vistaRecuContrasena.dispose();
            return;
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
