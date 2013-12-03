/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import novedades.dao.NovedadDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;
import pojo.Novedad;
import pojo.Sucursal;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class NovedadDaoImp extends Conexion implements NovedadDao {

    @Override
    public List<Novedad> listarNovedad(Empleado o) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        criteria.add(Restrictions.eq("Codigo de sucursal", o.getSucursal().getCodSuc()));
        ArrayList<Novedad> novedad = (ArrayList<Novedad>)criteria.list();
        session.close();
        return novedad;
    }

    @Override
    public Empleado getEmpleado(Empleado a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Empleado e = (Empleado) session.get(Empleado.class,a);
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public void deleteEmpleado(Empleado a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void upDateEmpleado(Empleado a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Concepto getConcepto(Concepto e) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Concepto con = (Concepto) session.get(Usuario.class,e);
        session.getTransaction().commit();
        session.close();
        return con; 
    }
    
    @Override
    public void addNovedad(Novedad n) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(n);
        session.getTransaction().commit();
        session.close();
    }

    public List<Novedad> listarNovedad(String cad){
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        ArrayList<Novedad> novedad = (ArrayList<Novedad>)criteria.list();
        session.close();
        return novedad;
    }
    
    public Novedad getFecha(String fec){
       Session session = Conexion.getSession();
        session.beginTransaction();
        Novedad con = (Novedad) session.get(Novedad.class,fec);
        session.getTransaction().commit();
        session.close();
        return con; 
    }

    @Override
    public List<Novedad> listarNovedad() {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        List<Novedad> novedad = (List<Novedad>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return novedad;
    }
    
    public List<Novedad> listarNovedad(Date fechaIni, Date fechaFin) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        criteria.add( Restrictions.ge("fecha", fechaIni) );
        criteria.add( Restrictions.le("fecha", fechaFin) ); 
        List<Novedad> novedad = (List<Novedad>)criteria.list();
        session.getTransaction().commit();
//        session.close();
        return novedad;
    }
    
    public List<Novedad> listarNovedad(Date fechaIni) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        criteria.add( Restrictions.ge("fecha", fechaIni) );
        List<Novedad> novedad = (List<Novedad>)criteria.list();
        session.getTransaction().commit();
//        session.close();
        return novedad;
    }

    @Override
    public List<Novedad> listarNovedad(Empleado e, Date fechaInicio, Date fechaFin) {
        Session session = Conexion.getSession();
        session.beginTransaction();
         Criteria criteria = session.createCriteria(Novedad.class);
         criteria.add(Restrictions.eq("empleado", e));
         criteria.add( Restrictions.ge("fecha", fechaInicio) );
         criteria.add( Restrictions.le("fecha", fechaFin) ); 
         List<Novedad> lista = criteria.list();
        return lista;
    }
    
    public List<Novedad> listarNovedad(Sucursal e, Date fechaInicio, Date fechaFin) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Novedad as n\n" +
                     "join fetch n.empleado a\n" +
                     "join fetch a.sucursal as s\n" +
                     "where s.codSuc = '"+e.getCodSuc()+"'";
        List<Novedad> lista = session.createQuery(sql).list();
        return lista;
    }
    
    public List<Novedad> listarNovedad(Empresa e, Date fechaInicio, Date fechaFin) {
//        Empleado emp = new EmpleadoDaoImp().getEmpleado(e.getSucursal().getCodSuc());
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = " from Novedad as n\n" +
                "join fetch n.empleado as e\n" +
                "join fetch e.sucursal as s\n" +
                "join fetch s.empresa as em\n" +
                "where em.codEmp = '"+e.getCodEmp()+"'";
        List<Novedad> lista = session.createQuery(sql).list();
//        Criteria criteria = session.createCriteria(Novedad.class);
//        criteria.add(Restrictions.eq("empresa", e));
//        criteria.add(Restrictions.ge("fecha", fechaInicio));
//        criteria.add(Restrictions.le("fecha", fechaFin));
//        List<Novedad> lista = criteria.list();
        return lista;
    }
    
     public List<Novedad> listarNovedad(Concepto e, Date fechaInicio, Date fechaFin) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Novedad.class);
        criteria.add(Restrictions.eq("concepto", e));
        criteria.add( Restrictions.ge("fecha", fechaInicio) );
        criteria.add( Restrictions.le("fecha", fechaFin) ); 
        List<Novedad> lista = criteria.list();
        return lista;
    }
    
}
