/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private TipoConsulta tipoConsulta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaElaboracionConsulta;
    @Column
    private boolean visto;
    @Column
    private String nombrePersonaEnvia;

    public String getNombrePersonaEnvia() {
        return nombrePersonaEnvia;
    }

    public void setNombrePersonaEnvia(String nombrePersonaEnvia) {
        this.nombrePersonaEnvia = nombrePersonaEnvia;
    }
    @ManyToOne
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }


    public DetalleConsulta getDetalleconsulta() {
        return detalleconsulta;
    }

    public void setDetalleconsulta(DetalleConsulta detalleconsulta) {
        this.detalleconsulta = detalleconsulta;
    }
    @ManyToOne
    private DetalleConsulta detalleconsulta;

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaElaboracionConsulta() {
        return fechaElaboracionConsulta;
    }

    public void setFechaElaboracionConsulta(Date fechaElaboracionConsulta) {
        this.fechaElaboracionConsulta = fechaElaboracionConsulta;
    }



    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    
}
