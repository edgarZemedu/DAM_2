/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.Propietario;
import Clases.Inmueble;
import Excepciones.MisExcepciones;
import Persistencia.Hibernate;
import java.util.List;
import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author a18zemedufc
 */
public class Operaciones {

    /**
     * Objeto Session y Transaction para porder realizar operaciones sobre la BD
     */
    private static Session sesion;
    private static Transaction transa;

    /**
     * obtenemos una referencia a "SessionFactory" usando nuestra clase de
     * utilidad "HibernateUtil". Una vez que tenemos la "SessionFactory" creamos
     * una conexi�n a la base de datos e iniciamos una nueva sesi�n con el
     * m�todo "openSession()". Una vez teniendo la sesi�n iniciamos una nueva
     * transacci�n y obtenemos una referencia a ella con "beginTransaction()"
     *
     */
    private static void iniciaOperacion() throws HibernateException {
        try {
            sesion = Hibernate.getSessionFactory().openSession();
            transa = sesion.beginTransaction();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Si se produce una excepci�n queremos que la transacci�n que se est�
     * ejecutando se deshaga y se relance la excepci�n (podr�amos lanzar una
     * excepci�n propia)
     */
    private static void manejaExcepcion(HibernateException he) {
        transa.rollback();
        throw new HibernateException("\n\nHa sucedido un error en la capa de acceso a datos", he);
    }

    /*
    Ahora crearemos los m�todos que nos permitir�n realizar las tareas de persistencia 
    de una entidad "Contacto", conocidas en lenguaje de base de datos como CRUD: guardarla, 
    actualizarla, eliminarla, buscar un entidad "Contacto" y obtener todas los contactos 
    que existen en la base de datos
     */
    /**
     * Permite guardar un contacto en la BD
     *
     * @param Empleado Contacto, elemento a insertar en la BD
     * @return devuelve el id generado para el elemento guardado o -1 si la
     * operaci�n no se ha podido realizar
     */
    public static long gurdarP(Propietario p) {
        int id = -1;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aqu� no se usa, pero se podr�a utilizar*/
            id = (int) sesion.save(p);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }

    public static long gurdarI(Inmueble i) {
        int id = -1;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aqu� no se usa, pero se podr�a utilizar*/
            id = (int) sesion.save(i);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }

    /**
     * Permite actualizar un contacto en la BD a partir del id que lo identifica
     *
     * @param Empleado Contacto, elemento a actualizar
     * @throws HibernateException
     */
    public static boolean actualizaP(Propietario p) {
        boolean actualizado = false;

        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();

            //Actualiza el contacto 
            sesion.update(p);
            transa.commit();
            actualizado = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return actualizado;
    }

    /**
     * Elimina el contacto en la BD Previamente lo obtiene de la BD para
     * confirmar que existe
     *
     * @param contacto Contacto, elemento a eliminar
     * @return si la operaci�n ha sido realizada con �xito, devuelve true
     * @throws HibernateException
     */
    public static boolean eliminaE(int id) {

        boolean eliminado = false;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();

            //Antes de eliminar el objeto debe ser recuperado de la BD con get
            Propietario getE = sesion.get(Propietario.class, id);

            //Elimina el contacto persistente si existe
            if (!Objects.isNull(getE)) {
                sesion.delete(getE);
                transa.commit();
                eliminado = true;
            }

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return eliminado;
    }

    /**
     * Obtiene un contacto de la BD Para ejecutar las b�squedas se puede usar
     * get o load. La diferencia es el comportamiento cuando no se encuentra la
     * entidad, mientras get() devuelve null, load() lanza una excepci�n
     *
     * @param idContacto
     * @return
     * @throws HibernateException
     */
    public static Propietario obtenEmpleado(int id) {
        Propietario e = null;
        boolean obtenido = false;

        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();

            e = sesion.get(Propietario.class, id);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return e;
    }

    /**
     * Recupera todos los contactos
     *
     * @return devuleve un ojeto List con todos los contactos de la BD
     * @throws HibernateException
     */
    public static List<Object[]> obtenerListaPI() throws HibernateException {
        List<Object[]> listaED = null;
        try {
            iniciaOperacion();
            listaED = sesion.createQuery("FROM Direccion AS dire INNER JOIN dire.empleado AS emp").list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return listaED;
    }

    public static List<Object[]> obtenerListaPIconID(int idBuscar) throws HibernateException {
        List<Object[]> listaPI = null;
        boolean obtenido = false;
        try {
            //abre la sesi�n e
            //inicia la transici�n
            iniciaOperacion();
            
            listaPI = sesion.createQuery("FROM Direccion AS dire INNER JOIN dire.empleado AS emp "
                    + "WHERE emp.id = :idP").setParameter("idP", idBuscar).list();
            
            //query.uniqueResult();
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return listaPI;
    }
}