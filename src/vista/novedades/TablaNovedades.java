/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.novedades;

import org.apache.poi.ss.usermodel.IndexedColors;
import hibernateUtil.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import novedades.dao.imp.ConceptoDaoImp;
import novedades.dao.imp.EmpleadoDaoImp;
import novedades.dao.imp.EmpresaDaoImp;
import novedades.dao.imp.NovedadDaoImp;
import novedades.dao.imp.SucursalDaoImp;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Sucursal;
import pojo.Usuario;
import util.CellRenderer;
import util.FechaUtil;
import util.HoraServer;
import util.TablaUtil;
import vistas.cargaRRHH;
/**
 *
 * @author usuario
 */
public class TablaNovedades extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private List<Novedad> listaNov;
    private Empleado empleado;
    JComboBox jcb = new JComboBox();
    JCheckBox chkbx = new JCheckBox();
    JTextField jtf = new JTextField();
    java.awt.Frame parent;
    //Variables para crear el Excel//
    int nxtRow, fila, bandera = 0;
    Novedad novedad = new Novedad();
    Usuario usuario = new Usuario();
    Date date1;
    String auxFecIni, auxFecFin;
    String auxCon;
    HoraServer hs = new HoraServer();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JDialog dialogo = null;
    
    
    
    public TablaNovedades(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        fechaInicio.setDate(FechaUtil.getFechaSinhora(new Date()));
        fechaFin.setDate(new Date());
        deshabilitarFechas();
        inactivarBusqueda();
        cmbConcepto.setEnabled(false);
        btnNuevo.setEnabled(false);
        rdbHoy.requestFocus();
        rdbHoy.setSelected(true);
        llenaCmbConcepto();
        llenaCmbEmpresa();
        inactivarEmpSuc();
        btnExcel.setEnabled(false);
        
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
        btnImprimir = new org.edisoncor.gui.button.ButtonIcon();
        btnNuevo = new org.edisoncor.gui.button.ButtonIcon();
        btnGuardar = new org.edisoncor.gui.button.ButtonIcon();
        btnExcel = new org.edisoncor.gui.button.ButtonIcon();
        btnCancelar = new org.edisoncor.gui.button.ButtonIcon();
        panelShadow2 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete2 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        rdbHoy = new javax.swing.JRadioButton();
        rdbMes = new javax.swing.JRadioButton();
        rdbFecha = new javax.swing.JRadioButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        cmbBusqueda = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbConcepto = new org.edisoncor.gui.comboBox.ComboBoxRound();
        cmbEmpresa = new org.edisoncor.gui.comboBox.ComboBoxRound();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        cmbSucursal = new org.edisoncor.gui.comboBox.ComboBoxRound();
        btnBuscar = new org.edisoncor.gui.button.ButtonIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNovedades = new javax.swing.JTable();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();

        setTitle("Tabla de Novedades");
        setIconImage(null);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setOpaque(false);

        btnImprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setAngulo(120);
        btnImprimir.setDistanciaDeSombra(45);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar_registro.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setAngulo(120);
        btnNuevo.setDistanciaDeSombra(45);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GUARDAR.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setAngulo(120);
        btnGuardar.setDistanciaDeSombra(45);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(51, 51, 51));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.setAngulo(120);
        btnExcel.setDistanciaDeSombra(45);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        btnCancelar.setText("Atras");
        btnCancelar.setToolTipText("");
        btnCancelar.setAngulo(120);
        btnCancelar.setDistanciaDeSombra(45);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        panel1.add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 1130, 90));

        panelShadow2.setDistance(10);

        panelTranslucidoComplete2.setOpaque(false);

        labelMetric1.setText("Conceptos");

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

        labelMetric3.setText("Busqueda");

        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO LOS EMPLEADOS", "LEGAJO", "EMPRESA Y SUCURSAL", "CONCEPTOS" }));
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

        cmbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpresaItemStateChanged(evt);
            }
        });

        labelMetric4.setText("Empresa");

        javax.swing.GroupLayout panelTranslucidoComplete2Layout = new javax.swing.GroupLayout(panelTranslucidoComplete2);
        panelTranslucidoComplete2.setLayout(panelTranslucidoComplete2Layout);
        panelTranslucidoComplete2Layout.setHorizontalGroup(
            panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(cmbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslucidoComplete2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89))
                                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                            .addComponent(cmbEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)))
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdbHoy)
                        .addGap(74, 74, 74)
                        .addComponent(rdbMes)
                        .addGap(75, 75, 75)
                        .addComponent(rdbFecha))))
        );
        panelTranslucidoComplete2Layout.setVerticalGroup(
            panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbHoy)
                    .addComponent(rdbMes)
                    .addComponent(rdbFecha))
                .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelTranslucidoComplete2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblNovedades.setBackground(new java.awt.Color(0, 0, 0));
        tblNovedades.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tblNovedades.setForeground(new java.awt.Color(255, 255, 255));
        tblNovedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "LEGAJO", "APELLIDO", "NOMBRE", "CONVENIO", "TAREA", "EMPRESA", "SUCURSAL", "CONCEPTO", "CANTIDAD", "OBSERVACION", "USUARIO", "EDITAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNovedades.setCellSelectionEnabled(true);
        tblNovedades.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNovedades);
        tblNovedades.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblNovedades.getColumnModel().getColumn(0).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(0).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(1).setMinWidth(60);
        tblNovedades.getColumnModel().getColumn(1).setMaxWidth(60);
        tblNovedades.getColumnModel().getColumn(2).setMinWidth(72);
        tblNovedades.getColumnModel().getColumn(2).setMaxWidth(72);
        tblNovedades.getColumnModel().getColumn(3).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(3).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(4).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(4).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(5).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(5).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(6).setMinWidth(120);
        tblNovedades.getColumnModel().getColumn(6).setMaxWidth(110);
        tblNovedades.getColumnModel().getColumn(7).setMinWidth(110);
        tblNovedades.getColumnModel().getColumn(7).setMaxWidth(110);
        tblNovedades.getColumnModel().getColumn(8).setMinWidth(150);
        tblNovedades.getColumnModel().getColumn(8).setMaxWidth(150);
        tblNovedades.getColumnModel().getColumn(9).setMinWidth(70);
        tblNovedades.getColumnModel().getColumn(9).setPreferredWidth(5);
        tblNovedades.getColumnModel().getColumn(9).setMaxWidth(70);
        tblNovedades.getColumnModel().getColumn(10).setPreferredWidth(40);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1270, 220));

        labelMetric5.setBackground(new java.awt.Color(255, 255, 0));
        labelMetric5.setForeground(new java.awt.Color(102, 255, 102));
        labelMetric5.setText("NO SE GUARDARAN DATOS EN LA COLUMNA CANTIDAD SI EL CONCEPTO NO ES CUANTITATIVO");
        labelMetric5.setColorDeSombra(new java.awt.Color(0, 51, 0));
        labelMetric5.setDireccionDeSombra(0);
        labelMetric5.setDistanciaDeSombra(2);
        labelMetric5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 10)); // NOI18N
        panel1.add(labelMetric5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 660, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1291, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        //********VERIFICA QUE LA FECHA DE INICIO NO SEA MAYOR QUE LA FECHA DE FIN********\\
        if (fechaInicio.getDate().getTime()<=fechaFin.getDate().getTime()) {
            
            if (cmbBusqueda.getSelectedIndex()== 1) {
           //********BUSQUEDA POR LEGAJO********\\
//                try {        
                    int leg = Integer.parseInt(txtBusqueda.getText().toString());
                    List<Empleado> emp = new EmpleadoDaoImp().getEmpleados(leg);
                    
                    if (emp!=null) {
                        listaNov = new NovedadDaoImp().listarNovedadEmp(leg,FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                    }else{
                        JOptionPane.showMessageDialog(this, "NO EXISTE EL EMPLEADO","ERROR",JOptionPane.ERROR_MESSAGE);
                    }         
//                
                //***BUSQUEDA POR EMPRESA Y SUCURSAL***\\
            }
           
            if(cmbBusqueda.getSelectedIndex()== 2){
                btnExcel.setEnabled(true);
                btnNuevo.setEnabled(true);
                inactivarBusqueda();
                Empresa emp;
                Sucursal suc;
                String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
                
                if (cod.charAt(1) == '-'){
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
                }else{
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
                }
                
                if(suc!=null){
                   
                    auxFecIni = FechaUtil.getFechaString10DDMMAAAA(fechaInicio.getDate());
                    auxFecFin = FechaUtil.getFechaString10DDMMAAAA(fechaFin.getDate());
                    
                    if(suc.getNombre().equals("TODAS")){
                        emp = new EmpresaDaoImp().getEmpresa(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
                        listaNov = new NovedadDaoImp().listarNovedad(emp, FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                    }else{
                        listaNov = new NovedadDaoImp().listarNovedad(suc, FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "NO EXISTE LA SUCURSAL","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            //***BUSQUEDA POR CONCEPTOS***//
            if(cmbBusqueda.getSelectedIndex()== 3){
                Concepto con = new ConceptoDaoImp().getConceptoHql(cmbConcepto.getSelectedItem().toString());
                if(con!=null){
                    listaNov = new NovedadDaoImp().listarNovedad(con, FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                }else{
                    JOptionPane.showMessageDialog(this, "NO EXISTE EL CONCEPTO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            if(cmbBusqueda.getSelectedIndex() == 0){
              // Busqueda asistencias de todos los empleados
                listaNov = new NovedadDaoImp().listarNovedad(FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
            }
          
        }else{  
               JOptionPane.showMessageDialog(this, "La fecha inicio no puedes ser mayor a la fecha Fin ","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            TablaUtil.prepararTablaRRHH(modelo, tblNovedades); 
            TablaUtil.cargarModeloRRHH(modelo, listaNov, tblNovedades);
            tblNovedades.setAutoCreateRowSorter(true);
            tblNovedades.getRowSorter().toggleSortOrder(1);//******ORDENA POR FECHA
           
            
            //******LLENA UN COMBOBOX Y LO INSERTA EN LA JTABLE EN LA COLUMNA  15 (EDITAR)
            llenaJComboBoxInvestigacion();
            
            insertarChkBox();
            tblNovedades.getColumnModel().getColumn(15).setCellRenderer(new CellRenderer());
            
//            tblNovedades.getColumnModel().getColumn(14).setCellEditor(rt);
            
//            jtf.addKeyListener(new KeyListener() {
//
//                @Override
//                public void keyTyped(KeyEvent e) {
//                    permitirSoloNumero(e);
//                }
//
//                @Override
//                public void keyPressed(KeyEvent e) {
//                    permitirSoloNumero(e);
//                }
//
//                @Override
//                public void keyReleased(KeyEvent e) {
//                    permitirSoloNumero(e);
//                }
//                private void permitirSoloNumero(java.awt.event.KeyEvent evt) {
//              // permitir solo el ingreso de numero
//                    char caracter = evt.getKeyChar();
//                    if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
//                    evt.consume();  // ignorar el evento de teclado
//                    }
//                }
//            });
            soloNumeros();
                        
            TableColumn tc2 = tblNovedades.getColumnModel().getColumn(11);
            TableCellEditor tce2 = new DefaultCellEditor(jtf);
            tc2.setCellEditor(tce2);
            
            TableColumn tc = tblNovedades.getColumnModel().getColumn(10);
            TableCellEditor tce = new DefaultCellEditor(jcb);
            tc.setCellEditor(tce);
            tblNovedades.setAutoResizeMode(tblNovedades.AUTO_RESIZE_ALL_COLUMNS);
            tblNovedades.setAutoResizeMode(tblNovedades.AUTO_RESIZE_OFF);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        int cel, o, dia,  valFecha = 0, nxtFila, dias, indice, inicio, fin, cantDiasMes, mes, anio, nxtMes;
        int mesIni, fecAnt = 0;
        String concepto;
        String valor;
        String legajo, apellido, nombre, convenio, tarea;
        String fecha;
        Empresa emp = new EmpresaDaoImp().getEmpresa(Integer.parseInt(String.valueOf(tblNovedades.getValueAt(0, 8).toString().charAt(0))));
        HSSFWorkbook libro;//crea el libro
        
        String ext = "";
        File file = null;
        JFileChooser fc = null;
        FileNameExtensionFilter filter = null;
        if (fc == null){
            fc = new JFileChooser();
            fc.setDialogTitle("Guardar");
            fc.setFileSelectionMode(0);
            filter = new FileNameExtensionFilter("Libro de Excel", new String[] { "xls" });
            fc.addChoosableFileFilter(filter);
            fc.setFileFilter(filter);
        }
        fc.setSelectedFile(null);
        
        libro = new HSSFWorkbook();
        CellStyle style = libro.createCellStyle();
        Map<String, CellStyle> styles = createStyles(libro);
        HSSFCellStyle cs = (HSSFCellStyle) libro.createCellStyle();
        HSSFDataFormat df = libro.createDataFormat();
        cs.setDataFormat(df.getFormat("MMM-yyyy"));
        HSSFSheet hoja = libro.createSheet("Novedades");//crea una hoja
        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));
        HSSFRow f = hoja.createRow(0);
        HSSFCell celda;
        celda = f.createCell(0);
        celda.setCellValue(emp.getNombre());
        celda.setCellStyle((CellStyle)styles.get("Titulo"));
        
        f = hoja.getRow(0);
        celda = f.createCell(4);
        String fechita = sdf.format(fechaInicio.getDate());
        celda.setCellValue(fechita);
        celda.setCellStyle((CellStyle)styles.get("center"));
        celda = f.createCell(5);
        celda.setCellValue("HASTA");
        celda.setCellStyle((CellStyle)styles.get("center"));
        celda = f.createCell(6);
        fechita = sdf.format(fechaFin.getDate());
        celda.setCellStyle((CellStyle)styles.get("center"));
        celda.setCellValue(fechita);
        
        
        f = hoja.createRow(2);
        celda = f.createCell(0);
        celda.setCellValue("CONCEPTOS");
        celda.setCellStyle((CellStyle)styles.get("conceptos"));
        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$3:$C$3"));

        int k = 0;
        int j = 4;
        int i =0;
        Session sesion = Conexion.getSession();
        sesion.beginTransaction();
//        String sql= "from Concepto as c where c.estado = true";
        String sql= "from Concepto";
        List<Concepto> list = sesion.createQuery(sql).list();

        //********CARGA TODOS LOS CONCEPTOS DE LA TABLA CONCEPTO********//
        for (Concepto con : list){
            if(k == 0){
               f = hoja.createRow(j); 
               celda = f.createCell(k);
               celda.setCellValue(con.getCodCon()+"-"+con.getDescripcion());
               celda.setCellStyle((CellStyle)styles.get("detalle"));
               i++;
               j++;
               nxtRow = j+1;//********VARIABLE QUE NOS OTORGA LA PROXIMA FILA PARA ESCRIBIR, DEBAJO DE LOS CONCEPTOS********//
            }else{
                f = hoja.getRow(j);
                celda = f.createCell(k);
                celda.setCellValue(con.getCodCon()+"-"+con.getDescripcion());
                celda.setCellStyle((CellStyle)styles.get("detalle"));
                j++;
                i++;
            }
            
            if (i == 8){
                k++;
                j = 4;
                i = 0;
            }
            hoja.autoSizeColumn(k);//***HACE QUE LAS CELDAS OBTENGAN TAMAÑO AUTOMATICO***\\
        }
        //********CREA LAS CABECERAS DEL EXCEL********\\
        f = hoja.createRow(nxtRow);//***GETROW HACE REFERENCIA A LA FILA YA CREADA PARA VOLVER A ESCRIBIR EN ELLA***\\
        celda = f.createCell(0);
        celda.setCellValue("LEGAJO");
        celda.setCellStyle((CellStyle)styles.get("cabecera"));
        celda = f.createCell(1);
        celda.setCellValue("APELLIDO");
        celda.setCellStyle((CellStyle)styles.get("cabecera"));
        hoja.autoSizeColumn(1);
        celda = f.createCell(2);
        celda.setCellValue("CONVENIO");
        celda.setCellStyle((CellStyle)styles.get("cabecera"));
        hoja.autoSizeColumn(2);
        celda = f.createCell(3);
        celda.setCellValue("TAREA");
        celda.setCellStyle((CellStyle)styles.get("cabecera"));
        hoja.autoSizeColumn(3);
        f.setRowStyle((CellStyle)styles.get("cabecera"));
        //*******POR CADA CONCEPTO CON CUATITATIVA = YES CREAMOS UNA COLUMNA Y GUARDAMOS LA CANTIDAD*******\\
        int iCol=4;
        int cantCuanti = 0;
        int fila = nxtRow+1;
        HSSFRow fil;
        int q = 4;
        int suma = 0;
        fil = hoja.createRow(fila);
        for(Concepto con : list){
            if (con.getTipo().equals("CUANTITATIVA")){
                celda = f.createCell(iCol);
                celda.setCellValue(con.getDescripcion());
                celda.setCellStyle((CellStyle)styles.get("cabecera"));
                hoja.autoSizeColumn(iCol);
                iCol++;
                cantCuanti++;
            }//***FIN IF QUE COMPARA CONCEPTOS PARA SACAR LAS CUANTITATIVAS
        }//***TERMINA EL CICLO DE LLENADO DE CUANTITATIVAS
        
        dias = Integer.parseInt(String.valueOf(FechaUtil.diferenciaEntreFechas(fechaInicio.getDate(), fechaFin.getDate())));
        indice = 0;
        inicio = FechaUtil.getDia(fechaInicio.getDate());
        fin = FechaUtil.getDia(fechaFin.getDate());
        mes = FechaUtil.getMes(fechaInicio.getDate());
        anio = FechaUtil.getAnio(fechaInicio.getDate());
        cantDiasMes = FechaUtil.getDiasDelMes(mes,anio);
        
        nxtMes = 0;
        f = hoja.getRow(fila-1);
        
        //********ESCRIBE LOS DIAS QUE DESEO BUSCAR********//
        for(int ind = 0;ind < dias; ind++){
                celda = f.createCell(iCol);
                
                celda.setCellValue(inicio+indice);
                celda.setCellStyle((CellStyle)styles.get("cabecera"));
                if((inicio+indice) < (cantDiasMes)){
                    
                    indice++;
                }else{
                    inicio = 1;
                    indice = 0;
                    mes = mes +1;
                    if (mes == 13){
                        mes = 1;
                        anio = anio+1;
                    }
                    cantDiasMes = FechaUtil.getDiasDelMes(mes, anio);
                }
                iCol++;
        }//***FIN DE CICLO PARA ESCRIBIR LOS DIAS BUSCADOS***\\
        
        int empSelect = Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0)));
        int cantSuc = cmbSucursal.getItemCount();
        tblNovedades.setAutoCreateRowSorter(true);//***LE DA AL JTABLE LA PROPIEDAD PARA PODER SER ORDENADO***\\

        List<Empleado> listEmp = new EmpleadoDaoImp().listarEmpleado();
        cel = 4;
        valor = "vacio";
        legajo = "vacio";
        nombre = "vacio";
        apellido = "vacio";
        convenio = "vacio";
        tarea = "vacio";
        fecha = "vacio";
//        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$12:$C$12"));
        tblNovedades.getRowSorter().toggleSortOrder(8);//***ORDENA POR COLUMNA SUCURSAL***//
        
        //********MODULO PARA ESCRIBIR UNA SUCURSAL********//
        for(int ind = 0; ind < tblNovedades.getRowCount(); ind++){
            if(!valor.equals(tblNovedades.getValueAt(ind, 9).toString())){
                valor = tblNovedades.getValueAt(ind, 9).toString();
                f = hoja.createRow(fila);
                celda = f.createCell(0);
                celda.setCellValue(valor);
                celda.setCellStyle((CellStyle)styles.get("localidad"));
                f.setRowStyle((CellStyle)styles.get("localidad"));
                fila++;
                tblNovedades.getRowSorter().toggleSortOrder(3);//******ORDENA POR LEGAJO
                
                //********MODULO PARA ESCRIBIR TODOS LOS EMPLEADOS DE ESA SUCURSAL QUE TENGAN NOVEDADES********//
                for(int m = 0; m < tblNovedades.getRowCount();m++){
                    if(!legajo.equals(tblNovedades.getValueAt(m, 3).toString())&& valor.equals(tblNovedades.getValueAt(m, 9))){
                        legajo = tblNovedades.getValueAt(m, 3).toString();
                        apellido = tblNovedades.getValueAt(m,4).toString();
                        nombre = tblNovedades.getValueAt(m,5).toString();
                        convenio = tblNovedades.getValueAt(m,6).toString();
                        tarea = tblNovedades.getValueAt(m,7).toString();
                        f = hoja.createRow(fila);
                        celda = f.createCell(0);
                        celda.setCellValue(legajo);
                        celda = f.createCell(1);
                        celda.setCellValue(apellido+" "+nombre);
                        celda = f.createCell(2);
                        celda.setCellValue(convenio);
                        celda = f.createCell(3);
                        celda.setCellValue(tarea);
                        hoja.autoSizeColumn(0);
                        hoja.autoSizeColumn(1);
                        hoja.autoSizeColumn(2);
                        hoja.autoSizeColumn(3);
                        hoja.autoSizeColumn(4);
                        //********MODULO PARA SUMAR LAS NOVEDADES CUANTITATIVAS DE CADA EMPLEADO********//
                        for( o = 0; o < cantCuanti; o++){//***RECORRE LAS COLUMNAS DEPENDIENDO DE CUANTOS CONCEPTOS CUANTITATIVOS HAYAN
                            suma = 0;
                            for(int n = 0; n < tblNovedades.getRowCount(); n++){//***RECORRE LA TABLA Y COMPARA LOS CONCEPTOS CON LOS QUE TENGO EXCEL
                                f = hoja.getRow(13);//***GETROW HACE REFERENCIA A LA FILA YA CREADA PARA VOLVER A ESCRIBIR EN ELLA***\\
                                celda = f.getCell(cel+o);
                                concepto = celda.getStringCellValue();
                                if(concepto.equals(tblNovedades.getValueAt(n, 10).toString()) && legajo.equals(tblNovedades.getValueAt(n, 3).toString())){
                                    suma = suma + Integer.parseInt(tblNovedades.getValueAt(n, 11).toString());//SUMA CANTIDAD
                                }//FIN DE IF QUE CONSULTA POR CONCEPTO Y LEGAJO
                            }//TERMINA EL FOR QUE RECORRE LAS COLUMNAS
                            
                            f = hoja.getRow(fila);
                            celda = f.createCell(cel+o);
                            celda.setCellValue(suma);
                            celda.setCellStyle((CellStyle)styles.get("suma"));
                        }//TERMINA EL MODULO PARA SUMAR LAS CUANTITATIVAS
                        
                        int cel2 = cel+o;
                        nxtFila = fila;
                        
                        //***MODULO PARA INSERTAR LAS NOVEDADES CUALITATIVAS SEGUN LOS DIAS BUSCADOS***\\
                        tblNovedades.getRowSorter().toggleSortOrder(2);//***ORDENA LAS COLUMNAS DEL JTABLE POR FECHA***\\
                        //***RECORRE LA FILAS DEL JTABLE ORDENADO POR FECHAS***\\
                        mesIni = FechaUtil.getMes(fechaInicio.getDate());
                        for(int p = 0;p < tblNovedades.getRowCount(); p++){
                            
                            //***PREGUNTA SI EL LEGAJO EN EL EXCEL ES IGUAL AL DEL JTABLE
                            if (legajo.equals(tblNovedades.getValueAt(p, 3).toString())){
                                try {
                                    fecha = tblNovedades.getValueAt(p, 1).toString();
                                    String aux = FechaUtil.FormateaFecha(fecha);
                                    sdf = new SimpleDateFormat("dd-MM-yyyy");
                                    Date date = sdf.parse(aux);
                                    dia = FechaUtil.getDia(date);
                                    
                                    //***CICLO PARA ESCRIBIR LAS NOVEDADES CUALITATIVAS DE LOS EMPLEADOS QUE TUVIERAN***\\
                                    fecAnt = 0;
                                    
                                    int mes2 = FechaUtil.getMes(date);
                                    do{
                                        
                                        f = hoja.getRow(13);
                                        celda = f.getCell(cel2);
                                        valFecha = (int) celda.getNumericCellValue();
                                        
                                        if(valFecha < fecAnt){
                                                mesIni = mesIni + 1;
                                                if (mesIni == 13){
                                                    mesIni = 1;
                                                }
                                            }
                                        //IF PARA COMPARAR LAS FECHAS BUSCADAS CON LAS DEL JTABLE
                                        if(dia == valFecha && mes2 == mesIni){
                                            Concepto con = new ConceptoDaoImp().getConceptoHql(tblNovedades.getValueAt(p, 10).toString());
                                            f = hoja.getRow(fila);
                                            celda = f.createCell(cel2);
                                            celda.setCellValue(con.getCodCon());
                                            colores(con.getCodCon(), libro, celda);
                                        }else{
                                            cel2++;
                                            
                                            fecAnt = valFecha;
                                        }//FIN IF DE COMPARACION DE FECHAS
                                    }while(dia != valFecha || mes2 != mesIni);//***FIN DE CICLO DO WHILE
                                    
                                } catch (ParseException ex) {
                                    Logger.getLogger(TablaNovedades.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }//***FIN DE IF QUE COMPARA LEGAJOS
                        }//***FIN DE CICLO QUE RECORRE FILAS ORDENADAS

                        tblNovedades.getRowSorter().toggleSortOrder(3);//ORDENA LA TABLA POR LEGAJO
                        
                        fila++; //INCREMENTA LA FILA EN 1
                    }//FIN DE IF DONDE CONSULTA POR LEGAJO Y VALOR

                }//TERMINA EL MODULO PARA ESCRIBIR TODOS LOS EMPLEADOS
                tblNovedades.getRowSorter().toggleSortOrder(9);//ORDENA LA TABLA POR SUCURSAL      
            }//FIN DE IF QUE CONSULTA POR UN VALOR DENTRO DE LA JTABLE

        }//FIN DE MODULO PARA ESCRIBIR TODAS LAS SUCURSALES
            
        //***ESCRIBE EL LIBRO***\\
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == 0){
            file = fc.getSelectedFile();
            
            if (fc.getFileFilter() == filter){
                String extension = file.getAbsolutePath();
                if (!extension.endsWith(".xls")){
                    ext = ".xls";
                }
            }
            try{
                OutputStream output = new FileOutputStream(file + ext);
                Throwable localThrowable2 = null;
                try{
                    libro.write(output);
                    output.close();
//                    visualizaDialogo(this, "El libro ha sido generado correctamente", "GENERADO", 2000);
                }catch (Throwable localThrowable1){
                    localThrowable2 = localThrowable1;
                    throw localThrowable1;
                }
                finally{
                    if (output != null){
                        if (localThrowable2 != null){
                            try{
                                output.close();
                            }catch (Throwable x2){
                                localThrowable2.addSuppressed(x2);
                            }
                        }else {
                            output.close();
                            
                        }
                    }
                }
            }catch (FileNotFoundException e){
                JOptionPane.showMessageDialog(this, "EL LIBRO ESTA ABIERTO O EN USO, CIERRELO Y VUELVA A INTENTAR", "ERROR", 0);
                this.dispose();
                bandera = 1;
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "EL LIBRO ESTA ABIERTO O EN USO, CIERRELO Y VUELVA A INTENTAR", "ERROR", 0);
                this.dispose();
                bandera = 1;
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (bandera == 0){
                visualizaDialogo(this, "EL LIBRO HA SIDO GENERADO CORRECTAMENTE", "ARCHIVO GENERADO", 2000);
//                dispose();
            }
        }

        
    }//GEN-LAST:event_btnExcelActionPerformed

    private void cmbBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBusquedaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBusquedaItemStateChanged

    private void cmbBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusquedaActionPerformed
        if(fechaInicio.getDate().getTime() < fechaFin.getDate().getTime()){
            
            if(cmbBusqueda.getSelectedIndex()== 0){
                inactivarBusqueda();
                inactivarEmpSuc();
                cmbConcepto.setEnabled(false);
                btnExcel.setEnabled(false);
                btnNuevo.setEnabled(false);
                
            }else if(cmbBusqueda.getSelectedIndex() == 1){
                txtBusqueda.setEditable(true);
                txtBusqueda.setBackground(Color.YELLOW);
                txtBusqueda.setForeground(Color.BLACK);
                txtBusqueda.requestFocus();
                cmbConcepto.setEnabled(false);
                cmbConcepto.setEditable(false);
                btnExcel.setEnabled(false);
                btnNuevo.setEnabled(false);
                inactivarEmpSuc();
                
            }else if(cmbBusqueda.getSelectedIndex() == 2){
                cmbEmpresa.requestFocus();
                btnBuscar.setEnabled(true);
                activarEmpSuc();
                inactivarBusqueda();
                cmbConcepto.setEnabled(false);
                
            }else if (cmbBusqueda.getSelectedIndex() == 3){
                cmbConcepto.setEnabled(true);
                btnExcel.setEnabled(false);
                btnNuevo.setEnabled(false);
                inactivarBusqueda();
                inactivarEmpSuc();
            }
        }
    }//GEN-LAST:event_cmbBusquedaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            tblNovedades.print();//envia los datos de la tabla a la impresora
        } catch (PrinterException ex) {
            Logger.getLogger(TablaNovedades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cmbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpresaItemStateChanged
        llenaCmbSucursal(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
    }//GEN-LAST:event_cmbEmpresaItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
        Sucursal suc;
        Empresa emp = new EmpresaDaoImp().getEmpresa(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
        if (cod.charAt(1) == '-'){
            suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
        }else{
            suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
        }
        auxFecIni = FechaUtil.getFechaString10DDMMAAAA(fechaInicio.getDate());
        if(suc.getNombre().equalsIgnoreCase("TODAS")){
            JOptionPane.showMessageDialog(parent, "DEBE SELECCIONAR UNICAMENTE UNA SUCURSAL PARA CARGAR DATOS","ADVERTENCIA",1);
        }else{
            new cargaRRHH(parent, rootPaneCheckingEnabled, suc, fechaInicio.getDate(), emp, usuario);
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int id;
        boolean ban = false;
        if(tblNovedades.isEditing()){
                tblNovedades.getCellEditor().stopCellEditing();
                for(int i = 0;i < tblNovedades.getRowCount();i++){
                    id = Integer.parseInt(tblNovedades.getValueAt(i, 0).toString());
                    novedad = new NovedadDaoImp().getNovedad(id);
                    if(getDatosTablaNew(i)){
                        ban = true;
                        new NovedadDaoImp().upDateNovedad(novedad);
                    }
//                    new NovedadDaoImp().upDateNovedad(novedad);
                }
                if (ban){
                    JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "NO SE REALIZARON MODIFICACION");
                }
            }else{
                for( int i = 0;i < tblNovedades.getRowCount();i++){
                    id = Integer.parseInt(tblNovedades.getValueAt(i, 0).toString());
                    novedad = new NovedadDaoImp().getNovedad(id);
                    if(getDatosTablaNew(i)){
                        ban = true;
                        new NovedadDaoImp().upDateNovedad(novedad);
                    }
//                    new NovedadDaoImp().upDateNovedad(novedad);
                }
                if (ban){
                    JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "NO SE REALIZARON MODIFICACION");
                }
//                    getDatosTablaNew(i);
//                    new NovedadDaoImp().upDateNovedad(novedad);
//                }
//                JOptionPane.showMessageDialog(rootPane, "SE CARGARON DATOS CORRECTAMENTE");
//            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIcon btnBuscar;
    private org.edisoncor.gui.button.ButtonIcon btnCancelar;
    private org.edisoncor.gui.button.ButtonIcon btnExcel;
    private org.edisoncor.gui.button.ButtonIcon btnGuardar;
    private org.edisoncor.gui.button.ButtonIcon btnImprimir;
    private org.edisoncor.gui.button.ButtonIcon btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbBusqueda;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbConcepto;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbEmpresa;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbSucursal;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
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
    // End of variables declaration//GEN-END:variables
    
//    private void getDatosTabla(int i){
//        String auxCant = String.valueOf(tblNovedades.getValueAt(i, 11));
//        String auxObs = String.valueOf(tblNovedades.getValueAt(i, 12));
//        System.out.println("auxObs "+auxObs);
//        Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedades.getValueAt(i, 2).toString()));
//        novedad.setEmpleado(e);
//        Concepto c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedades.getValueAt(i, 10).toString()));
//        novedad.setConcepto(c);
//        System.out.println("Estado "+tblNovedades.getValueAt(i, 14));
////        novedad.setEstado((Boolean)tblNovedades.getValueAt(i, 14));
//        novedad.setQuien(usuario.getUsuario()+" "+hs.getFechaHora());
//        System.out.println("usuario "+(novedad.getQuien()));
//        if(auxCant == null){
//            novedad.setCantidad(0);
//        }else{
//            novedad.setCantidad(Integer.parseInt(tblNovedades.getValueAt(i, 11).toString()));
//        }
//        if (auxObs == null){
//           novedad.setObservacion("-"); 
//        }else{
//            novedad.setObservacion(tblNovedades.getValueAt(i, 12).toString());
//        }
//        
//    }
//    private void getDatosTablaNew(int i){
//        if(tblNovedades.getValueAt(i, 15) != null){
//            boolean estado = (Boolean)tblNovedades.getValueAt(i, 15);
//            if(estado != false){
//                String auxCant = String.valueOf(tblNovedades.getValueAt(i, 11));
//                String auxObs = String.valueOf(tblNovedades.getValueAt(i, 12));
//                Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedades.getValueAt(i, 2).toString()));
//                novedad.setEmpleado(e);
//                Concepto c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedades.getValueAt(i, 10).toString()));
//                novedad.setConcepto(c);
//                novedad.setModificador(usuario.getUsuario()+" "+hs.getFechaHora());
//                if(auxCant == null){
//                    novedad.setCantidad(0);
//                }else{
//                    novedad.setCantidad(Integer.parseInt(tblNovedades.getValueAt(i, 11).toString()));
//                }
//                if (auxObs == null){
//                   novedad.setObservacion("-"); 
//                }else{
//                    novedad.setObservacion(tblNovedades.getValueAt(i, 12).toString());
//                }
//            }
//        }
//        
//    }
    private boolean getDatosTablaNew(int i){
        boolean ban = false;
        if(tblNovedades.getValueAt(i, 15) != null){
            boolean estado = (Boolean)tblNovedades.getValueAt(i, 15);
            if(estado != false){
                ban = true;
                String auxCant = String.valueOf(tblNovedades.getValueAt(i, 11));
                String auxObs = String.valueOf(tblNovedades.getValueAt(i, 12));
                Empleado e = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(tblNovedades.getValueAt(i, 2).toString()));
                novedad.setEmpleado(e);
                Concepto c = new ConceptoDaoImp().getConceptoHql(String.valueOf(tblNovedades.getValueAt(i, 10).toString()));
                novedad.setConcepto(c);
                auxCon = c.getTipo();
                novedad.setModificador(usuario.getUsuario()+" "+hs.getFechaHora());
                if((auxCant != null && !auxCant.equals("")) && auxCon.equals("CUANTITATIVA")){
                    novedad.setCantidad(Integer.parseInt(tblNovedades.getValueAt(i, 11).toString()));
                }else{
                    novedad.setCantidad(0);
                }
                if (auxObs == null){
                   novedad.setObservacion("-"); 
                }else{
                    novedad.setObservacion(tblNovedades.getValueAt(i, 12).toString());
                }
            }else if (ban = false){
                return ban;
            }else{
                return ban;
            }
        }
        return ban;
    }
    
    public void llenaCmbConcepto() {
        Session session;
        try {
            session = Conexion.getSession();
            session.beginTransaction();
            String sql = "from Concepto as c\n" +
                         "where c.estado = true";
            List<Concepto> lisCon = session.createQuery(sql).list();
            session.getTransaction().commit();
            cmbConcepto.removeAllItems();
            for (Concepto con : lisCon) {
                cmbConcepto.addItem(con.getDescripcion());
            }
            session.close();
        }catch (Exception e) {}
    }
    
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
     
    private void activarEmpSuc(){
        cmbEmpresa.setEnabled(true);
        cmbSucursal.setEnabled(true);
        cmbEmpresa.setBackground(Color.white);
        cmbSucursal.setBackground(Color.white);
    } 
    
    private void inactivarEmpSuc(){
        cmbEmpresa.setEnabled(false);
        cmbSucursal.setEnabled(false);
        cmbEmpresa.setBackground(Color.BLACK);
        cmbSucursal.setBackground(Color.black);
    }
    private void inactivarBusqueda(){
         // dejar no editable el txtbusqueda y no activo el boton busqueda
        txtBusqueda.setEditable(false);
        //borro el contendido de la caja de texto
        txtBusqueda.setText("");
        txtBusqueda.setBackground(Color.DARK_GRAY);
    }

    private void habilitarFechas(){
    fechaInicio.setEnabled(true);
    fechaFin.setEnabled(true);
    }
    
    private void deshabilitarFechas(){
        fechaInicio.setEnabled(false);
        fechaFin.setEnabled(false);
    }

    private void llenaJComboBoxInvestigacion(){
        Session session = null;
        try {
                session = Conexion.getSession();
                Criteria crit = session.createCriteria(Concepto.class);
                List<Concepto> rsConcepto = crit.list();// SELECT * FROM TABLA
                for (Concepto inv : rsConcepto) {
                    jcb.addItem(inv.getDescripcion());
                }
                session.close();
        } catch (Exception e) {
        }
    }
    
    public void soloNumeros(){
        jtf.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                permitirSoloNumero(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                permitirSoloNumero(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                permitirSoloNumero(e);
            }
            private void permitirSoloNumero(java.awt.event.KeyEvent evt) {
          // permitir solo el ingreso de numero
                char caracter = evt.getKeyChar();
                if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
                evt.consume();  // ignorar el evento de teclado
                }
            }
        });
        
    }
    
//    public void Excel(){
//        Workbook libro = new HSSFWorkbook();//Creo el LIBRO donde guardare las HOJAS
//            Map<String, CellStyle> styles = createStyles(libro);//Crea un ESTILO para la hoja
//            Sheet hoja = libro.createSheet("Novedades");//Creo una HOJA
//            hoja.setPrintGridlines(false);
//            hoja.setDisplayGridlines(false);
//            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));
//      
//
//            PrintSetup printSetup = hoja.getPrintSetup();
//            printSetup.setLandscape(true);
//            hoja.setFitToPage(true);
//            hoja.setHorizontallyCenter(true);
//      
//
//            Row filatitulo = hoja.createRow(0);//Creo la primer FILA
//            filatitulo.setHeightInPoints(35.0F);//Le doy un TAMAÑO
//            for (int i = 1; i <= 7; i++) {
//              filatitulo.createCell(i).setCellStyle((CellStyle)styles.get("title"));//Setea el ESTILO a las CELDAS  
//            }
//            Cell filaCell = filatitulo.getCell(2);//Obtiene una CELDA
//            filaCell.setCellValue("Cálculo retribuciones en especie: ");//Inserta el VALOR que queremos a la CELDA(ENCABEZADO)
//            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));//Combina y centra el VALOR insertado en la CELDA
//            
//            Row row = hoja.createRow(0);//Fila
//            Cell cell = row.createCell(0);//Columna
//            cell.setCellValue("Distribuidora Don Pedro");//Sacado de la BASE de DATOS
//            cell.setCellStyle((CellStyle)styles.get("title"));
//            
//            row = hoja.createRow(1);
//            cell = row.createCell(0);
//            cell.setCellValue("CUIT N°");//Sacado de la BASE de DATOS
//            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$2:$H$3"));
//            cell.setCellStyle((CellStyle)styles.get("fondo"));
//            
////            row = hoja.createRow(1);
//            cell = row.createCell(2);
//            cell.setCellValue("Junio 2013");//Sacado de la BASE de DATOS
//            cell.setCellStyle((CellStyle)styles.get("title"));
//            
//            row = hoja.createRow(3);
//            cell = row.createCell(2);
//            cell.setCellValue("Bruto nómina");
//            cell.setCellStyle((CellStyle)styles.get("item_left"));
//            cell = row.createCell(5);
////            cell.setCellValue(this.NominajTextField.getText());
//            cell.setCellStyle((CellStyle)styles.get("data"));
//            cell.setAsActiveCell();
//            
//            row = hoja.createRow(4);
//            cell = row.createCell(2);
//            cell.setCellValue("Ingreso a cuenta");
//            cell.setCellStyle((CellStyle)styles.get("item_left"));
//            cell = row.createCell(5);
////            cell.setCellValue(this.IngresoaCuentajTextField.getText());
//            cell.setCellStyle((CellStyle)styles.get("data"));
//            
//            row = hoja.createRow(5);
//            cell = row.createCell(2);
//            cell.setCellValue("Total retribucion en especie");
//            cell.setCellStyle((CellStyle)styles.get("item_left"));
//            cell = row.createCell(5);
////            cell.setCellValue(this.TotaljTextField.getText());
//            cell.setCellStyle((CellStyle)styles.get("data"));
//            
//            row = hoja.createRow(6);
//            cell = row.createCell(2);
//            cell.setCellValue("IVA repercutido");
//            cell.setCellStyle((CellStyle)styles.get("item_left"));
//            cell = row.createCell(5);
////            cell.setCellValue(this.IVAjTextField.getText());
//            cell.setCellStyle((CellStyle)styles.get("data"));
//            try {
//                CrearExcel(libro);
//            } catch (Exception ex) {
//                Logger.getLogger(TablaNovedades.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
//    public void CrearExcel(Workbook libro) throws Exception{
//        JFileChooser fc = null;
//        FileNameExtensionFilter filter = null;
//        if (fc == null){
//            fc = new JFileChooser();
//            fc.setDialogTitle("Guardar");
//      
//            fc.setFileSelectionMode(0);
//            filter = new FileNameExtensionFilter("Libro de Excel", new String[] { "xls" });
//            fc.addChoosableFileFilter(filter);
//            fc.setFileFilter(filter);
//        }
//        int returnVal = fc.showSaveDialog(this);
//        if (returnVal == 0){
//            File file = fc.getSelectedFile();
//            String ext = "";
//            if (fc.getFileFilter() == filter){
//                String extension = file.getAbsolutePath();
//                if (!extension.endsWith(".xls")){
//                    ext = ".xls";
//                }
//            }
//        try{
//            OutputStream output = new FileOutputStream(file + ext);
//            Throwable localThrowable2 = null;
//            try{
//                libro.write(output);
//                output.close();
//            }catch (Throwable localThrowable1){
//                localThrowable2 = localThrowable1;
//                throw localThrowable1;
//            }
//            finally{
//                if (output != null){
//                    if (localThrowable2 != null){
//                        try{
//                            output.close();
//                        }catch (Throwable x2){
//                            localThrowable2.addSuppressed(x2);
//                        }
//                    }else {
//                        output.close();
//                    }
//                }
//            }
//        }catch (FileNotFoundException e){
//            System.err.println(e.getMessage());
//        }catch (IOException e){
//            System.err.println(e.getMessage());
//        }
//     }
//     fc.setSelectedFile(null);
//  }
  
  private Map<String, CellStyle> createStyles(Workbook wb)
  {
    Map<String, CellStyle> styles = new HashMap();
    
    Font titleFont = wb.createFont();
    titleFont.setFontHeightInPoints((short)24);
    titleFont.setFontName("French Script MT");
    CellStyle style = wb.createCellStyle();
    
    Font fuenteTitulo = wb.createFont();
    fuenteTitulo.setFontHeightInPoints((short)24);
    fuenteTitulo.setFontName("French Script MT");
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
    style.setFillPattern((short)1);
    style.setFont(fuenteTitulo);
    styles.put("Titulo", style);
    
    Font itemFont = wb.createFont();
    itemFont.setFontHeightInPoints((short)10);
    itemFont.setFontName("Arial Black");
    style = wb.createCellStyle();
    style.setFont(itemFont);
    styles.put("item_left", style);
    
    itemFont.setFontHeightInPoints((short)10);
    itemFont.setFontName("Arial Black");
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("conceptos", style);
    
    itemFont.setFontHeightInPoints((short)9);
    itemFont.setFontName("Arial");
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("detalle", style);
    
    itemFont.setFontHeightInPoints((short)9);
    itemFont.setFontName("Verdana");
    itemFont.setBoldweight((short)3);
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("cabecera", style);
    
    itemFont.setFontHeightInPoints((short)9);
    itemFont.setFontName("Verdana");
    itemFont.setBoldweight((short)3);
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("localidad", style);
    
    itemFont.setFontHeightInPoints((short)9);
    itemFont.setFontName("Verdana");
    itemFont.setBoldweight((short)3);
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("suma", style);
    
    style = wb.createCellStyle();
    style.setAlignment((short)2);
    style.setFont(itemFont);
    styles.put("center", style);
    
    style = wb.createCellStyle();
    style.setAlignment((short)3);
    style.setFont(itemFont);
    style.setBorderRight((short)7);
    style.setRightBorderColor(IndexedColors.RED.getIndex());
    style.setBorderBottom((short)7);
    style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
    style.setBorderLeft((short)7);
    style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
    style.setBorderTop((short)7);
    style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
    style.setDataFormat(wb.createDataFormat().getFormat("0"));
    style.setBorderBottom((short)7);
    style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
    style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
    style.setFillPattern((short)1);
    styles.put("data", style);
    
    style.setFont(itemFont);
    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
    style.setAlignment((short)1);
    styles.put("fondo", style);
    

    return styles;
  }
  
  private void colores(int i, HSSFWorkbook wb, HSSFCell celda){
      Map<String, CellStyle> styles = new HashMap();
      CellStyle style = wb.createCellStyle();
      switch (i) {
          case 0:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 1:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 2:
                style.setAlignment((short)2);
                style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
                style.setFillPattern((short)1);
                styles.put(String.valueOf(i), style);
                celda.setCellStyle(style);
              break;
          case 3:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 4:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 5:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 6:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 7:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 8:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 9:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.RED.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 10:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 11:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 12:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIME.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 13:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.MAROON.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 14:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 15:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.PLUM.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 16:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          default:
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.RED.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              break;
      }
      
  }
  
  public void visualizaDialogo( Component padre, String texto, String titulo, final long timeout){
        
        
        JOptionPane option = new JOptionPane("", JOptionPane.INFORMATION_MESSAGE);
        
        option.setMessage(texto);
        
        if ( null == dialogo ){
            dialogo = option.createDialog(padre, titulo);
        }else{
            dialogo.setTitle(titulo);
        }
 
        Thread hilo = new Thread(){
            public void run(){
                try{
                    Thread.sleep(timeout);
                    if ( dialogo.isVisible() ){
                        dialogo.setVisible(false);
                    }
                }
                catch ( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
 
        dialogo.setVisible(true);
    }
  
  public void insertarChkBox(){
      chkbx.setSelected(false);
//      TableColumn tcol = tblNovedades.getColumn(14);
//      TableCellEditor tcell = new DefaultCellEditor(chkbx);
//      tcol.setCellEditor(tcell);
      tblNovedades.getColumn("EDITAR").setCellEditor(new DefaultCellEditor(chkbx));
  }
  
    public static boolean isCuantitativa(String c){
        if("CUANTITATIVA".equals(c)){
            return true;
        }else{
            return false;
        }
    }
    
}
  

  
   


