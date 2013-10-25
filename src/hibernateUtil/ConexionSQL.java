/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateUtil;

import java.sql.Connection;

/**
 *
 * @author Leo
 */
public class ConexionSQL {
    public String db = "novedades";
    public String url = "jdbc:mysql://localhost/novedades";
    public String user = "root";
    public String pass = "";
    
    public ConexionSQL(){
        
    }
    
//    public Connection Conectar(){
//        Connection link = null;
//        try{
//            Class.forName("oracle")
//        }
//    }
}
