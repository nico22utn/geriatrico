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
public class Area extends Entidad{
    private String nombreArea;

    public Area() {
    }
    
    @Override
    public String getOID() {
        return super.OID;
    }

    @Override
    public void setOID(String OID) {
        super.OID=OID;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    
}
