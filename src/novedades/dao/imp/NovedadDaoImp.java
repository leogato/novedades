/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

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

/**
 *
 * @author usuario
 */
public class NovedadDaoImp extends Conexion implements NovedadDao {

    @Override
    public void addNovedad(Novedad n) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(n);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
   public void upDateNovedad(Novedad n) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(n);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Novedad getNovedad(int id){
       Session session = Conexion.getSession();
        session.beginTransaction();
        Novedad nov = (Novedad) session.get(Novedad.class,id);
        session.getTransaction().commit();
        session.close();
        return nov; 
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
    
    @Override
    public List<Novedad> listarNovedad(Date fechaIni, Date fechaFin) {
        java.sql.Date parseIni, parseFin;
        Session session = Conexion.getSession();
        session.beginTransaction();
        parseIni = new java.sql.Date(fechaIni.getTime());
        parseFin = new java.sql.Date (fechaFin.getTime());
        String sql = "from Novedad as n \n" +
                "join fetch n.empleado as e \n" +
                "where n.fecha >= '"+parseIni+"' and n.fecha <= '"+parseFin+"'";
        List<Novedad> lista = session.createQuery(sql).list();
        return lista;
    }
    
    @Override
    public List<Novedad> listarNovedad(String fechaIni, int codSuc) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        System.out.println("fecha: "+fechaIni);
        System.out.println("codigo: "+codSuc);
        String sql = "from Novedad as n \n" +
                     "join fetch n.empleado as e \n" +
                     "join fetch e.sucursal as s\n" +
                     "where n.fecha = '"+fechaIni+"' and s.codSuc ='"+codSuc+"'";
        List<Novedad> novedad = session.createQuery(sql).list();
        session.getTransaction().commit();
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
    
    @Override
    public List<Novedad> listarNovedad(Sucursal s, Date fechaInicio, Date fechaFin) {
        java.sql.Date parseIni, parseFin;
        Session session = Conexion.getSession();
        session.beginTransaction();
        parseIni = new java.sql.Date(fechaInicio.getTime());
        parseFin = new java.sql.Date (fechaFin.getTime());
        String sql = "from Novedad as n\n" +
                     "join fetch n.empleado e\n" +
                     "join fetch e.sucursal as s\n" +
                     "where s.codSuc = '"+s.getCodSuc()+"' and n.fecha >= '"+parseIni+"' and n.fecha <= '"+parseFin+"'";
        List<Novedad> lista = session.createQuery(sql).list();
        return lista; 
    }
    
    @Override
    public List<Novedad> listarNovedad(Empresa e, Date fechaInicio, Date fechaFin) {
        java.sql.Date parseIni, parseFin;
        Session session = Conexion.getSession();
        session.beginTransaction();
        parseIni = new java.sql.Date(fechaInicio.getTime());
        parseFin = new java.sql.Date (fechaFin.getTime());
        String sql = " from Novedad as n \n" +
                "join fetch n.empleado as e \n" +
                "join fetch e.sucursal as s \n" +
                "join fetch s.empresa as em \n" +
                "where em.codEmp = '"+e.getCodEmp()+"' and n.fecha >= '"+parseIni+"' and n.fecha <= '"+parseFin+"'";
        List<Novedad> lista = session.createQuery(sql).list();
        return lista;
    }
    
    @Override
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
