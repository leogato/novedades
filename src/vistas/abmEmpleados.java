/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import pojo.Empleado;
import pojo.Empresa;
import pojo.Sucursal;

/**
 *
 * @author usuario
 */
public class abmEmpleados extends javax.swing.JDialog {

    /**
     * Creates new form abmEmpleados
     */
    public abmEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        txtApellido = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtCuit = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtLegajo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        btnAceptar = new org.edisoncor.gui.button.ButtonIpod();
        btnNuevo = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnModificar = new org.edisoncor.gui.button.ButtonIpod();
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtConvenio = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        txtTarea = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        txtEmpresa = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtSucursal = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 2, true), "ALTA, BAJA Y MODIFICACION DE EMPLEADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), java.awt.Color.white)); // NOI18N
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        txtApellido.setBackground(new java.awt.Color(102, 102, 102));
        txtApellido.setBorder(null);
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setCaretColor(new java.awt.Color(102, 102, 102));
        txtApellido.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtApellido.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        txtNombre.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre.setBorder(null);
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setCaretColor(new java.awt.Color(102, 102, 102));
        txtNombre.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtNombre.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        txtCuit.setBackground(new java.awt.Color(102, 102, 102));
        txtCuit.setBorder(null);
        txtCuit.setForeground(new java.awt.Color(255, 255, 255));
        txtCuit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCuit.setCaretColor(new java.awt.Color(102, 102, 102));
        txtCuit.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtCuit.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        txtLegajo.setBackground(new java.awt.Color(102, 102, 102));
        txtLegajo.setBorder(null);
        txtLegajo.setForeground(new java.awt.Color(255, 255, 255));
        txtLegajo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLegajo.setCaretColor(new java.awt.Color(102, 102, 102));
        txtLegajo.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtLegajo.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelTranslucidoComplete1.setOpaque(false);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Tick (1).png"))); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adduser.png"))); // NOI18N
        btnNuevo.setText("Nuevo");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        btnModificar.setText("Modificar");

        buttonIpod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        buttonIpod1.setText("Eliminar");

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        labelMetric1.setText("CONVENIO");
        labelMetric1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric2.setText("LEGAJO");
        labelMetric2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric3.setText("CUIT");
        labelMetric3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric4.setText("NOMBRE");
        labelMetric4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric5.setText("APELLIDO");
        labelMetric5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtConvenio.setBackground(new java.awt.Color(102, 102, 102));
        txtConvenio.setBorder(null);
        txtConvenio.setForeground(new java.awt.Color(255, 255, 255));
        txtConvenio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtConvenio.setCaretColor(new java.awt.Color(102, 102, 102));
        txtConvenio.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtConvenio.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        labelMetric7.setText("TAREA");
        labelMetric7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtTarea.setBackground(new java.awt.Color(102, 102, 102));
        txtTarea.setBorder(null);
        txtTarea.setForeground(new java.awt.Color(255, 255, 255));
        txtTarea.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarea.setCaretColor(new java.awt.Color(102, 102, 102));
        txtTarea.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtTarea.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        labelMetric8.setText("EMPRESA");
        labelMetric8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtEmpresa.setBackground(new java.awt.Color(102, 102, 102));
        txtEmpresa.setBorder(null);
        txtEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtEmpresa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEmpresa.setCaretColor(new java.awt.Color(102, 102, 102));
        txtEmpresa.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtEmpresa.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        txtSucursal.setBackground(new java.awt.Color(102, 102, 102));
        txtSucursal.setBorder(null);
        txtSucursal.setForeground(new java.awt.Color(255, 255, 255));
        txtSucursal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSucursal.setCaretColor(new java.awt.Color(102, 102, 102));
        txtSucursal.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtSucursal.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N

        labelMetric9.setText("SUCURSAL");
        labelMetric9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtConvenio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Empleado empleado = new Empleado();
        Empresa empresa = new Empresa();
        Sucursal sucursal = new Sucursal();
                
                empleado.setLegajo(Integer.parseInt(txtLegajo.getText()));
                empleado.setApellido(txtApellido.getText());
                empleado.setNombre(txtNombre.getText());
                empleado.setCuit(txtCuit.getText());
                empresa.setNombre(txtEmpresa.getText());
                sucursal.setNombre(txtSucursal.getText());
                empleado.setConvenio(txtConvenio.getText());
                empleado.setTarea(txtTarea.getText());
                // todos los empleados que se den de alta aqi no seran administradores
           
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(abmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                abmEmpleados dialog = new abmEmpleados(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnAceptar;
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnModificar;
    private org.edisoncor.gui.button.ButtonIpod btnNuevo;
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete panelTranslucidoComplete1;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtApellido;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtConvenio;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtCuit;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtEmpresa;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtLegajo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtNombre;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtSucursal;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtTarea;
    // End of variables declaration//GEN-END:variables
}
