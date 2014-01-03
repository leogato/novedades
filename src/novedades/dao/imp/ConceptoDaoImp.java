/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;


import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.List;
import novedades.dao.ConceptoDao;


import org.hibernate.Session;
import pojo.Concepto;

/**
 *
 * @author Joel
 */
public class ConceptoDaoImp extends Conexion implements ConceptoDao{

    @Override
    public List<Concepto> listarConcepto() {
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Concepto as c where c.estado = true";
        ArrayList<Concepto> concepto = (ArrayList<Concepto>)session.createQuery(sql).list();
        session.close();
        return concepto;
    }

    @Override
    public void addConcepto(Concepto a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteConcepto(Concepto a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void upDateConcepto(Concepto a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Concepto getConcepto(int idConcepto) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Concepto a = (Concepto) session.get(Concepto.class,idConcepto);
        session.getTransaction().commit();
        session.close();
        return a;      
    } 

    @Override
    public Concepto getConceptoHql(String descripcion) {
        Concepto con = null;
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Concepto u\n"+"Where u.descripcion = '"+descripcion+"'";
        con = (Concepto)session.createQuery(sql).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return con;
    }

}
