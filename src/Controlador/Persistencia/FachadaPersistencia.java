package Controlador.Persistencia;

import java.util.*;
import DTO.DTOCriterio;

public class FachadaPersistencia
{

    private static FachadaPersistencia instancia;

    public FachadaPersistencia ()
    {
    }

    public static FachadaPersistencia getInstancia ()
    {
        if (instancia == null)
        {
            instancia = new FachadaPersistencia();
        }
        return instancia;
    }

    /**
     *
     * @param claseABuscar
     * @param criterioList
     * @return
     */
    public List<Object> buscar (String claseABuscar, List<DTOCriterio> criterioList)
    {
        return FachadaInterna.getInstancia().buscar(claseABuscar, criterioList);
    }
    
    public List<Object> buscarMax (String claseABuscar, List<DTOCriterio> criterioList)
    {
        return FachadaInterna.getInstancia().buscarMax(claseABuscar, criterioList);
    }

    public void guardar (Object objeto)
    {
        FachadaInterna.getInstancia().guardar(objeto);
    }
    
    public void eliminar (Object objeto){
        FachadaInterna.getInstancia().eliminar(objeto);
    }
    

}
