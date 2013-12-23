/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



import hibernateUtil.Conexion;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import novedades.dao.imp.EmpleadoDaoImp;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Usuario;
import vistas.cargaNovedades;

/**
 *
 * @author Alumno
 */
public class TablaUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static String fecha;
    /**
     * Crea la estructura de la tabla Asamblea , indica que columnas contendra
     * @param modelo  modelo de la tabla asamblea 
     * @param tablaAsamblea  tabla donde contendra informacion de todas las asableas
     */
    public static void prepararTablaAsistencia(DefaultTableModel modelo, JTable tablaAsistencia){
        
        String[] titulos = {"ID","LEGAJO","EMPLEADO","ENTRADA/SALIDA","FECHA","HORA"};
       modelo= new DefaultTableModel(null,titulos){
                	@Override// impleamento este metodo para que la tabla sea no editable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
       };
       
       tablaAsistencia.setModel(modelo);
    }
    
    
    /**
     * Carga todos registros en la tabla Asamblea 
     * @param modelo  modelos de la tabla asamblea
     * @param listaAsamblea  
     * @param tablaAsamblea tabla donde contiene toda la informacion de las asambleas
     */
    
//    public static void cargarModeloAsistencia(DefaultTableModel modelo,Set<Asistencia> listaOrdenDia,JTable tablaOrdendelDia){
//         modelo =(DefaultTableModel) tablaOrdendelDia.getModel();
//       for (Iterator it = listaOrdenDia.iterator(); it.hasNext();) {
//        Asistencia a = (Asistencia) it.next();
//        // extraigo de la asistencia el legajo y nombre del empleado
//        Object[] empl = new AsistenciaDaoImp().getLegajoYNombreEmpleadoDeAsis(a.getIdAsistencia());
//        String fecha= FechaUtil.getDateDDMMAAAA(a.getFecha());
//        Object[] filaAsistencia = {a.getIdAsistencia(),empl[0],empl[1],a.getEstado(),fecha,FechaUtil.getHora(a.getHora())}; 
//        modelo.addRow(filaAsistencia);
//             
//    }
//       // hago que la columna 0 no sea visible
//        tablaOrdendelDia.getColumnModel().getColumn(0).setMaxWidth(0);
//        tablaOrdendelDia.getColumnModel().getColumn(0).setMinWidth(0);
//        tablaOrdendelDia.getColumnModel().getColumn(0).setPreferredWidth(0);
//}
    public static void cargarModeloConcepto(DefaultTableModel modelo,List<Concepto> listaConcepto,JTable tablaOrdendelDia){
         modelo =(DefaultTableModel) tablaOrdendelDia.getModel();
         for (Concepto a : listaConcepto) {
        Object[] filaNovedad = {a.getCodCon(),a.getDescripcion(),a.getTipo(),a.getCargaUser()}; 
        modelo.addRow(filaNovedad);
    }
//        Conexion.getSessionFactory().close();
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
             Object[] filaNovedad = {a.getId(),a.getFecha(),a.getEmpleado().getLegajo(),a.getEmpleado().getApellido(),a.getEmpleado().getNombre(),a.getEmpleado().getConvenio(),a.getEmpleado().getTarea(),a.getEmpleado().getSucursal().getEmpresa().getCodEmp()+"-"+a.getEmpleado().getSucursal().getEmpresa().getNombre(),a.getEmpleado().getSucursal().getCodSuc()+"-"+a.getEmpleado().getSucursal().getNombre(),a.getConcepto().getDescripcion(),a.getCantidad(),a.getObservacion()}; 
            modelo.addRow(filaNovedad);
            
        }
        tablaOrdendelDia.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(0).setMinWidth(0);
        tablaOrdendelDia.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    public static void prepararTablaRRHH(DefaultTableModel modelo, JTable tablaConcepto){
        String[] titulos = {"ID","FECHA","LEGAJO","APELLIDO","NOMBRE","CONVENIO","TAREA","EMPRESA","SUCURSAL","CONCEPTO","CANTIDAD", "OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int col){
                if(col == 9){    
                    return true;
                }else{
                    return false;
                }
            }
        };
        tablaConcepto.setModel(modelo);
    }
