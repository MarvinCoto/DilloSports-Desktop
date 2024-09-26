/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Torneos;
import vista.frmArbitros2;
import vista.frmEquipos;
import vista.frmHome;
import vista.frmInicio;
import vista.frmNoticias;
import vista.frmTorneos;
import vista.registro;

/**
 *
 * @author marvi
 */
public class ctrlTorneos implements MouseListener{
    
    //////////////////////////2- Parametros
    private Torneos modeloTorneos;
    private frmHome vistaHome;
    private frmTorneos panelTorneos;
    
    public ctrlTorneos(Torneos modeloTorneos, frmHome vistaHome, frmTorneos panelTorneos) {
        
        //////////////////////////2- Parametros
        this.modeloTorneos = modeloTorneos;
        this.vistaHome = vistaHome;
        this.panelTorneos = panelTorneos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmTorneos.btnGuardar.addMouseListener(this);
        frmTorneos.btnActualizar.addMouseListener(this);
        frmTorneos.btnEliminar.addMouseListener(this);
        frmTorneos.btnLimpiar.addMouseListener(this);
        frmTorneos.btnRegistrarEquipos.addMouseListener(this);
        frmTorneos.btnRegistrarArbitros.addMouseListener(this);
        frmTorneos.txtBuscar.addMouseListener(this);
        frmTorneos.jtbTorneos.addMouseListener(this);
        vistaHome.jlbNoticias.addMouseListener(this);
        modeloTorneos.MostrarTorneo(frmTorneos.jtbTorneos);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        //////////////////////////4- Detección de clicks en la vista
        
        
        
        if (e.getSource() == panelTorneos.btnGuardar) {
            if (panelTorneos.txtNombreTorneo.getText().isEmpty() || panelTorneos.txtUbicacionTorneo.getText().isEmpty() || panelTorneos.txtDescripcionTorneo.getText().isEmpty() || panelTorneos.txtLogoTorneo.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(panelTorneos, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloTorneos.setNombre(panelTorneos.txtNombreTorneo.getText());
                    modeloTorneos.setUbicacion(panelTorneos.txtUbicacionTorneo.getText());
                    modeloTorneos.setDescripcion(panelTorneos.txtDescripcionTorneo.getText());
                    modeloTorneos.setLogo(panelTorneos.txtLogoTorneo.getText());
                    //Ejecutar el metodo 
                    modeloTorneos.GuardarTorneo();
                    modeloTorneos.MostrarTorneo(panelTorneos.jtbTorneos);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        if (e.getSource() == panelTorneos.btnEliminar) {
            if (panelTorneos.txtNombreTorneo.getText().isEmpty() || panelTorneos.txtUbicacionTorneo.getText().isEmpty() || panelTorneos.txtDescripcionTorneo.getText().isEmpty() || panelTorneos.txtLogoTorneo.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(panelTorneos, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                modeloTorneos.EliminarTorneo(panelTorneos.jtbTorneos);
                modeloTorneos.MostrarTorneo(panelTorneos.jtbTorneos);
               // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                    }
                }
            }
        
        
        if (e.getSource() == panelTorneos.btnActualizar) {
            if (panelTorneos.txtNombreTorneo.getText().isEmpty() || panelTorneos.txtUbicacionTorneo.getText().isEmpty() || panelTorneos.txtDescripcionTorneo.getText().isEmpty() || panelTorneos.txtLogoTorneo.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(panelTorneos, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloTorneos.setNombre(panelTorneos.txtNombreTorneo.getText());
                    modeloTorneos.setUbicacion(panelTorneos.txtUbicacionTorneo.getText());
                    modeloTorneos.setDescripcion(panelTorneos.txtDescripcionTorneo.getText());
                    modeloTorneos.setLogo(panelTorneos.txtLogoTorneo.getText());

                    //Ejecutar el método    
                    modeloTorneos.ActualizarTorneo(panelTorneos.jtbTorneos);
                    modeloTorneos.MostrarTorneo(panelTorneos.jtbTorneos);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelTorneos, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == panelTorneos.btnLimpiar) {
          modeloTorneos.limpiar(panelTorneos);
        }
        
        if (e.getSource() == panelTorneos.jtbTorneos) {
            modeloTorneos.cargarDatosTabla(panelTorneos);
        }
        
        if (e.getSource() == panelTorneos.btnRegistrarArbitros) {
          
        
            frmArbitros2.initArbitros();
        }
        
        if (e.getSource() == panelTorneos.btnRegistrarEquipos) {
          
        
            frmEquipos.initEquipos();
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
