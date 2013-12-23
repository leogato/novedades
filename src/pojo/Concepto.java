package pojo;
// Generated 20/12/2013 12:56:08 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Concepto generated by hbm2java
 */
public class Concepto  implements java.io.Serializable {


     private int codCon;
     private String descripcion;
     private String tipo;
     private Boolean estado;
     private Boolean cargaUser;
     private Set novedads = new HashSet(0);

    public Concepto() {
    }

	
    public Concepto(int codCon, String descripcion) {
        this.codCon = codCon;
        this.descripcion = descripcion;
    }
    public Concepto(int codCon, String descripcion, String tipo, Boolean estado, Boolean cargaUser, Set novedads) {
       this.codCon = codCon;
       this.descripcion = descripcion;
       this.tipo = tipo;
       this.estado = estado;
       this.cargaUser = cargaUser;
       this.novedads = novedads;
    }
   
    public int getCodCon() {
        return this.codCon;
    }
    
    public void setCodCon(int codCon) {
        this.codCon = codCon;
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
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Boolean getCargaUser() {
        return this.cargaUser;
    }
    
    public void setCargaUser(Boolean cargaUser) {
        this.cargaUser = cargaUser;
    }
    public Set getNovedads() {
        return this.novedads;
    }
    
    public void setNovedads(Set novedads) {
        this.novedads = novedads;
    }




}


