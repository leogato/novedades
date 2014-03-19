/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

import java.util.List;
import novedades.dao.EmpresaDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Empresa;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class EmpresaDaoImp extends Conexion implements EmpresaDao {

    @Override
    public List<Empresa> listarEmpresa() {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empresa.class);
        List<Empresa> lista = (List<Empresa>)criteria.list();
        session.getTransaction().commit();        
        session.close();
        return lista;
    }

    @Override
    public void addEmpresa(Empresa a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteEmpresa(Empresa a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateEmpresa(Empresa a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Empresa getEmpresa(int cod_emp) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Empresa a = (Empresa) session.get(Empresa.class,cod_emp);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
    @Override
    public Empresa getEmpresaLogin(int cod_emp) {
        Empresa e = null;
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empresa.class);
        criteria.add(Restrictions.eq("cod_emp", cod_emp));
        List<Empresa> lista = (List<Empresa>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }
}
