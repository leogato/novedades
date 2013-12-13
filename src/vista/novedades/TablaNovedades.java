/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.novedades;

import org.apache.poi.ss.usermodel.IndexedColors;
import hibernateUtil.Conexion;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Sucursal;
import util.FechaUtil;
import util.TablaUtil;
/**
 *
 * @author usuario
 */
public class TablaNovedades extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private List<Novedad> listaNov;
    private Empleado empleado;
    JComboBox jcb = new JComboBox();
    java.awt.Frame parent;
    //Variables para crear el Excel//
    int nxtRow;
    private String auxFecIni;
    private String auxFecFin;
    private short colores[] = new short[48];
    
    
    
    
    public TablaNovedades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        fechaInicio.setDate(new Date());
//        String fechaInicio;
        fechaInicio.setDate(FechaUtil.getFechaSinhora(new Date()));
        fechaFin.setDate(new Date());
        deshabilitarFechas();
        inactivarBusqueda();
        cmbConcepto.setEnabled(false);
        rdbHoy.requestFocus();
        rdbHoy.setSelected(true);
        llenaCmbConcepto();
        llenaCmbEmpresa();
//        llenaCmbSucursal();
        inactivarEmpSuc();
        btnExcel.setEnabled(false);
        
        
        

//        cargarTabla();
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
        btnImprimir = new org.edisoncor.gui.button.ButtonIcon();
        btnNuevo = new org.edisoncor.gui.button.ButtonIcon();
        btnGuardar = new org.edisoncor.gui.button.ButtonIcon();
        btnExcel = new org.edisoncor.gui.button.ButtonIcon();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de Novedades");
        setIconImage(null);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setOpaque(false);

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

        btnPDF.setBackground(new java.awt.Color(51, 51, 51));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPDF.setText("PDF");
        btnPDF.setAngulo(120);
        btnPDF.setDistanciaDeSombra(45);

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

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GUARDAR.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setAngulo(120);
        btnGuardar.setDistanciaDeSombra(45);

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

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        tblNovedades.setBackground(new java.awt.Color(153, 153, 153));
        tblNovedades.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tblNovedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"15/11/2013",  new Integer(237), "campos", "leonardo", null, null, "don pedro", "jujuy", "falta",  new Double(100.0), "nada"},
                {"15/11/2013",  new Integer(157), "ainstein", "facundo", null, null, "don pedro", "jujuy", "feriado",  new Double(300.0), "nada"},
                {"15/11/2013",  new Integer(233), "flores", "guillermo", null, null, "daniel manzur", "salta", "adelando",  new Double(400.0), "ade"},
                {"16/11/2013",  new Integer(133), "claure", "ruben", null, null, "fernando", "san pedro", "sin novedad",  new Double(100.0), "sin"},
                {"16/11/2013",  new Integer(233), "campos", "leonardo", null, null, "don pedro", "jujuy", "feriado",  new Double(400.0), "nada"}
            },
            new String [] {
                "FECHA", "LEGAJO", "APELLIDO", "NOMBRE", "CONVENIO", "TAREA", "EMPRESA", "SUCURSAL", "CONCEPTO", "CANTIDAD", "OBSERVACION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        System.out.println("Cantidad de dias entre una fecha y otra: "+FechaUtil.diferenciaEntreFechas(fechaInicio.getDate(), fechaFin.getDate()));
        List<Concepto> conce = (List) new ConceptoDaoImp().listarConcepto();
        System.out.println("Total de conceptos"+conce.size());
        
        for(IndexedColors c : IndexedColors.values()){
            System.out.println("c: "+c);
        }
        System.out.println("----------------------------------------------------------------------------");
        
        listaNov = new  ArrayList<Novedad>();
        //********VERIFICA QUE LA FECHA DE INICIO NO SEA MAYOR QUE LA FECHA DE FIN********\\
        if (fechaInicio.getDate().getTime()<=fechaFin.getDate().getTime()) {
            
            if (cmbBusqueda.getSelectedIndex()== 1) {
           //********BUSQUEDA POR LEGAJO********\\
                try {        
                    Empleado emp = new EmpleadoDaoImp().getEmpleado(Integer.parseInt(txtBusqueda.getText().toString()));
//                    String sql = "from Novedad as n join fetch n.empleado as e where e.legajo = '"+emp.getLegajo()+"'";
                    if (emp!=null) {
                        listaNov = new NovedadDaoImp().listarNovedad(emp,FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                    }else{
                        JOptionPane.showMessageDialog(this, "NO EXISTE EL EMPLEADO","ERROR",JOptionPane.ERROR_MESSAGE);
                    }         
                } catch (Exception e) {
//                   JOptionPane.showMessageDialog(this, "DEBES INGRESAR UN LEGAJO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else if(cmbBusqueda.getSelectedIndex()== 2){
                btnExcel.setEnabled(true);
                inactivarBusqueda();
                Empresa emp;
                Sucursal suc;
                String cod = String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1));
                System.out.println("Cod: "+cod);
                
                if (cod.charAt(1) == '-'){
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))));
                }else{
                    suc = new SucursalDaoImp().getSucursal(Integer.parseInt(String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(0))+String.valueOf(cmbSucursal.getSelectedItem().toString().charAt(1))));
                }
                
                if(suc!=null){
                   
                    auxFecIni = FechaUtil.getFechaString10DDMMAAAA(fechaInicio.getDate());
                    auxFecFin = FechaUtil.getFechaString10DDMMAAAA(fechaFin.getDate());
                    
                    if(suc.getNombre().equals("TODAS")){
                        /**/System.out.println("Todas");
                        emp = new EmpresaDaoImp().getEmpresa(Integer.parseInt(String.valueOf(cmbEmpresa.getSelectedItem().toString().charAt(0))));
                        listaNov = new NovedadDaoImp().listarNovedad(emp, auxFecIni, auxFecFin);
                    }else{
                        System.out.println("Por Sucursal");
                        listaNov = new NovedadDaoImp().listarNovedad(suc, auxFecIni, auxFecFin);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "NO EXISTE LA SUCURSAL","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if(cmbBusqueda.getSelectedIndex()== 3){
                Concepto con = new ConceptoDaoImp().getConceptoHql(cmbConcepto.getSelectedItem().toString());
                if(con!=null){
                    listaNov = new NovedadDaoImp().listarNovedad(con, FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                }else{
                    JOptionPane.showMessageDialog(this, "NO EXISTE EL CONCEPTO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
              // Busqueda asistencias de todos los empleados
                listaNov = new NovedadDaoImp().listarNovedad(FechaUtil.getFechaSinhora(fechaInicio.getDate()), fechaFin.getDate());
                }
          
        }else{  
               JOptionPane.showMessageDialog(this, "La fecha inicio no puedes ser mayor a la fecha Fin ","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            TablaUtil.prepararTablaRRHH(modelo, tblNovedades); 
            TablaUtil.cargarModeloRRHH(modelo, listaNov, tblNovedades);
            tblNovedades.setAutoCreateRowSorter(true);
            
            //******LLENA UN COMBOBOX Y LO INSERTA EN LA JTABLE EN LA COLUMNA  8 (CONCEPTOS)
            llenaJComboBoxInvestigacion();
            TableColumn tc = tblNovedades.getColumnModel().getColumn(8);
            TableCellEditor tce = new DefaultCellEditor(jcb);
            tc.setCellEditor(tce);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        
        int cel, o, dia,  valFecha, nxtFila, dias, indice, inicio, fin, cantDiasMes, nxtMes;
        String concepto;
        String valor;
        String legajo, apellido, nombre, convenio, tarea;
        String fecha;
        Empresa emp = new EmpresaDaoImp().getEmpresa(Integer.parseInt(String.valueOf(tblNovedades.getValueAt(1, 6).toString().charAt(0))));
        
        HSSFWorkbook libro;//crea el libro
        libro = new HSSFWorkbook();
        CellStyle style = libro.createCellStyle();
        Map<String, CellStyle> styles = createStyles(libro);
        HSSFCellStyle cs = (HSSFCellStyle) libro.createCellStyle();
        HSSFDataFormat df = libro.createDataFormat();
        cs.setDataFormat(df.getFormat("MMMM-yyyy"));
        HSSFSheet hoja = libro.createSheet("Novedades");//crea una hoja
        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));
        HSSFRow f = hoja.createRow(0);
        HSSFCell celda;
        celda = f.createCell(0);
        celda.setCellValue(emp.getNombre());
        celda.setCellStyle((CellStyle)styles.get("Titulo"));
        
        f = hoja.getRow(0);
        celda = f.createCell(4);
        celda.setCellValue(fechaInicio.getDate());
        celda.setCellStyle(cs);
        celda = f.createCell(5);
        celda.setCellValue("HASTA");
        celda = f.createCell(6);
        celda.setCellValue(fechaFin.getDate());
        celda.setCellStyle(cs);
        
        f = hoja.createRow(2);
        celda = f.createCell(0);
        celda.setCellValue("CONCEPTOS");
        celda.setCellStyle((CellStyle)styles.get("conceptos"));
        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$3:$C$3"));

        int k = 0;
        int j = 4;
        int i =0;
        Session sesion = Conexion.getSession();
        Criteria crit = sesion.createCriteria(Concepto.class);
        List<Concepto> list = crit.list();

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
                System.out.println("I: "+i);
                f = hoja.getRow(j);
                celda = f.createCell(k);
                celda.setCellValue(con.getCodCon()+"-"+con.getDescripcion());
//                celda.setCellStyle((CellStyle)styles.get("detalle"));
                j++;
                i++;
            }
            
            if (i == 8){
                k++;
                j = 3;
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
//                    for(int l = 0; l < tblNovedades.getRowCount(); l++){
//                        System.out.println("Entré");
//                        System.out.println("tabla: "+tblNovedades.getValueAt(l, 8));
//                        System.out.println("Concepto: "+con.getDescripcion());
//                        if (con.getDescripcion().equals(tblNovedades.getValueAt(l, 8))){
//                            System.out.println("Contenido de columna 8"+tblNovedades.getValueAt(id, 8));
//                            int cant = Integer.parseInt(tblNovedades.getValueAt(id, 9).toString());
//                            suma = suma + cant;
//                            id++;//PERMITE QUE VAYA RECORRIENDO LAS COLUMNAS DE CANTIDAD DE TABLA NOVEDADES// 
//                            celda = fil.createCell(q);
//                            celda.setCellValue(suma);
//                            q++;//VA CAMBIANDO LA COLUMNA DEPENDIENDO DEL CONCEPTO ENCONTRADO//...CREO
//                            fil = hoja.getRow(fila);
//    //                        fila++;
//
//                        }
//                    }
            }//***FIN IF QUE COMPARA CONCEPTOS PARA SACAR LAS CUANTITATIVAS
            System.out.println("Cantidad: "+cantCuanti);
        }//***TERMINA EL CICLO DE LLENADO DE CUANTITATIVAS
        
        dias = Integer.parseInt(String.valueOf(FechaUtil.diferenciaEntreFechas(fechaInicio.getDate(), fechaFin.getDate())));
        indice = 0;
        inicio = FechaUtil.getDia(fechaInicio.getDate());
        fin = FechaUtil.getDia(fechaFin.getDate());
        cantDiasMes = FechaUtil.getDiasDelMes(FechaUtil.getMes(fechaInicio.getDate()),FechaUtil.getAnio(fechaInicio.getDate()));
        nxtMes = 0;
        f = hoja.getRow(fila-1);
        
        //********ESCRIBE LOS DIAS QUE DESEO BUSCAR********//
        for(int ind = 0;ind < dias; ind++){
                celda = f.createCell(iCol);
                if((inicio+indice) < (cantDiasMes)){
                    celda.setCellValue(inicio+indice);
                    celda.setCellStyle((CellStyle)styles.get("cabecera"));
                    indice++;
                }else{
                    celda.setCellValue(inicio+indice);
                    celda.setCellStyle((CellStyle)styles.get("cabecera"));
                    inicio = 1;
                    indice = 0;
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
        SimpleDateFormat sdf;
        SimpleDateFormat sdf1;
//        hoja.addMergedRegion(CellRangeAddress.valueOf("$A$12:$C$12"));
        tblNovedades.getRowSorter().toggleSortOrder(7);//***ORDENA POR COLUMNA SUCURSAL***//
        
        //********MODULO PARA ESCRIBIR UNA SUCURSAL********//
        for(int ind = 0; ind < tblNovedades.getRowCount(); ind++){
            if(!valor.equals(tblNovedades.getValueAt(ind, 7).toString())){
                valor = tblNovedades.getValueAt(ind, 7).toString();
                f = hoja.createRow(fila);
                celda = f.createCell(0);
                celda.setCellValue(valor);
                fila++;
                tblNovedades.getRowSorter().toggleSortOrder(1);//******ORDENA POR LEGAJO
                
                //********MODULO PARA ESCRIBIR TODOS LOS EMPLEADOS DE ESA SUCURSAL QUE TENGAN NOVEDADES********//
                for(int m = 0; m < tblNovedades.getRowCount();m++){
                    if(!legajo.equals(tblNovedades.getValueAt(m, 1).toString())&& valor.equals(tblNovedades.getValueAt(m, 7))){
                        legajo = tblNovedades.getValueAt(m, 1).toString();
                        apellido = tblNovedades.getValueAt(m,2).toString();
                        nombre = tblNovedades.getValueAt(m,3).toString();
                        convenio = tblNovedades.getValueAt(m,4).toString();
                        tarea = tblNovedades.getValueAt(m,5).toString();
                        f = hoja.createRow(fila);
                        celda = f.createCell(0);
                        celda.setCellValue(legajo);
                        celda = f.createCell(1);
                        celda.setCellValue(apellido+" "+nombre);
                        celda = f.createCell(2);
                        celda.setCellValue(convenio);
                        celda = f.createCell(3);
                        celda.setCellValue(tarea);
                        hoja.autoSizeColumn(1);
                        hoja.autoSizeColumn(2);
                        hoja.autoSizeColumn(3);
                        //********MODULO PARA SUMAR LAS NOVEDADES CUANTITATIVAS DE CADA EMPLEADO********//
                        for( o = 0; o < cantCuanti; o++){//***RECORRE LAS COLUMNAS DEPENDIENDO DE CUANTOS CONCEPTOS CUANTITATIVOS HAYAN
                            suma = 0;
                            for(int n = 0; n < tblNovedades.getRowCount(); n++){//***RECORRE LA TABLA Y COMPARA LOS CONCEPTOS CON LOS QUE TENGO EXCEL
                                f = hoja.getRow(13);//***GETROW HACE REFERENCIA A LA FILA YA CREADA PARA VOLVER A ESCRIBIR EN ELLA***\\
                                celda = f.getCell(cel+o);
                                concepto = celda.getStringCellValue();
                                if(concepto.equals(tblNovedades.getValueAt(n, 8).toString())&&legajo.equals(tblNovedades.getValueAt(n, 1).toString())){
                                    suma = suma + Integer.parseInt(tblNovedades.getValueAt(n, 9).toString());
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
                        tblNovedades.getRowSorter().toggleSortOrder(0);//***ORDENA LAS COLUMNAS DEL JTABLE POR FECHA***\\
                        //***RECORRE LA FILAS DEL JTABLE ORDENADO POR FECHAS***\\
                        for(int p = 0;p < tblNovedades.getRowCount(); p++){
                            
                            //***PREGUNTA SI EL LEGAJO EN EL EXCEL ES IGUAL AL DEL JTABLE
                            if (legajo.equals(tblNovedades.getValueAt(p, 1).toString())){
                                
                                try {
                                    fecha = tblNovedades.getValueAt(p, 0).toString();
                                    String aux = FechaUtil.FormateaFecha(fecha);
                                    sdf = new SimpleDateFormat("dd-MM-yyyy");
                                    Date date = sdf.parse(aux);
                                    dia = FechaUtil.getDia(date);
                                    
                                    //***CICLO PARA ESCRIBIR LAS NOVEDADES CUALITATIVAS DE LOS EMPLEADOS QUE TUVIERAN***\\
                                    do{
                                        f = hoja.getRow(13);
                                        celda = f.getCell(cel2);
                                        valFecha = (int) celda.getNumericCellValue();
                                        
                                        //IF PARA COMPARAR LAS FECHAS BUSCADAS CON LAS DEL JTABLE
                                        if(dia == valFecha){
                                            Concepto con = new ConceptoDaoImp().getConceptoHql(tblNovedades.getValueAt(p, 8).toString());
                                            f = hoja.getRow(fila);
                                            celda = f.createCell(cel2);
                                            celda.setCellValue(con.getCodCon());

                                            //***RECORRE EL JTABLE PARA ASIGNARLE COLORES A LOS CONCEPTOS QUE VA ENCONTRANDO***\\    
                                            for(int z = 0; z < tblNovedades.getRowCount();z++){
                                                System.out.println("codCon: "+con.getCodCon());
                                                
                                                if (con.getCodCon() == z){
                                                    System.out.println("Entro al IF");
                                                    colores(z, libro, celda);
                                                }
                                            
                                            }//FIN DE CICLO QUE ASIGNA COLOR
                                            
                                        }else{
                                            cel2++;
                                        }//FIN IF DE COMPARACION DE FECHAS
                                    }while(dia != valFecha);//***FIN DE CICLO DO WHILE

                                } catch (ParseException ex) {
                                    Logger.getLogger(TablaNovedades.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }//***FIN DE IF QUE COMPARA LEGAJOS
                        }//***FIN DE CICLO QUE RECORRE FILAS ORDENADAS

                        tblNovedades.getRowSorter().toggleSortOrder(1);//ORDENA LA TABLA POR LEGAJO
                        
                        fila++; //INCREMENTA LA FILA EN 1
                    }//FIN DE IF DONDE CONSULTA POR LEGAJO Y VALOR

                }//TERMINA EL MODULO PARA ESCRIBIR TODOS LOS EMPLEADOS
                tblNovedades.getRowSorter().toggleSortOrder(7);//ORDENA LA TABLA POR SUCURSAL      
            }//FIN DE IF QUE CONSULTA POR UN VALOR DENTRO DE LA JTABLE

        }//FIN DE MODULO PARA ESCRIBIR TODAS LAS SUCURSALES
            
        //***ESCRIBE EL LIBRO***\\
        try {
            FileOutputStream elFichero = new FileOutputStream("prueba.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
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
                
            }else if(cmbBusqueda.getSelectedIndex() == 1){
                txtBusqueda.setEditable(true);
                txtBusqueda.setBackground(Color.YELLOW);
                txtBusqueda.setForeground(Color.BLACK);
                txtBusqueda.requestFocus();
                cmbConcepto.setEnabled(false);
                cmbConcepto.setEditable(false);
                btnExcel.setEnabled(false);
                inactivarEmpSuc();
                
            }else if(cmbBusqueda.getSelectedIndex() == 2){
                cmbEmpresa.requestFocus();
                activarEmpSuc();
                inactivarBusqueda();
                cmbConcepto.setEnabled(false);
                
            }else if (cmbBusqueda.getSelectedIndex() == 3){
                cmbConcepto.setEnabled(true);
                btnExcel.setEnabled(false);
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
    
    private void cargarTabla(List<Novedad> listaNovedad){
        listaNovedad = new NovedadDaoImp().listarNovedad();
        util.TablaUtil.prepararTablaRRHH(modelo, tblNovedades);
        util.TablaUtil.cargarModeloRRHH(modelo, listaNovedad, tblNovedades);
    }
    
    public void llenaCmbConcepto() {
        Session sesion;
        try {
            sesion = Conexion.getSession();
            Criteria crit = sesion.createCriteria(Concepto.class);
            List<Concepto> rsConcepto = crit.list();// SELECT * FROM TABLA
            System.out.println("rsConcepto: "+rsConcepto);
            cmbConcepto.removeAllItems();
            for (Concepto con : rsConcepto) {
                cmbConcepto.addItem(con.getDescripcion());
            }
            sesion.close();
        } catch (Exception e) {
        }
    }
    
    private void llenaCmbEmpresa(){
        Session sesion;
        try{
            sesion = Conexion.getSession();
            sesion.beginTransaction();
            String sql = "from Empresa";
//            Criteria crit = sesion.createCriteria(Empresa.class);
//            List<Empresa> rsEmpresa = crit.list();
            List<Empresa> rsEmpresa = (List<Empresa>)sesion.createQuery(sql).list();
            System.out.println("rsEmpresa: "+rsEmpresa);
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
        
        
        
      
//        btnBusquedaPersonal.setEnabled(false);
    }
    private void activarBusqueda(){
       txtBusqueda.setEditable(false);
       cmbEmpresa.setEditable(true);
       cmbSucursal.setEditable(true);
       //obtnego el foco
       cmbEmpresa.requestFocus();
//       txtSucursal.requestFocus();
       //cambio el color
       txtBusqueda.setBackground(Color.darkGray);
       cmbSucursal.setBackground(Color.white);
       cmbEmpresa.setBackground(Color.WHITE);
//       btnBusquedaPersonal.setEnabled(true);
         
    }
    private void activarLegajo(){
        txtBusqueda.setEditable(true);
        cmbSucursal.setEditable(false);
        cmbEmpresa.setEditable(false);
        txtBusqueda.requestFocus();
        txtBusqueda.setBackground(Color.white);
        cmbSucursal.setBackground(Color.DARK_GRAY);
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
        Session session = null;
        try {
                session = Conexion.getSession();
                Criteria crit = session.createCriteria(Concepto.class);
                List<Concepto> rsConcepto = crit.list();// SELECT * FROM TABLA
                System.out.println("Entre a llenaCMB");
                for (Concepto inv : rsConcepto) {
                    System.out.println("desc "+inv.getDescripcion());
                    jcb.addItem(inv.getDescripcion());
                }
                System.out.println("Salte el For");
                session.close();
        } catch (Exception e) {
        }
    }
    
    public void Excel(){
        Workbook libro = new HSSFWorkbook();//Creo el LIBRO donde guardare las HOJAS
            Map<String, CellStyle> styles = createStyles(libro);//Crea un ESTILO para la hoja
            Sheet hoja = libro.createSheet("Novedades");//Creo una HOJA
            hoja.setPrintGridlines(false);
            hoja.setDisplayGridlines(false);
            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));
      

            PrintSetup printSetup = hoja.getPrintSetup();
            printSetup.setLandscape(true);
            hoja.setFitToPage(true);
            hoja.setHorizontallyCenter(true);
      

            Row filatitulo = hoja.createRow(0);//Creo la primer FILA
            filatitulo.setHeightInPoints(35.0F);//Le doy un TAMAÑO
            for (int i = 1; i <= 7; i++) {
              filatitulo.createCell(i).setCellStyle((CellStyle)styles.get("title"));//Setea el ESTILO a las CELDAS  
            }
            Cell filaCell = filatitulo.getCell(2);//Obtiene una CELDA
            filaCell.setCellValue("Cálculo retribuciones en especie: ");//Inserta el VALOR que queremos a la CELDA(ENCABEZADO)
            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$1:$H$1"));//Combina y centra el VALOR insertado en la CELDA
            
            Row row = hoja.createRow(0);//Fila
            Cell cell = row.createCell(0);//Columna
            cell.setCellValue("Distribuidora Don Pedro");//Sacado de la BASE de DATOS
            cell.setCellStyle((CellStyle)styles.get("title"));
            
            row = hoja.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue("CUIT N°");//Sacado de la BASE de DATOS
            hoja.addMergedRegion(CellRangeAddress.valueOf("$A$2:$H$3"));
            cell.setCellStyle((CellStyle)styles.get("fondo"));
            
//            row = hoja.createRow(1);
            cell = row.createCell(2);
            cell.setCellValue("Junio 2013");//Sacado de la BASE de DATOS
            cell.setCellStyle((CellStyle)styles.get("title"));
            
            row = hoja.createRow(3);
            cell = row.createCell(2);
            cell.setCellValue("Bruto nómina");
            cell.setCellStyle((CellStyle)styles.get("item_left"));
            cell = row.createCell(5);
//            cell.setCellValue(this.NominajTextField.getText());
            cell.setCellStyle((CellStyle)styles.get("data"));
            cell.setAsActiveCell();
            
            row = hoja.createRow(4);
            cell = row.createCell(2);
            cell.setCellValue("Ingreso a cuenta");
            cell.setCellStyle((CellStyle)styles.get("item_left"));
            cell = row.createCell(5);
//            cell.setCellValue(this.IngresoaCuentajTextField.getText());
            cell.setCellStyle((CellStyle)styles.get("data"));
            
            row = hoja.createRow(5);
            cell = row.createCell(2);
            cell.setCellValue("Total retribucion en especie");
            cell.setCellStyle((CellStyle)styles.get("item_left"));
            cell = row.createCell(5);
//            cell.setCellValue(this.TotaljTextField.getText());
            cell.setCellStyle((CellStyle)styles.get("data"));
            
            row = hoja.createRow(6);
            cell = row.createCell(2);
            cell.setCellValue("IVA repercutido");
            cell.setCellStyle((CellStyle)styles.get("item_left"));
            cell = row.createCell(5);
//            cell.setCellValue(this.IVAjTextField.getText());
            cell.setCellStyle((CellStyle)styles.get("data"));
            try {
                CrearExcel(libro);
            } catch (Exception ex) {
                Logger.getLogger(TablaNovedades.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void CrearExcel(Workbook libro) throws Exception{
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
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == 0){
            File file = fc.getSelectedFile();
            String ext = "";
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
            System.err.println(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
     }
     fc.setSelectedFile(null);
  }
  
  private Map<String, CellStyle> createStyles(Workbook wb)
  {
    Map<String, CellStyle> styles = new HashMap();
    
    Font titleFont = wb.createFont();
    titleFont.setFontHeightInPoints((short)24);
//    titleFont.setFontName("Trebuchet MS");
    titleFont.setFontName("French Script MT");
    CellStyle style = wb.createCellStyle();
    style.setBorderBottom((short)7);
    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    style.setFont(titleFont);
    style.setFillBackgroundColor(IndexedColors.INDIGO.getIndex());
    styles.put("title", style);
    
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
//    style.setAlignment((short)1);
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
    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
    style.setFillPattern((short)1);
    style.setFont(itemFont);
    styles.put("suma", style);
    
    style = wb.createCellStyle();
    style.setAlignment((short)3);
    style.setFont(itemFont);
    styles.put("item_right", style);
    

//    style = wb.createCellStyle();
//    style.setAlignment((short)3);
//    style.setFont(itemFont);
//    style.setBorderRight((short)7);
//    style.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
//    style.setBorderBottom((short)7);
//    style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
//    style.setBorderLeft((short)7);
//    style.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
//    style.setBorderTop((short)7);
//    style.setTopBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
//    style.setDataFormat(wb.createDataFormat().getFormat("0"));
//    style.setBorderBottom((short)7);
//    style.setBottomBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
//    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//    style.setFillPattern((short)1);
//    styles.put("data", style);
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
      System.out.println("Entro al switch");
      Map<String, CellStyle> styles = new HashMap();
      CellStyle style = wb.createCellStyle();
      switch (i) {
          case 0:
            System.out.println("Entro "+i);
            style.setAlignment((short)2);
            style.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
            style.setFillPattern((short)1);
            styles.put(String.valueOf(i), style);
            celda.setCellStyle(style);
          case 1:
                System.out.println("Entro "+i);
                style.setAlignment((short)2);
                style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
                style.setFillPattern((short)1);
                styles.put(String.valueOf(i), style);
                celda.setCellStyle(style);

              break;
          case 2:
              System.out.println("Entro "+i);
                style.setAlignment((short)2);
                style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
                style.setFillPattern((short)1);
                styles.put(String.valueOf(i), style);
                celda.setCellStyle(style);
              break;
          case 3:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 4:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 5:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 6:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 7:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 8:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 9:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 10:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 11:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 12:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.LIME.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 13:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.MAROON.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 14:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          case 15:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.PLUM.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;
          case 16:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              celda.setCellStyle(style);
              break;    
          default:
              System.out.println("Entro "+i);
              style.setAlignment((short)2);
              style.setFillForegroundColor(IndexedColors.RED.getIndex());
              style.setFillPattern((short)1);
              styles.put(String.valueOf(i), style);
              break;
      }
      
      
  }
  
}
  

  
   


