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
  
    public void addNovedad(Novedad n);
    public void upDateNovedad(Novedad n);
    public Novedad getNovedad(int id);
    List<Novedad> listarNovedad();
    public List<Novedad> listarNovedad(Date fechaIni, Date fechaFin);
    public List<Novedad> listarNovedad(String fechaIni, int codSuc);
    List<Novedad> listarNovedad(Empleado e, Date fechaInicio, Date fechaFin);
    public List<Novedad> listarNovedad(Sucursal s, Date fechaInicio, Date fechaFin);
    public List<Novedad> listarNovedad(Empresa e, Date fechaInicio, Date fechaFin);
    public List<Novedad> listarNovedad(Concepto e, Date fechaInicio, Date fechaFin);
}
