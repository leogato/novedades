/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package novedades.dao.imp;

import hibernateUtil.Conexion;

import java.util.List;
import java.util.Set;
import novedades.dao.EmpleadoDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Concepto;
import pojo.Empleado;
import pojo.Empresa;

/**
 *
 * @author joel
 */
public class EmpleadoDaoImp extends Conexion implements EmpleadoDao{

    

    @Override
    public void addEmpleado(Empleado a) {
       Session session = Conexion.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
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
        session.saveOrUpdate(a);
//        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    public List<Empleado> getEmpleados(int legajo){
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql  = "from Empleado as e where e.legajo = '"+legajo+"'";
        List<Empleado> lista = (List<Empleado>)session.createQuery(sql).list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }
    
    @Override
    public Empleado getEmpleado(int legajo) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Empleado a = (Empleado) session.get(Empleado.class, legajo);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    @Override
    public Empleado getEmpleado(String nombre){
       Session session = Conexion.getSession();
        session.beginTransaction();
        Empleado a = (Empleado) session.get(Empleado.class, nombre);
        session.getTransaction().commit();
        session.close();
        return a;
    }

    

    @Override
    public List<Empleado> listarEmpleado() {
       Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Empleado as c where c.estado = true";
        List<Empleado> lista = (List<Empleado>)session.createQuery(sql).list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }
    
    @Override
    public List<Empleado> listarEmpleado(int codSuc){
        Session sesion = Conexion.getSession();
        sesion.beginTransaction();
        String sql = "from Empleado as e\n" +
                     "join fetch e.sucursal as s\n" +
                     "where e.estado = true and s.codSuc = '"+codSuc+"'";
        List<Empleado> lista = (List<Empleado>) sesion.createQuery(sql).list();
        sesion.getTransaction().commit();
        sesion.close();
        return lista;
    }
    
    @Override
    public List<Empleado> listarEmpleado(Empresa e){
        Session session = Conexion.getSession();
        session.beginTransaction();
        String sql = "from Empleado as e\n" +
                "join fetch e.sucursal as suc\n" +
                "join fetch suc.empresa as emp\n" +
                "where emp.codEmp = '"+e.getCodEmp()+"'";
        List<Empleado> lista = (List<Empleado>)session.createQuery(sql).list();
        return lista;
    }
    
    @Override
        public List<Empleado> listarEmpleado(int codEmp, int codSuc){
            Session session = Conexion.getSession();
            session.beginTransaction();
            String sql = "from Empleado as e\n" +
                    "join fetch e.sucursal as suc\n" +
                    "join fetch suc.empresa as emp\n" +
                    "where emp.codEmp = '"+codEmp+"' and suc.codSuc = '"+codSuc+"'";
            List<Empleado> lista = (List<Empleado>)session.createQuery(sql).list();
            return lista;
        }
    
    @Override
    public List<Empleado> listarEmpleado(int leg, String ape, String nom) {
        Session session = Conexion.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        List<Empleado> lista = (List<Empleado>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }
    
}
