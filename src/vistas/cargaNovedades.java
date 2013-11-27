/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import hibernateUtil.Conexion;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import novedades.dao.imp.ConceptoDaoImp;
import novedades.dao.imp.EmpleadoDaoImp;
import novedades.dao.imp.NovedadDaoImp;
import novedades.dao.imp.UsuarioDaoImp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;
import pojo.Usuario;
import util.FechaUtil;
//import vista.novedades.prueba;



/**
 *
 * @author usuario
 */
public class cargaNovedades extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private Empleado e = new Empleado();
    private Novedad novedad = new Novedad();
    private Concepto c= new Concepto();
    private Usuario usuario= new Usuario();
    int legajo = 0;
    Date date = new Date();
    DateFormat df = DateFormat.getDateInstance();
    Date ultimaCarga;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JComboBox jcb = new JComboBox();
    
               
   public cargaNovedades(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        cargarTablaNovedades();
    
        llenaJComboBoxInvestigacion();
         jcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroActionPerformed(evt);
            }

            private void jcbFiltroActionPerformed(ActionEvent evt) {
                if(!isCualitiva(jcb.getSelectedItem().toString())){
                   // bloquear las columna 4
                 int fila= tblNovedadesUsr.getSelectedRow();
                 tblNovedadesUsr.setColumnSelectionInterval(fila, 4);
                 tblNovedadesUsr.getModel().isCellEditable(fila, 4);
                }
            }

            private boolean isCualitiva(String descrip) {
                boolean b = false;
                Concepto c = new ConceptoDaoImp().getConceptoHql(descrip);
                System.out.println("Descripcion "+c.getTipo());
                if ("CUALITATIVA".equalsIgnoreCase(c.getTipo())) {
                   b = true;  
                } 
                return b;
            }
        });
        TableColumn tc = tblNovedadesUsr.getColumnModel().getColumn(3);
        
        TableCellEditor tce = new DefaultCellEditor(jcb);
        tc.setCellEditor(tce);
        tblNovedadesUsr.setAutoCreateRowSorter(true);
        
        lblFecha.setText(sdf.format(date));
        ultimaCarga = new Date(sdf.format(date));
        System.out.println("Ultima Carga: "+ultimaCarga);
        
        lblEmpresa.setText(usuario.getEmpleado().getSucursal().getEmpresa().getCodEmp()+"-"+usuario.getEmpleado().getSucursal().getEmpresa().getNombre());
        System.out.println("Usuario: "+this.usuario.getTipo());
        lblSucursal.setText(usuario.getEmpleado().getSucursal().getCodSuc()+"-"+usuario.getEmpleado().getSucursal().getNombre());
        
//        if (lblFecha.getText() == novedad.getFecha()){
//            
//        }
        
        // si el usuario ya cargo novedad cuando ingrese a esta ventana solo puede ver y no cargar 
        // en sintesis se debe inhabilitar el boton carga
//        if (usuario.getCargo() && usuario.getUltimoIngreso().equals(new Date())) {
//        usuario.setCargo(false);
        String ultimoing = util.FechaUtil.getFechaString10DDMMAAAA(usuario.getUltimoIngreso());
        Date fecha = util.FechaUtil.getFechaSinhora(date);
        System.out.println("ultimo: "+fecha);
