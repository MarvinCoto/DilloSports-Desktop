package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Noticias;
import vista.frmNoticias;


    //////////////////////////1- Implementar herencia: ActionListener
    public class ctrlNoticias implements MouseListener, KeyListener{
    
    //////////////////////////2- Parametros
    private Noticias modeloNoticias;
    private frmNoticias vistaNoticias;
    
    //////////////////////////3- Constructor de la clase
    public ctrlNoticias(Noticias modeloNoticias, frmNoticias vistaNoticias) {
        
        this.modeloNoticias = modeloNoticias;
        this.vistaNoticias = vistaNoticias;
        
        //Siempre hay que poner los botones que vamos a utilizar
        vistaNoticias.btnGuardar.addMouseListener(this);
        vistaNoticias.btnActualizar.addMouseListener(this);
        vistaNoticias.btnEliminar.addMouseListener(this);
        vistaNoticias.btnLimpiar.addMouseListener(this);
        vistaNoticias.txtBuscar.addMouseListener(this);
        vistaNoticias.jtbNoticias.addMouseListener(this);
        
        modeloNoticias.MostrarNoticia(vistaNoticias.jtbNoticias);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //////////////////////////4- Detección de clicks en la vista
        if (e.getSource() == vistaNoticias.btnGuardar) {
            if (vistaNoticias.txtTitulo.getText().isEmpty() || vistaNoticias.txtDescripcion.getText().isEmpty() || vistaNoticias.txtFecha.getText().isEmpty() || vistaNoticias.txtImagen.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modeloNoticias.setTitulo(vistaNoticias.txtTitulo.getText());
                    modeloNoticias.setDescripcion(vistaNoticias.txtDescripcion.getText());
                    modeloNoticias.setFecha(vistaNoticias.txtFecha.getText());
                    modeloNoticias.setImagen(vistaNoticias.txtImagen.getText());
                    //Ejecutar el metodo 
                    modeloNoticias.GuardarNoticia();
                    modeloNoticias.MostrarNoticia(vistaNoticias.jtbNoticias);
                    modeloNoticias.limpiar(vistaNoticias);
                } catch (Exception ex) {
                    System.out.println("este es el error al guardar" + e);
                }
            }
        }
        
        if (e.getSource() == vistaNoticias.btnEliminar) {
            if (vistaNoticias.txtTitulo.getText().isEmpty() || vistaNoticias.txtDescripcion.getText().isEmpty() || vistaNoticias.txtFecha.getText().isEmpty() || vistaNoticias.txtImagen.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloNoticias.EliminarNoticia(vistaNoticias.jtbNoticias);
                modeloNoticias.MostrarNoticia(vistaNoticias.jtbNoticias);
                modeloNoticias.limpiar(vistaNoticias);
            }
        }
        
        if (e.getSource() == vistaNoticias.btnActualizar) {
            if (vistaNoticias.txtTitulo.getText().isEmpty() || vistaNoticias.txtDescripcion.getText().isEmpty() || vistaNoticias.txtFecha.getText().isEmpty() || vistaNoticias.txtImagen.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(vistaNoticias, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modeloNoticias.setTitulo(vistaNoticias.txtTitulo.getText());
                    modeloNoticias.setDescripcion(vistaNoticias.txtDescripcion.getText());
                    modeloNoticias.setFecha(vistaNoticias.txtFecha.getText());
                    modeloNoticias.setImagen(vistaNoticias.txtImagen.getText());

                    //Ejecutar el método    
                    modeloNoticias.ActualizarNoticia(vistaNoticias.jtbNoticias);
                    modeloNoticias.MostrarNoticia(vistaNoticias.jtbNoticias);
                    modeloNoticias.limpiar(vistaNoticias);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vistaNoticias, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vistaNoticias.btnLimpiar) {
            modeloNoticias.limpiar(vistaNoticias);
        }
        
        if (e.getSource() == vistaNoticias.jtbNoticias) {
            modeloNoticias.cargarDatosTabla(vistaNoticias);
        }
        
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource() == vistaNoticias.txtBuscar) {
            modeloNoticias.Buscar(vistaNoticias.jtbNoticias, vistaNoticias.txtBuscar);
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
