package pojo;
// Generated 20/12/2013 12:56:08 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private int legajo;
     private Sucursal sucursal;
     private String apellido;
     private String nombre;
     private String cuit;
     private Integer codEmp;
     private String convenio;
     private String tarea;
     private Boolean estado;
     private Set usuarios = new HashSet(0);
     private Set novedads = new HashSet(0);

    public Empleado() {
    }

	
    public Empleado(int legajo, String apellido, String nombre, String cuit, String convenio, String tarea) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cuit = cuit;
        this.convenio = convenio;
        this.tarea = tarea;
    }
    public Empleado(int legajo, Sucursal sucursal, String apellido, String nombre, String cuit, Integer codEmp, String convenio, String tarea, Boolean estado, Set usuarios, Set novedads) {
       this.legajo = legajo;
       this.sucursal = sucursal;
       this.apellido = apellido;
       this.nombre = nombre;
       this.cuit = cuit;
       this.codEmp = codEmp;
       this.convenio = convenio;
       this.tarea = tarea;
       this.estado = estado;
       this.usuarios = usuarios;
       this.novedads = novedads;
    }
   
    public int getLegajo() {
        return this.legajo;
    }
    
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public Integer getCodEmp() {
        return this.codEmp;
    }
    
    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }
    public String getConvenio() {
        return this.convenio;
    }
    
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    public String getTarea() {
        return this.tarea;
    }
    
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getNovedads() {
        return this.novedads;
    }
    
    public void setNovedads(Set novedads) {
        this.novedads = novedads;
    }




}


