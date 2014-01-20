/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import hibernateUtil.Conexion;
import java.sql.ResultSet;
import java.util.*;
/**
 *
 * @author Leo
 */
public class HoraServer {
    
    Conexion conexion = new Conexion();
     
    public HoraServer(){      
        
    }
    
    public String getFecha(){
            String fecha_y_hora = getDate_Full();
            String fecha="";
            String hora="";
            String x[]= fecha_y_hora.split(" ");
            String x1[]=x[0].split("-");
            fecha =x1[2]+"-"+x1[1]+"-"+x1[0];
            hora= x[1];
            hora=hora.substring(0,hora.length()-2);

            System.out.println("Fecha: "+fecha);       
            System.out.println("Hora: "+hora);    
            return fecha;
        }
     
    public String getDate_Full(){
        String sql="SELECT NOW() AS Hora_Fecha";      
        String fx="2010-02-01 00:00:00";
        try
        {
            ResultSet  re1 = conexion.st.executeQuery(sql);
            while(re1.next())
            {
                fx=re1.getString("Hora_Fecha");
            }
        }catch(Exception e )
        {
            System.out.print(e);
        }      
        return fx;
    }
    
}
    