//    public static void prepararTablaRRHH(DefaultTableModel modelo, JTable tablaConcepto){
//        String[] titulos = {"FECHA","LEGAJO","APELLIDO","NOMBRE","CONVENIO","TAREA","EMPRESA","SUCURSAL","CONCEPTO","CANTIDAD", "OBSERVACION"};
//        modelo = new DefaultTableModel(null, titulos){
//            @Override
//            public boolean isCellEditable(int row, int col){
//                
//                if (col == 8){
//                    return true;
//                    
//                }else{
//                    return false;
//                }
//            
//            }
//        };
//        tablaConcepto.setModel(modelo);
//    }
    
    public static void prepararTablaNovedades(DefaultTableModel modelo, JTable tablaNovedades, String tipo){
        System.out.println("Tipo: "+tipo);
        final String aux = tipo;
        System.out.println("aux: "+aux);
        String[] titulos = {"LEGAJO","APELLIDO","NOMBRE","CONCEPTO","CANTIDAD","OBSERVACION"};
        
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row,int col){
                boolean b = false;
                System.out.println("col: "+col);
                
                if(col == 3){
                    b = true;
                }
                    
                
                return b;
            }
       
       
//            public boolean isCellEditable(int row, int col){
//                System.out.println("Entro!");
//                boolean b = false;
//                    if (aux.equals("CUANTITATIVA")){
//                        if (col == 4){
//                            b= true;
//                        }else if(col == 5){
//                            b = true;
//                        }
//                    }
//                    return b;
//            }
                
        };
        tablaNovedades.setModel(modelo);
    }
    public static void prepararTablaNovedades(DefaultTableModel modelo, JTable tablaNovedades){
        String[] titulos = {"LEGAJO","APELLIDO","NOMBRE","CONCEPTO","CANTIDAD","OBSERVACION"};
        
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row,int col){
                boolean b = false;
                if(col == 4){
                        b = true;
                    }else if (col == 5){
                        b= true;
                    }else if(col == 3){
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
            Object[] filaAsistencia = {n.getLegajo(),n.getApellido(),n.getNombre(),"Sin Novedad"}; 
            modelo.addRow(filaAsistencia);
        }
//        Conexion.getSessionFactory().close();
    }
    public static void cargarNovedadesCompleta(DefaultTableModel modelo, List<Novedad> listaEmpleado, JTable tablaNovedades){
        modelo = (DefaultTableModel) tablaNovedades.getModel();
        for (Novedad n : listaEmpleado){
            Object[] filaAsistencia = {n.getEmpleado().getLegajo(),n.getEmpleado().getApellido(),n.getEmpleado().getNombre(),n.getConcepto().getDescripcion(),n.getCantidad(),n.getObservacion()};//,n.getEmpleado().getNombre(),n.getConcepto().getDescripcion(),n.getCantidad(),n.getObservacion()}; 
            modelo.addRow(filaAsistencia);
            //Cargar todas las novedades con fecha de hoy
        }
    }
    
    public static void prepararTablaEmpleado(DefaultTableModel modelo, JTable tablaEmpleado){
        String[] titulos = {"LEGAJO","APELLIDO","NOMBRE","EMPRESA","SUCURSAL","CUIT","CONVENIO","TAREA"};
        modelo= new DefaultTableModel(null,titulos){
            @Override// impleamento este metodo para que la tabla sea no editable
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaEmpleado.setModel(modelo);
    }  
  
    
  
  public static void cargarModeloEmpleado(DefaultTableModel modelo,List<Empleado>listaEmpleado,JTable tablaEmpleado){
    modelo =(DefaultTableModel) tablaEmpleado.getModel();
    if (listaEmpleado == null)
        JOptionPane.showMessageDialog(tablaEmpleado, "Lista de usuario esta vacia, cargue un nuevo Empleado");
        for ( Empleado a : listaEmpleado) {
            Object[] filaEmpleado = {a.getLegajo(),a.getApellido(),a.getNombre(),a.getCodEmp(),a.getSucursal().getCodSuc(),a.getCuit(),a.getConvenio(),a.getTarea()}; 
            modelo.addRow(filaEmpleado);
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
            JOptionPane.showMessageDialog(tablaEmpresa, "Lista de usuario esta vacia, cargue un nuevo Empleado");
            for ( Empresa e : listaEmpresa) {
                Object[] filaEmpleado = {e.getCodEmp(),e.getNombre(),e.getGerente(),e.getMailGerente(),e.getEstado()};
                modelo.addRow(filaEmpleado);
            }
            tablaEmpresa.setAutoCreateRowSorter(true);
            tablaEmpresa.setAutoResizeMode(0);
    }
  
    public static void prepararTablaUsuario(DefaultTableModel modelo, JTable tablaUsuario){
        
        String[] titulos = {"LEGAJO","USUARIO","DESCRIPCION","CLAVE","TIPO"};
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
                Object[] filaUsuario = {u.getEmpleado().getLegajo(),u.getUsuario(),u.getDescripcion(),u.getClave(),u.getTipo()};
                modelo.addRow(filaUsuario);
               // hago que la columna 0 no sea visible
//                tablaUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
//                tablaUsuario.getColumnModel().getColumn(0).setMinWidth(0);
//                tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(0);

           }
        
 }
  
}
    
    
 