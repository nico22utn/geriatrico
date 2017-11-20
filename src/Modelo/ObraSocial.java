/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author User
 */
public class ObraSocial extends Entidad{
    private String nombreObraSocial;

    public ObraSocial() {
    }
    
    @Override
    public String getOID() {
        return super.OID;
    }

    @Override
    public void setOID(String OID) {
        super.OID=OID;
    }

    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }
    
    
}
