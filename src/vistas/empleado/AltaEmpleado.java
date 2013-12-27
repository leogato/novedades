/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.empleado;

import pojo.Empleado;
import novedades.dao.imp.EmpleadoDaoImp;
import hibernateUtil.Conexion;
import java.util.List;
import javax.swing.JOptionPane;
import novedades.dao.imp.EmpresaDaoImp;
import novedades.dao.imp.SucursalDaoImp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Empresa;
import pojo.Sucursal;

/**
 *
 * @author Leo
 */
public class AltaEmpleado extends javax.swing.JDialog {

    public static final int GESTOR_EMPLEADO =1;
    private int legajo=0;
    private boolean BotonGuardarSelecciono=false;
    private String nombredelarchivo;

    public boolean isBotonGuardarSelecciono() {
        return BotonGuardarSelecciono;
    }
    
    
    /**
     * Creates new form Personal
     */
    
    
    public AltaEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenaCmbEmpresa();
//        llenaCmbSucursal();
        btneEliminar.setVisible(false);
        btneEliminar.setEnabled(false);
        this.setTitle("NUEVO EMPLEADO");
        setLocationRelativeTo(this);
        setVisible(true);
        // no se realizara la carga de foto
       
        
        
    }
    
    public AltaEmpleado(java.awt.Frame parent, boolean modal,int legajo) {
        super(parent, modal);
        initComponents();
        llenaCmbEmpresa();
//        llenaCmbSucursal();
        this.legajo = legajo;
        btneEliminar.setVisible(true);
        this.setTitle("EDITAR EMPLEADO");
        configurarParaEditar();
        setLocationRelativeTo(this); 
        setVisible(true);
        // no se realizara la carga de foto
       
        
        
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elegirFichero = new javax.swing.JFileChooser();
        pnlPrincipal = new org.edisoncor.gui.panel.Panel();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        btneEliminar = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        txtTarea = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric15 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric13 = new org.edisoncor.gui.label.LabelMetric();
        txtConvenio = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtCuit = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric12 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric11 = new org.edisoncor.gui.label.LabelMetric();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtApellido = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        txtLegajo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric14 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric16 = new org.edisoncor.gui.label.LabelMetric();
        cmbEmpresa = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbSucursal = new org.edisoncor.gui.comboBox.ComboBoxRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLEADO", 2, 2, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        pnlPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GUARDAR.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setAnimacion(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btneEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btneEliminar.setText("ELIMINAR");
        btneEliminar.setAnimacion(false);
        btneEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnCancelar.setText("ATRAS");
        btnCancelar.setAnimacion(false);
        btnCancelar.setDistanciaDeSombra(45);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtTarea.setBackground(new java.awt.Color(102, 102, 102));
        txtTarea.setBorder(null);
        txtTarea.setForeground(new java.awt.Color(255, 255, 255));
        txtTarea.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarea.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtTarea.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        labelMetric15.setText("TAREA");

        labelMetric13.setText("CONVENIO");

        txtConvenio.setBackground(new java.awt.Color(102, 102, 102));
        txtConvenio.setBorder(null);
        txtConvenio.setForeground(new java.awt.Color(255, 255, 255));
        txtConvenio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtConvenio.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtConvenio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        txtCuit.setBackground(new java.awt.Color(102, 102, 102));
        txtCuit.setBorder(null);
        txtCuit.setForeground(new java.awt.Color(255, 255, 255));
        txtCuit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCuit.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtCuit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        labelMetric12.setText("CUIT");

        labelMetric11.setText("NOMBRE");

        txtNombre.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre.setBorder(null);
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombre.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtNombre.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        txtApellido.setBackground(new java.awt.Color(102, 102, 102));
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtApellido.setCaretColor(new java.awt.Color(255, 102, 0));
        txtApellido.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtApellido.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        labelMetric10.setText("APELLIDO");

        labelMetric9.setText("LEGAJO");

        txtLegajo.setBackground(new java.awt.Color(255, 255, 0));
        txtLegajo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLegajo.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtLegajo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLegajoActionPerformed(evt);
            }
        });
        txtLegajo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLegajoFocusLost(evt);
            }
        });
        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLegajoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        labelMetric14.setText("EMPRESA");

        labelMetric16.setText("SUCURSAL");

        cmbEmpresa.setBackground(new java.awt.Color(102, 102, 102));
        cmbEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        cmbEmpresa.setColorDeBorde(new java.awt.Color(255, 102, 0));
        cmbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpresaItemStateChanged(evt);
            }
        });

        cmbSucursal.setBackground(new java.awt.Color(102, 102, 102));
        cmbSucursal.setForeground(new java.awt.Color(255, 255, 255));
        cmbSucursal.setColorDeBorde(new java.awt.Color(255, 102, 0));
        cmbSucursal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSucursalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btneEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelMetric16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped
        permitirSoloNumero(evt);
    }//GEN-LAST:event_txtLegajoKeyTyped

    private void txtLegajoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyPressed

    }//GEN-LAST:event_txtLegajoKeyPressed

    private void txtLegajoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLegajoFocusLost

                //validar el empleado
        
