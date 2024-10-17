/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.EnviarCorreo;
import modelo.tbUsuario;
import vista.frmIngresoCodigo;
import vista.frmIngresoCorreo;
import vista.frmRegistroAdminTorneo;

/**
 *
 * @author marvi
 */
public class ctrlIngresoCorreo implements MouseListener {
    
    private tbUsuario modelo;
    private frmIngresoCorreo vista;
    
    public static int codigoRecuperacion;
    public static String correoUsuario;
    
    public ctrlIngresoCorreo(tbUsuario modelo, frmIngresoCorreo vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnEnviarCodigo.addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnEnviarCodigo){
        
             Random random = new Random();
        
        // Genera un número aleatorio de 4 dígitos (1000 a 9999)
            int numeroAleatorio = 1000 + random.nextInt(9000);
            
            codigoRecuperacion = numeroAleatorio;
            correoUsuario = vista.txtCorreo.getText();

            if (vista.txtCorreo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "El campo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                String recipient = vista.txtCorreo.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el código de recuperación: " + numeroAleatorio;

            EnviarCorreo.enviarCorreo(recipient, subject, content);
            
            frmIngresoCodigo.initFrmIngresoCodigo();
        
            vista.dispose();
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
