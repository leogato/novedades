/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.empleado;

import hibernateUtil.Conexion;
import pojo.Empleado;
import novedades.dao.imp.EmpleadoDaoImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import novedades.dao.imp.EmpresaDaoImp;
import novedades.dao.imp.NovedadDaoImp;
import novedades.dao.imp.SucursalDaoImp;
import org.hibernate.Session;
import pojo.Empresa;
import pojo.Sucursal;
import util.FechaUtil;
import util.TablaUtil;

/**
 *
 * @author Joel
 */
public class GestorEmpleado extends javax.swing.JDialog {
    public static final int VENTANA_GESTOR_ASISTENCIA=1;
    public static final int MENU=2;
    public   boolean isModificar = false;// paramentro global uso: para ver si se presiono un boton agregar o moficar
                                         // sirve para configuarar ventnana infomracion  empleado
    private DefaultTableModel modelo;
    private List<Empleado> listaEmpleado;
    private boolean seleccionado;
    private int legajo;
    
    int quienloyamo;
    java.awt.Frame parent;// indica quien es el padre. me sirve para pasar el icono de la aplcacion
   
    public GestorEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        initComponentesVentana();    
        this.setTitle("MODIFICACION DE EMPLEADO");
        llenaCmbEmpresa();
        btnBuscar.setVisible(false);
        setLocationRelativeTo(this);
        setVisible(true);
        
        
    }
    public GestorEmpleado(java.awt.Frame parent, boolean modal,int quienloyamo) {
        super(parent, modal);
        this.parent = parent;
        this.quienloyamo = quienloyamo;
        initComponents();
        this.setTitle("ALTA DE EMPLEADO");
        llenaCmbEmpresa();
        if (MENU== quienloyamo) {
            //boton seleccionar no debe aparecer
        }else{
           // buscador de empleado
            this.setSize(this.getWidth(),this.getHeight()-btnModificar.getWidth() );
            btnNuevo.setVisible(false);
            btnModificar.setVisible(false);
            btnCancelarOperacion.setVisible(false);
            btnBuscar.setVisible(true);
        }
        initComponentesVentana();  
        setLocationRelativeTo(this);
        setVisible(true);
    }
   
    public void initComponentesVentana(){
        btnModificar.setEnabled(false);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete21 = new org.edisoncor.gui.panel.PanelTranslucidoComplete2();
        btnNuevo = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelarOperacion = new org.edisoncor.gui.button.ButtonIpod();
        btnModificar = new org.edisoncor.gui.button.ButtonIpod();
        btnBuscar = new org.edisoncor.gui.button.ButtonIcon();
        panelShadow2 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete22 = new org.edisoncor.gui.panel.PanelTranslucidoComplete2();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        cmbEmpresa = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        cmbSucursal = new org.edisoncor.gui.comboBox.ComboBoxRound();
        btnFiltro = new org.edisoncor.gui.button.ButtonIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "GESTOR DE EMPLEADOS", 2, 2, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        tblEmpleado.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LEGAJO", "APELLIDO", "NOMBRE", "EMPRESA", "SUCURSAL", "CUIT", "CONVENIO", "TAREA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseClicked(evt);
            }
        });
        tblEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblEmpleadoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleado);
        tblEmpleado.getColumnModel().getColumn(0).setResizable(false);
        tblEmpleado.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblEmpleado.getColumnModel().getColumn(1).setResizable(false);
        tblEmpleado.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblEmpleado.getColumnModel().getColumn(2).setResizable(false);
        tblEmpleado.getColumnModel().getColumn(2).setPreferredWidth(120);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 186, 1081, 170));

        panelShadow1.setDistance(20);
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTranslucidoComplete21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adduser.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setAnimacion(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelTranslucidoComplete21.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, -1));

        btnCancelarOperacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnCancelarOperacion.setText("ATRAS");
        btnCancelarOperacion.setAnimacion(false);
        btnCancelarOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOperacionActionPerformed(evt);
            }
        });
        panelTranslucidoComplete21.add(btnCancelarOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 81, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        btnModificar.setText("MODIFIC");
        btnModificar.setAnimacion(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panelTranslucidoComplete21.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/OK.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setAngulo(120);
        btnBuscar.setDistanciaDeSombra(45);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelTranslucidoComplete21.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 67, 67));

        panelShadow1.add(panelTranslucidoComplete21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 1070, 100));

        panel1.add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 1080, 120));

        panelShadow2.setDistance(20);

        panelTranslucidoComplete22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), "FILTRO", 2, 0, null, java.awt.Color.white));

        labelMetric1.setText("Empresa");

        cmbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpresaItemStateChanged(evt);
            }
        });

        labelMetric2.setText("Sucursal");

        btnFiltro.setBackground(new java.awt.Color(51, 51, 51));
        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnFiltro.setText("Filtro");
        btnFiltro.setToolTipText("");
        btnFiltro.setAngulo(120);
        btnFiltro.setDistanciaDeSombra(45);
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucidoComplete22Layout = new javax.swing.GroupLayout(panelTranslucidoComplete22);
        panelTranslucidoComplete22.setLayout(panelTranslucidoComplete22Layout);
        panelTranslucidoComplete22Layout.setHorizontalGroup(
            panelTranslucidoComplete22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete22Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        panelTranslucidoComplete22Layout.setVerticalGroup(
            panelTranslucidoComplete22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete22Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelTranslucidoComplete22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(panelTranslucidoComplete22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        panel1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1090, 130));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isBotonSeleccionado() {
        return seleccionado;
    }

    public int getLegajo() {
        return legajo;
    }
      
    private void buttonIpod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIpod1ActionPerformed
    }//GEN-LAST:event_buttonIpod1ActionPerformed

    private void buttonIpod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIpod2ActionPerformed
     
    }//GEN-LAST:event_buttonIpod2ActionPerformed

    private void btnCancelarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOperacionActionPerformed
       // cancela la operacion actual
        this.dispose();
    }//GEN-LAST:event_btnCancelarOperacionActionPerformed

    private void tblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMouseClicked
           int fila = tblEmpleado.getSelectedRow();
        if (fila!= -1) {
            btnBuscar.setVisible(false);
            btnModificar.setEnabled(true);  
            System.out.println("selecciono con el mouse");
        }
    }//GEN-LAST:event_tblEmpleadoMouseClicked

    private void tblEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEmpleadoKeyPressed
