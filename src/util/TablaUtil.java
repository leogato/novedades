/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



import hibernateUtil.Conexion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import novedades.dao.imp.EmpleadoDaoImp;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;
import pojo.Usuario;
import vistas.cargaNovedades;

/**
 *
 * @author Alumno
 */
public class TablaUtil {
    
    
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
        Object[] filaNovedad = {a.getFecha(),a.getEmpleado().getLegajo(),a.getEmpleado().getApellido(),a.getEmpleado().getNombre(),a.getEmpleado().getSucursal().getEmpresa().getCodEmp()+" "+a.getEmpleado().getSucursal().getEmpresa().getNombre(),a.getEmpleado().getSucursal().getCodSuc()+" "+a.getEmpleado().getSucursal().getNombre(),a.getConcepto().getCodCon()+"-"+a.getConcepto().getDescripcion(),a.getCantidad(),a.getConcepto(),a.getObservacion()}; 
        modelo.addRow(filaNovedad);
        }
//        Conexion.getSessionFactory().close();
    }
    
    public static void prepararTablaRRHH(DefaultTableModel modelo, JTable tablaConcepto){
        String[] titulos = {"FECHA","LEGAJO","APELLIDO","NOMBRE","EMPRESA","SUCURSAL","CONCEPTO","CANTIDAD", "OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        tablaConcepto.setModel(modelo);
    }
    
    public static void prepararTablaNovedades(DefaultTableModel modelo, JTable tablaNovedades){
        
        String[] titulos = {"LEGAJO","APELLIDO","NOMBRE","CONCEPTO","CANTIDAD","OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row,int col){
                boolean b = false;
                if (col == 4){
                    b = false;
                }else{
                    b= true;
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
    
    
 