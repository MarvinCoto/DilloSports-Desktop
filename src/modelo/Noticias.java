package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.frmNoticias;

public class Noticias {
    
    //Parametros
    private String UUID_Noticia;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String imagen;

    //2- Getters y Setters
    public String getUUID_Noticia() {
        return UUID_Noticia;
    }

    public void setUUID_Noticia(String UUID_Noticia) {
        this.UUID_Noticia = UUID_Noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    //3- Métodos (select, insert, update, delete)

    //Ingresar
    public void GuardarNoticia() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addNoticia = conexion.prepareStatement("INSERT INTO tbNoticias(UUID_Noticia, Titulo_Noticia, Descripcion_Noticia, Fecha_Noticia, Imagen_Noticia) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addNoticia.setString(1, UUID.randomUUID().toString());
            addNoticia.setString(2, getTitulo());
            addNoticia.setString(3, getDescripcion());
            addNoticia.setString(4, getFecha());
            addNoticia.setString(5, getImagen());
 
            //Ejecutar la consulta
            addNoticia.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void MostrarNoticia(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloNoticias = new DefaultTableModel();
        modeloNoticias.setColumnIdentifiers(new Object[]{"UUID_Noticia", "Titulo_Noticia", "Descripcion_Noticia", "Fecha_Noticia", "Imagen_Noticia"});
        try {
         
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("select UUID_Noticia, Titulo_Noticia, Descripcion_Noticia, Fecha_Noticia, Imagen_Noticia FROM tbNoticias");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloNoticias.addRow(new Object[]{rs.getString("UUID_Noticia"), 
                    rs.getString("Titulo_Noticia"), 
                    rs.getString("Descripcion_Noticia"), 
                    rs.getString("Fecha_Noticia"), 
                    rs.getString("Imagen_Noticia")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloNoticias);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void EliminarNoticia(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbNoticias where UUID_Noticia = ?";
            PreparedStatement deleteNoticia = conexion.prepareStatement(sql);
            deleteNoticia.setString(1, miId);
            deleteNoticia.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void ActualizarNoticia(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbNoticias set Titulo_Noticia = ?, Descripcion_Noticia = ?, Fecha_Noticia = ?, Imagen_Noticia = ? where UUID_Noticia = ?";
                PreparedStatement updateNoticia = conexion.prepareStatement(sql);

                updateNoticia.setString(1, getTitulo());
                updateNoticia.setString(2, getDescripcion());
                updateNoticia.setString(3, getFecha());
                updateNoticia.setString(4, getImagen());
                updateNoticia.setString(5, miUUId);
                updateNoticia.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
    
    public void Buscar(JTable tabla, JTextField miTextField) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_Noticia", "Titulo_Noticia", "Descripcion_Noticia", "Fecha_Noticia", "Imagen_Noticia"});
        try {
            String sql = "SELECT * FROM tbNoticias WHERE Titulo_Noticia LIKE ? || '%'";
            PreparedStatement searchNoticia = conexion.prepareStatement(sql);
            searchNoticia.setString(1, miTextField.getText());
            ResultSet rs = searchNoticia.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Noticia"), rs.getString("Titulo_Noticia"), rs.getString("Descripcion_Noticia"), rs.getString("Fecha_Noticia"), rs.getString("Imagen_Noticia")});
            }

            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
    
    
    public void limpiar(frmNoticias vistaNoticias) {
        vistaNoticias.txtTitulo.setText("");
        vistaNoticias.txtDescripcion.setText("");
        vistaNoticias.txtFecha.setText("");
        vistaNoticias.txtImagen.setText("");
    }

    public void cargarDatosTabla(frmNoticias vistaNoticias) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vistaNoticias.jtbNoticias.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vistaNoticias.jtbNoticias.getValueAt(filaSeleccionada, 0).toString();
            String TituloDeTB = vistaNoticias.jtbNoticias.getValueAt(filaSeleccionada, 1).toString();
            String DescripcionDeTb = vistaNoticias.jtbNoticias.getValueAt(filaSeleccionada, 2).toString();
            String FechadDeTB = vistaNoticias.jtbNoticias.getValueAt(filaSeleccionada, 3).toString();
            String ImagenDeTB = vistaNoticias.jtbNoticias.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vistaNoticias.txtTitulo.setText(TituloDeTB);
            vistaNoticias.txtDescripcion.setText(DescripcionDeTb);
            vistaNoticias.txtFecha.setText(FechadDeTB);
            vistaNoticias.txtImagen.setText(ImagenDeTB);
        }
    }
    
    
    
}
