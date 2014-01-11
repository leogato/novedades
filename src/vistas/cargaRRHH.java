/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import hibernateUtil.Conexion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Sucursal;
import pojo.Usuario;
import util.FechaUtil;



/**
 *
 * @author usuario
 */
public class cargaRRHH extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private Empleado e = new Empleado();
    private Novedad novedad = new Novedad();
    private Concepto c= new Concepto();
    private Usuario usuario= new Usuario();
    private Sucursal sucursal = new Sucursal();
    int legajo = 0;
    String auxCant;
    String auxObs;
    String tipo;
    Date fecha;
    Date date = new Date();
    String hoy;
    DateFormat df = DateFormat.getDateInstance();
    Date ultimaCarga;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JComboBox jcb = new JComboBox();
    
               
      public cargaRRHH(java.awt.Frame parent, boolean modal, Sucursal sucursal, Date f, Empresa emp) {
        super(parent, modal);
        initComponents();
        auxCant = sdf.format(f);
        this.sucursal = sucursal;
        this.fecha = f;
        
        cargo();

        btnCargar.setEnabled(true);
        llenaJComboBoxInvestigacioRRHH();
        TableColumn tc = tblNovedadesUsr.getColumnModel().getColumn(4);
        TableCellEditor tce = new DefaultCellEditor(jcb);
        tc.setCellEditor(tce);
        
        tblNovedadesUsr.setAutoCreateRowSorter(true);
        lblFecha.setText(sdf.format(f));
        lblEmpresa.setText(emp.getCodEmp()+"-"+emp.getNombre());
        lblSucursal.setText(sucursal.getCodSuc()+"-"+sucursal.getNombre());
        setLocationRelativeTo(this);
        setVisible(true);
    }
           
    public cargaRRHH(){
        
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
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perseids_tudorica.gif"))); // NOI18N

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        int id;
        if(tblNovedadesUsr.isEditing()){
                tblNovedadesUsr.getCellEditor().stopCellEditing();
                for(int i = 0;i < tblNovedadesUsr.getRowCount();i++){
//                    id = Integer.parseInt(tblNovedadesUsr.getValueAt(i, 0).toString());
//                    novedad = new NovedadDaoImp().getNovedad(id);
                    getDatosTabla(i);
                    System.out.println("novedad: "+novedad);
                    new NovedadDaoImp().addNovedad(novedad);
                }
                JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
            }else{
                for( int i = 0;i < tblNovedadesUsr.getRowCount();i++){
//                    id = Integer.parseInt(tblNovedadesUsr.getValueAt(i, 0).toString());
//                    novedad = new NovedadDaoImp().getNovedad(id);
                    getDatosTabla(i);
                    System.out.println("novedad: "+novedad);
                    new NovedadDaoImp().addNovedad(novedad);
                }
                JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
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

    
     
    private void getDatosTabla(int i){
        auxCant = (String)tblNovedadesUsr.getValueAt(i, 5);
        auxObs = (String)tblNovedadesUsr.getValueAt(i, 6);
        e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedadesUsr.getValueAt(i, 1).toString()));
        novedad.setEmpleado(e);
        c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedadesUsr.getValueAt(i, 4).toString()));
        novedad.setConcepto(c);
        if(auxCant == null){
            novedad.setCantidad(0);
        }else{
            novedad.setCantidad(Integer.parseInt(tblNovedadesUsr.getValueAt(i, 5).toString()));
        }
        if (auxObs == null){
           novedad.setObservacion("-"); 
        }else{
            novedad.setObservacion(tblNovedadesUsr.getValueAt(i, 6).toString());
        }
        System.out.println(lblFecha.getText());
        System.out.println();
    }
    
   public void llenaJComboBoxInvestigacioRRHH() {
        Session session = null;
        int i = 0;
        try {
                session = Conexion.getSession();
                session.beginTransaction();
                String sql = "from Concepto as c\n" +
                             "where c.estado = true";
                List<Concepto> lisCon = session.createQuery(sql).list();
                session.getTransaction().commit();
                jcb.removeAllItems();
                
                for (Concepto inv : lisCon) {
                    jcb.addItem(inv.getDescripcion());
                }
                
                session.close();
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
   
   private void cargarTablaNovedades(){
        List<Empleado> listaEmpleado = new EmpleadoDaoImp().listarEmpleado(usuario.getEmpleado().getSucursal().getEmpresa().getCodEmp(), usuario.getEmpleado().getSucursal().getCodSuc());
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr, tipo);
        util.TablaUtil.cargarModeloNovedades(modelo, listaEmpleado, tblNovedadesUsr);
    }

    private void cargarTablaNovedadesCompleta() {
        System.out.println("CodSuc: "+usuario.getEmpleado().getSucursal().getCodSuc());
        String fecha = FechaUtil.getFechaString11AAAAMMDD(date);
//        List<Empleado> listaEmpleado = new EmpleadoDaoImp().listarEmpleado(usuario.getEmpleado().getSucursal().getEmpresa().getCodEmp(), usuario.getEmpleado().getSucursal().getCodSuc());
        List<Novedad> listaEmpleado = new NovedadDaoImp().listarNovedad(fecha, usuario.getEmpleado().getSucursal().getCodSuc());
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr);
        util.TablaUtil.cargarNovedadesCompleta(modelo, listaEmpleado, tblNovedadesUsr);
    }
    
      private void cargarTablaNovedadesRRHH() {
//        List<Empleado> listaEmpleado = new EmpleadoDaoImp().listarEmpleado(usuario.getEmpleado().getSucursal().getEmpresa().getCodEmp(), usuario.getEmpleado().getSucursal().getCodSuc());
        String aux = FechaUtil.getFechaString11AAAAMMDD(fecha);
        List<Novedad> listaNovSuc = new NovedadDaoImp().listarNovedad(aux, sucursal.getCodSuc());
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr);
        util.TablaUtil.cargarNovedadesCompleta(modelo, listaNovSuc, tblNovedadesUsr);
    }
      
      private void cargarTablaNovedadesVacia(Sucursal suc){
        List<Empleado> listaEmpleado = new EmpleadoDaoImp().listarEmpleado(suc.getEmpresa().getCodEmp(), suc.getCodSuc());
        util.TablaUtil.prepararTablaNovedades(modelo, tblNovedadesUsr, tipo);
        util.TablaUtil.cargarModeloNovedades(modelo, listaEmpleado, tblNovedadesUsr);
      
      }
    
    private void cargo(){//CARGA LA TABLA DE UNA U OTRA FORMA DEPENDIENDO SI HAY ALGUNA NOVEDAD CARGADA ESA FECHA PARA ESA SUCURSAL O NO
        List<Novedad> nov;
        Session session = Conexion.getSession();
        session.beginTransaction();
        hoy = FechaUtil.getFechaString11AAAAMMDD(fecha);
        String sql = "from Novedad as n join fetch n.empleado as e join fetch e.sucursal as s where e.estado = true and n.fecha = '"+hoy+"' and s.codSuc = '"+sucursal.getCodSuc()+"'";
        nov = (List<Novedad>)session.createQuery(sql).list();
        session.getTransaction().commit();
        session.close();
        
        if(nov.isEmpty()){
            cargarTablaNovedadesVacia(sucursal);
            btnCargar.setEnabled(true);
        }else{
            cargarTablaNovedadesRRHH();
            btnCargar.setEnabled(false);
        }
    }
   
}