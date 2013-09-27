package pojo;
// Generated 27/09/2013 11:51:17 by Hibernate Tools 3.2.1.GA



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int id;
     private Empleado empleado;
     private String usuario;
     private String clave;
     private String descripcion;
     private String tipo;

    public Usuario() {
    }

    public Usuario(int id, Empleado empleado, String usuario, String clave, String descripcion, String tipo) {
       this.id = id;
       this.empleado = empleado;
       this.usuario = usuario;
       this.clave = clave;
       this.descripcion = descripcion;
       this.tipo = tipo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


