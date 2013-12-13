/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import vistas.empleado.AltaEmpleado;
import vistas.empleado.GestorEmpleado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JMenuBar;
import pojo.Concepto;
import pojo.Usuario;
import vista.novedades.TablaNovedades;
import vistas.concepto.AbmConceptos;
import vistas.concepto.GestorConcepto;
import vistas.empresa.AltaEmpresa;
import vistas.empresa.AltaEmpresa2;
import vistas.empresa.GestorEmpresa;
import vistas.usuario.AltaUsuario;
import vistas.usuario.GestorUsuario;
import vistas.usuario.Login;

/**
 *
 * @author usuario
 */
public class principal extends javax.swing.JFrame {
    
    Usuario usuario= new Usuario();
    List<Concepto> con;
    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        setConfiguracionMenuAdministrador(false);
        setLocationRelativeTo(this);
        setVisible(true);
        
    }
    public class BackgroundMenuBar extends JMenuBar
{
    Color bgColor=Color.BLACK;

    public void setColor(Color color)
    {
        bgColor=color;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panel1 = new org.edisoncor.gui.panel.Panel();
        clkHora = new org.edisoncor.gui.varios.ClockDigital();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuItmLogin = new javax.swing.JMenuItem();
        mnuItmClose = new javax.swing.JMenuItem();
        mnuItmAcerca = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuNovedades = new javax.swing.JMenu();
        mnuItmCargaNovedades = new javax.swing.JMenuItem();
        mnuItmNovedadesRRHH = new javax.swing.JMenuItem();
        mnuEmpleados = new javax.swing.JMenu();
        mnuGestorEmpleados = new javax.swing.JMenuItem();
        mnuAltaEmpleados = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        mnuItmGestorUsuario = new javax.swing.JMenuItem();
        mnuABMUsuario = new javax.swing.JMenuItem();
        mnuEmpresa = new javax.swing.JMenu();
        mnuItemGestorEmpresa = new javax.swing.JMenuItem();
        mnuItemEmpresa = new javax.swing.JMenuItem();
        mnuSucursal = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuConcepto = new javax.swing.JMenu();
        mnuItmGestorConcepto = new javax.swing.JMenuItem();
        mnuItmAltaConceptos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Floorboard & Wall - Green by ABH 1680x1050.jpg"))); // NOI18N
        panel1.setOpaque(false);

        clkHora.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(clkHora, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clkHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        mnuArchivo.setText("Archivo");

        mnuItmLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnuItmLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Profile.png"))); // NOI18N
        mnuItmLogin.setText("Iniciar Sesion");
        mnuItmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmLoginActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuItmLogin);

        mnuItmClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuItmClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar sesion - copia.png"))); // NOI18N
        mnuItmClose.setText("Cerrar Sesion");
        mnuItmClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmCloseActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuItmClose);

        mnuItmAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Info.png"))); // NOI18N
        mnuItmAcerca.setText("Acerca");
        mnuArchivo.add(mnuItmAcerca);

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Exit.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        jMenuBar1.add(mnuArchivo);

