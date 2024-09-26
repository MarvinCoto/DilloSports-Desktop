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
import vista.frmHome;
import modelo.Arbitros;
import vista.frmArbitros;

/**
 *
 * @author Estudiante
 */
public class ctlrArbitros  implements MouseListener, KeyListener{
    
    private Arbitros modeloArbitro;
    private frmHome vistaHome; 
    private frmArbitros vistaArbitros; 
    
    public ctlrArbitros(Arbitros modeloArbitros, frmHome vistaHome, frmArbitros vistaArbitros) {
        this.modeloArbitro = modeloArbitros;
        this.vistaHome = vistaHome;
        this.vistaArbitros = vistaArbitros;
        
        
        vistaArbitros.btnGuardarArbitro.addMouseListener(this);
        vistaArbitros.btnActualizarArbitro.addMouseListener(this);
        vistaArbitros.btnEliminarArbitro.addMouseListener(this);
        vistaArbitros.btnLimpiarArbitros.addMouseListener(this);
       
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaArbitros.btnGuardarArbitro) {
            if (vistaArbitros.txtNombreArbitro.getText().isEmpty() || vistaArbitros.txtApellidoArbitro.getText().isEmpty() || vistaArbitros.telefonoArbitro.getText().isEmpty() || vistaArbitros.txtEdadArbitro.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vistaArbitros, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloArbitro.setNombre_Arbitro(vistaArbitros.txtNombreArbitro.getText());
                    modeloArbitro.setApellido_Arbitro(vistaArbitros.txtApellidoArbitro.getText());
                    modeloArbitro.setEdad_Arbitro(vistaArbitros.txtEdadArbitro.getText());
                    modeloArbitro.setTelefono_Arbitro(vistaArbitros.telefonoArbitro.getText());
                    //Ejecutar el metodo 
                    modeloArbitro.GuardarArbitro();
                    modeloArbitro.MostrarArbitro(vistaArbitros.jtbArbitro);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        
       
      
        if (e.getSource() == vistaArbitros.btnEliminarArbitro) {
            if (vistaArbitros.txtNombreArbitro.getText().isEmpty() || vistaArbitros.txtApellidoArbitro.getText().isEmpty() || vistaArbitros.telefonoArbitro.getText().isEmpty() || vistaArbitros.txtEdadArbitro.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaArbitros, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                modeloArbitro.EliminarArbitro(vistaArbitros.jtbArbitro);
                modeloArbitro.MostrarArbitro(vistaArbitros.jtbArbitro);
               // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                    }
                }
            }
        
        if (e.getSource() == vistaArbitros.btnActualizarArbitro) {
            if (vistaArbitros.txtNombreArbitro.getText().isEmpty() || vistaArbitros.txtApellidoArbitro.getText().isEmpty() || vistaArbitros.telefonoArbitro.getText().isEmpty() || vistaArbitros.txtEdadArbitro.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaArbitros, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloArbitro.setTitulo(vistaNoticias.txtTitulo.getText());
                    modeloNoticias.setDescripcion(vistaNoticias.txtDescripcion.getText());
                    modeloNoticias.setFecha(vistaNoticias.txtFecha.getText());
                    modeloNoticias.setImagen(vistaNoticias.txtImagen.getText());

                    //Ejecutar el método    
                    modeloNoticias.ActualizarNoticia(vistaNoticias.jtbNoticias);
                    modeloNoticias.MostrarNoticia(vistaNoticias.jtbNoticias);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vistaNoticias, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
