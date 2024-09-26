/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Arbitros2;
import modelo.Equipos;
import vista.frmArbitros2;
import vista.frmEquipos;

/**
 *
 * @author marvi
 */
public class ctrlEquipos implements MouseListener{
    
    //////////////////////////2- Parametros
    private Equipos modeloEquipos;
    private frmEquipos vistaEquipos;
    
    public ctrlEquipos(Equipos modeloEquipos, frmEquipos vistaEquipos) {
        
        //////////////////////////2- Parametros
        this.modeloEquipos = modeloEquipos;
        this.vistaEquipos = vistaEquipos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmArbitros2.btnGuardar.addMouseListener(this);
        frmArbitros2.btnActualizar.addMouseListener(this);
        frmArbitros2.btnEliminar.addMouseListener(this);
        frmArbitros2.btnLimpiar.addMouseListener(this);
        frmArbitros2.btnRegresar.addMouseListener(this);
        frmArbitros2.txtBuscar.addMouseListener(this);
        frmArbitros2.jtbArbitros.addMouseListener(this);
        modeloEquipos.MostrarEquipo(frmEquipos.jtbEquipos);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistaEquipos.btnGuardar) {
            if (vistaEquipos.txtNombre.getText().isEmpty() || vistaEquipos.txtDescripcion.getText().isEmpty() || vistaEquipos.txtUbicacion.getText().isEmpty() || vistaEquipos.txtLogo.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vistaEquipos, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloEquipos.setNombre(vistaEquipos.txtNombre.getText());
                    modeloEquipos.setDescripcion(vistaEquipos.txtDescripcion.getText());
                    modeloEquipos.setUbicacion(vistaEquipos.txtUbicacion.getText());
                    modeloEquipos.setLogo(vistaEquipos.txtLogo.getText());
                    //Ejecutar el metodo 
                    modeloEquipos.GuardarEquipo();
                    modeloEquipos.MostrarEquipo(vistaEquipos.jtbEquipos);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        if (e.getSource() == vistaEquipos.btnEliminar) {
            if (vistaEquipos.txtNombre.getText().isEmpty() || vistaEquipos.txtDescripcion.getText().isEmpty() || vistaEquipos.txtUbicacion.getText().isEmpty() || vistaEquipos.txtLogo.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaEquipos, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                modeloEquipos.EliminarEquipo(vistaEquipos.jtbEquipos);
                modeloEquipos.MostrarEquipo(vistaEquipos.jtbEquipos);
               // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                    }
                }
            }
        
        
        if (e.getSource() == vistaEquipos.btnActualizar) {
            if (vistaEquipos.txtNombre.getText().isEmpty() || vistaEquipos.txtDescripcion.getText().isEmpty() || vistaEquipos.txtUbicacion.getText().isEmpty() || vistaEquipos.txtLogo.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaEquipos, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloEquipos.setNombre(vistaEquipos.txtNombre.getText());
                    modeloEquipos.setDescripcion(vistaEquipos.txtDescripcion.getText());
                    modeloEquipos.setUbicacion(vistaEquipos.txtUbicacion.getText());
                    modeloEquipos.setLogo(vistaEquipos.txtLogo.getText());

                    //Ejecutar el método    
                    modeloEquipos.ActualizarEquipo(vistaEquipos.jtbEquipos);
                    modeloEquipos.MostrarEquipo(vistaEquipos.jtbEquipos);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vistaEquipos, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vistaEquipos.btnLimpiar) {
          modeloEquipos.limpiar(vistaEquipos);
        }
        
        if (e.getSource() == vistaEquipos.jtbEquipos) {
            modeloEquipos.cargarDatosTabla(vistaEquipos);
        }
        
        if (e.getSource() == vistaEquipos.btnRegresar) {
            
            vistaEquipos.dispose();
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
