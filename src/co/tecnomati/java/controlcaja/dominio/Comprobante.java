package co.tecnomati.java.controlcaja.dominio;
// Generated 18/10/2013 11:16:44 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Comprobante generated by hbm2java
 */
public class Comprobante  implements java.io.Serializable {


     private Integer id;
     private Tipocomprobante tipocomprobante;
     private String numeroSerie;
     private Long numeroSerieIzq;
     private Long numeroSerieDer;
     private int idEntidad;
     private Integer tipoPersona;
     private Date fecha;
     private Integer tipoProceso;
     private Date ejercicioEconomico;
     private Boolean estado;
     private Set<Comprobanteconcepto> comprobanteconceptos = new HashSet<Comprobanteconcepto>(0);

    public Comprobante() {
    }

	
    public Comprobante(int idEntidad) {
        this.idEntidad = idEntidad;
    }
    public Comprobante(Tipocomprobante tipocomprobante, String numeroSerie, Long numeroSerieIzq, Long numeroSerieDer, int idEntidad, Integer tipoPersona, Date fecha, Integer tipoProceso, Date ejercicioEconomico, Boolean estado, Set<Comprobanteconcepto> comprobanteconceptos) {
       this.tipocomprobante = tipocomprobante;
       this.numeroSerie = numeroSerie;
       this.numeroSerieIzq = numeroSerieIzq;
       this.numeroSerieDer = numeroSerieDer;
       this.idEntidad = idEntidad;
       this.tipoPersona = tipoPersona;
       this.fecha = fecha;
       this.tipoProceso = tipoProceso;
       this.ejercicioEconomico = ejercicioEconomico;
       this.estado = estado;
       this.comprobanteconceptos = comprobanteconceptos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Tipocomprobante getTipocomprobante() {
        return this.tipocomprobante;
    }
    
    public void setTipocomprobante(Tipocomprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }
    public String getNumeroSerie() {
        return this.numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public Long getNumeroSerieIzq() {
        return this.numeroSerieIzq;
    }
    
    public void setNumeroSerieIzq(Long numeroSerieIzq) {
        this.numeroSerieIzq = numeroSerieIzq;
    }
    public Long getNumeroSerieDer() {
        return this.numeroSerieDer;
    }
    
    public void setNumeroSerieDer(Long numeroSerieDer) {
        this.numeroSerieDer = numeroSerieDer;
    }
    public int getIdEntidad() {
        return this.idEntidad;
    }
    
    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }
    public Integer getTipoPersona() {
        return this.tipoPersona;
    }
    
    public void setTipoPersona(Integer tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getTipoProceso() {
        return this.tipoProceso;
    }
    
    public void setTipoProceso(Integer tipoProceso) {
        this.tipoProceso = tipoProceso;
    }
    public Date getEjercicioEconomico() {
        return this.ejercicioEconomico;
    }
    
    public void setEjercicioEconomico(Date ejercicioEconomico) {
        this.ejercicioEconomico = ejercicioEconomico;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set<Comprobanteconcepto> getComprobanteconceptos() {
        return this.comprobanteconceptos;
    }
    
    public void setComprobanteconceptos(Set<Comprobanteconcepto> comprobanteconceptos) {
        this.comprobanteconceptos = comprobanteconceptos;
    }




}


