/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="obraSocial")
public class ObraSocial implements Serializable{
    @Id @GeneratedValue
    private Long id;
    @Column(name="nombreObraSocial")
    private String nombreObraSocial;

    public ObraSocial() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }
    
    
}
