/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.funLogyRegistrar;
import modelo.tbUsuario;
import vista.registro;

/**
 *
 * @author alanbrito
 */
public class Controlador  implements ActionListener{
    
    funLogyRegistrar registrar = new funLogyRegistrar();
    tbUsuario regUsuario = new tbUsuario();
    registro reg = new registro();
    
    public Controlador (registro reg, tbUsuario users) {

this.registrar = registrar;
this.reg = reg;
this.regUsuario = regUsuario;
this.reg.btnRegistrar.addActionListener(this);



}
    
    public void Registrar(){
        regUsuario.setNombre_Usuario(reg.txtUsernameR.getText());
        regUsuario.setApellido_Usuario(reg.txtApellidoR.getText());
        regUsuario.setUser_name(reg.txtUsernameR.getText());
        regUsuario.setContrasena(reg.txtContrasena.getText());
        regUsuario.setCorreo_Usuario(reg.txtCorreoR.getText());
        regUsuario.getGenero_Usuario(reg.txtGeneroReg.getText());
        regUsuario.getFNacimiento_Usuario(reg.txtFnacimientoR.getText());
        
        if (registrar.InsertUser(regUsuario)) {

            JOptionPane.showMessageDialog(null, "usuario registrado");
        } else {
            JOptionPane.showMessageDialog(null, "error al registrar");
        }
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== reg.btnRegistrar ){
            Registrar();
        }
    }
    
    
    
    
    
}



