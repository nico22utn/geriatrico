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
public class TipoPrioridad extends Entidad {
    private String nombre;
    private String codigo;

    @Override
    public String getOID() {
        return super.OID;
    }

    @Override
    public void setOID(String OID) {
        super.OID = OID;
    }

    public TipoPrioridad() {
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
