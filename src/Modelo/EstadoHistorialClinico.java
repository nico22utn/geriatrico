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
public class EstadoHistorialClinico extends Entidad{

    private String nombre;

    public EstadoHistorialClinico() {
    }
    
    @Override
    public String getOID() {
        return super.OID;
    }

    @Override
    public void setOID(String OID) {
        super.OID=OID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
