/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOEspecializacion;
import Controlador.DTO.DTOPersonal;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoRealizarSugerencia {
    
    
    public List<DTOPersonal> buscar(){
        List<Object> listaPersonal = HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.fechaBaja=" + null).list();
        List<DTOPersonal> listadtoPersonal = new ArrayList<>();
        for(Object personal : listaPersonal){
            Personal personalencontrado = (Personal) personal;
            DTOPersonal dtoPersonal = new DTOPersonal();
            dtoPersonal.setId(personalencontrado.getId());
            dtoPersonal.setApellidoPersonal(personalencontrado.getApellido());
            dtoPersonal.setNombrePersonal(personalencontrado.getNombre());
            dtoPersonal.setDni(personalencontrado.getDni());
            dtoPersonal.setFechaAlta(personalencontrado.getFechaAlta());
            dtoPersonal.setFechaBaja(personalencontrado.getFechaBaja());
            dtoPersonal.setNombreArea(personalencontrado.getArea().getNombreArea());
            dtoPersonal.setNombreRol(personalencontrado.getRol().getNombreRol());
            
            List<DTOEspecializacion> listadtoEspecialidad = new ArrayList<>();
            for(Especialidad especialidad:personalencontrado.getEspecialidad()){
                DTOEspecializacion dtoespe = new DTOEspecializacion();
                dtoespe.setIdEspecializacion(especialidad.getId());
                dtoespe.setNombreEspecializacion(especialidad.getNombreEspecialidad());
                listadtoEspecialidad.add(dtoespe);
            }
            dtoPersonal.setListaEspecialidad(listadtoEspecialidad);
            listadtoPersonal.add(dtoPersonal);
        }
        
        return listadtoPersonal;
    }
    
    public List<TipoPrioridad> buscarPrioridad(){
        List<Object> listaPrioridadEncontrada = HibernateUtil.getSession().createQuery("SELECT p FROM TipoPrioridad p").list();
        List<TipoPrioridad> listaPrioridad = new ArrayList<>();
        for(Object o : listaPrioridadEncontrada){
            TipoPrioridad tp = (TipoPrioridad) o;
            listaPrioridad.add(tp);
            
        }
        
        return listaPrioridad;
        
        
    }
    
}