        mnuNovedades.setText("Novedades");
        mnuNovedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNovedadesActionPerformed(evt);
            }
        });

        mnuItmCargaNovedades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuItmCargaNovedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asistencia empelado.png"))); // NOI18N
        mnuItmCargaNovedades.setText("Carga Novedades");
        mnuItmCargaNovedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmCargaNovedadesActionPerformed(evt);
            }
        });
        mnuNovedades.add(mnuItmCargaNovedades);

        mnuItmNovedadesRRHH.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnuItmNovedadesRRHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pad.png"))); // NOI18N
        mnuItmNovedadesRRHH.setText("Novedades RRHH");
        mnuItmNovedadesRRHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmNovedadesRRHHActionPerformed(evt);
            }
        });
        mnuNovedades.add(mnuItmNovedadesRRHH);

        jMenuBar1.add(mnuNovedades);

        mnuEmpleados.setText("Empleados");

        mnuGestorEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/User_Group_Icon_32.png"))); // NOI18N
        mnuGestorEmpleados.setText("Gestor de Empleados");
        mnuGestorEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestorEmpleadosActionPerformed(evt);
            }
        });
        mnuEmpleados.add(mnuGestorEmpleados);

        mnuAltaEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Profile.png"))); // NOI18N
        mnuAltaEmpleados.setText("Alta de Empleados");
        mnuAltaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltaEmpleadosActionPerformed(evt);
            }
        });
        mnuEmpleados.add(mnuAltaEmpleados);

        jMenuBar1.add(mnuEmpleados);

        mnuUsuario.setText("Usuarios");

        mnuItmGestorUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/users.png"))); // NOI18N
        mnuItmGestorUsuario.setText("Gestor de Usuarios");
        mnuItmGestorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmGestorUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuItmGestorUsuario);

        mnuABMUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        mnuABMUsuario.setText("Alta de Usuarios");
        mnuABMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuABMUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuABMUsuario);

        jMenuBar1.add(mnuUsuario);

        mnuEmpresa.setText("Empresas");

        mnuItemGestorEmpresa.setText("Gestor de Empresas");
        mnuItemGestorEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemGestorEmpresaActionPerformed(evt);
            }
        });
        mnuEmpresa.add(mnuItemGestorEmpresa);

        mnuItemEmpresa.setText("Alta de Empresas");
        mnuItemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemEmpresaActionPerformed(evt);
            }
        });
        mnuEmpresa.add(mnuItemEmpresa);

        jMenuBar1.add(mnuEmpresa);

        mnuSucursal.setText("Sucursales");

        jMenuItem2.setText("Gestor de Sucursales");
        mnuSucursal.add(jMenuItem2);

        jMenuItem3.setText("Alta de Sucursales");
        mnuSucursal.add(jMenuItem3);

        jMenuBar1.add(mnuSucursal);

        mnuConcepto.setText("Conceptos");

        mnuItmGestorConcepto.setText("Gestor de Conceptos");
        mnuItmGestorConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmGestorConceptoActionPerformed(evt);
            }
        });
        mnuConcepto.add(mnuItmGestorConcepto);

        mnuItmAltaConceptos.setText("Alta de Conceptos");
        mnuItmAltaConceptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmAltaConceptosActionPerformed(evt);
            }
        });
        mnuConcepto.add(mnuItmAltaConceptos);

        jMenuBar1.add(mnuConcepto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuNovedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNovedadesActionPerformed
        
    }//GEN-LAST:event_mnuNovedadesActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuItmCargaNovedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmCargaNovedadesActionPerformed
        cargaNovedades cn = new cargaNovedades(this, true, usuario);
    }//GEN-LAST:event_mnuItmCargaNovedadesActionPerformed

    private void mnuItemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemEmpresaActionPerformed
        new AltaEmpresa(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItemEmpresaActionPerformed

    private void mnuABMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuABMUsuarioActionPerformed
        new AltaUsuario(this, true);
    }//GEN-LAST:event_mnuABMUsuarioActionPerformed

    private void mnuAltaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltaEmpleadosActionPerformed
        new AltaEmpleado(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuAltaEmpleadosActionPerformed

    private void mnuGestorEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestorEmpleadosActionPerformed
        new GestorEmpleado(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuGestorEmpleadosActionPerformed

    private void mnuItmGestorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmGestorUsuarioActionPerformed
        new GestorUsuario(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItmGestorUsuarioActionPerformed

    private void mnuItmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmLoginActionPerformed
        Login login = new Login(this, true);
        if (login.isBotonAceptar() && login.isComun() == false) {
            usuario = login.getUsuario();
            setConfiguracionMenuAdministrador(true);
            mnuItmLogin.setEnabled(false);
            mnuSalir.setEnabled(false);
            
        } else if(login.isBotonAceptar() && login.isComun()){
            usuario = login.getUsuario();
            setConfiguracionComun(true);
            mnuItmLogin.setEnabled(false);
            mnuSalir.setEnabled(false);
        }
       
    }//GEN-LAST:event_mnuItmLoginActionPerformed

    private void mnuItmCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmCloseActionPerformed
        setConfiguracionMenuAdministrador(false);
        mnuItmLogin.setEnabled(true);
        mnuSalir.setEnabled(true);
        usuario = null;
    }//GEN-LAST:event_mnuItmCloseActionPerformed

    private void mnuItmGestorConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmGestorConceptoActionPerformed
        new GestorConcepto(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItmGestorConceptoActionPerformed

    private void mnuItmAltaConceptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmAltaConceptosActionPerformed
        new AbmConceptos(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItmAltaConceptosActionPerformed

    private void mnuItmNovedadesRRHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmNovedadesRRHHActionPerformed
        new TablaNovedades(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItmNovedadesRRHHActionPerformed

    private void mnuItemGestorEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemGestorEmpresaActionPerformed
        new GestorEmpresa(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuItemGestorEmpresaActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.ClockDigital clkHora;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem mnuABMUsuario;
    private javax.swing.JMenuItem mnuAltaEmpleados;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuConcepto;
    private javax.swing.JMenu mnuEmpleados;
    private javax.swing.JMenu mnuEmpresa;
    private javax.swing.JMenuItem mnuGestorEmpleados;
    private javax.swing.JMenuItem mnuItemEmpresa;
    private javax.swing.JMenuItem mnuItemGestorEmpresa;
    private javax.swing.JMenuItem mnuItmAcerca;
    private javax.swing.JMenuItem mnuItmAltaConceptos;
    private javax.swing.JMenuItem mnuItmCargaNovedades;
    private javax.swing.JMenuItem mnuItmClose;
    private javax.swing.JMenuItem mnuItmGestorConcepto;
    private javax.swing.JMenuItem mnuItmGestorUsuario;
    private javax.swing.JMenuItem mnuItmLogin;
    private javax.swing.JMenuItem mnuItmNovedadesRRHH;
    private javax.swing.JMenu mnuNovedades;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuSucursal;
    private javax.swing.JMenu mnuUsuario;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
private void setConfiguracionMenuAdministrador(boolean b){
        
        mnuSalir.setVisible(true);
        mnuItmAcerca.setVisible(true);
        mnuNovedades.setVisible(b);
        mnuNovedades.setEnabled(b);
        mnuItmCargaNovedades.setVisible(true);
        mnuItmNovedadesRRHH.setEnabled(b);
        mnuItmNovedadesRRHH.setVisible(b);
        mnuEmpleados.setEnabled(b);
        mnuEmpleados.setVisible(b);
        mnuUsuario.setEnabled(b);
        mnuUsuario.setVisible(b);
        mnuEmpresa.setEnabled(b);
        mnuEmpresa.setVisible(b);
        mnuSucursal.setEnabled(b);
        mnuSucursal.setVisible(b);
        mnuConcepto.setEnabled(b);
        mnuConcepto.setVisible(b);
        mnuItmClose.setEnabled(b);
        
    }
    private void setConfiguracionComun(boolean b){
        mnuNovedades.setVisible(b);
        mnuNovedades.setEnabled(b);
        mnuItmCargaNovedades.setVisible(b);
        mnuItmCargaNovedades.setEnabled(b);
        mnuItmClose.setEnabled(b);
    }

}

