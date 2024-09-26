/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.frmHome;
import vista.frmPartidos;
import vista.frmPerfil;

/**
 *
 * @author marvi
 */
public class ctrlPerfil implements MouseListener{
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmPerfil panelPerfil;
    
    public ctrlPerfil(frmHome vistaHome, frmPerfil panelPerfil) {
        
        
        this.vistaHome = vistaHome;
        this.panelPerfil = panelPerfil;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmPerfil.btnPrueba.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelPerfil.btnPrueba){
            JOptionPane.showMessageDialog(panelPerfil, "Hola");
    
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
