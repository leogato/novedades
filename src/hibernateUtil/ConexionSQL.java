/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Leo
 */
public class ConexionSQL {
    private Connection conexion;
    public String db = "novedades";
    public String url = "jdbc:mysql://192.168.0.100/novedades";
    public String user = "root";
    public String pass = "";
    public ServerSocket ref;
    
    public ConexionSQL(){
        try {
            this.ref = new ServerSocket(3306);
            ref.accept();
        } catch (IOException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void establecerConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,pass);
        }
            catch(Exception e){
                System.out.println("Imposible realizar conexion con la BD");
                e.printStackTrace();
            }
    }
 
    public Connection getConexion(){
        return conexion;
    }
 
    public void cerrar(ResultSet rs){
        if(rs !=null){
            try{
                rs.close();
            }
            catch(Exception e){
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }

    public void cerrar(java.sql.Statement stmt){
        if(stmt !=null){
            try{
                stmt.close();
            }
            catch(Exception e){
                
            }
        }
    }
    

    public void destruir(){

        if(conexion !=null){

            try{
                conexion.close();
            }
            catch(Exception e){
            }
        }
 
    }
    
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new AnnotationConfiguration()
            .configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
            return sessionFactory.openSession();
    }
    
    
    
}