//        if (!isModificar) {
//           if (evt.getKeyCode()==KeyEvent.VK_ENTER){
//        int fila = tblEmpleado.getSelectedRow();
//        if (fila!= -1) {
//        modelo =(DefaultTableModel)tblEmpleado.getModel();
//        legajo = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
//            if (quienloyamo==MENU) {
//                 Empleado empleado = new EmpleadoDaoImp().getEmpleado(legajo);
//                 System.out.println(empleado.getApellido());
//                 btnModificar.setEnabled(true);    
//            }
//       
//        }
//       }
            
//      }
        
        
    }//GEN-LAST:event_tblEmpleadoKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = tblEmpleado.getSelectedRow();
        if (fila!= -1) {
            legajo = (Integer) tblEmpleado.getModel().getValueAt(tblEmpleado.getSelectedRow(), 0);
            //LLAMAR A A LA VENTANA NUEVO EMPLEADO PARA EDITAR
            AltaEmpleado ventanaEditEmpleado = new AltaEmpleado(parent, true, legajo);
        }else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar un Empleado de la Tabla");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        AltaEmpleado ventanaNuevoEmpleado = new AltaEmpleado(parent, true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cmbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpresaItemStateChanged
        llenaCmbSucursal(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
    }//GEN-LAST:event_cmbEmpresaItemStateChanged

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        Sucursal suc;
        String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
        if (cod.charAt(1) == '-'){
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
                }else{
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
                }
        if(suc.getNombre().equals("TODAS")){
            System.out.println("cod emp :"+suc.getEmpresa().getCodEmp()+" cod Suc: "+suc.getCodSuc());
            listaEmpleado =new EmpleadoDaoImp().listarEmpleado(suc.getEmpresa());
        }else{
            System.out.println("cod Suc: "+suc.getCodSuc());
            listaEmpleado =new EmpleadoDaoImp().listarEmpleado(suc.getCodSuc());
        }
        util.TablaUtil.prepararTablaEmpleado(modelo, tblEmpleado);
        util.TablaUtil.cargarModeloEmpleado(modelo, listaEmpleado, tblEmpleado);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int fila = tblEmpleado.getSelectedRow();
        if (fila== -1) {
            // no se selecciono ninguna fila de la lista
            JOptionPane.showMessageDialog(null, "debes seleccionar un Empleado ", "Informacion",JOptionPane.INFORMATION_MESSAGE);
        } else {
            seleccionado = true;
            modelo = (DefaultTableModel)tblEmpleado.getModel();
            legajo = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
            this.dispose();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
      
    private void permitirSoloNumero(java.awt.event.KeyEvent evt) {
      // permitir solo el ingreso de numero
        char caracter = evt.getKeyChar();
        if(((caracter < '0') ||
            (caracter > '9')) &&
            (caracter != '\b' /*corresponde a BACK_SPACE*/)){
            evt.consume();  // ignorar el evento de teclado
        }
       
    }    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIcon btnBuscar;
    private org.edisoncor.gui.button.ButtonIpod btnCancelarOperacion;
    private org.edisoncor.gui.button.ButtonIcon btnFiltro;
    private org.edisoncor.gui.button.ButtonIpod btnModificar;
    private org.edisoncor.gui.button.ButtonIpod btnNuevo;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbEmpresa;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbSucursal;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow2;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete2 panelTranslucidoComplete21;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete2 panelTranslucidoComplete22;
    private javax.swing.JTable tblEmpleado;
    // End of variables declaration//GEN-END:variables

    /**
     * PREPERARA Y CARAGA LA TABLA EMPLEADO CON DATOS 
     */
//    private void cargarTablaConEmpleado() {
//        Sucursal suc;
//        String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
//        if (cod.charAt(1) == '-'){
//                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
//                }else{
//                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
//                }
//        
//        listaEmpleado =new EmpleadoDaoImp().listarEmpleado(suc.getCodSuc());
//        util.TablaUtil.prepararTablaEmpleado(modelo, tblEmpleado);
//        util.TablaUtil.cargarModeloEmpleado(modelo, listaEmpleado, tblEmpleado);
//    }

    
    

   /**
    * 
    * @param logico indica que los componetnes estara o no editables
    * @param isModificado indica si se va a editar para agregar o modificar un empleado existente
    * en caso de que sea un empleado existente las cajas legajo,clave,y repertir clave se mantendran no editable
    */
     
          
     private void llenaCmbEmpresa(){
        Session sesion;
        try{
            sesion = Conexion.getSession();
            sesion.beginTransaction();
            String sql = "from Empresa as e where e.estado = true";
            List<Empresa> rsEmpresa = (List<Empresa>)sesion.createQuery(sql).list();
            cmbEmpresa.removeAllItems();
            for(Empresa emp : rsEmpresa){
                cmbEmpresa.addItem(emp.getCodEmp()+"-"+emp.getNombre());
            }
            sesion.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
     private void llenaCmbSucursal(int codEmp) {
        Session sesion;
        try{
            sesion = Conexion.getSession();
            String sql = "from Sucursal as s join fetch s.empresa as e where e.codEmp = '"+codEmp+"'";
            List<Sucursal> rsSucursal = (List<Sucursal>)sesion.createQuery(sql).list();
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

     

