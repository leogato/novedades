package pojo;
// Generated 18/10/2013 16:57:56 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Sucursal generated by hbm2java
 */
public class Sucursal  implements java.io.Serializable {


     private int codSuc;
     private Empresa empresa;
     private String nombre;
     private Boolean estado;
     private Set<Empleado> empleados = new HashSet<Empleado>(0);

    public Sucursal() {
    }

	
    public Sucursal(int codSuc, Empresa empresa, String nombre) {
        this.codSuc = codSuc;
        this.empresa = empresa;
        this.nombre = nombre;
    }
    public Sucursal(int codSuc, Empresa empresa, String nombre, Boolean estado, Set<Empleado> empleados) {
       this.codSuc = codSuc;
       this.empresa = empresa;
       this.nombre = nombre;
       this.estado = estado;
       this.empleados = empleados;
    }
   
    public int getCodSuc() {
        return this.codSuc;
    }
    
    public void setCodSuc(int codSuc) {
        this.codSuc = codSuc;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


