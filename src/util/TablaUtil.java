/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Usuario;

/**
 *
 * @author Alumno
 */
public class TablaUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static String fecha;
    
    
    public static void cargarModeloConcepto(DefaultTableModel modelo,List<Concepto> listaConcepto,JTable tablaOrdendelDia){
         modelo =(DefaultTableModel) tablaOrdendelDia.getModel();
         String carga = null;
         for (Concepto a : listaConcepto) {
            if (a.getCargaUser()) {
                carga = "SI";
            }else{
                carga = "NO";
            }
                
            Object[] filaNovedad = {a.getCodCon(),a.getDescripcion(),a.getTipo(),carga}; 
            modelo.addRow(filaNovedad);
        }
         
    }
    
    public static void prepararTablaConcepto(DefaultTableModel modelo, JTable tablaConcepto){
        String[] titulos = {"CODIGO","DESCRIPCION","TIPO","CARGA USUARIO"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        tablaConcepto.setModel(modelo);
    }
    
    public static void cargarModeloRRHH(DefaultTableModel modelo,List<Novedad> listaNovedad,JTable tablaOrdendelDia){
         modelo =(DefaultTableModel) tablaOrdendelDia.getModel();
         for (Novedad a : listaNovedad) {
             Object[] filaNovedad = {a.getId(),a.getFecha(),a.getEmpleado().getId(),a.getEmpleado().getLegajo(),a.getEmpleado().getApellido(),a.getEmpleado().getNombre(),a.getEmpleado().getConvenio(),a.getEmpleado().getTarea(),a.getEmpleado().getSucursal().getEmpresa().getCodEmp()+"-"+a.getEmpleado().getSucursal().getEmpresa().getNombre(),a.getEmpleado().getSucursal().getCodSuc()+"-"+a.getEmpleado().getSucursal().getNombre(),a.getConcepto().getDescripcion(),a.getCantidad(),a.getObservacion(),a.getQuien(),a.getModificador()}; 
            modelo.addRow(filaNovedad);
            
        }
        tablaOrdendelDia.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(0).setMinWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(2).setMinWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(2).setPreferredWidth(0);
        
    }
    
    public static void prepararTablaRRHH(DefaultTableModel modelo, JTable tablaConcepto){
        String[] titulos = {"ID","FECHA","IDEMP","LEGAJO","APELLIDO","NOMBRE","CONVENIO","TAREA","EMPRESA","SUCURSAL","CONCEPTO","CANTIDAD", "OBSERVACION","USUARIO","MODIFICADOR","EDITAR"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int col){
                if(col == 10 || col == 11 || col == 12 || col == 15){    
                    return true;
                }else{
                    return false;
                }
            }
            @Override
            public Class getColumnClass(int column) {
                if (column == 11 || column == 3) {
                    return Integer.class;
                } else {
                    return Object.class;
                }
            }
        };
        tablaConcepto.setModel(modelo);
    }
    
    public static void prepararTablaNovedades(DefaultTableModel modelo, JTable tablaNovedades, String tipo){
        final String aux = tipo;
        String[] titulos = {"ID","IDEMP","LEGAJO","APELLIDO","NOMBRE","CONCEPTO","CANTIDAD","OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row,int col){
                boolean b = false;
                if(col == 5 || col == 6 || col == 7){
                    b = true;
                }
                return b;
            }
        };
        tablaNovedades.setModel(modelo);
    }
    
    public static void prepararTablaCargaRRHH(DefaultTableModel modelo, JTable tablaNovedades){
        String[] titulos = {"ID","IDEMP","LEGAJO","APELLIDO","NOMBRE","CONCEPTO","CANTIDAD","OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row,int col){
                boolean b = false;
                if(col == 5 || col == 6 || col == 7){
                        b = true;
                }
                return b;
            }
        };
        tablaNovedades.setModel(modelo);
    }
    
    public static void cargarModeloNovedades(DefaultTableModel modelo,List<Empleado> listaEmpleado,JTable tablaNovedades){
        modelo = (DefaultTableModel) tablaNovedades.getModel();
        
        for (Empleado n : listaEmpleado){
            Object[] filaAsistencia = {"",n.getId(),n.getLegajo(),n.getApellido(),n.getNombre(),"Sin Novedad"}; 
            modelo.addRow(filaAsistencia);
        }
        
        tablaNovedades.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaNovedades.getColumnModel().getColumn(0).setMinWidth(0);
        tablaNovedades.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setMinWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setPreferredWidth(0);
////        Conexion.getSessionFactory().close();
    }
    
    public static void cargarNovedadesCompleta(DefaultTableModel modelo, List<Novedad> listaEmpleado, JTable tablaNovedades){
        modelo = (DefaultTableModel) tablaNovedades.getModel();
        
        for (Novedad n : listaEmpleado){
            Object[] filaAsistencia = {n.getId(),"",n.getEmpleado().getLegajo(),n.getEmpleado().getApellido(),n.getEmpleado().getNombre(),n.getConcepto().getDescripcion(),n.getCantidad(),n.getObservacion()};//,n.getEmpleado().getNombre(),n.getConcepto().getDescripcion(),n.getCantidad(),n.getObservacion()}; 
            modelo.addRow(filaAsistencia);
        }
        
        tablaNovedades.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaNovedades.getColumnModel().getColumn(0).setMinWidth(0);
        tablaNovedades.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setMinWidth(0);
        tablaNovedades.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    
    public static void prepararTablaEmpleado(DefaultTableModel modelo, JTable tablaEmpleado){
        String[] titulos = {"IDEMP","LEGAJO","APELLIDO","NOMBRE","EMPRESA","SUCURSAL","CUIT","CONVENIO","TAREA"};
        modelo= new DefaultTableModel(null,titulos){
            @Override// impleamento este metodo para que la tabla sea no editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class getColumnClass(int column) {
                if (column == 1) {
                    return Integer.class;
                } else {
                    return Object.class;
                }
            }
            
        };
        tablaEmpleado.setModel(modelo);
    }  
  
  
  public static void cargarModeloEmpleado(DefaultTableModel modelo,List<Empleado>listaEmpleado,JTable tablaEmpleado){
    modelo =(DefaultTableModel) tablaEmpleado.getModel();
    if (listaEmpleado == null)
        JOptionPane.showMessageDialog(tablaEmpleado, "LA LISTA ESTA VACIA, CARGUE UN EMPLEADO");
        for ( Empleado a : listaEmpleado) {
            Object[] filaEmpleado = {a.getId(),a.getLegajo(),a.getApellido(),a.getNombre(),a.getNomEmp(),a.getNomSuc(),a.getCuit(),a.getConvenio(),a.getTarea()}; 
            modelo.addRow(filaEmpleado);
            tablaEmpleado.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaEmpleado.getColumnModel().getColumn(0).setMinWidth(0);
            tablaEmpleado.getColumnModel().getColumn(0).setPreferredWidth(0);
        }
    }
  
    public static void prepararTablaEmpresa(DefaultTableModel modelo, JTable tablaEmpresa){
        String[] titulos = {"CODIGO","NOMBRE","GERENTE","MAIL","ESTADO"};
        modelo= new DefaultTableModel(null,titulos){
            @Override// impleamento este metodo para que la tabla sea no editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaEmpresa.setModel(modelo);
    }  
  
    public static void cargarModeloEmpresa(DefaultTableModel modelo,List<Empresa>listaEmpresa,JTable tablaEmpresa){
        modelo =(DefaultTableModel) tablaEmpresa.getModel();
        if (listaEmpresa == null)
            JOptionPane.showMessageDialog(tablaEmpresa, "LA LISTA ESTA VACIA, CARGUE UNA NUEVA EMPRESA");
            for ( Empresa e : listaEmpresa) {
                Object[] filaEmpleado = {e.getCodEmp(),e.getNombre(),e.getGerente(),e.getMailGerente(),e.getEstado()};
                modelo.addRow(filaEmpleado);
            }
            tablaEmpresa.setAutoCreateRowSorter(true);
            tablaEmpresa.setAutoResizeMode(0);
    }
  
    public static void prepararTablaUsuario(DefaultTableModel modelo, JTable tablaUsuario){
        
        String[] titulos = {"ID","LEGAJO","USUARIO","DESCRIPCION","TIPO"};
       modelo= new DefaultTableModel(null,titulos){
                	@Override// impleamento este metodo para que la tabla sea no editable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
       };
       tablaUsuario.setModel(modelo);
    } 
 
 public static void cargarModeloUsuario(DefaultTableModel modelo, List<Usuario> listaUsuario, JTable tablaUsuario){
    modelo =(DefaultTableModel) tablaUsuario.getModel();
            for (Usuario u : listaUsuario) {
                Object[] filaUsuario = {u.getEmpleado().getId(),u.getLegajo(),u.getUsuario(),u.getDescripcion(),u.getTipo()};
                modelo.addRow(filaUsuario);
               // hago que la columna 0 no sea visible
                tablaUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
                tablaUsuario.getColumnModel().getColumn(0).setMinWidth(0);
                tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);

           }
        
 }
 
 
 
 
 
 
 public DefaultCellEditor integerEditor;
 StringOnlyDigitField doc = new StringOnlyDigitField();

    public void StringDigitalCellEditor(){
         //JTextField al cual le pongamos el document.
         final JTextField integerField = new JTextField();
         //Poniendole el document al JTextField que creamos.
         integerField.setDocument(doc);
         integerField.setHorizontalAlignment(JTextField.LEFT);

        // insertando el JTextField  en el CellEditor.
         integerEditor = new DefaultCellEditor(integerField) {
             @Override
             //metodo que se encarga de devolver el valor editado.
             public Object getCellEditorValue() {
                 return integerField.getText();
             }
         };

    }
  
}
    
    
 