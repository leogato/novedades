/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

import java.util.ArrayList;
import java.util.List;
import novedades.dao.NovedadDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Novedad;
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
    
    
}
