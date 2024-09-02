/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseListener;
import modelo.tbUsuario;
import static oracle.sql.NUMBER.e;
import vista.frmLogin;

/**
 *
 * @author FerOrtiz08
 */
public class ctrlLogin implements MouseListener {
    
    tbUsuario modelo;
    frmLogin vista;
    
    public ctrlLogin(tbUsuario modelo, frmLogin vista ) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnRegistrar.addMouseListener(this);
        
        if(e.getSource() == vista.btnRegistrar){
            vista.registro.initregistro();
            vista.dispose();
        }
    }
    
}
