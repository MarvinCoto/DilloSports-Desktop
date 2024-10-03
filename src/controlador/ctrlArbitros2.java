/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Arbitros2;
import vista.frmArbitros2;

/**
 *
 * @author marvi
 */
public class ctrlArbitros2 implements MouseListener{
    
    //////////////////////////2- Parametros
    private Arbitros2 modeloArbitros;
    private frmArbitros2 panelArbitros;
    
    public ctrlArbitros2(Arbitros2 modeloArbitros, frmArbitros2 panelTorneos) {
        
        //////////////////////////2- Parametros
        this.modeloArbitros = modeloArbitros;
        this.panelArbitros = panelTorneos;
        
        //Siempre hay que poner los botones que vamos a utilizar
        frmArbitros2.btnGuardar.addMouseListener(this);
        frmArbitros2.btnActualizar.addMouseListener(this);
        frmArbitros2.btnEliminar.addMouseListener(this);
        frmArbitros2.btnLimpiar.addMouseListener(this);
        frmArbitros2.btnRegresar.addMouseListener(this);
        frmArbitros2.txtBuscar.addMouseListener(this);
        frmArbitros2.jtbArbitros.addMouseListener(this);
        modeloArbitros.MostrarArbitro(frmArbitros2.jtbArbitros);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        
        try {
                int edadNumerica = Integer.parseInt(panelArbitros.txtEdad.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(panelArbitros, "Ingrese una edad valida");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panelArbitros, "Ingrese solo numeros");
            }
        
        
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
