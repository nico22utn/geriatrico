/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOObraSocial;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;




/**
 *
 * @author Maxi
 */
public class ExpertoABMAbuelos {
    
    public boolean iniciarAlta(DTOAbuelo abuelo){
        Date fechaHoy = new Date();
        Paciente abueloExistente =(Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.dni= :dni").setParameter("dni", abuelo.getDni()).uniqueResult();
        if(abueloExistente == null){
            Paciente paciente = new Paciente();
            paciente.setNombre(abuelo.getNombre());
            paciente.setApellido(abuelo.getApellido());
            paciente.setDni(abuelo.getDni());
            paciente.setFechaAlta(fechaHoy);
            paciente.setFechaBaja(null);
            paciente.setFechadeNacimiento(abuelo.getFechadeNacimiento());
            ObraSocial obra = (ObraSocial) HibernateUtil.getSession().createQuery("SELECT o FROM ObraSocial o WHERE o.nombreObraSocial = :nombreObraSocial").setParameter("nombreObraSocial", abuelo.getNombreObraSocial()).uniqueResult();
            paciente.setObraSocial(obra);
            paciente.setPeso(abuelo.getPeso());
            paciente.setTalla(abuelo.getTalla());
            paciente.setEdad(CalcularEdad(abuelo.getFechadeNacimiento()));
            byte[] imagen = convertirStringAbyte(abuelo.getRutafotoPaciente());
            paciente.setFotoPaciente(imagen);
            FachadaInterna.getInstancia().guardar(paciente);
            return true;
            
        }else{
            return false;
        }
    }
    
    public int CalcularEdad(Date fechaNacimiento){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String stringfechaNacimiento = sdf.format(fechaNacimiento);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ahora = LocalDate.now();
            LocalDate fechaNac = LocalDate.parse(stringfechaNacimiento,fmt);
            Period periodo = Period.between(fechaNac,ahora);
            return periodo.getYears();
    }
    
    public byte[] convertirStringAbyte(String rutaFoto){
       try{
        FileInputStream archivofoto = new FileInputStream(rutaFoto);
        byte[] foto = IOUtils.toByteArray(archivofoto);
        return foto;    
       }catch(Exception e){
           System.out.println("No existe archivo");
           return null;
       }
        
            
            
        
        
    }
    
    public List<DTOAbuelo> buscar(){
     List listaAbuelos = HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p").list();
     List<DTOAbuelo> listaDTOAbuelo = new ArrayList<>();
     for(Object a : listaAbuelos){
         Paciente paciente = (Paciente) a;
         DTOAbuelo dtoabuelo = new DTOAbuelo();
         dtoabuelo.setApellido(paciente.getApellido());
         dtoabuelo.setNombre(paciente.getNombre());
         dtoabuelo.setDni(paciente.getDni());
         dtoabuelo.setFechaAlta(paciente.getFechaAlta());
         dtoabuelo.setFechaBaja(paciente.getFechaBaja());
         dtoabuelo.setEdad(CalcularEdad(paciente.getFechadeNacimiento()));
         dtoabuelo.setFoto(paciente.getFotoPaciente());
         dtoabuelo.setNombreObraSocial(paciente.getObraSocial().getNombreObraSocial());
         dtoabuelo.setPeso(paciente.getPeso());
         dtoabuelo.setTalla(paciente.getTalla());
         dtoabuelo.setId(paciente.getId());
         dtoabuelo.setFechadeNacimiento(paciente.getFechadeNacimiento());
         listaDTOAbuelo.add(dtoabuelo);
     }
     
     return listaDTOAbuelo;
             
    }
    
    public List<DTOObraSocial> buscarObra(){
        List listaObraSocial = HibernateUtil.getSession().createQuery("SELECT o FROM ObraSocial o").list();
        List<DTOObraSocial> listaDTO = new ArrayList<>();
        for(Object o : listaObraSocial){
            ObraSocial obrasocial = (ObraSocial) o;
            DTOObraSocial dtoObraSocial = new DTOObraSocial();
            dtoObraSocial.setNombreObraSocial(obrasocial.getNombreObraSocial());
            listaDTO.add(dtoObraSocial);
            
        }
        
        return listaDTO;
    }
    

}
