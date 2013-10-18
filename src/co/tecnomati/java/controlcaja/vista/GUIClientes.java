/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Cliente;
import co.tecnomati.java.controlcaja.dominio.dao.ClienteDAO;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.util.mensajero;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AnahiAramayo
 */
public class GUIClientes extends javax.swing.JDialog {
private boolean modificar=false;
    Cliente cliente;
    boolean agregado=false;
    /**
     * Creates new form GUIClientes
     */
    public GUIClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        cliente = new Cliente();    
    
        SNumeros(txtCuit);
        SNumeros(txtTelefono);
        //SLetras(txtDomicilio);
        SLetras(txtRazonSocial);
      
        this.setTitle(Constantes.NAME_NUEVO_CLIENTE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public GUIClientes(java.awt.Frame parent, boolean modal,Cliente cliente ) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
         modificar = true;
        this.setTitle(Constantes.NAME_NUEVO_PROVEEDOR);
        setDatos(cliente);
        
        SNumeros(txtCuit);
        SNumeros(txtTelefono);
        //SLetras(txtDomicilio);
        SLetras(txtRazonSocial);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

   public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
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
        labelCuit = new org.edisoncor.gui.label.LabelMetric();
        txtCuit = new org.edisoncor.gui.textField.TextField();
        txtRazonSocial = new org.edisoncor.gui.textField.TextField();
        labelRazonSocial = new org.edisoncor.gui.label.LabelMetric();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        labelRazonSocial1 = new org.edisoncor.gui.label.LabelMetric();
        txtDomicilio = new org.edisoncor.gui.textField.TextField();
        txtTelefono = new org.edisoncor.gui.textField.TextField();
        labelRazonSocial2 = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelCuit.setText("CUIT");

        txtCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuitActionPerformed(evt);
            }
        });

        labelRazonSocial.setText("Razon Social");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        labelRazonSocial1.setText("Domicilio");

        labelRazonSocial2.setText("Telefono");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelRazonSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRazonSocial2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(labelCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuitActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean b = false;   
        if (modificar == false) {
           //si se ingresa un nueva persona
           cliente = new Cliente();    
        }
       ClienteDAO clienteDAO = new ClienteDaoImp();
     try {
         boolean cA, cRS, cD, cT = false;
            cA = txtCuit.getText().trim().isEmpty();
            cRS = txtRazonSocial.getText().trim().isEmpty();
            cD = txtDomicilio.getText().trim().isEmpty();
            cT = txtTelefono.getText().trim().isEmpty();
            //corroboro que no este vacio
            if (cA || cRS || cT || cD) {
               if (cA) {
                mensajero.mensajeError(null, "Tipo cuit no puede estar vacio");
            } else if (cRS) {
                mensajero.mensajeError(null, "razon no puede estar vacio");
            } else if (cD) {
                mensajero.mensajeError(null, "domicilio no puede estar vacio");
            } else if (cT) {
                mensajero.mensajeError(null, "telefono no puede estar vacio");
            } 
        } else {
           
            cliente.setCuit(txtCuit.getText());
            cliente.setRazonSocial(txtRazonSocial.getText().toUpperCase());
            cliente.setDomicilio(txtDomicilio.getText().toUpperCase());
            cliente.setTelefono(txtTelefono.getText().toUpperCase());
            setAgregado(true);
            
            
            //se crea un proveedor nuevo
            if (modificar == false) {
                clienteDAO.addCliente(cliente);
            } else {
                //se carga un proveedor para editarlo
                clienteDAO.upDateCliente(cliente);
                
            }
            //setAgregado(true);
            JOptionPane.showMessageDialog(null, "Se cargo correctamente...");
            this.dispose();
        } }catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
        modificar = false;
        this.dispose();
}
    }//GEN-LAST:event_btnGuardarActionPerformed

     /**
     * Setea el formulario con los datos de proveedor pasado por parametro
     *
     * @param cliente es la persona que se desea que se muestre en el
     * formulario
     */
    public void setDatos(Cliente cliente) {
        txtCuit.setText(String.valueOf(cliente.getCuit()));
        txtRazonSocial.setText(cliente.getRazonSocial());
        txtDomicilio.setText(cliente.getDomicilio());
        txtTelefono.setText(cliente.getTelefono());
    }

    /**
     * Devuelve un objeto cliente a partir de los datos que existe en el
     * formulario
     *
     * @return
     */
    public void getDatos() {
       
        cliente.setCuit(txtCuit.getText());
        cliente.setRazonSocial(txtRazonSocial.getText());
        cliente.setTelefono(txtTelefono.getText().trim());
        cliente.setDomicilio(txtDomicilio.getText().trim());
        
    }

    
    
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
            java.util.logging.Logger.getLogger(GUIClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIClientes dialog = new GUIClientes(new javax.swing.JFrame(), true);
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
    
        public void SLetras(JTextField a){
    a.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent v){
            char c=v.getKeyChar();
            if (Character.isDigit(c)){
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo Letras...");
                v.consume();
            }
        }
    });
            }
      public void SNumeros(JTextField a){
    a.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent v){
            char c=v.getKeyChar();
            if (!Character.isDigit(c)){
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo Nùmeros...");
                v.consume();
            }
        }
    });
            }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private org.edisoncor.gui.label.LabelMetric labelCuit;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial1;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextField txtCuit;
    private org.edisoncor.gui.textField.TextField txtDomicilio;
    private org.edisoncor.gui.textField.TextField txtRazonSocial;
    private org.edisoncor.gui.textField.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
