/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Noticias;
import vista.frmHome;
import vista.frmInicio;
import vista.frmNoticias;

/**
 *
 * @author marvi
 */
public class ctrlInicio implements MouseListener{
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmInicio panelInicio;
    
    public ctrlInicio(frmHome vistaHome, frmInicio panelInicio) {
        
        
        this.vistaHome = vistaHome;
        this.panelInicio = panelInicio;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmInicio.btnPrueba.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelInicio.btnPrueba){
            JOptionPane.showMessageDialog(panelInicio, "Hola");
    
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
