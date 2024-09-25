/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        vistaArbitros.btnEliminar.addMouseListener(this);
        vistaArbitros.btn
       
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaArbitros.btnGuardarArbitro) {
            if (vistaArbitros.txtNombreArbitro.getText().isEmpty() || vistaArbitros.txtApellidoArbitro.getText().isEmpty() || vistaArbitros.telefonoArbitro.getText().isEmpty() || vistaArbitros.txtEdadArbitro.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vistaArbitros, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloArbitro.setNombreArbitro(vistaArbitros.txtNombreArbitro.getText());
                    modeloArbitro.setApellidoArbitro(vistaArbitros.txtApellidoArbitro.getText());
                    modeloArbitro.setEdadArbitro(vistaArbitros.txtEdadArbitro.getText());
                    modeloArbitro.setTelefonoArbitro(vistaArbitros.telefonoArbitro.getText());
                    //Ejecutar el metodo 
                    modeloArbitro.GuardarArbitro();
                    modeloArbitro.MostrarArbitro(vistaArbitros.jtbArbitros);
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
                modeloArbitro.MostrarNoticia(vistaNoticias.jtbNoticias);
               // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
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
