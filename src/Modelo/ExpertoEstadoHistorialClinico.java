/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOEstadoHistorialClinico;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ExpertoEstadoHistorialClinico {
    public boolean iniciarAlta(String nombreEstado){
    
    EstadoHistorialClinico estadoExistente = (EstadoHistorialClinico) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoHistorialClinico e WHERE e.nombreEstado = :nombreEstado").setParameter("nombreEstado", nombreEstado).uniqueResult();
    if(estadoExistente == null){
        EstadoHistorialClinico estado=new EstadoHistorialClinico();
        estado.setNombreEstado(nombreEstado);
        FachadaInterna.getInstancia().guardar(estadoExistente);
        return true;
    }else{
        
        return false;
    }
    
    
    }
    public boolean iniciarModificacion(Long idEstado,String nombreEstado){
    EstadoHistorialClinico estadoExistente = (EstadoHistorialClinico) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoHistorialClinico e WHERE e.nombreEstado = :nombre").setParameter("nombre", nombreEstado).uniqueResult();

        if(estadoExistente == null){
        EstadoHistorialClinico estadoEncontrado = (EstadoHistorialClinico) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoHistorialClinico e WHERE e.id = :id").setParameter("id", idEstado).uniqueResult();
        estadoEncontrado.setNombreEstado(nombreEstado);
        FachadaInterna.getInstancia().guardar(estadoEncontrado);
        return true;
    }else{
        return false;
        
    }    
    }
    
    public boolean iniciarBaja(Long idEstado){
        HistorialClinicoEstado hcestado= (HistorialClinicoEstado) HibernateUtil.getSession().createQuery("SELECT h FROM HistorialClinicoEstado h  WHERE c.estadoHistorialClinico.id=: id").setParameter("id",idEstado).uniqueResult();
        
        if(hcestado == null){
        EstadoHistorialClinico estadoEncontrado = (EstadoHistorialClinico) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoHistorialClinico e WHERE e.id=:id ").setParameter("id", idEstado).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(estadoEncontrado);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTOEstadoHistorialClinico> buscar(){
        List<Object> lista = HibernateUtil.getSession().createQuery("SELECT e FROM EstadoHistorialClinico e").list();
        List<DTOEstadoHistorialClinico> listadtoestado = new ArrayList<>();
        for(Object estado : lista){
            EstadoConsulta estadoencontrado = (EstadoConsulta) estado;
            DTOEstadoHistorialClinico dto=new DTOEstadoHistorialClinico();
            dto.setNombre(estadoencontrado.getNombre());
            dto.setId(estadoencontrado.getId());
            listadtoestado.add(dto);
        }
        
        return listadtoestado;
    }
}
