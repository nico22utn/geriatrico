package Controlador.Persistencia;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import DTO.DTOCriterio;


public class FachadaInterna
{

    private static FachadaInterna instancia;

    public FachadaInterna (){}

    public static FachadaInterna getInstancia (){
        if (instancia == null){
            instancia = new FachadaInterna();
        }
        return instancia;
    }

     public List<Object> buscarMax (String claseABuscar, List<DTOCriterio> criterioList){
        iniciarTransaccion();
        Criteria cr = null;
        try{
            cr = HibernateUtil.getSession().createCriteria(Class.forName("Entidades." + claseABuscar), claseABuscar.toLowerCase()).setProjection(Projections.max("codigo"+claseABuscar));
        }
        catch (ClassNotFoundException e){
            System.out.println("Error creating criteria. " + e);
        }
        if (criterioList != null){
            for (DTOCriterio criterio : criterioList){
                String atributo = criterio.getAtributo();
                String operacion = criterio.getOperador();
                Object valor = criterio.getValor();

                switch (operacion){
                    case "is null":
                            cr.add(Restrictions.conjunction(Restrictions.isNull(atributo)));
                        break;
                    case "=":
                        cr.add(Restrictions.conjunction(Restrictions.eq(atributo, valor)));
                        break;
                    case "<":
                        cr.add(Restrictions.conjunction(Restrictions.lt(atributo, valor)));
                        break;
                    case ">":
                        cr.add(Restrictions.conjunction(Restrictions.gt(atributo, valor)));
                        break;
                    case "<=":
                        cr.add(Restrictions.conjunction(Restrictions.le(atributo, valor)));
                        break;
                    case ">=":
                        cr.add(Restrictions.conjunction(Restrictions.ge(atributo, valor)));
                        break;
                    case "<>":
                        cr.add(Restrictions.conjunction(Restrictions.ne(atributo, valor)));
                        break;
                    case "contains":
                        //Todos las colecciones deben empezar de la siguiente manera: claseColeccionList
                        //Generamos el nombre de esa colección a partir del atributo
                        String lista = String.valueOf(atributo.charAt(0))
                                .toLowerCase() + atributo.substring(1) + "List"; //materiaList, detalleReposicionList
                        cr.createAlias(lista, "lista")
                                .add(Restrictions.conjunction(Restrictions.eq("lista.OID" + claseABuscar, ((Entidades.Entidad) valor).getOID())));
                        break;
                }
            }
        }
        iniciarTransaccion();
        return cr.list();
    }

    public List<Object> buscar (String claseABuscar, List<DTOCriterio> criterioList){
        iniciarTransaccion();
        Criteria cr = null;
        try{
            cr = HibernateUtil.getSession().createCriteria(Class.forName("Entidades." + claseABuscar), claseABuscar.toLowerCase());
        }
        catch (ClassNotFoundException e){
            System.out.println("Error creating criteria. " + e);
        }
        if (criterioList != null){
            for (DTOCriterio criterio : criterioList){
                String atributo = criterio.getAtributo();
                String operacion = criterio.getOperador();
                Object valor = criterio.getValor();

                switch (operacion){
                    case "is null":
                            cr.add(Restrictions.conjunction(Restrictions.isNull(atributo)));
                        break;
                    case "=":
                        cr.add(Restrictions.conjunction(Restrictions.eq(atributo, valor)));
                        break;
                    case "<":
                        cr.add(Restrictions.conjunction(Restrictions.lt(atributo, valor)));
                        break;
                    case ">":
                        cr.add(Restrictions.conjunction(Restrictions.gt(atributo, valor)));
                        break;
                    case "<=":
                        cr.add(Restrictions.conjunction(Restrictions.le(atributo, valor)));
                        break;
                    case ">=":
                        cr.add(Restrictions.conjunction(Restrictions.ge(atributo, valor)));
                        break;
                    case "<>":
                        cr.add(Restrictions.conjunction(Restrictions.ne(atributo, valor)));
                        break;
                    case "contains":
                        //Todos las colecciones deben empezar de la siguiente manera: claseColeccionList
                        //Generamos el nombre de esa colección a partir del atributo
                        String lista = String.valueOf(atributo.charAt(0))
                                .toLowerCase() + atributo.substring(1) + "List"; //materiaList, detalleReposicionList
                        cr.createAlias(lista, "lista")
                                .add(Restrictions.conjunction(Restrictions.eq("lista.OID" + claseABuscar, ((Entidades.Entidad) valor).getOID())));
                        break;
                }
            }
        }
        iniciarTransaccion();
        return cr.list();
    }

    public void guardar (Object objeto){
        HibernateUtil.getSession().save(objeto);
    }

    public void iniciarTransaccion (){
        Transaction transaccion = HibernateUtil.getSession().getTransaction();
        if(transaccion.isActive() == false ){ //SI NO HAY UNA TRANSACCION, LA CREA
            HibernateUtil.getSession().beginTransaction();
        }        
    }

    public void finalizarTransaccion (){        
        HibernateUtil.getSession().getTransaction().commit();
        HibernateUtil.getSession().close();
        HibernateUtil.getSessionFactory().close();            
    }
    
    public void eliminar (Object objeto){
        HibernateUtil.getSession().delete(objeto);
        //no hacer iniciar transaccion ni commit en esta parte, se hace en el finalizar transaccion
    }
}
