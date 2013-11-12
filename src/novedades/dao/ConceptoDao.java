/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao;

import java.util.List;
import pojo.Concepto;
import pojo.Empleado;


/**
 *
 * @author Joel
 */
public interface ConceptoDao {
    
  public List<Concepto> listarConcepto();
  public Concepto getConcepto(boolean carga);
  public Concepto getConceptoHql(String descripcion);
  public void addConcepto(Concepto a);
  public void deleteConcepto(Concepto a);
  public void upDateConcepto(Concepto a);
  public Concepto getConcepto(int idConcepto);
  
}
