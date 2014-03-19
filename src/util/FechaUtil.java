package util;

import java.text.SimpleDateFormat;
import static util.FechaUtil.getAnio;
import static util.FechaUtil.getDia;
import static util.FechaUtil.getDiaString;
import static util.FechaUtil.getMes;
import static util.FechaUtil.getMesString;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 *
 * @author alumno
 */
public class FechaUtil {
    
    
     public static String getFechaString10DDMMAAAA (Date fecha){
         String fec;
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");     
         fec = sdf.format(fecha);
         return fec;
    }
     
     public static String getFechaString11AAAAMMDD (Date fecha){
        
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     
         return sdf.format(fecha);
    }
 
//     public static Date getFechaDate(String fecha) throws ParseException{
//         Date date = null;
//         System.out.println("Entre a parsear");
//         date = new SimpleDateFormat("yyyy-MM-dd").(fecha);
//         return date;
//         
//    }
     
     
//     private String getWhereFecha() { 
//         String desdeS= FechaUtil.getFechaString10AAAAMMDD(dateDesde.getDate());
//         String hastaS= FechaUtil.getFechaString10AAAAMMDD(dateHasta.getDate()); 
//         return "c.fecha<='" + hastaS + "' and c.fecha>='" + desdeS + "'"; }
     
    /**
     * 
     * @param fecha  recibe una fecha de tipo date
     * @return la fecha en formato String  DD/MM/AAAA  
     */
    public static String getDateDDMMAAAA (Date fecha){
        String mifecha = fecha.toString();
        String dia = mifecha.substring(8, 10);
        String  mes = mifecha.substring(5, 7);
        String anio = mifecha.substring(0, 4);
        String f = dia+"/"+mes+"/"+anio;
        
        return f;
    }
    
    public static String FormateaFecha(String vFecha){
        String vDia, vMes, vAno;
        StringTokenizer tokens = new StringTokenizer(vFecha,"-");
        vAno = tokens.nextToken();
        vMes = tokens.nextToken();
        vDia = tokens.nextToken();
        return vDia+"-"+vMes+"-"+vAno;
}
//    
    
      /**
     * 
     * @param fecha de tipo date
     * @return  convierte en String en el formato DD-MM-AAAA
     */
       public static String getDateDD_MM_AAAA (Date fecha){
        String mifecha = fecha.toString();
        int dia = getDia(fecha);
        int mes = getMes(fecha);
        int anio = getAnio(fecha);
        String f = dia+"-"+mes+"-"+anio;
        
        return f;
    }

    public static int getDia (Date fecha){//********DEVUELVE EL DIA DEL MES SELECCIONADO
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc.get(Calendar.DAY_OF_MONTH);
    }
    public static String getDiaString (Date fecha){
        String dia="";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int index = gc.get(Calendar.DAY_OF_WEEK);
        if (index == Calendar.SUNDAY) {
            dia= "DOMINGO";
        } else {
            if (index == Calendar.MONDAY) {
                dia ="LUNES";
            } else {
                if (index == Calendar.TUESDAY) {
                dia ="MARTES";
            } 
                if (index == Calendar.WEDNESDAY) {
                dia ="MIERCOLES";
            } 
                else {
                    if (index == Calendar.THURSDAY) {
                dia ="JUEVES";
            } else {
                  if (index == Calendar.FRIDAY) {
                dia ="VIERNES";
            } else {
                  if (index == Calendar.SATURDAY) {
                dia ="SABADO";    
                     
            }      
            }
            }
            }
        }
        }
        
       return dia;
    }
    
