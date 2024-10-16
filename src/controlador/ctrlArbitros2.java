/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Arbitros;
import modelo.Torneos;
import vista.frmArbitros;
import vista.frmEquipos;

/**
 *
 * @author marvi
 */
public class ctrlArbitros2 implements MouseListener, KeyListener{
    
    //////////////////////////2- Parametros
    private Arbitros modeloArbitros;
    private Torneos modeloTorneos;
    private frmArbitros panelArbitros;
    
    public ctrlArbitros2(Arbitros modeloArbitros, Torneos modeloTorneos, frmArbitros panelTorneos) {
        
        //////////////////////////2- Parametros
        this.modeloArbitros = modeloArbitros;
        this.panelArbitros = panelTorneos;
        this.modeloTorneos = modeloTorneos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmArbitros.btnGuardar.addMouseListener(this);
        frmArbitros.btnActualizar.addMouseListener(this);
        frmArbitros.btnEliminar.addMouseListener(this);
        frmArbitros.btnLimpiar.addMouseListener(this);
        frmArbitros.btnRegresar.addMouseListener(this);
        frmArbitros.txtBuscar.addKeyListener(this);
        frmArbitros.cbTorneos.addMouseListener(this);
        this.modeloTorneos.CargarComboTorneos(frmArbitros.cbTorneos);
        frmArbitros.jtbArbitros.addMouseListener(this);
        modeloArbitros.MostrarArbitro(frmArbitros.jtbArbitros);
        
        //Obtener el UUID del doctor seleccionado
        frmArbitros.cbTorneos.addActionListener(e -> {
            if (e.getSource() == frmArbitros.cbTorneos) {
                Torneos selectedItem = (Torneos) frmArbitros.cbTorneos.getSelectedItem();
                if (selectedItem != null) {
                    String UUID = selectedItem.getUUID_Torneo();
                    modeloTorneos.setUUID_Torneo(UUID);
                }
            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        
        
        
        
        if (e.getSource() == panelArbitros.btnGuardar) {
            if (panelArbitros.txtNombre.getText().isEmpty() || panelArbitros.txtApellido.getText().isEmpty() || panelArbitros.txtEdad.getText().isEmpty() || panelArbitros.txtTelefono.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(panelArbitros, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloArbitros.setNombre(panelArbitros.txtNombre.getText());
                    modeloArbitros.setApellido(panelArbitros.txtApellido.getText());
                    modeloArbitros.setEdad(Integer.parseInt(panelArbitros.txtEdad.getText()));
                    modeloArbitros.setTelefono(panelArbitros.txtTelefono.getText());
                    modeloArbitros.setUUID_Torneo(modeloTorneos.getUUID_Torneo());
                    //Ejecutar el metodo 
                    modeloArbitros.GuardarArbitro();
                    modeloArbitros.MostrarArbitro(panelArbitros.jtbArbitros);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        if (e.getSource() == panelArbitros.btnEliminar) {
            if (panelArbitros.txtNombre.getText().isEmpty() || panelArbitros.txtApellido.getText().isEmpty() || panelArbitros.txtEdad.getText().isEmpty() || panelArbitros.txtTelefono.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(panelArbitros, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                modeloArbitros.EliminarArbitro(panelArbitros.jtbArbitros);
                modeloArbitros.MostrarArbitro(panelArbitros.jtbArbitros);
               // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                    }
                }
            }
        
        
        if (e.getSource() == panelArbitros.btnActualizar) {
            if (panelArbitros.txtNombre.getText().isEmpty() || panelArbitros.txtApellido.getText().isEmpty() || panelArbitros.txtEdad.getText().isEmpty() || panelArbitros.txtTelefono.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(panelArbitros, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloArbitros.setNombre(panelArbitros.txtNombre.getText());
                    modeloArbitros.setApellido(panelArbitros.txtApellido.getText());
                    modeloArbitros.setEdad(Integer.parseInt(panelArbitros.txtEdad.getText()));
                    modeloArbitros.setTelefono(panelArbitros.txtTelefono.getText());
                    modeloArbitros.setUUID_Torneo(modeloTorneos.getUUID_Torneo());

                    //Ejecutar el método    
                    modeloArbitros.ActualizarArbitro(panelArbitros.jtbArbitros);
                    modeloArbitros.MostrarArbitro(panelArbitros.jtbArbitros);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelArbitros, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == panelArbitros.btnLimpiar) {
          modeloArbitros.limpiar(panelArbitros);
        }
        
        if (e.getSource() == panelArbitros.jtbArbitros) {
            modeloArbitros.cargarDatosTabla(panelArbitros);
        }
        
        if (e.getSource() == panelArbitros.btnRegresar) {
            
            panelArbitros.dispose();
        }
        
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource() == panelArbitros.txtBuscar) {
            modeloArbitros.Buscar(panelArbitros.jtbArbitros, panelArbitros.txtBuscar);
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

    
    
}
