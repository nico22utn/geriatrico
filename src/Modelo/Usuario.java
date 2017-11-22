/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Maxi
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column(name="nombreUsuario")
    private String nombreUsuario;
    @Column(name="password")
    private String password;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Personal personal;

    public Usuario() {
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
    
}
