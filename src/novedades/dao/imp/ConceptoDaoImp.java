/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;


import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import novedades.dao.ConceptoDao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;

/**
 *
 * @author Joel
 */
public class ConceptoDaoImp extends Conexion implements ConceptoDao{

    @Override
    public List<Concepto> listarConcepto() {
       Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Concepto.class);
        
        ArrayList<Concepto> concepto = (ArrayList<Concepto>)criteria.list();
        session.close();
        return concepto;
    }

    @Override
    public void addConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void upDateConcepto(Concepto a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Concepto getConcepto(int idConcepto) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,idConcepto);
        session.getTransaction().commit();
        session.close();
        return a;      
    }

    public Concepto getCarga(boolean carga) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,carga);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
    public List<Concepto> listarConcepto(Empleado e, Date fecIni){
        Session session = getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Concepto.class);
         criteria.addOrder(Order.asc("Legajo"));
         criteria.add(Restrictions.eq("empleado", e));
         criteria.add( Restrictions.ge("fecha", fecIni) );
         List<Concepto> lista = criteria.list();
         return lista;
    }
    
    public List<Novedad> listarNovedad(Date fechaInicio) {
        Session session = getSessionFactory().openSession();
          Criteria criteria = session.createCriteria(Novedad.class);
//          criteria.addOrder(Order.asc("fecha"));
//         criteria.addOrder(Order.asc("idAsistencia"));
         criteria.add( Restrictions.ge("fecha", fechaInicio) );
         List<Novedad> lista = criteria.list();
//         session.close();
          return lista;
    }
   
  

}
