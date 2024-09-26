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
import vista.frmCodigoRecu;

/**
 *
 * @author FerOrtiz08
 */
public class ctrlCodigoRecuperacion implements MouseListener, KeyListener {
    
    private tbUsuario ModeloUS;
    private frmCodigoRecu VisCodigoRecu;
    
    public ctrlCodigoRecuperacion(tbUsuario tbusuarios, frmCodigoRecu VisCodigoRecu){
        
        this.ModeloUS = tbusuarios;
        this.VisCodigoRecu = VisCodigoRecu;
        
        VisCodigoRecu.txtCodigoVerificacion.addMouseListener(this);
        VisCodigoRecu.btnIngresar.addMouseListener(this);
        VisCodigoRecu.btnRegresar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == VisCodigoRecu.btnRegresar) {
            JOptionPane.showMessageDialog(VisCodigoRecu, "Ingrese el codigo que se le a enviado");
            return;
        } 
        
        vista.frmRecuperacionContrasena.initfrmRecucontra();
        VisCodigoRecu.dispose();
        
        if (e.getSource() == VisCodigoRecu.btnIngresar){
            
            vista.frmContrasenaNueva.initfrmContraNueva();
            VisCodigoRecu.dispose();
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
