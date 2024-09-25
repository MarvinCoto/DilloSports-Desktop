/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Noticias;
import vista.frmAjustes;
import vista.frmHome;
import vista.frmInicio;
import vista.frmInicio2;
import vista.frmNoticias;
import vista.frmPartidos;
import vista.frmPerfil;
import vista.frmTorneos;

/**
 *
 * @author marvin
 */

//////////////////////////1- Implementar herencia: ActionListener
public class ctrlHome implements MouseListener {
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmInicio2 panelInicio;
    private frmPartidos panelPartidos;
    private frmNoticias panelNoticias;
    private frmTorneos panelTorneos;
    private frmPerfil panelPerfil;
    private frmAjustes panelAjustes;
    
    
    
    public ctrlHome(frmHome vistaHome, frmNoticias panelNoticias, frmInicio2 panelInicio) {
        
        this.vistaHome = vistaHome;
        
        
        //Siempre hay que poner los botones que vamos a utilizar
        vistaHome.jlbNoticias.addMouseListener(this);
        vistaHome.jpInicio.addMouseListener(this);
        vistaHome.jpPartidos.addMouseListener(this);
        vistaHome.jpNoticias.addMouseListener(this);
        vistaHome.jpTorneos.addMouseListener(this);
        vistaHome.jpPerfil.addMouseListener(this);
        vistaHome.jpAjustes.addMouseListener(this);
        vistaHome.jpContenedor.addMouseListener(this);

    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        if(e.getSource() == vistaHome.jpInicio) {
        frmInicio2 objInicio = new frmInicio2();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objInicio);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
        }
        
        if(e.getSource() == vistaHome.jlbNoticias) {
        frmNoticias objNoticias = new frmNoticias();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objNoticias);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
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
