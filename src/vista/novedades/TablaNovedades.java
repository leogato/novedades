/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.novedades;

import hibernateUtil.Conexion;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
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
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;
import util.FechaUtil;
import util.TablaUtil;
/**
 *
 * @author usuario
 */
public class TablaNovedades extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private List<Concepto> listaNovedad;
    private List<Novedad> listaNov;
    JComboBox jcb = new JComboBox();
    java.awt.Frame parent;
    
    public TablaNovedades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fechaInicio.setDate(new Date());
        fechaFin.setDate(new Date());
        deshabilitarFechas();
        inactivarBusqueda();
        rdbHoy.requestFocus();
        llenaJComboBoxInvestigacion();
        TableColumn tc = tblNovedades.getColumnModel().getColumn(6);
        TableCellEditor tce = new DefaultCellEditor(jcb);
        tc.setCellEditor(tce);
//        String[] datos = {"0-Sin Noveadad","1-Falta con aviso","2-Tardanza","3-Anticipo"};
               
        //el dispatcher se registra en forma global, por lo que es recomendable hacerlo dentro del frame principal
//primero obtenemos le FocusManager (que a su vez es el KeyEventDispatcher)
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
//y enseguida registramos nuestro dispatcher
        manager.addKeyEventDispatcher(new KeyEventDispatcher(){
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
                //como dije, solo las notificaciones del tipo "typed" son las que actualizan los componentes
                if(e.getID() == KeyEvent.KEY_TYPED){
                        //como vamos a convertir todo a mayúsculas, entonces solo checamos si los caracteres son 
                        //minusculas
                        if(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'){
                                //si lo son, entonces lo reemplazamos por su respectivo en mayúscula en el mismo evento
                                // (esto se logra por que en java todas las variables son pasadas por referencia)
                                e.setKeyChar((char)(((int)e.getKeyChar()) - 32));
                        }
                }
                //y listo, regresamos siempre falso para que las demas notificaciones continuen, si regresamos true
                // significa que el dispatcher consumio el evento
                return false; 
        }
});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        btnCancelar = new org.edisoncor.gui.button.ButtonIcon();
        btnPDF = new org.edisoncor.gui.button.ButtonIcon();
        btnExcel = new org.edisoncor.gui.button.ButtonIcon();
        btnImprimir = new org.edisoncor.gui.button.ButtonIcon();
        btnNuevo = new org.edisoncor.gui.button.ButtonIcon();
        btnGuardar = new org.edisoncor.gui.button.ButtonIcon();
        panelShadow2 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete2 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        cmbBusqueda = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        rdbHoy = new javax.swing.JRadioButton();
        rdbMes = new javax.swing.JRadioButton();
        rdbFecha = new javax.swing.JRadioButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        txtSucursal = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        btnBuscar = new org.edisoncor.gui.button.ButtonIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNovedades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de Novedades");
        setIconImage(null);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setOpaque(false);

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("buttonIcon1");
        btnCancelar.setAngulo(120);
        btnCancelar.setDistanciaDeSombra(45);

        btnPDF.setBackground(new java.awt.Color(51, 51, 51));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPDF.setText("buttonIcon2");
        btnPDF.setAngulo(120);
        btnPDF.setDistanciaDeSombra(45);

        btnExcel.setBackground(new java.awt.Color(51, 51, 51));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        btnExcel.setText("buttonIcon3");
        btnExcel.setAngulo(120);
        btnExcel.setDistanciaDeSombra(45);

        btnImprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setAngulo(120);
        btnImprimir.setDistanciaDeSombra(45);

        btnNuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar_registro.png"))); // NOI18N
        btnNuevo.setText("buttonIcon5");
        btnNuevo.setAngulo(120);
        btnNuevo.setDistanciaDeSombra(45);

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GUARDAR.png"))); // NOI18N
        btnGuardar.setText("buttonIcon6");
        btnGuardar.setAngulo(120);
        btnGuardar.setDistanciaDeSombra(45);

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShadow2.setDistance(10);

        panelTranslucidoComplete2.setOpaque(false);

        labelMetric1.setText("Busqueda");

        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO LOS EMPLEADOS", "LEGAJO", "EMPRESA Y SUCURSAL" }));
        cmbBusqueda.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cmbBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBusquedaItemStateChanged(evt);
            }
        });
        cmbBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBusquedaActionPerformed(evt);
            }
        });

        txtBusqueda.setText("Daniel Manzur");
        txtBusqueda.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        rdbHoy.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rdbHoy);
        rdbHoy.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbHoy.setForeground(new java.awt.Color(255, 255, 255));
        rdbHoy.setText("Hoy");
        rdbHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHoyActionPerformed(evt);
            }
        });

        rdbMes.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rdbMes);
        rdbMes.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbMes.setForeground(new java.awt.Color(255, 255, 255));
        rdbMes.setText("Mes Actual");
        rdbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMesActionPerformed(evt);
            }
        });

        rdbFecha.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rdbFecha);
        rdbFecha.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbFecha.setForeground(new java.awt.Color(255, 255, 255));
        rdbFecha.setText("Entre las Fechas");
        rdbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFechaActionPerformed(evt);
            }
        });

        fechaInicio.setBackground(new java.awt.Color(255, 255, 255));
        fechaInicio.setBorder(new javax.swing.border.SoftBevelBorder(0));
        fechaInicio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fechaInicio.setMaxSelectableDate(new Date());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Y");

        fechaFin.setBackground(new java.awt.Color(255, 255, 255));
        fechaFin.setBorder(new javax.swing.border.SoftBevelBorder(0));
        fechaFin.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fechaFin.setMaxSelectableDate(new Date());

        labelMetric2.setText("Sucursal");

        txtSucursal.setText("Maimara");
        txtSucursal.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setAngulo(120);
        btnBuscar.setDistanciaDeSombra(45);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucidoComplete2Layout = new javax.swing.GroupLayout(panelTranslucidoComplete2);
        panelTranslucidoComplete2.setLayout(panelTranslucidoComplete2Layout);
        panelTranslucidoComplete2Layout.setHorizontalGroup(
            panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(rdbHoy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbFecha)))
                .addContainerGap())
        );
        panelTranslucidoComplete2Layout.setVerticalGroup(
            panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbFecha)
                            .addComponent(rdbMes)
                            .addComponent(rdbHoy))
                        .addGap(17, 17, 17)
                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(panelTranslucidoComplete2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblNovedades.setBackground(new java.awt.Color(153, 153, 153));
        tblNovedades.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tblNovedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FECHA", "LEGAJO", "APELLIDO", "NOMBRE", "EMPRESA", "SUCURSAL", "CONCEPTO", "CANTIDAD", "OBSERVACION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNovedades.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNovedades);
        tblNovedades.getColumnModel().getColumn(0).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(0).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(1).setMinWidth(60);
        tblNovedades.getColumnModel().getColumn(1).setMaxWidth(60);
        tblNovedades.getColumnModel().getColumn(2).setMinWidth(72);
        tblNovedades.getColumnModel().getColumn(2).setMaxWidth(72);
        tblNovedades.getColumnModel().getColumn(3).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(3).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(4).setMinWidth(120);
        tblNovedades.getColumnModel().getColumn(4).setMaxWidth(110);
        tblNovedades.getColumnModel().getColumn(5).setMinWidth(110);
        tblNovedades.getColumnModel().getColumn(5).setMaxWidth(110);
        tblNovedades.getColumnModel().getColumn(6).setMinWidth(150);
        tblNovedades.getColumnModel().getColumn(6).setMaxWidth(150);
        tblNovedades.getColumnModel().getColumn(7).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(7).setPreferredWidth(5);
        tblNovedades.getColumnModel().getColumn(7).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(8).setPreferredWidth(40);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
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

    private void cmbBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBusquedaItemStateChanged

    }//GEN-LAST:event_cmbBusquedaItemStateChanged

    private void cmbBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusquedaActionPerformed
        if (cmbBusqueda.getSelectedIndex()==1) {
//             busqueda de empleado por legajo o empresa y sucursal
            activarLegajo();
        } else if (cmbBusqueda.getSelectedIndex()==2){
              activarBusqueda();
        } else  {
//             todos los empleados
            inactivarBusqueda();
        }

    }//GEN-LAST:event_cmbBusquedaActionPerformed

    private void rdbHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHoyActionPerformed
        if (rdbHoy.isSelected())
        {
            fechaInicio.setDate(FechaUtil.getFechaSinhora(new Date()));
            fechaFin.setDate(new Date());
            deshabilitarFechas();
            
        }
    }//GEN-LAST:event_rdbHoyActionPerformed

    private void rdbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMesActionPerformed
        if (rdbMes.isSelected())
        {
            fechaInicio.setDate(new Date(new Date().getYear(),new Date().getMonth(),1,0,0,0));
            fechaFin.setDate(new Date());
            deshabilitarFechas();

        }
    }//GEN-LAST:event_rdbMesActionPerformed

    private void rdbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFechaActionPerformed
        if (rdbFecha.isSelected())
        {
            habilitarFechas();
            
        }
    }//GEN-LAST:event_rdbFechaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listaNov = new  ArrayList<Novedad>();
       if (fechaInicio.getDate().getTime()<=fechaFin.getDate().getTime()) {
            //  verificar de que la fecha inicio no sea mayor que la fecha fin
        if (cmbBusqueda.getSelectedIndex()==1) {
            
           //busqueda empleado por DNI  
            try {        
              Empleado  e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtBusqueda.getText()));
            
            if (e!=null) {
              listaNov = new ConceptoDaoImp().listarNovedad(fechaInicio.getDate());
          
            }else{
            JOptionPane.showMessageDialog(this, "NO EXISTE EL EMPLEADO","ERROR",JOptionPane.ERROR_MESSAGE);

            }         
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "DEBES INGRESAR UN LEGAJO","ERROR",JOptionPane.ERROR_MESSAGE);
            }
       
        } else {
              // Busqueda asistencias de todos los empleados
               listaNov = new ConceptoDaoImp().listarNovedad(FechaUtil.getFechaSinhora(fechaInicio.getDate()));
              
               System.out.println("cantidad de datos en la busqueda "+listaNov.size());
            }
          
       }else{  
               JOptionPane.showMessageDialog(this, "La fecha inicio no puedes ser mayor a la fecha Fin ","ERROR",JOptionPane.ERROR_MESSAGE);
       }
        
    
           TablaUtil.prepararTablaRRHH(modelo, tblNovedades); 
           TablaUtil.cargarModeloRRHH(modelo, listaNov, tblNovedades);
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(TablaNovedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaNovedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaNovedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaNovedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TablaNovedades dialog = new TablaNovedades(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIcon btnBuscar;
    private org.edisoncor.gui.button.ButtonIcon btnCancelar;
    private org.edisoncor.gui.button.ButtonIcon btnExcel;
    private org.edisoncor.gui.button.ButtonIcon btnGuardar;
    private org.edisoncor.gui.button.ButtonIcon btnImprimir;
    private org.edisoncor.gui.button.ButtonIcon btnNuevo;
    private org.edisoncor.gui.button.ButtonIcon btnPDF;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbBusqueda;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow2;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete panelTranslucidoComplete1;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete panelTranslucidoComplete2;
    private javax.swing.JRadioButton rdbFecha;
    private javax.swing.JRadioButton rdbHoy;
    private javax.swing.JRadioButton rdbMes;
    private javax.swing.JTable tblNovedades;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBusqueda;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtSucursal;
    // End of variables declaration//GEN-END:variables
 private void inactivarBusqueda(){
         // dejar no editable el txtbusqueda y no activo el boton busqueda
        txtBusqueda.setEditable(false);
        txtSucursal.setEditable(false);
        //borro el contendido de la caja de texto
        txtBusqueda.setText("");
        txtBusqueda.setBackground(Color.DARK_GRAY);
        txtSucursal.setText("");
        txtSucursal.setBackground(Color.DARK_GRAY);
      
//        btnBusquedaPersonal.setEnabled(false);
    }
    private void activarBusqueda(){
       txtBusqueda.setEditable(true);
       txtSucursal.setEditable(true);
       //obtnego el foco
       txtBusqueda.requestFocus();
//       txtSucursal.requestFocus();
       //cambio el color
       txtBusqueda.setBackground(Color.white);
       txtSucursal.setBackground(Color.white);
//       btnBusquedaPersonal.setEnabled(true);
         
    }
    private void activarLegajo(){
        txtBusqueda.setEditable(true);
        txtSucursal.setEditable(false);
        txtBusqueda.requestFocus();
        txtBusqueda.setBackground(Color.white);
        txtSucursal.setText("");
        txtSucursal.setBackground(Color.DARK_GRAY);
    }
    
private void habilitarFechas()
{
    fechaInicio.setEnabled(true);
    fechaFin.setEnabled(true);
    
}
private void deshabilitarFechas()
{
    fechaInicio.setEnabled(false);
    fechaFin.setEnabled(false);
}

    private void llenaJComboBoxInvestigacion() {
        Session sesion = null;
        try {

            sesion = Conexion.getSessionFactory().openSession();

            Criteria crit = sesion.createCriteria(Concepto.class);
            List<Concepto> rsConcepto = crit.list();// SELECT * FROM TABLA

            jcb.removeAllItems();

            for (Concepto inv : rsConcepto) {
                jcb.addItem("" + inv.getCodCon()+ " - " + inv.getDescripcion());
            }

            sesion.close();

            //JOptionPane.showMessageDialog(this, "Factor creado Satisfactoriamente", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Error al crear Factor:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

