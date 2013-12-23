package pojo;
// Generated 20/12/2013 12:56:08 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private Integer codEmp;
     private String nombre;
     private String gerente;
     private String mailGerente;
     private Boolean estado;
     private Set sucursals = new HashSet(0);

    public Empresa() {
    }

    public Empresa(String nombre, String gerente, String mailGerente, Boolean estado, Set sucursals) {
       this.nombre = nombre;
       this.gerente = gerente;
       this.mailGerente = mailGerente;
       this.estado = estado;
       this.sucursals = sucursals;
    }
   
    public Integer getCodEmp() {
        return this.codEmp;
    }
    
    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGerente() {
        return this.gerente;
    }
    
    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    public String getMailGerente() {
        return this.mailGerente;
    }
    
    public void setMailGerente(String mailGerente) {
        this.mailGerente = mailGerente;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getSucursals() {
        return this.sucursals;
    }
    
    public void setSucursals(Set sucursals) {
        this.sucursals = sucursals;
    }




}