//                 try{
//                    Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText()));
//                     if (e!=null) {
//                            JOptionPane.showMessageDialog(rootPane, "EL LEGAJO YA EXISTE, INTENTE NUEVAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
//                            txtLegajo.setText("");
//                            txtLegajo.requestFocus();
//                        }else{
//                             // es uno legajo nuevo , por defecto la clave sera la misma que su legajo
//                             txtLegajo.setText(txtLegajo.getText());
//                             txtApellido.requestFocus();
//                         }
//                    }catch(Exception eee){
//                        if (!btnCancelar.isEnabled() ||txtLegajo.getText().trim().isEmpty() ) {
//                            JOptionPane.showMessageDialog(this, "NO PUEDE ESTAR VACIEO EL CAMPO LEGAJO");
//                            txtLegajo.setText("");
//                            txtLegajo.requestFocus();
//                        }
//                    }
    }//GEN-LAST:event_txtLegajoFocusLost

    private void txtLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLegajoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // cancela la operacion actual
        txtLegajo.setEnabled(false);//  esto  es para que no capture el evento foculost de txtlegajo
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btneEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneEliminarActionPerformed
        //        limpiarVenanaEmpleado();
        //        setEnableVentanaInformacionEmpleado(true);
        int resp =JOptionPane.showConfirmDialog(rootPane,"Esta seguro de eliminar el Empleado: \n"+txtApellido.getText()+" "+txtNombre.getText()+" ?", "ELIMINAR EMPLEADO",JOptionPane.OK_CANCEL_OPTION);
        if (resp==JOptionPane.OK_OPTION) {
            Empleado e = new EmpleadoDaoImp().getEmpleado(legajo);
            new EmpleadoDaoImp().deleteEmpleado(e);
            JOptionPane.showMessageDialog(rootPane, "La Eliminacion se realizo exitosamente ", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btneEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //               try{
            //obtengos los datos ingresados

            if (legajo==0) {
                System.out.println("entro en nuevo");
                // nuevo empleado
                if(validarEmpleadoNuevo()){
                    System.out.println(validarEmpleadoNuevo());
                    Empleado e = getDatosEmpleado();
                    new EmpleadoDaoImp().addEmpleado(e);
                    this.dispose();
                }
            } else {
                System.out.println("entro a modificar");
                //actualizar empleado
                if (validarEmpleadoActulizado()) {
                    //obtengos los datos y creo el empelado
                    Empleado e = getDatosEmpleado();
                    if (legajo != Integer.parseInt(txtLegajo.getText().trim())) {
                        Empleado o = new EmpleadoDaoImp().getEmpleado(legajo);
                        List<Empleado> lista =new EmpleadoDaoImp().listarEmpleado();
                        new EmpleadoDaoImp().upDateEmpleado(e);
                        // aqui va borrar el empleado o   porque se modiico la clave primario
                        new EmpleadoDaoImp().deleteEmpleado(o);
                        Empleado emplUp = new EmpleadoDaoImp().getEmpleado(e.getLegajo());

                    }else{
                        new EmpleadoDaoImp().upDateEmpleado(e);

                    }
                    this.dispose();
                }

            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbSucursalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSucursalItemStateChanged
        
    }//GEN-LAST:event_cmbSucursalItemStateChanged

    private void cmbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpresaItemStateChanged
        llenaCmbSucursal(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
    }//GEN-LAST:event_cmbEmpresaItemStateChanged
     
    private void permitirSoloNumero(java.awt.event.KeyEvent evt) {
          // permitir solo el ingreso de numero
        char caracter = evt.getKeyChar();
        if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
         evt.consume();  // ignorar el evento de teclado
      }
       
     }    
    /**
 * 
 * @param label  label donde estara visualizada la imagen
 * @param img   imagen que se quiere viusalizar en el label
 */
    
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
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AltaEmpleado dialog = new AltaEmpleado(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private org.edisoncor.gui.button.ButtonIpod btneEliminar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbEmpresa;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbSucursal;
    private javax.swing.JFileChooser elegirFichero;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric11;
    private org.edisoncor.gui.label.LabelMetric labelMetric12;
    private org.edisoncor.gui.label.LabelMetric labelMetric13;
    private org.edisoncor.gui.label.LabelMetric labelMetric14;
    private org.edisoncor.gui.label.LabelMetric labelMetric15;
    private org.edisoncor.gui.label.LabelMetric labelMetric16;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel pnlPrincipal;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtApellido;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtConvenio;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtCuit;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtLegajo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtNombre;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtTarea;
    // End of variables declaration//GEN-END:variables

     private void limpiarVenanaEmpleado() {
       txtApellido.setText("");
       txtCuit.setText("");
       txtLegajo.setText("");
       txtConvenio.setText("");
       txtNombre.setText("");
       txtTarea.setText("");
       //BOTON
      // btnGuardar.setEnabled(true);
       btneEliminar.setEnabled(false);
       // falta par aque  el cursor se situe en el campo legajo por defecyto
       txtLegajo.requestFocus();
    }
    
    /**
     * 
     * @return retornaun Objeto tipo Empleado a partir de los datos ingresados por el usuario
     * ademas se encarga de hacer la validaciones de ingreso de datos, en caso de que haya ingresado mal algun 
     * dato , el  metodo retorna NULL
     */
       
     public boolean validarEmpleadoActulizado(){
        boolean todoOk = true;
        Empleado empOriginal = new EmpleadoDaoImp().getEmpleado(legajo); 
        System.out.println("empleado original "+empOriginal.getLegajo());
        if (empOriginal.getLegajo() !=Integer.parseInt(txtLegajo.getText().trim())) {
             // el empleado modifico el legajo
            Empleado empLeg = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText().trim()));  
             if (empLeg!=null) {
                 todoOk = false;
                 JOptionPane.showMessageDialog(this, "El LEGAJO ya existe");
             }
         }
        return todoOk;
     }
     
     public boolean validarEmpleadoNuevo(){
         boolean todoOk=false;
         try{
         Empleado empLeg = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText().trim()));
         System.out.println("Variable empLeg: "+empLeg);
             //actualizar
             
             if (empLeg ==null){
                 todoOk= true;
             }else{
                 if (empLeg!=null) {
                   JOptionPane.showMessageDialog(this, "El LEGAJO ya existe");
                } 
             }
           }catch(Exception ex){
              JOptionPane.showMessageDialog(this, "El campo LEGAJO no puede estar vacio");
              todoOk=false;
         }   
         return todoOk;
     }
     
     public Empleado getDatosEmpleado(){
        
        Empleado empleado = new Empleado();
        Sucursal sucursal = null;
        String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
                System.out.println("Cod: "+cod);
                if (cod.charAt(1) == '-'){
                    sucursal = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
                }else{
                    sucursal = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
                }
        empleado.setSucursal(sucursal);
        System.out.println("Legajo "+Integer.parseInt(txtLegajo.getText()));
        empleado.setLegajo(Integer.parseInt(txtLegajo.getText()));
        empleado.setApellido(txtApellido.getText());
        empleado.setNombre(txtNombre.getText());
        empleado.setCodEmp(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
        int v = Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0)));
        System.out.println("Cod Emp "+v);
        empleado.setCuit(txtCuit.getText());
        empleado.setConvenio(txtConvenio.getText());
        empleado.setTarea(txtTarea.getText());
        
        return empleado;
     }
     
      private void setEditableVentanaInformacionEmpleado(boolean logico) {
        // editable la ventana configuarcion
        // cajas de texto
        txtLegajo.setEditable(logico);
        txtApellido.setEditable(logico);
        txtNombre.setEditable(logico);
        txtCuit.setEditable(logico);
        txtConvenio.setEditable(logico);
        txtTarea.setEditable(logico);
        btnGuardar.setEnabled(logico);
        btneEliminar.setEnabled(logico);
        //foco
        txtLegajo.requestFocus();
       
       
    }
     
      private void setEnableVentanaInformacionEmpleado(boolean logico) {
        // editable la ventana configuarcion
        // cajas de texto
        txtLegajo.setEnabled(logico);
        txtApellido.setEnabled(logico);
        txtNombre.setEnabled(logico);
        txtCuit.setEnabled(logico);
        txtConvenio.setEnabled(logico);
        txtTarea.setEnabled(logico);
        btnCancelar.setEnabled(logico);
        btnGuardar.setEnabled(logico);
        btneEliminar.setEnabled(logico);
        //foco
        txtLegajo.requestFocus();
       
       
    }

    private void configurarParaEditar() {
        Empleado e = new EmpleadoDaoImp().getEmpleado(legajo);
        txtLegajo.setText(String.valueOf(e.getLegajo()));
        txtApellido.setText(e.getApellido());
        txtNombre.setText(e.getNombre());
        txtCuit.setText(String.valueOf(e.getCuit()));
        txtConvenio.setText(e.getConvenio());
        txtTarea.setText(e.getTarea());
    }
    
    public void llenaCmbEmpresa() {
        Session sesion = null;
        try {
            sesion = Conexion.getSession();
            Criteria crit = sesion.createCriteria(Empresa.class);
            List<Empresa> rsConcepto = crit.list();// SELECT * FROM TABLA
            cmbEmpresa.removeAllItems();
            
            for (Empresa emp : rsConcepto) {
                cmbEmpresa.addItem(emp.getCodEmp()+"-"+ emp.getNombre());
                System.out.println(emp.getCodEmp()+"-"+emp.getNombre());
            }
//            sesion.close();
            //JOptionPane.showMessageDialog(this, "Factor creado Satisfactoriamente", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenaCmbSucursal(int codEmp) {
//        Empresa emp = new EmpresaDaoImp().getEmpresa(cmbEmpresa.getSelectedItem().toString().charAt(0));
        Session sesion;
        System.out.println("codEmp: "+codEmp);
        try{
            sesion = Conexion.getSession();
            String sql = "from Sucursal as s join fetch s.empresa as e where e.codEmp = '"+codEmp+"'";
//            Criteria crit = sesion.createCriteria(Sucursal.class);
//            List<Sucursal> rsSucursal = crit.list();
            List<Sucursal> rsSucursal = (List<Sucursal>)sesion.createQuery(sql).list();
            System.out.println("rsSucursal: "+rsSucursal);
            cmbSucursal.removeAllItems();
            for(Sucursal suc : rsSucursal){
                cmbSucursal.addItem(suc.getCodSuc()+"-"+suc.getNombre());
            }
            sesion.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
