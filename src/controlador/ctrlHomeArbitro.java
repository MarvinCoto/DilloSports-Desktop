/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.frmBienvenida;
import vista.frmHomeAdminTorneo;
import vista.frmHomeArbitro;
import vista.frmReporteArbitro;
import vista.frmReporteEquipo;
import vista.frmReporteJugador;
import vista.frmReportePartido;

/**
 *
 * @author marvi
 */
public class ctrlHomeArbitro implements MouseListener{
    
    //////////////////////////2- Parametros
    private frmHomeArbitro vista;

    
    public ctrlHomeArbitro(frmHomeArbitro vista) {
        
        //////////////////////////2- Parametros

        this.vista = vista;
        
        //Siempre hay que poner los botones que vamos a utilizar
        vista.btnHistorial.addMouseListener(this);
        vista.btnReporte.addMouseListener(this);
        vista.btnCerrarSesion.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.btnHistorial) {
            
            frmReporteArbitro.initFrmReportesAdmin();
        
            
        
        }
        
        //if (e.getSource() == vista.btnArbitros) {
            
            //frmReporteArbitro.initFrmReportesAdmin();
        
            
        
        //}
        
        
        
        if (e.getSource() == vista.btnCerrarSesion) {
            
            new frmBienvenida().setVisible(true);
        
        frmBienvenida bienvenida = new frmBienvenida();
        
        bienvenida.setVisible(true);
        
        vista.dispose();
        
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
