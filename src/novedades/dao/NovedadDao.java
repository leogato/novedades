/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;


import java.util.Date;
import java.util.List;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Sucursal;

/**
 *
 * @author usuario
 */
public interface NovedadDao {
  List<Novedad> listarNovedad(Empleado o);
  List<Novedad> listarNovedad();
  
  public List<Novedad> listarNovedad(Date fechaIni, Date fechaFin);
  
  public Empleado getEmpleado(Empleado a);
  public Novedad getNovedad(int id);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Concepto getConcepto(Concepto e);
  public void addNovedad(Novedad n);
  public void upDateNovedad(Novedad n);
  
  List<Novedad> listarNovedad(Empleado e, Date fechaInicio, Date fechaFin);
  public List<Novedad> listarNovedad(String fechaIni, int codSuc);
  public List<Novedad> listarNovedad(Sucursal s, Date fechaInicio, Date fechaFin);
  public List<Novedad> listarNovedad(Empresa e, Date fechaInicio, Date fechaFin);
  public List<Novedad> listarNovedad(Concepto e, Date fechaInicio, Date fechaFin);
//  public Novedad getNovedad(int idConcepto);
}
