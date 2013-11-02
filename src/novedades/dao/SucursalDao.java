/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import hibernateUtil.Conexion;
import pojo.Sucursal;

/**
 *
 * @author Leo
 */
public interface SucursalDao{
  java.util.List<Sucursal> listarSucursal();
  public void addSucursal(Sucursal a);
  public void deleteSucursal(Sucursal a);
  public void upDateSucursal(Sucursal a);
  public Sucursal getSucursal(int idSuc);
    
}
