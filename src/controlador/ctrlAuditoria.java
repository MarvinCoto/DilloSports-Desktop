/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Auditoria;
import modelo.Noticias;
import vista.frmHome;
import vista.frmReportes;
import vista.frmAuditoria;
import vista.frmNoticias;

/**
 *
 * @author marvi
 */
public class ctrlAuditoria implements MouseListener{
    
    //////////////////////////2- Parametros
    private Auditoria modeloAuditoria;
    private frmHome vistaHome;
    private frmAuditoria panelAuditoria;
    
    public ctrlAuditoria(Auditoria modeloAuditoria, frmHome vistaHome, frmAuditoria panelAuditoria) {
        
        
        this.vistaHome = vistaHome;
        this.panelAuditoria = panelAuditoria;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmAuditoria.btnPrueba.addMouseListener(this);
        frmAuditoria.jtbAuditoria.addMouseListener(this);
        modeloAuditoria.MostrarAuditoria(frmAuditoria.jtbAuditoria);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        if(e.getSource() == panelAuditoria.btnPrueba){
            JOptionPane.showMessageDialog(panelAuditoria, "Hola");
    
        }
        
        if (e.getSource() == panelAuditoria.jtbAuditoria) {
            modeloAuditoria.cargarDatosTabla(panelAuditoria);
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
