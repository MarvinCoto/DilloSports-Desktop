/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.frmAjustes;
import vista.frmHome;
import vista.frmInicio;

/**
 *
 * @author marvi
 */
public class ctrlAjustes implements MouseListener {
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmAjustes panelAjustes;
    
    public ctrlAjustes(frmHome vistaHome, frmAjustes panelAjustes) {
        
        
        this.vistaHome = vistaHome;
        this.panelAjustes = panelAjustes;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmAjustes.btnPrueba.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelAjustes.btnPrueba){
            JOptionPane.showMessageDialog(panelAjustes, "Hola");
    
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
