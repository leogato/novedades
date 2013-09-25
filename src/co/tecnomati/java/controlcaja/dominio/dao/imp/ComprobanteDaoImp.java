/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.dominio.dao.imp;


import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.ComprobanteDAO;
import co.tecnomati.java.controlcaja.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 *
 * @author Joel
 */
public class ComprobanteDaoImp extends HibernateUtil implements ComprobanteDAO{

    @Override
    public List<Comprobante> listarFormulario() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comprobante.class);
        
        ArrayList<Comprobante> comprobante = (ArrayList<Comprobante>)criteria.list();
        session.close();
        return comprobante;
    }

    @Override
    public void addFormulario(Comprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.flush();
        session.close();     }

    @Override
    public void deleteFormulario(Comprobante a) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();   }

    @Override
    public void upDateFormulario(Comprobante a) {
//       Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public Comprobante getFormulario(int idComprobante) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class,idComprobante);
        session.getTransaction().commit();
        session.close();
        return a;      }

    @Override
    public Tipocomprobante getTipocomprobante(int idComprobante) {
//       Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class,idComprobante);
        Tipocomprobante tipoCom = a.getTipocomprobante();
        session.getTransaction().commit();
        
        return tipoCom;      }

    @Override
    public Set<Comprobanteconcepto> listarConcepto(int idComprobante) {
  
//     Session session = HibernateUtil.getSessionFactory().openSession();
                Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Comprobante a = (Comprobante) session.get(Comprobante.class,idComprobante);
        Set<Comprobanteconcepto> conjuntoConceptos = a.getComprobanteconceptos();
        session.getTransaction().commit();
        
        return conjuntoConceptos; 
    
    }

    
}
