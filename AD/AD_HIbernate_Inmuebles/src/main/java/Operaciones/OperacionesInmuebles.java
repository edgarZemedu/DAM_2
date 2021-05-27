/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.Inmueble;
import Clases.DatosBancarios;
import Clases.Propietario;
import Persistencia.Hibernate;
import java.util.List;
import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Contiene los métodos para realizar las siguientes operaciones con Hibernate:
 * abrir sesión, crear transacción, agregar, eliminar, actualizar, obtener y
 * listaR elementos de la BB
 *
 * @author Fran
 */
public class OperacionesInmuebles {

    /**
     * Objeto Session y Transaction para porder realizar operaciones sobre la BD
     */
    private static Session sesion;
    private static Transaction transa;

    /**
     * obtenemos una referencia a "SessionFactory" usando nuestra clase de
     * utilidad "HibernateUtil". Una vez que tenemos la "SessionFactory" creamos
     * una conexión a la base de datos e iniciamos una nueva sesión con el
     * método "openSession()". Una vez teniendo la sesión iniciamos una nueva
     * transacción y obtenemos una referencia a ella con "beginTransaction()"
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
     * Si se produce una excepción queremos que la transacción que se está
     * ejecutando se deshaga y se relance la excepción (podríamos lanzar una
     * excepción propia)
     */
    private static void manejaExcepcion(HibernateException he) {
        transa.rollback();
        throw new HibernateException("Ha sucedido un error en la capa de acceso a datos", he);
    }

    /*
    Ahora crearemos los métodos que nos permitirán realizar las tareas de persistencia 
    de una entidad "Contacto", conocidas en lenguaje de base de datos como CRUD: guardarla, 
    actualizarla, eliminarla, buscar un entidad "Contacto" y obtener todas los contactos 
    que existen en la base de datos
     */
    /**
     * Permite guardar un contacto en la BD
     *
     * @param propietario Propietarios, elemento a insertar en la BD
     * @return
     */
    static public void guardaInmueble(Inmueble inmueble) {

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aquí no se usa, pero se podría utilizar*/
            sesion.save(inmueble);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }

    }

    /**
     *
     * @param id
     * @return
     */
    public static List<Object[]> obtenInmueblePropietario(int id) {
        List<Object[]> inmueblePropietario = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            inmueblePropietario = sesion.createQuery("FROM Inmuebles AS i "
                    + "INNER JOIN i.propietarios WHERE i.id = :idP").setParameter("idP", id).list();
            //query.uniqueResult();
            transa.commit();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return inmueblePropietario;
    }

    /**
     *
     *
     * @return
     */
    public static List<Object[]> obtenInmueblesYPropietarios() {
        List<Object[]> inmueblesPropietarios = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            inmueblesPropietarios = sesion.createQuery("FROM Inmuebles AS i "
                    + "INNER JOIN i.propietarios").list();
            //query.uniqueResult();
            transa.commit();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return inmueblesPropietarios;
    }

    /**
     * Obtiene el inmueble
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    public static Inmueble obtenInmueble(int id) {
        Inmueble inmuebles = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            inmuebles = sesion.get(Inmueble.class, id);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return inmuebles;
    }

    /**
     * Elimina el contacto en la BD
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    public static boolean eliminaInmueble(int id) {

        boolean eliminado = false;
        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            //Antes de eliminar el objeto debe ser recuperado de la BD con get
            Inmueble inmueble_get = sesion.get(Inmueble.class, id);

            //Elimina el contacto persistente si existe
            if (!Objects.isNull(inmueble_get)) {
                sesion.delete(inmueble_get);
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
     * Permite actualizar un contacto en la BD
     *
     * @param propietario
     * @return
     * @throws HibernateException
     */
    public static boolean actualizaInmueble(Inmueble inmueble) {
        boolean actualizado = false;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            //Actualiza el contacto 
            sesion.update(inmueble);
            transa.commit();
            actualizado = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return actualizado;
    }
}
