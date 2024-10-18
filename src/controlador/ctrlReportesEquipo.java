/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import modelo.ClaseConexion;
import modelo.Torneos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.frmPruebaReporte;
import static vista.frmPruebaReporte.txtIdTorneo;
import vista.frmReporteArbitro;
import vista.frmReporteEquipo;

/**
 *
 * @author marvi
 */
public class ctrlReportesEquipo implements MouseListener, KeyListener {
    
    //////////////////////////2- Parametros
    private frmReporteEquipo vistaEquipo;

    
    public ctrlReportesEquipo(frmReporteEquipo vistaEquipo) {
        
        //////////////////////////2- Parametros

        this.vistaEquipo = vistaEquipo;
        
        //Siempre hay que poner los botones que vamos a utilizar
        vistaEquipo.txtParametro.addMouseListener(this);
        vistaEquipo.btnGenerarReporte.addMouseListener(this);
        vistaEquipo.btnRegresar.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistaEquipo.btnGenerarReporte) {
          
            if(vistaEquipo.txtParametro.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Debes colocar el identificador para generar el reporte");
                
            } else {
                
                try {
                  //Crear un objeto Map para almacenar los parámetros
            Map<String, Object> parametros = new HashMap<>();
            //Agregador el parametro con el valor deseado
            parametros.put("idTorneo", vistaEquipo.txtParametro.getText());
                
             JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteEquiposTorneo.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ClaseConexion.getConexion());
        
        JasperViewer view = new JasperViewer (jprint, false);
        view.setTitle("Arbitros");
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        
        
            
            } catch (JRException ex) {
                Logger.getLogger(ctrlReportes.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            }
         
          
        }
        
        if (e.getSource() == vistaEquipo.btnRegresar) {
            
            vistaEquipo.dispose();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
}
