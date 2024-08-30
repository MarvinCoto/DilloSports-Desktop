package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Noticias;
import vista.frmHome;
import vista.frmNoticias;
import vista.noticiasPrueba;


    //////////////////////////1- Implementar herencia: ActionListener
    public class ctrlNoticias implements MouseListener, KeyListener{
    
    //////////////////////////2- Parametros
    private Noticias modeloNoticias;
    private frmHome vistaNoticias;
    private noticiasPrueba Panel; 
    
    //////////////////////////3- Constructor de la clase
    public ctrlNoticias(Noticias modeloNoticias, frmHome VistaNoticias, noticiasPrueba panel) {
        
        this.modeloNoticias = modeloNoticias;
        this.vistaNoticias = VistaNoticias;
        this.Panel = panel;
        
        //Siempre hay que poner los botones que vamos a utilizar
        noticiasPrueba.btnGuardar.addMouseListener(this);
        noticiasPrueba.btnActualizar.addMouseListener(this);
        noticiasPrueba.btnEliminar.addMouseListener(this);
        noticiasPrueba.btnLimpiar.addMouseListener(this);
        noticiasPrueba.txtBuscar.addMouseListener(this);
        noticiasPrueba.jtbNoticias.addMouseListener(this);
        vistaNoticias.jlbNoticias.addMouseListener(this);
        modeloNoticias.MostrarNoticia(noticiasPrueba.jtbNoticias);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        if(e.getSource() == vistaNoticias.jlbNoticias){
            vistaNoticias.jpContenedor.removeAll();
            vistaNoticias.jpContenedor.add(Panel);
            vistaNoticias.jpContenedor.revalidate();
            vistaNoticias.jpContenedor.repaint();
        }
        
        
        if (e.getSource() == Panel.btnGuardar) {
            if (Panel.txtTitulo.getText().isEmpty() || Panel.txtDescripcion.getText().isEmpty() || Panel.txtFecha.getText().isEmpty() || Panel.txtImagen.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloNoticias.setTitulo(Panel.txtTitulo.getText());
                    modeloNoticias.setDescripcion(Panel.txtDescripcion.getText());
                    modeloNoticias.setFecha(Panel.txtFecha.getText());
                    modeloNoticias.setImagen(Panel.txtImagen.getText());
                    //Ejecutar el metodo 
                    modeloNoticias.GuardarNoticia();
                    modeloNoticias.MostrarNoticia(Panel.jtbNoticias);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        if (e.getSource() == Panel.btnEliminar) {
            if (Panel.txtTitulo.getText().isEmpty() || Panel.txtDescripcion.getText().isEmpty() || Panel.txtFecha.getText().isEmpty() || Panel.txtImagen.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloNoticias.EliminarNoticia(Panel.jtbNoticias);
                modeloNoticias.MostrarNoticia(Panel.jtbNoticias);
               // modeloNoticias.limpiar(Panel);
            }
        }
        
        if (e.getSource() == Panel.btnActualizar) {
            if (Panel.txtTitulo.getText().isEmpty() || Panel.txtDescripcion.getText().isEmpty() || Panel.txtFecha.getText().isEmpty() || Panel.txtImagen.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloNoticias.setTitulo(Panel.txtTitulo.getText());
                    modeloNoticias.setDescripcion(Panel.txtDescripcion.getText());
                    modeloNoticias.setFecha(Panel.txtFecha.getText());
                    modeloNoticias.setImagen(Panel.txtImagen.getText());

                    //Ejecutar el método    
                    modeloNoticias.ActualizarNoticia(Panel.jtbNoticias);
                    modeloNoticias.MostrarNoticia(Panel.jtbNoticias);
                   // modeloNoticias.limpiar(Panel);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == Panel.btnLimpiar) {
          //  modeloNoticias.limpiar(vistaNoticias);
        }
        
        if (e.getSource() == Panel.jtbNoticias) {
            //modeloNoticias.cargarDatosTabla(Panel);
        }
        
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource() == Panel.txtBuscar) {
            modeloNoticias.Buscar(Panel.jtbNoticias, Panel.txtBuscar);
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
