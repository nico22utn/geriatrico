/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMAbuelos;

import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOObraSocial;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMAbuelos;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMAbuelos {
    ExpertoABMAbuelos experto = new ExpertoABMAbuelos();
    public boolean iniciarAlta(DTOAbuelo abuelo){
        FachadaInterna.getInstancia().iniciarTransaccion();
        boolean exito = experto.iniciarAlta(abuelo);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
    }
    
    public List<DTOAbuelo> buscar(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        List<DTOAbuelo> lista = experto.buscar();
        FachadaInterna.getInstancia().finalizarTransaccion();
        return lista;
    }
    

    
    
}