//        String hoy = util.FechaUtil.getFechaString10DDMMAAAA(new Date());
        Date hoy = util.FechaUtil.getFechaSinhora(date);
        System.out.println("hoy: "+ultimoing);
        System.out.println("Cargo?: "+usuario.getCargo());
        System.out.println("Cargo?: "+ultimoing.equals(hoy));
        if(!ultimoing.equals(hoy)){
            usuario.setCargo(false);
        }
       
        if (ultimoing.equals(hoy) || usuario.getCargo()) {
            System.out.println("estoy aqui!!");
            btnCargar.setEnabled(true);
            // mostrar las novedades  cargados en la tabla
//            cargarTablaNovedadesCompleta();
            
        }else {
//           usuario.setCargo(false);
           btnCargar.setEnabled(true);
       }
         
        
        setLocationRelativeTo(this);
        setVisible(true);
        
        usuario.setUltimoIngreso(new Date());
    }
           
    public cargaNovedades(){
        
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
        btnCargar = new org.edisoncor.gui.button.ButtonIpod();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        lblFecha = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNovedadesUsr = new javax.swing.JTable();
        lblEmpresa = new org.edisoncor.gui.label.LabelMetric();
        lblSucursal = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Floorboard & Wall - Green by ABH 1680x1050.jpg"))); // NOI18N

        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.setDistanciaDeSombra(45);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        btnCargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCargarKeyPressed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        tblNovedadesUsr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "0 - Sin Novedad", "0", "-"}
            },
            new String [] {
                "LEGAJO", "APELLIDO", "NOMBRE", "NOVEDAD", "CANTIDAD", "OBSERVACION"
            }
        ));
        tblNovedadesUsr.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblNovedadesUsr);

        lblEmpresa.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        lblEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblSucursal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblSucursal.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lblEmpresa.getAccessibleContext().setAccessibleName("3 - FERNANDO MANZUR SUCURSAL");

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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        int i;
        try{
        ArrayList nov = null;
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Novedad as n join fetch n.empleado as e where e.legajo = '"+tblNovedadesUsr.getValueAt(0, 0)+"' and n.fecha = '"+lblFecha.getText()+"'";
        nov = (ArrayList)session.createQuery(sql).list();
        session.getTransaction().commit();
        session.close();
        System.out.println("nov: "+nov);
//        tblNovedadesUsr.getCellEditor().stopCellEditing();
//        if (lblFecha.getText() == novedad.getFecha()){
//            JOptionPane.showMessageDialog(rootPane, "LOS DATOS YA FUERON CARGADOS");
//        }else{
//            getDatosTabla(WIDTH);
//        }
     
        if (nov.isEmpty()){
            if(tblNovedadesUsr.isEditing()){
                tblNovedadesUsr.getCellEditor().stopCellEditing();
                System.out.println("Entro");
                for( i = 0;i < tblNovedadesUsr.getRowCount();i++){
                    System.out.println(i);
                    getDatosTabla(i);
//                    novedad.setFecha(lblFecha.getText().toString);
                    novedad.setFecha(FechaUtil.getFechaSinhora(date));
                    usuario.setCargo(true);
                    new NovedadDaoImp().addNovedad(novedad);
                    new UsuarioDaoImp().upDateUsuario(usuario);
                }
                JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
            }else{
                for( i = 0;i < tblNovedadesUsr.getRowCount();i++){
                    System.out.println(i);
                    getDatosTabla(i);
                    novedad.setFecha(date);
                    novedad.setFecha((date));
                    usuario.setCargo(true);
                    new NovedadDaoImp().addNovedad(novedad);
                    new UsuarioDaoImp().upDateUsuario(usuario);
                }
                JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "LOS DATOS YA FUERON CARGADOS ANTERIORMENTE, INTENTE MAÑANA NUEVAMENTE");
            cargarTablaNovedadesCompleta();
        }
        this.dispose();
     }catch(NullPointerException ex){
            System.out.println(ex);
            for( i = 0;i < tblNovedadesUsr.getRowCount();i++){
                    System.out.println(i);
                    getDatosTablaNull(i);
                    novedad.setCantidad(0);
                    novedad.setObservacion("-");
                    novedad.setFecha(date);
                    usuario.setCargo(true);
                    new NovedadDaoImp().addNovedad(novedad);
                    new UsuarioDaoImp().upDateUsuario(usuario);
                }
            JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
            this.dispose();
     }
        
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnCargarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCargarKeyPressed
        
    }//GEN-LAST:event_btnCargarKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnCargar;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.label.LabelMetric lblEmpresa;
    private org.edisoncor.gui.label.LabelMetric lblFecha;
    private org.edisoncor.gui.label.LabelMetric lblSucursal;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblNovedadesUsr;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaNovedades(){
        List<Empleado> listaEmpleado = new EmpleadoDaoImp().listarEmpleado(usuario.getEmpleado().getSucursal().getEmpresa().getCodEmp(), usuario.getEmpleado().getSucursal().getCodSuc());
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr);
        util.TablaUtil.cargarModeloNovedades(modelo, listaEmpleado, tblNovedadesUsr);
    }
     
    private void getDatosTabla(int i){
        e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedadesUsr.getValueAt(i, 0).toString()));
        novedad.setEmpleado(e);
        c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedadesUsr.getValueAt(i, 3).toString()));
        novedad.setConcepto(c);
        novedad.setCantidad(Integer.parseInt(tblNovedadesUsr.getValueAt(i, 4).toString()));
        novedad.setObservacion(tblNovedadesUsr.getValueAt(i, 5).toString());
        System.out.println(lblFecha.getText());
        System.out.println();
    }
    
       private void getDatosTablaNull(int i){
        e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedadesUsr.getValueAt(i, 0).toString()));
        novedad.setEmpleado(e);
        c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedadesUsr.getValueAt(i, 3).toString()));
        novedad.setConcepto(c);
        System.out.println(lblFecha.getText());
        System.out.println();
    }
       
   public void llenaJComboBoxInvestigacion() {
        Session session = null;
        int i = 0;
        try {
            if (usuario.getTipo().equals("COMUN")){
                session = Conexion.getSession();
                boolean cargar = true;
                Criteria crit = session.createCriteria(Concepto.class);
                crit.add(Restrictions.eq("cargaUser", cargar));
                List<Concepto> liscon = crit.list();
                for (Concepto inv : liscon){
                    jcb.addItem(inv.getDescripcion());
//                    i++;
                }
                session.close();
            }else{
                session = Conexion.getSession();
                Criteria crit = session.createCriteria(Concepto.class);
                List<Concepto> rsConcepto = crit.list();// SELECT * FROM TABLA
                jcb.removeAllItems();
                for (Concepto inv : rsConcepto) {
                    jcb.addItem(inv.getDescripcion());
                }
                session.close();
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
   }      
   
   public void cargaCantidad(){
//       Concepto con = new ConceptoDaoImp().getConcepto(Integer.parseInt(tblNovedadesUsr.getValueAt(0, 4).toString()));
       Concepto con = new ConceptoDaoImp().getConcepto(Integer.parseInt(String.valueOf(tblNovedadesUsr.getValueAt(0, 4).toString().charAt(0))));
       if(con.getCargaUser()){
//           tblNovedadesUsr.set;
       }
   }

    private void cargarTablaNovedadesCompleta() {
        List<Novedad> listaEmpleado = new NovedadDaoImp().listarNovedad(date);
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr);
        util.TablaUtil.cargarNovedadesCompleta(modelo, listaEmpleado, tblNovedadesUsr);
    }
   
}