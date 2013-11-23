/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;


import java.util.Date;
import java.util.List;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;

/**
 *
 * @author usuario
 */
public interface NovedadDao {
  java.util.List<Novedad> listarNovedad(Empleado o);
  java.util.List<Novedad> listarNovedad();
  List<Novedad> listarNovedad(Empleado e, Date fechaInicio, Date fechaFin);
  public Empleado getEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Concepto getConcepto(Concepto e);
  public void addNovedad(Novedad n);
//  public Novedad getNovedad(int idConcepto);
}
