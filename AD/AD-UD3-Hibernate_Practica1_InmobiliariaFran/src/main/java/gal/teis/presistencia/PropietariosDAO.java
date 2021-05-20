/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.presistencia;

import gal.teis.negocio.DatosBancarios;
import gal.teis.negocio.Propietarios;
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
public class PropietariosDAO {

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
            sesion = HibernateUtil.getSessionFactory().openSession();
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
    public static long guardaPropietario(Propietarios propietario) {
        long id = -1;
        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aquí no se usa, pero se podría utilizar*/
            id = (long) sesion.save(propietario);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }

    /**
     * Permite actualizar un contacto en la BD
     *
     * @param propietario
     * @return
     * @throws HibernateException
     */
    public static boolean actualizaPropietario(Propietarios propietario) {
        boolean actualizado = false;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            //Actualiza el contacto 
            sesion.update(propietario);
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
     * Elimina el contacto en la BD
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    public static boolean eliminaPropietario(long id) {

        boolean eliminado = false;
        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            //Antes de eliminar el objeto debe ser recuperado de la BD con get
            Propietarios propietario_get = sesion.get(Propietarios.class, id);

            //Elimina el contacto persistente si existe
            if (!Objects.isNull(propietario_get)) {
                sesion.delete(propietario_get);
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
     * Obtiene un contacto de la BD Para ejecutar las búsquedas se puede usar
     * get o load.La diferencia es el comportamiento cuando no se encuentra la
     * entidad, mientras get() devuelve null, load() lanza una excepción
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    public static Propietarios obtenPropietario(long id) {
        Propietarios propietario = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            propietario = sesion.get(Propietarios.class, id);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return propietario;
    }

    /**
     * Recupera todos los contactos
     *
     * @return devuleve un ojeto List con todos los contactos de la BD
     * @throws HibernateException
     */
    public static List<Propietarios> obtenListaPropietarios() {
        List<Propietarios> listaPropietarios = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();
            listaPropietarios = sesion.createQuery("from Propietarios").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }

        return listaPropietarios;
    }

    /**
     * Permite añadir datos Bancarios en la BD
     *
     * @param datosBancarios DatosBancarios, elemento a insertar en la BD
     * @return
     */
    public static long guardaDatosBancarios(DatosBancarios datosBancarios) {
        long id = 0;
        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aquí no se usa, pero se podría utilizar*/
            id = (long) sesion.save(datosBancarios);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }

    public static List<Object[]> obtenPropietarioCuentaBancaria(long id) {
        List<Object[]> propietarioCuenta = null;

        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            propietarioCuenta = sesion.createQuery("from DatosBancarios as dat "
                    + "inner join dat.propietario as pro where pro.id = :idP").setParameter("idP", id).list();
            //query.uniqueResult();
            transa.commit();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return propietarioCuenta;
    }

    public DatosBancarios obtenDatosBancarios(String numCuenta) throws HibernateException {
        List<DatosBancarios> listaDatosBancarios = null;
        DatosBancarios encontrado = new DatosBancarios();
        try {
            iniciaOperacion();
            //Obtiene una lista de contactos utilizando el lenguaje HQL
            listaDatosBancarios = sesion.createQuery("from DatosBancarios where numCuenta= :nC").setParameter("nC", numCuenta).list();
            if (listaDatosBancarios.size() > 0) {
                encontrado = listaDatosBancarios.get(0);
            }
        } finally {
            sesion.close();
        }
        return encontrado;
    }

    /**
     * Permite actualizar un contacto en la BD
     *
     * @param nuevosDatos
     * @return
     * @throws HibernateException
     */
    public static boolean actualizaDatosBancarios(DatosBancarios nuevosDatos) {
        boolean actualizado = false;
        try {
            iniciaOperacion();
            //actualiza el contacto en la base de datos
            sesion.update(nuevosDatos);
            transa.commit();

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return actualizado;

    }
    
    /**
     *
     * @return
     */
    public static List<Object[]> listarPropietariosInmuebles() {
        List<Object[]> propietarioInmueble = null;


        try {
            //abre la sesión e inicia la transición
            iniciaOperacion();

            propietarioInmueble = sesion.createQuery("from Inmuebles as inm "
                    + "inner join inm.propietarios").list();
            //query.uniqueResult();
            transa.commit();


        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return propietarioInmueble;
    }
    
    

}
