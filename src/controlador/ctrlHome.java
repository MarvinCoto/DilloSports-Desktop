/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Noticias;
import vista.frmAjustes;
import vista.frmAjustes;
import vista.frmHome;
import vista.frmInicio;
import vista.frmInicio;
import vista.frmNoticias;
import vista.frmReportes;
import vista.frmReportes;
import vista.frmAuditoria;
import vista.frmAuditoria;
import vista.frmBienvenida;
import vista.frmRegistroAdminTorneo;
import vista.frmTorneos;
import vista.frmTorneos;

/**
 *
 * @author marvin
 */

//////////////////////////1- Implementar herencia: ActionListener
public class ctrlHome implements MouseListener {
    
    //////////////////////////2- Parametros
    private frmHome vistaHome;
    private frmInicio panelInicio;
    private frmReportes panelPartidos;
    private frmNoticias panelNoticias;
    private frmTorneos panelTorneos;
    private frmAuditoria panelPerfil;
    private frmAjustes panelAjustes;
    
    
    
    public ctrlHome(frmHome vistaHome, frmInicio panelInicio, frmReportes panelPartidos, frmNoticias panelNoticias, frmTorneos panelTorneos, frmAuditoria panelPerfil, frmAjustes panelAjustes) {
        
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
        vistaHome.JlTitulo.addMouseListener(this);

    }
    
    //Establezco colores por defecto para el menú de navegación
    Color DefaultColor = new Color(0,0,0);
    Color ClickedColor = new Color(51,51,51);
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        if(e.getSource() == vistaHome.jpInicio) {
        frmInicio objInicio = new frmInicio();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objInicio);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
        }
        
        if(e.getSource() == vistaHome.jpPartidos) {
        frmReportes objPartidos = new frmReportes();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objPartidos);
            
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
        
        if(e.getSource() == vistaHome.jpTorneos) {
        frmTorneos objTorneos = new frmTorneos();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objTorneos);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
        }
        
        if(e.getSource() == vistaHome.jpPerfil) {
        frmAuditoria objPerfil = new frmAuditoria();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objPerfil);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
        }
        
        if(e.getSource() == vistaHome.jpAjustes) {
        frmAjustes objAjustes = new frmAjustes();
            
            vistaHome.jpContenedor.removeAll();
            vistaHome.jpContenedor.add(objAjustes);
            
            vistaHome.jpContenedor.revalidate();
            vistaHome.jpContenedor.repaint();
        }
        
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
        if(e.getSource() == vistaHome.jpInicio) {
            
        vistaHome.jpInicio.setBackground(ClickedColor);
        vistaHome.jpPartidos.setBackground(DefaultColor);
        vistaHome.jpNoticias.setBackground(DefaultColor);
        vistaHome.jpTorneos.setBackground(DefaultColor);
        vistaHome.jpPerfil.setBackground(DefaultColor);
        
        vistaHome.JlTitulo.setText("Inicio");
        
        }
        
        if(e.getSource() == vistaHome.jpPartidos) {
            
        vistaHome.jpInicio.setBackground(DefaultColor);
        vistaHome.jpPartidos.setBackground(ClickedColor);
        vistaHome.jpNoticias.setBackground(DefaultColor);
        vistaHome.jpTorneos.setBackground(DefaultColor);
        vistaHome.jpPerfil.setBackground(DefaultColor);
        
        vistaHome.JlTitulo.setText("Partidos");
        
        }
        
        if(e.getSource() == vistaHome.jlbNoticias) {
            
        vistaHome.jpInicio.setBackground(DefaultColor);
        vistaHome.jpPartidos.setBackground(DefaultColor);
        vistaHome.jpNoticias.setBackground(ClickedColor);
        vistaHome.jpTorneos.setBackground(DefaultColor);
        vistaHome.jpPerfil.setBackground(DefaultColor);
        
        vistaHome.JlTitulo.setText("Noticias");
        
        }
        
        if(e.getSource() == vistaHome.jpTorneos) {
            
        vistaHome.jpInicio.setBackground(DefaultColor);
        vistaHome.jpPartidos.setBackground(DefaultColor);
        vistaHome.jpNoticias.setBackground(DefaultColor);
        vistaHome.jpTorneos.setBackground(ClickedColor);
        vistaHome.jpPerfil.setBackground(DefaultColor);
        
        vistaHome.JlTitulo.setText("Torneos");
        
        }
        
        if(e.getSource() == vistaHome.jpPerfil) {
            
        vistaHome.jpInicio.setBackground(DefaultColor);
        vistaHome.jpPartidos.setBackground(DefaultColor);
        vistaHome.jpNoticias.setBackground(DefaultColor);
        vistaHome.jpTorneos.setBackground(DefaultColor);
        vistaHome.jpPerfil.setBackground(ClickedColor);
        
        vistaHome.JlTitulo.setText("Perfil");
        
        }
        
        if(e.getSource() == vistaHome.jpAjustes) {
            
        new frmBienvenida().setVisible(true);
        
        frmBienvenida bienvenida = new frmBienvenida();
        
        bienvenida.setVisible(true);
        
        vistaHome.dispose();
        
        
        }
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
