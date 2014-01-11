/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.sucursal;

import vistas.empleado.*;
import pojo.Empleado;
import novedades.dao.imp.EmpleadoDaoImp;
import javax.swing.JOptionPane;
import novedades.dao.imp.UsuarioDaoImp;
import pojo.Usuario;

/**
 *
 * @author Leo
 */
public class AltaUsuario extends javax.swing.JDialog {

    public static final int GESTOR_EMPLEADO =1;
    private int legajo=0;
    private boolean BotonGuardarSelecciono=false;

    public boolean isBotonGuardarSelecciono() {
        return BotonGuardarSelecciono;
    }
    /**
     * Creates new form Personal
     */
    
    
    public AltaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btneEliminar.setVisible(false);
        btneEliminar.setEnabled(false);
        this.setTitle("NUEVO USUARIO");
        setLocationRelativeTo(this);
        setVisible(true);
        // no se realizara la carga de foto
       
        
        
    }
    
    public AltaUsuario(java.awt.Frame parent, boolean modal,int legajo) {
        super(parent, modal);
        initComponents();
        this.setTitle("EDITAR EMPLEADO");
        this.legajo = legajo;
        btneEliminar.setVisible(true);
        btnBuscar.setVisible(false);
        Empleado e = new EmpleadoDaoImp().getEmpleado(legajo);
        Usuario u = new Usuario();
        u.setEmpleado(e);
        configurarParaEditar();
        setLocationRelativeTo(this); 
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        elegirFichero = new javax.swing.JFileChooser();
        pnlPrincipal = new org.edisoncor.gui.panel.Panel();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        btneEliminar = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        labelMetric11 = new org.edisoncor.gui.label.LabelMetric();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        txtLegajo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric14 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric16 = new org.edisoncor.gui.label.LabelMetric();
        txtContrasenia = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();
        cmbTipo = new org.edisoncor.gui.comboBox.ComboBoxRound();
        btnBuscar = new org.edisoncor.gui.button.ButtonIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", 2, 2, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N
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

        labelMetric11.setText("DESCRIPCION");

        txtDescripcion.setBackground(new java.awt.Color(102, 102, 102));
        txtDescripcion.setBorder(null);
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescripcion.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtDescripcion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        txtUsuario.setBackground(new java.awt.Color(102, 102, 102));
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUsuario.setCaretColor(new java.awt.Color(255, 102, 0));
        txtUsuario.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtUsuario.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        labelMetric10.setText("USUARIO");

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

        labelMetric14.setText("CLAVE");

        labelMetric16.setText("TIPO");

        txtContrasenia.setBackground(new java.awt.Color(102, 102, 102));
        txtContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setColorDeBorde(new java.awt.Color(255, 102, 0));

        cmbTipo.setBackground(new java.awt.Color(102, 102, 102));
        cmbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ADMINISTRADOR", "COMUN" }));
        cmbTipo.setAnchoDeBorde(2.0F);
        cmbTipo.setColorDeBorde(new java.awt.Color(255, 102, 0));

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/binoculares.png"))); // NOI18N
        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btneEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(cmbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
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
    }// </editor-fold>                        

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {                                   
        permitirSoloNumero(evt);
    }                                  

    private void txtLegajoKeyPressed(java.awt.event.KeyEvent evt) {                                     

    }                                    

    private void txtLegajoFocusLost(java.awt.event.FocusEvent evt) {                                    

        //        //validar el empleado
        //
        //         try{
            //        Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText()));
            //         if (e!=null) {
                //            mensajero.mensajeError(this, "YA EXISTE EL EMPLEADO CON LEGAJO ="+e.getLegajo());
                //            txtLegajo.setText("");
                //            txtLegajo.requestFocus();
                //        }else{
                //             // es uno legajo nuevo , por defecto la clave sera la misma que su legajo
                //             txtClave.setText(txtLegajo.getText());
                //             txtClaveRepetir.setText(txtLegajo.getText());
                //             txtApellido.requestFocus();
                //         }
            //        }catch(Exception eee){
            //            if (!btnCancelarOperacion.isEnabled() ||txtLegajo.getText().trim().isEmpty() ) {
                //            mensajero.mensajeError(this, "NO PUEDE ESTAR VACIEO EL CAMPO LEGAJO");
                //            txtLegajo.setText("");
                //            txtLegajo.requestFocus();
                //        }
            //        }
    }                                   

    private void txtLegajoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // cancela la operacion actual
        txtLegajo.setEnabled(false);//  esto  es para que no capture el evento foculost de txtlegajo
        this.dispose();
    }                                           

    private void btneEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        //        limpiarVenanaEmpleado();
        //        setEnableVentanaInformacionEmpleado(true);
        int resp =JOptionPane.showConfirmDialog(rootPane,"Esta seguro de eliminar el Usuario: \n"+txtUsuario.getText()+" ?", "ELIMINAR USUARIO",JOptionPane.OK_CANCEL_OPTION);
        if (resp==JOptionPane.OK_OPTION) {
            Usuario u = new UsuarioDaoImp().getUsuario(legajo);
//            u.setEstado(false);
            new UsuarioDaoImp().deleteUsuario(u);
            JOptionPane.showMessageDialog(rootPane, "La Eliminacion se realizo exitosamente ", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }                                            

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //               try{
            //obtengos los datos ingresados
        if (legajo==0){
            Usuario u = new Usuario();
            Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText()));
            u.setEmpleado(e);
            u = getDatosUsuario();
            new UsuarioDaoImp().addUsuario(u);
            this.dispose();
        }else{
            Usuario u = new Usuario();
            Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText()));
            u.setEmpleado(e);
            u = getDatosUsuario();
            new UsuarioDaoImp().upDateUsuario(u);
            this.dispose();
        }
    }                                          
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        GestorEmpleado ventanaPersonal = new GestorEmpleado(null, true, GestorEmpleado.VENTANA_GESTOR_ASISTENCIA);
        if (ventanaPersonal.isBotonSeleccionado()) {
            // si el usuario selecciono un empleado
            Empleado e = new EmpleadoDaoImp().getEmpleado(ventanaPersonal.getLegajo());
            txtLegajo.setText(String.valueOf(e.getLegajo()));
            txtUsuario.setText(e.getNombre().charAt(0)+e.getApellido());
            txtDescripcion.requestFocus();
        }
    }                                         
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
    // Variables declaration - do not modify                     
    private org.edisoncor.gui.button.ButtonIcon btnBuscar;
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private org.edisoncor.gui.button.ButtonIpod btneEliminar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbTipo;
    private javax.swing.JFileChooser elegirFichero;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric11;
    private org.edisoncor.gui.label.LabelMetric labelMetric14;
    private org.edisoncor.gui.label.LabelMetric labelMetric16;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel pnlPrincipal;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtContrasenia;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtLegajo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration                   

      
    /**
     * 
     * @return retornaun Objeto tipo Empleado a partir de los datos ingresados por el usuario
     * ademas se encarga de hacer la validaciones de ingreso de datos, en caso de que haya ingresado mal algun 
     * dato , el  metodo retorna NULL
     */
       
     public boolean validarEmpleadoActulizado(){
        boolean todoOk=true;
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

     public Usuario getDatosUsuario(){
         Usuario usuario = new Usuario();
         Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtLegajo.getText()));
         usuario.setEmpleado(e);
         usuario.setId(Integer.parseInt(txtLegajo.getText()));
         usuario.setUsuario(txtUsuario.getText());
         usuario.setDescripcion(txtDescripcion.getText());
         usuario.setClave(txtContrasenia.getText());
         usuario.setTipo(cmbTipo.getSelectedItem().toString());
         usuario.setEstado(true);
         return usuario;
     }
      private void setEditableVentanaInformacionEmpleado(boolean logico) {
        // editable la ventana configuarcion
        // cajas de texto
        txtLegajo.setEditable(logico);
        txtUsuario.setEditable(logico);
        txtDescripcion.setEditable(logico);
        txtContrasenia.setEditable(logico);
        cmbTipo.setEditable(logico);
        btnGuardar.setEnabled(logico);
        btneEliminar.setEnabled(logico);
        //foco
        txtLegajo.requestFocus();
       
       
    }
     
      private void setEnableVentanaInformacionEmpleado(boolean logico) {
        // editable la ventana configuarcion
        // cajas de texto
        txtLegajo.setEnabled(logico);
        txtUsuario.setEnabled(logico);
        txtDescripcion.setEnabled(logico);
        txtContrasenia.setEnabled(logico);
        cmbTipo.setEnabled(logico);
        btnCancelar.setEnabled(logico);
        btnGuardar.setEnabled(logico);
        btneEliminar.setEnabled(logico);
        //foco
        txtLegajo.requestFocus();

      }

    private void configurarParaEditar() {
//        Empleado e = new EmpleadoDaoImp().getEmpleado(legajo);
//        Usuario u = new UsuarioDaoImp().getUsuario(e.getLegajo());
//        if(u.getEstado()){
//            txtLegajo.setText(String.valueOf(e.getLegajo()));
//            txtUsuario.setText(u.getUsuario());
//            txtDescripcion.setText(u.getDescripcion());
//            txtContrasenia.setText(u.getClave());
//            cmbTipo.setSelectedItem(u.getTipo());
//        }else{
//            JOptionPane.showMessageDialog(this, "EL USUARIO SE ENCUENTRA ANULADO");
//        }
        Empleado e = new EmpleadoDaoImp().getEmpleado(legajo);
        Usuario u = new UsuarioDaoImp().getUsuario(e.getLegajo());
        System.out.println("u: "+u);
        System.out.println("e: "+e);
        txtLegajo.setText(String.valueOf(e.getLegajo()));
        txtUsuario.setText(u.getUsuario());
        txtDescripcion.setText(u.getDescripcion());
        txtContrasenia.setText(u.getClave());
        cmbTipo.setSelectedItem(u.getTipo());
        
    }
}