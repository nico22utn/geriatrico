/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMPersonal;

import Controlador.DTO.DTOArea;
import Controlador.DTO.DTOEspecializacion;
import Controlador.DTO.DTOPersonal;
import Controlador.DTO.DTORol;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMPersonal;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMPersonal {
    ExpertoABMPersonal experto = new ExpertoABMPersonal();
    public List<DTOPersonal> buscar(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        List<DTOPersonal> lista = experto.buscar();
        FachadaInterna.getInstancia().finalizarTransaccion();
        return lista;
        
    }
    
    public List<DTORol> buscarRol(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscarRol();
        
    }
    
    public List<DTOEspecializacion> buscarEspecialidad(){
        
        return experto.buscarEspecialidad();
    }
    
    public List<DTOArea> buscarArea(){
        return experto.buscarArea();
    }
    
    
    
}
