/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;
import java.util.ArrayList;
import java.util.List;
import novedades.dao.UsuarioDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Usuario;

/**
 *
 * @author joel
 */
public class UsuarioDaoImp extends Conexion implements UsuarioDao{

    @Override
    public List<Usuario> listarUsuario() {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        
        ArrayList<Usuario> usuario = (ArrayList<Usuario>)criteria.list();
        session.close();
        return usuario;
    }


    @Override
    public void addUsuario(Usuario a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();       }

    @Override
    public void deleteUsuario(Usuario a) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();       
    }

    @Override
    public void upDateUsuario(Usuario a) {
Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();      }

    @Override
    public Usuario getUsuario(int legajo) {
        Session session = Conexion.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario a = (Usuario) session.get(Usuario.class,legajo);
        session.getTransaction().commit();
        session.close();
        return a;     
    }
    public Usuario getUsuarioAdministrador(String usuario,String clave){
        Usuario e = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        criteria.add(Restrictions.eq("clave", clave));
        
        List<Usuario> lista = (List<Usuario>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }
    
}
