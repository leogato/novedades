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
       Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        
        ArrayList<Usuario> usuario = (ArrayList<Usuario>)criteria.list();
        session.close();
        return usuario;
    }


    @Override
    public void addUsuario(Usuario a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();       }

    @Override
    public void deleteUsuario(Usuario a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();       
    }

    @Override
    public void upDateUsuario(Usuario a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();      }

    @Override
    public Usuario getUsuario(int legajo) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        Usuario a = (Usuario) session.get(Usuario.class,legajo);
        session.getTransaction().commit();
        session.close();
        return a;     
    }
    public Usuario getUsuarioAdministrador(String usuario,String clave){
        Usuario e = null;
        Session session = Conexion.getSession();
        session.beginTransaction();
        e = (Usuario) session.createQuery("from Usuario u\n"+"join fetch u.empleado as e\n"+
                "join fetch e.sucursal as suc\n"+
                "join fetch suc.empresa as emp\n"+
                "where u.usuario = '"+usuario+"' and u.clave = '"+clave+"'").uniqueResult();
        session.getTransaction().commit();
        session.close();
        return e;
    }
    
    public Usuario getUsuarioLogin(String usuario){
        Usuario e = null;
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "FROM Usuario u\n" +"join fetch u.empleado as e\n" +
        "join fetch e.sucursal as suc\n"+
        "join fetch suc.empresa as emp\n" +
        "WHERE u.usuario = '"+usuario+"'";
        e = (Usuario)session.createQuery(sql).uniqueResult();
//        Criteria criteria = session.createCriteria(Usuario.class);
//        criteria.add(Restrictions.eq("usuario", usuario));
//        List<Usuario> lista = (List<Usuario>)criteria.list();
//        if (lista.size()!=0) {
//            e = lista.get(0);
//        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }    
}
