package co.tecnomati.java.controlcaja.dominio;
// Generated 14/09/2013 06:55:51 by Hibernate Tools 3.2.1.GA



/**
 * Comprobanteconcepto generated by hbm2java
 */
public class Comprobanteconcepto  implements java.io.Serializable {


     private int id;
     private Concepto concepto;
     private Comprobante comprobante;
     private Double monto;

    public Comprobanteconcepto() {
    }

	
    public Comprobanteconcepto(int id) {
        this.id = id;
    }
    public Comprobanteconcepto(int id, Concepto concepto, Comprobante comprobante, Double monto) {
       this.id = id;
       this.concepto = concepto;
       this.comprobante = comprobante;
       this.monto = monto;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Concepto getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }
    public Comprobante getComprobante() {
        return this.comprobante;
    }
    
    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    public Double getMonto() {
        return this.monto;
    }
    
    public void setMonto(Double monto) {
        this.monto = monto;
    }




}


