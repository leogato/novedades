/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

import java.util.List;
import novedades.dao.SucursalDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Sucursal;

/**
 *
 * @author Leo
 */
public class SucursalDaoImp extends Conexion implements SucursalDao{

    @Override
    public List<Sucursal> listarSucursal() {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Sucursal.class);
        List<Sucursal> lista = (List<Sucursal>)criteria.list();
        session.getTransaction().commit();        
        session.close();
        return lista;
    }

    @Override
    public void addSucursal(Sucursal a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteSucursal(Sucursal a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateSucursal(Sucursal a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    
    }

    @Override
    public Sucursal getSucursal(int idSuc) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Sucursal a = (Sucursal) session.get(Sucursal.class,idSuc);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
    @Override
    public Sucursal getSucursalLogin(int idSuc){
        Sucursal e = null;
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Sucursal.class);
        criteria.add(Restrictions.eq("cod_suc", idSuc));
        List<Sucursal> lista = (List<Sucursal>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }
    
}
