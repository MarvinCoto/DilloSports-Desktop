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
import vista.frmReportes;

/**
 *
 * @author marvi
 */
public class ctrlReportesMenu implements MouseListener{
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmReportes panelPartidos;
    
    public ctrlReportesMenu(frmHome vistaHome, frmReportes panelPartidos) {
        
        
        this.vistaHome = vistaHome;
        this.panelPartidos = panelPartidos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmReportes.btnPartidos.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelPartidos.btnPartidos){
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
