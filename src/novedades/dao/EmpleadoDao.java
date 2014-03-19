/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import java.util.List;
import java.util.Set;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;

/**
 *
 * @author usuario
 */
public interface EmpleadoDao {
  public List<Empleado> listarEmpleado();
  public void addEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Empleado getEmpleado(int legajo);
  public Empleado getEmpleado(String nombre);
  public List<Empleado> listarEmpleado(int codEmp, int codSuc);
  public List<Empleado> listarEmpleado(int codSuc);
  public List<Empleado> listarEmpleado(Empresa e);
  public List<Empleado> listarEmpleado(int leg, String ape, String nom);
}
