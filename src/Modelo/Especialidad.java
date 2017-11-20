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
public class Especialidad extends Entidad{

    private String nombreEspecialidad;
    
    public Especialidad() {
    }

    @Override
    public String getOID() {
        return super.OID;
    }

    @Override
    public void setOID(String OID) {
        super.OID=OID;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    
}