    public static String  getMesString(Date fecha){
        String mes="";
         GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int index  = gc.get(Calendar.MONTH);
        if (index == Calendar.JANUARY) {
            mes = "ENERO";
        } else {
             if (index == Calendar.FEBRUARY) {
            mes = "FEBRERO";
        } else {
              if (index == Calendar.MARCH) {
                  mes = "MARZO";
              } else {
                   if (index == Calendar.APRIL) {
                      mes = "ABRIL";
                   } else {
                         if (index == Calendar.MAY) {
                             mes = "MAYO";
                            } else {
                             if (index == Calendar.JUNE) {
                                   mes = "JUNIO";
                            } else {
                                 if (index == Calendar.JULY) {
                                       mes = "JULIO";
                                   } else {
                                      if (index == Calendar.AUGUST) {
                                           mes = "AGOSTO";
                                      } else {
                                       if (index == Calendar.SEPTEMBER) {
                                            mes = "SEPTIEMBRE";
                                        } else {
                                          if (index == Calendar.OCTOBER) {
                                               mes = "OCTUBRE";
                                            } else {
                                             if (index == Calendar.NOVEMBER) {
                                                mes = "NOVIEMBRE";
                                              } else {
                                              if (index == Calendar.DECEMBER) {
                                                        mes = "DICIEMBRE";
                                                } 
                                             }
                                            }
                                        }
                                      }
                                   }
                             }
                         }
                    }
              }    
        }
        }
        
        return mes;
    }
    public static String getFecha_Dia_DD_De_MM_De_AAAA(Date fecha){
        String fechaActual = getDiaString(fecha)+" "+getDia(fecha)+" DE "+getMesString(fecha)+" DE "+getAnio(fecha);
        return fechaActual;
    }
    
    public static int getMes (Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int mes  = gc.get(Calendar.MONTH)+1;
        return mes;
    }
   
    public static int getAnio (Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc.get(Calendar.YEAR);
        
    }
    
   
  
    /**
     * 
     * @param fechaHoy una fecha ingresada
     * @return la hora en formato hh:mm en String
     */
       public static String getHora(Date fechaHoy){
           String hora= String.valueOf(fechaHoy.getHours()) ;
           String min= String.valueOf(fechaHoy.getMinutes());
           
           if (fechaHoy.getHours()==0) {
               hora = "0"+ fechaHoy.getHours();    
           }
           if (fechaHoy.getMinutes()<=9){
               min= "0"+ fechaHoy.getMinutes();
           }
           String horaEnString = hora +":"+ min;
         return horaEnString;
     }
     /**
        * 
        * @param hora recibe una cadena con el formato HH:MM
        * @return  una fecha donde contendra en sus atributos la hora
        */
     public static Date getHora(String hora){
         int hs = Integer.parseInt(hora.substring(0, 1));
         int min = Integer.parseInt(hora.substring(3, 4));
         Date miHora = new Date(0, 0, 0, hs, min);
         return miHora;
     }
    
    public static Date getFechaSinhora (Date fecha){
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        return fecha;
        
    }
     
    public static long diferenciaEntreFechas(Date fecIni, Date fecFin){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
               
	 
	        // Establecer las fechas
	        cal1.set(2006, 12, 30);
	        cal2.set(2007, 5, 3);
	 
	        // conseguir la representacion de la fecha en milisegundos
	        long milis1 = fecIni.getTime();
	        long milis2 = fecFin.getTime();
	 
	        // calcular la diferencia en milisengundos
	        long diff = milis2 - milis1;
	 
	        // calcular la diferencia en segundos
	        long diffSeconds = diff / 1000;
	 
	        // calcular la diferencia en minutos
	        long diffMinutes = diff / (60 * 1000);
	 
	        // calcular la diferencia en horas
	        long diffHours = diff / (60 * 60 * 1000);
	 
	        // calcular la diferencia en dias
	        long diffDays = (diff / (24 * 60 * 60 * 1000))+1;
	 
                return diffDays;
    }
    public static int getDiasDelMes(int mes, int año){
        switch(mes){
        case 1:  // Enero
        case 3:  // Marzo
        case 5:  // Mayo
        case 7:  // Julio
        case 8:  // Agosto
        case 10:  // Octubre
        case 12: // Diciembre
            return 31;
        case 4:  // Abril
        case 6:  // Junio
        case 9:  // Septiembre
        case 11: // Noviembre
            return 30;
        case 2:  // Febrero
            if ( ((año%100 == 0) && (año%400 == 0)) ||
                    ((año%100 != 0) && (año%  4 == 0))   )
                return 29;  // Año Bisiesto
            else
                return 28;
        default:
            throw new java.lang.IllegalArgumentException("El mes debe estar entre 0 y 11");
        }
    }
}
