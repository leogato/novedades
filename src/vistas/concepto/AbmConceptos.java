/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.concepto;

import hibernateUtil.Conexion;
import java.util.List;
import javax.swing.JOptionPane;
import novedades.dao.imp.ConceptoDaoImp;
import pojo.Concepto;

/**
 *
 * @author usuario
 */
public class AbmConceptos extends javax.swing.JDialog {

    public static int GESTOR_DE_CONCEPTOS = 1;
    private int cod_con=0;
    private boolean BotonGuardarSelecciono=false;
    private String des;
    public boolean isBotonGuardarSeleccionado(){
        return BotonGuardarSelecciono;
}
    
    /**
     * Creates new form AbmConceptos
     */
    public AbmConceptos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnEliminar.setVisible(false);
        btnEliminar.setEnabled(false);
        this.setTitle("NUEVO CONCEPTO");
        setLocationRelativeTo(this);
        setVisible(true);
    }
    
    public AbmConceptos(java.awt.Frame parent, boolean modal, int cod_con){
        super(parent, modal);
        initComponents();
        this.cod_con = cod_con;
        btnEliminar.setVisible(true);
        txtId.setEditable(false);
        this.setTitle("EDITAR CONCEPTO");
        configurarParaEditar();
        setLocationRelativeTo(this); 
        setVisible(true);
    }
    
    public AbmConceptos(int cod, String desc){
        this.cod_con = cod;
        this.des = desc;
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
        txtId = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        btnAtras = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnEliminar = new org.edisoncor.gui.button.ButtonIpod();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        chkCarga = new javax.swing.JCheckBox();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        cmbTipo = new org.edisoncor.gui.comboBox.ComboBoxRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 2, true), "ALTA, BAJA Y MODIFICACION DE CONCEPTOS", 2, 0, new java.awt.Font("Calibri", 1, 24), java.awt.Color.white)); // NOI18N
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        txtId.setBackground(new java.awt.Color(102, 102, 102));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtId.setCaretColor(new java.awt.Color(102, 102, 102));
        txtId.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtId.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtDescripcion.setBackground(new java.awt.Color(102, 102, 102));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setCaretColor(new java.awt.Color(102, 102, 102));
        txtDescripcion.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtDescripcion.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        panelTranslucidoComplete1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelTranslucidoComplete1.setOpaque(false);

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GUARDAR.png"))); // NOI18N
        btnCancelar.setText("Guardar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        labelMetric1.setText("DESCRIPCION");
        labelMetric1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric2.setText("ID");
        labelMetric2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric3.setText("CARGA USUARIO");
        labelMetric3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        labelMetric4.setText("TIPO");
        labelMetric4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        cmbTipo.setBackground(new java.awt.Color(102, 102, 102));
        cmbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CUALITATIVA", "CUANTITATIVA" }));
        cmbTipo.setAnchoDeBorde(2.0F);
        cmbTipo.setColorDeBorde(new java.awt.Color(255, 102, 0));
        cmbTipo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkCarga)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkCarga)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (cod_con==0) {
                System.out.println("entro en nuevo");
                // nuevo empleado
                if(validarConceptoNuevo()){
                    System.out.println(validarConceptoNuevo());
                    Concepto e = getDatosConcepto();
                    // agrego los datos que faltan
                    //                       e.setAdministrador(false);
                    //                       e.setClave("");
                    //                       e.setFechaIngreso(null);
                    new ConceptoDaoImp().addConcepto(e);
                    //                       mensajero.mensajeInformacionAltaOK(this);
                    this.dispose();
                }
            } else {
                System.out.println("entro a modificar");
                //actualizar empleado
                if (validarConceptoActulizado()) {
                    //obtengos los datos y creo el empelado
                    Concepto e = getDatosConcepto();
                    if (cod_con != Integer.parseInt(txtId.getText().trim())) {
                        Concepto c = new ConceptoDaoImp().getConcepto(cod_con);
                        List<Concepto> lista =new ConceptoDaoImp().listarConcepto();
                        new ConceptoDaoImp().addConcepto(e);
                        // aqui va borrar el empleado o   porque se modiico la clave primario

                        new ConceptoDaoImp().deleteConcepto(c);
                        Concepto conUp = new ConceptoDaoImp().getConcepto(e.getCodCon());

                    }else{
                        new ConceptoDaoImp().upDateConcepto(e);

                    }
                    // agregar todas la asistencia

                    Conexion.getSessionFactory().close();
                    this.dispose();
                }

            }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        permitirSoloNumero(evt);
    }//GEN-LAST:event_txtIdKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resp =JOptionPane.showConfirmDialog(rootPane,"Esta seguro de eliminar el Concepto: \n"+txtId.getText()+txtDescripcion.getText()+" ?", "ELIMINAR CONCEPTO",JOptionPane.OK_CANCEL_OPTION);
        if (resp==JOptionPane.OK_OPTION) {
             Concepto c = new ConceptoDaoImp().getConcepto(cod_con);
            new ConceptoDaoImp().deleteConcepto(c);
            JOptionPane.showMessageDialog(rootPane, "La Eliminacion se realizo exitosamente ", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(AbmConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmConceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AbmConceptos dialog = new AbmConceptos(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIpod btnAtras;
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnEliminar;
    private javax.swing.JCheckBox chkCarga;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbTipo;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete panelTranslucidoComplete1;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtId;
    // End of variables declaration//GEN-END:variables

    private void configurarParaEditar() {
        Concepto e = new ConceptoDaoImp().getConcepto(cod_con);
        txtId.setText(String.valueOf(e.getCodCon()));
        txtDescripcion.setText(e.getDescripcion());
        cmbTipo.setSelectedItem(e.getTipo());
        chkCarga.setSelected(e.getCargaUser());
    }
    
    private void permitirSoloNumero(java.awt.event.KeyEvent evt) {
          // permitir solo el ingreso de numero
         char caracter = evt.getKeyChar();
        if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
         evt.consume();  // ignorar el evento de teclado
        }
    }
    
    public boolean validarConceptoNuevo(){
         boolean todoOk=false;
         try{
         Concepto con = new ConceptoDaoImp().getConcepto(Integer.parseInt(txtId.getText().trim()));
         System.out.println("Variable empLeg: "+con);
             //actualizar
             
             if (con ==null){
                 todoOk= true;
             }else{
                 if (con!=null) {
                   JOptionPane.showMessageDialog(this, "El CONCEPTO ya existe");
                } 
             }
           }catch(Exception ex){
              JOptionPane.showMessageDialog(this, "El campo ID no puede estar vacio");
              todoOk=false;
         }   
         return todoOk;
     }
    
    public boolean validarConceptoActulizado(){
        boolean todoOk=true;
        Concepto con = new ConceptoDaoImp().getConcepto(Integer.parseInt(txtId.getText().trim()));
        System.out.println("empleado original "+con.getCodCon()+"-"+con.getDescripcion());
        
        if (con.getCodCon()!=Integer.parseInt(txtId.getText().trim())) {
             // el empleado modifico el legajo
            Concepto conId = new ConceptoDaoImp().getConcepto(Integer.parseInt(txtId.getText().trim()));  
             if (conId!=null) {
                 todoOk = false;
                 JOptionPane.showMessageDialog(this, "El CONCEPTO ya existe");
             }
         }
        return todoOk;
     }
    
    public Concepto getDatosConcepto(){
        Concepto con = new Concepto();
        System.out.println("ID "+Integer.parseInt(txtId.getText()));
        con.setCodCon(Integer.parseInt(txtId.getText()));
        con.setDescripcion(txtDescripcion.getText());
        con.setTipo(cmbTipo.getSelectedItem().toString());
        con.setCargaUser(chkCarga.isSelected());
        return con;
     }
}

