/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.frmHome;
import vista.frmInicio;
import vista.frmPartidos;

/**
 *
 * @author marvi
 */
public class ctrlPartidos implements MouseListener{
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmPartidos panelPartidos;
    
    public ctrlPartidos(frmHome vistaHome, frmPartidos panelPartidos) {
        
        
        this.vistaHome = vistaHome;
        this.panelPartidos = panelPartidos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmPartidos.btnPrueba.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelPartidos.btnPrueba){
            JOptionPane.showMessageDialog(panelPartidos, "Hola");
    
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
