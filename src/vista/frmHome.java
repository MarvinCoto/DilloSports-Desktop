/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ctrlHome;
import controlador.ctrlNoticias;
import java.awt.Color;
import modelo.Noticias;

/**
 *
 * @author marvi
 */
public class frmHome extends javax.swing.JFrame {

    /**
     * Creates new form frmPrueba
     */
    
    Color DefaultColor;
    
    public frmHome() {
        initComponents();
        
        
        //Establecer el color predeterminado en Panorámico en tiempo de ejecución
        jpInicio.setBackground(DefaultColor);
        jpPartidos.setBackground(DefaultColor);
        jpNoticias.setBackground(DefaultColor);
        jpTorneos.setBackground(DefaultColor);
        jpPerfil.setBackground(DefaultColor);
        jpAjustes.setBackground(DefaultColor);
        
        this.setLocationRelativeTo(null);
        
    }
    
        public static void initHome(){
        
        frmHome vista = new frmHome();
        frmInicio panelInicio = new frmInicio();
        frmPartidos panelPartidos = new frmPartidos();
        frmNoticias panelNoticias = new frmNoticias();
        frmTorneos panelTorneos = new frmTorneos();
        frmPerfil panelPerfil = new frmPerfil();
        frmAjustes panelAjustes = new frmAjustes();
        
        ctrlHome controlador = new ctrlHome(vista, panelInicio, panelPartidos, panelNoticias, panelTorneos, panelPerfil, panelAjustes);
        
        vista.setVisible(true);
    
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpInicio = new javax.swing.JPanel();
        jlbInicio = new javax.swing.JLabel();
        jpPartidos = new javax.swing.JPanel();
        jlbPartidos = new javax.swing.JLabel();
        jpNoticias = new javax.swing.JPanel();
        jlbNoticias = new javax.swing.JLabel();
        jpTorneos = new javax.swing.JPanel();
        jlbTorneos = new javax.swing.JLabel();
        jpAjustes = new javax.swing.JPanel();
        jlbAjustes = new javax.swing.JLabel();
        jpPerfil = new javax.swing.JPanel();
        jlbPerfil = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JlTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jpInicio.setBackground(new java.awt.Color(0, 0, 0));
        jpInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpInicioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpInicioMousePressed(evt);
            }
        });

        jlbInicio.setBackground(new java.awt.Color(0, 0, 0));
        jlbInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbInicio.setForeground(new java.awt.Color(255, 0, 51));
        jlbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homee.png"))); // NOI18N
        jlbInicio.setText(" Inicio");
        jlbInicio.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpInicioLayout = new javax.swing.GroupLayout(jpInicio);
        jpInicio.setLayout(jpInicioLayout);
        jpInicioLayout.setHorizontalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jpInicioLayout.setVerticalGroup(
            jpInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpPartidos.setBackground(new java.awt.Color(0, 0, 0));
        jpPartidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPartidosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpPartidosMousePressed(evt);
            }
        });

        jlbPartidos.setBackground(new java.awt.Color(0, 0, 0));
        jlbPartidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbPartidos.setForeground(new java.awt.Color(255, 0, 51));
        jlbPartidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/match.png"))); // NOI18N
        jlbPartidos.setText(" Partidos");
        jlbPartidos.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpPartidosLayout = new javax.swing.GroupLayout(jpPartidos);
        jpPartidos.setLayout(jpPartidosLayout);
        jpPartidosLayout.setHorizontalGroup(
            jpPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPartidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPartidosLayout.setVerticalGroup(
            jpPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPartidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpNoticias.setBackground(new java.awt.Color(0, 0, 0));
        jpNoticias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpNoticiasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpNoticiasMousePressed(evt);
            }
        });

        jlbNoticias.setBackground(new java.awt.Color(0, 0, 0));
        jlbNoticias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbNoticias.setForeground(new java.awt.Color(255, 0, 51));
        jlbNoticias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/noticias.png"))); // NOI18N
        jlbNoticias.setText("Noticias");
        jlbNoticias.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpNoticiasLayout = new javax.swing.GroupLayout(jpNoticias);
        jpNoticias.setLayout(jpNoticiasLayout);
        jpNoticiasLayout.setHorizontalGroup(
            jpNoticiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNoticiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNoticias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jpNoticiasLayout.setVerticalGroup(
            jpNoticiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNoticiasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlbNoticias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpTorneos.setBackground(new java.awt.Color(0, 0, 0));
        jpTorneos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTorneosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpTorneosMousePressed(evt);
            }
        });

        jlbTorneos.setBackground(new java.awt.Color(0, 0, 0));
        jlbTorneos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbTorneos.setForeground(new java.awt.Color(255, 0, 51));
        jlbTorneos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/torneo.png"))); // NOI18N
        jlbTorneos.setText("Torneos");
        jlbTorneos.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpTorneosLayout = new javax.swing.GroupLayout(jpTorneos);
        jpTorneos.setLayout(jpTorneosLayout);
        jpTorneosLayout.setHorizontalGroup(
            jpTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTorneosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTorneos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jpTorneosLayout.setVerticalGroup(
            jpTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTorneosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlbTorneos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpAjustes.setBackground(new java.awt.Color(0, 0, 0));
        jpAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAjustesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpAjustesMousePressed(evt);
            }
        });

        jlbAjustes.setBackground(new java.awt.Color(0, 0, 0));
        jlbAjustes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbAjustes.setForeground(new java.awt.Color(255, 0, 51));
        jlbAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ajustes.png"))); // NOI18N
        jlbAjustes.setText("Ajustes");
        jlbAjustes.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpAjustesLayout = new javax.swing.GroupLayout(jpAjustes);
        jpAjustes.setLayout(jpAjustesLayout);
        jpAjustesLayout.setHorizontalGroup(
            jpAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAjustesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jpAjustesLayout.setVerticalGroup(
            jpAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAjustesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlbAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
        );

        jpPerfil.setBackground(new java.awt.Color(0, 0, 0));
        jpPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPerfilMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpPerfilMousePressed(evt);
            }
        });

        jlbPerfil.setBackground(new java.awt.Color(0, 0, 0));
        jlbPerfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbPerfil.setForeground(new java.awt.Color(255, 0, 51));
        jlbPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N
        jlbPerfil.setText("Perfil");
        jlbPerfil.setPreferredSize(new java.awt.Dimension(107, 50));

        javax.swing.GroupLayout jpPerfilLayout = new javax.swing.GroupLayout(jpPerfil);
        jpPerfil.setLayout(jpPerfilLayout);
        jpPerfilLayout.setHorizontalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPerfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jpPerfilLayout.setVerticalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPartidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpNoticias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTorneos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpNoticias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dillo.png"))); // NOI18N
        jLabel2.setText("Dillo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Sports");

        JlTitulo.setBackground(new java.awt.Color(0, 0, 0));
        JlTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlTitulo.setForeground(new java.awt.Color(255, 0, 51));
        JlTitulo.setText("Inicio");
        JlTitulo.setPreferredSize(new java.awt.Dimension(107, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dillo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267)
                .addComponent(JlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(287, 287, 287)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(JlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jpContenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInicioMouseClicked
        // TODO add your handling code here:
        //frmInicio frmInicio = new frmInicio();
        //jpContenedor.removeAll();
        //jpContenedor.add(frmInicio).setVisible(true);
    }//GEN-LAST:event_jpInicioMouseClicked

    private void jpPartidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPartidosMouseClicked
        // TODO add your handling code here:
        //frmPartidos frmPartidos = new frmPartidos();
        //jpContenedor.removeAll();
        //jpContenedor.add(frmPartidos).setVisible(true);
    }//GEN-LAST:event_jpPartidosMouseClicked

    private void jpNoticiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpNoticiasMouseClicked
        // TODO add your handling code here:
      //  frmNoticias frmNoticias = new frmNoticias();
      //  jpContenedor.removeAll();
      //  jpContenedor.add(frmNoticias).setVisible(true);
    }//GEN-LAST:event_jpNoticiasMouseClicked

    private void jpTorneosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTorneosMouseClicked
        // TODO add your handling code here:
        //frmTorneos frmTorneos = new frmTorneos();
        //jpContenedor.removeAll();
        //jpContenedor.add(frmTorneos).setVisible(true);
    }//GEN-LAST:event_jpTorneosMouseClicked

    private void jpPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPerfilMouseClicked
        // TODO add your handling code here:
        //frmPerfil frmPerfil = new frmPerfil();
        //jpContenedor.removeAll();
        //jpContenedor.add(frmPerfil).setVisible(true);
    }//GEN-LAST:event_jpPerfilMouseClicked

    private void jpAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAjustesMouseClicked
        // TODO add your handling code here:
        //frmAjustes frmAjustes = new frmAjustes();
        //jpContenedor.removeAll();
        //jpContenedor.add(frmAjustes).setVisible(true);
    }//GEN-LAST:event_jpAjustesMouseClicked

    private void jpInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInicioMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(ClickedColor);
        //jpPartidos.setBackground(DefaultColor);
        //jpNoticias.setBackground(DefaultColor);
        //jpTorneos.setBackground(DefaultColor);
        //jpPerfil.setBackground(DefaultColor);
        //jpAjustes.setBackground(DefaultColor);
        
        //JlTitulo.setText("Inicio");
    }//GEN-LAST:event_jpInicioMousePressed

    private void jpPartidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPartidosMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(DefaultColor);
        //jpPartidos.setBackground(ClickedColor);
        //jpNoticias.setBackground(DefaultColor);
        //jpTorneos.setBackground(DefaultColor);
        //jpPerfil.setBackground(DefaultColor);
        //jpAjustes.setBackground(DefaultColor);
        
        //JlTitulo.setText("Partidos");
    }//GEN-LAST:event_jpPartidosMousePressed

    private void jpNoticiasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpNoticiasMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(DefaultColor);
        //jpPartidos.setBackground(DefaultColor);
        //jpNoticias.setBackground(ClickedColor);
        //jpTorneos.setBackground(DefaultColor);
        //jpPerfil.setBackground(DefaultColor);
        //jpAjustes.setBackground(DefaultColor);
        
        //JlTitulo.setText("Noticias");
    }//GEN-LAST:event_jpNoticiasMousePressed

    private void jpTorneosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTorneosMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(DefaultColor);
        //jpPartidos.setBackground(DefaultColor);
        //jpNoticias.setBackground(DefaultColor);
        //jpTorneos.setBackground(ClickedColor);
        //jpPerfil.setBackground(DefaultColor);
        //jpAjustes.setBackground(DefaultColor);
        
        //JlTitulo.setText("Torneos");
    }//GEN-LAST:event_jpTorneosMousePressed

    private void jpPerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPerfilMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(DefaultColor);
        //jpPartidos.setBackground(DefaultColor);
        //jpNoticias.setBackground(DefaultColor);
        //jpTorneos.setBackground(DefaultColor);
        //jpPerfil.setBackground(ClickedColor);
        //jpAjustes.setBackground(DefaultColor);
        
        //JlTitulo.setText("Perfil");
    }//GEN-LAST:event_jpPerfilMousePressed

    private void jpAjustesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAjustesMousePressed
        // TODO add your handling code here:
        //jpInicio.setBackground(DefaultColor);
        //jpPartidos.setBackground(DefaultColor);
        //jpNoticias.setBackground(DefaultColor);
        //jpTorneos.setBackground(DefaultColor);
        //jpPerfil.setBackground(DefaultColor);
        //jpAjustes.setBackground(ClickedColor);
        
        //JlTitulo.setText("Ajustes");
    }//GEN-LAST:event_jpAjustesMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initHome();
                
            }
        });
        
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JlTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel jlbAjustes;
    public javax.swing.JLabel jlbInicio;
    public javax.swing.JLabel jlbNoticias;
    public javax.swing.JLabel jlbPartidos;
    public javax.swing.JLabel jlbPerfil;
    public javax.swing.JLabel jlbTorneos;
    public javax.swing.JPanel jpAjustes;
    public javax.swing.JPanel jpContenedor;
    public javax.swing.JPanel jpInicio;
    public javax.swing.JPanel jpNoticias;
    public javax.swing.JPanel jpPartidos;
    public javax.swing.JPanel jpPerfil;
    public javax.swing.JPanel jpTorneos;
    // End of variables declaration//GEN-END:variables
}
