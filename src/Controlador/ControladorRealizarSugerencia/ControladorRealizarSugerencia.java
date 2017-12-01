/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorRealizarSugerencia;

import Controlador.DTO.DTOPersonal;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoRealizarSugerencia;
import Modelo.TipoPrioridad;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorRealizarSugerencia {
    
    ExpertoRealizarSugerencia experto = new ExpertoRealizarSugerencia();
    
    public List<DTOPersonal> buscar(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscar();
        
        
    }
    
    public List<TipoPrioridad> buscarPrioridad(){
        List<TipoPrioridad> lista = experto.buscarPrioridad();
        FachadaInterna.getInstancia().finalizarTransaccion();
        return lista;
    }
    
}
