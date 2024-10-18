/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import modelo.ClaseConexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.frmHome;
import vista.frmInicio;
import static vista.frmPruebaReporte.txtIdTorneo;
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
        frmReportes.btnNoticias.addMouseListener(this);
        frmReportes.btnTorneos.addMouseListener(this);
        frmReportes.btnEquipos.addMouseListener(this);
        frmReportes.btnArbitros.addMouseListener(this);
        frmReportes.btnJugadores.addMouseListener(this);
        frmReportes.btnPartidos.addMouseListener(this);
        frmReportes.txtIdTorneo.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelPartidos.btnNoticias){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteNoticias.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Noticias");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
        }
        
        if(e.getSource() == panelPartidos.btnTorneos){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteTorneos.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Torneos");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
        }
        
        if(e.getSource() == panelPartidos.btnEquipos){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteEquipos.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Equipos");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
        }
        
        if(e.getSource() == panelPartidos.btnArbitros){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteArbitros.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Arbitros");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
        }
        
        if(e.getSource() == panelPartidos.btnJugadores){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteJugadores.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Jugadores");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    
        }
        
        if(e.getSource() == panelPartidos.btnPartidos){
            
            try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", frmReportes.txtIdTorneo.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReportePartidos.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Detalles de Partidos");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
    
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
