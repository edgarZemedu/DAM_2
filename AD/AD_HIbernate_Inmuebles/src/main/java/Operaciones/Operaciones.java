/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.DatosBancarios;
import Clases.Propietario;
import Clases.Inmueble;
import Excepciones.MisExcepciones;
import Libreria.ControlData;
import Menu.Menu;
import static Menu.Menu.pintarMenuPrincipal;
import Persistencia.Hibernate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
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
    static Scanner sc = new Scanner(System.in);
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
        throw new HibernateException("\nHa sucedido un error en la capa de acceso a datos "+he.getMessage(), he);
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
    public static Propietario añadirP(Scanner sc) {

        System.out.println("Dime el dni: ");
        String dni = sc.nextLine();
        System.out.println("Dime el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Dime el apellido: ");
        String apellidos = sc.nextLine();
        System.out.println("Dime el direccion: ");
        String direccion = sc.nextLine();
        System.out.println("Dime el teléfono: ");
        String telefono = sc.nextLine();
        Propietario p = new Propietario(dni, nombre, apellidos, direccion, telefono);

        return p;
    }

    public static DatosBancarios añadirDatosBancariosP(Propietario nuevoP, Scanner sc) {
        DatosBancarios nuevoDB = new DatosBancarios();
        try {
            System.out.println("Introduce el Número de Cuenta");
            String numCuenta = ControlData.lerString(sc);
            System.out.println("Introduce el nombre del Banco");
            String nombreBanco = ControlData.lerNome(sc);
            nuevoDB = new DatosBancarios(numCuenta, nombreBanco, nuevoP);

            //nuevoDB.setPropietario(nuevoPropietario);
            long id = gurdarDB(nuevoDB);
            System.out.println("Se han guardado los datos bancarios del propietario que tiene el id " + id);

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

        return nuevoDB;
    }

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

    public static void gurdarI() {
        System.out.println("Introduce el ID");
        int id = ControlData.lerChar(sc);
        System.out.println("Introduce la Dirección del Inmueble");
        String inDireccion = ControlData.lerString(sc);
        System.out.println("Introduce el código de la zona");
        int inCodZona = ControlData.lerInt(sc);
        System.out.println("Introduce el estado del Inmueble");
        String inEstado = ControlData.lerString(sc);
        System.out.println("Introduce el ID del propietario");
        int idPropietario = ControlData.lerInt(sc);

        //List<Propietario> listaPropietarios = null;
        //listaPropietarios = OperacionesPropietarios.obtenListaPropietarios();

        try {
            Propietario propietario = OperacionesPropietarios.obtenPropietario(idPropietario);

            //Crea un un inmueble con los datos introducidos
            Inmueble nuevoInmueble = new Inmueble(inDireccion, inCodZona, inEstado, propietario);
            OperacionesInmuebles.guardaInmueble(nuevoInmueble);
            System.out.println("Se ha guardado el Inmueble que tendrá el id " + id);
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    public static long gurdarDB(DatosBancarios dp) {
        int id = -1;
        try {
            iniciaOperacion();
            id = (int) sesion.save(dp);
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
    public static void menuActualizarI() {
        System.out.println("Introduce el id del inmueble a modificar ");
        char id = ControlData.lerChar(sc);
        boolean modificado = false;
        try {
            Inmueble inmueble_localizado = OperacionesInmuebles.obtenInmueble(id);
            if (!Objects.isNull(inmueble_localizado)) {
                System.out.println("Confirme que el inmueble a modificar es (S/N) " + inmueble_localizado.toString());
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                    byte opcion = Menu.pintarMenuModificarInmueble(sc);
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduce el nuevo ID");
                            char idn = ControlData.lerChar(sc);
                            inmueble_localizado.setId(idn);
                            modificado = OperacionesInmuebles.actualizaInmueble(inmueble_localizado);
                            break;
                        case 2:
                            System.out.println("Introduce la nueva dirección");
                            String inDireccion = ControlData.lerString(sc);
                            inmueble_localizado.setDireccion(inDireccion);
                            modificado = OperacionesInmuebles.actualizaInmueble(inmueble_localizado);
                            break;
                        case 3:
                            System.out.println("Introduce el nuevo código de zona");
                            int inCodZona = ControlData.lerInt(sc);
                            inmueble_localizado.setCodigoPostal(inCodZona);
                            modificado = OperacionesInmuebles.actualizaInmueble(inmueble_localizado);
                            break;
                        case 4:
                            System.out.println("Introduce el nuevo estado");
                            String inEstado = ControlData.lerString(sc);
                            inmueble_localizado.setEstado(inEstado);
                            modificado = OperacionesInmuebles.actualizaInmueble(inmueble_localizado);
                            break;
                        case 5:
                            System.out.println("Introduce el nuevo propietario");
                            int idPropietario = ControlData.lerInt(sc);
                            Propietario propietario = OperacionesPropietarios.obtenPropietario(idPropietario);
                            inmueble_localizado.setPropietario(propietario);
                            modificado = OperacionesInmuebles.actualizaInmueble(inmueble_localizado);
                            break;

                        default:
                            System.out.println("Operación de actualización cancelada");
                    }

                    if (modificado) {
                        System.out.println("El inmueble ha sido modificado correctamente");
                    }
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("El inmueble no ha sido localizado");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    /**
     * Elimina el contacto en la BD Previamente lo obtiene de la BD para
     * confirmar que existe
     *
     * @param contacto Contacto, elemento a eliminar
     * @return si la operaci�n ha sido realizada con �xito, devuelve true
     * @throws HibernateException
     */
    public static boolean eliminaP(int id) {

        boolean eliminado = false;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();

            //Antes de eliminar el objeto debe ser recuperado de la BD con get
            Propietario getP = sesion.get(Propietario.class, id);

            //Elimina el contacto persistente si existe
            if (!Objects.isNull(getP)) {
                sesion.delete(getP);
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
    public static void eliminarI() {
        System.out.println("Introduce el id del inmueble a eliminar ");
        int id = ControlData.lerInt(sc);
        boolean eliminado = false;
        try {
            Inmueble ilocalizado = OperacionesInmuebles.obtenInmueble(id);
            if (!Objects.isNull(ilocalizado)) {
                System.out.println("El Inmueble ha sido localizado");
                System.out.println(ilocalizado.toString());
                System.out.println("¿Está seguro de que desea eliminarlo (S/N)?");
                char siEliminar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siEliminar) == 'S') {//Realizamos la operación
                    eliminado = OperacionesInmuebles.eliminaInmueble(ilocalizado.getId());
                    if (eliminado) {
                        System.out.println("El Inmueble ha sido eliminado correctamente");
                    }
                }
            } else {
                System.out.println("El Inmueble no ha sido localizado");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
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
    public static Propietario obtenerP(int id) {
        Propietario e = null;

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

    public static DatosBancarios obtenerDB(int id) {
        DatosBancarios dp = null;
        boolean obtenido = false;

        try {
            iniciaOperacion();
            dp = sesion.get(DatosBancarios.class, id);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return dp;
    }

    public static void obtenerInm() {
        System.out.println("Introduce el id del inmueble a buscar ");
        char id = ControlData.lerChar(sc);

        try {
            List<Object[]> inmueble_localizado = OperacionesInmuebles.obtenInmueblePropietario(id);
            if (!Objects.isNull(inmueble_localizado)) {
                System.out.println("El inmueble ha sido localizado ");
                System.out.println(inmueble_localizado.get(0)[0]);

                System.out.println("Quiere ver el propietario (S/N) ");
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación

                    System.out.println(inmueble_localizado.get(0)[0] + " - " + inmueble_localizado.get(0)[1]);
                }

            } else {
                System.out.println("El Inmueble no ha sido localizado ");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    /**
     * Recupera todos los contactos
     *
     * @return devuleve un ojeto List con todos los contactos de la BD
     * @throws HibernateException
     */
    public static void obtenerListaPI()  {
        int i = 0;
        try {
            List<Object[]> listaIP =  OperacionesPropietarios.listarPropietariosInmuebles();
            if (!Objects.isNull(listaIP)) {

                Iterator it = listaIP.iterator();

                while (it.hasNext()) {
                    it.next();                    
                    System.out.println("Propietario: "+listaIP.get(i)[1] + " Inmueble: " + listaIP.get(i)[0]);
                    i++;
                }
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    public static List<Object[]> obtenerListaPdatosB() throws HibernateException {
        List<Object[]> listaPdatosB = null;
        try {
            iniciaOperacion();
            listaPdatosB = sesion.createQuery("FROM datosBancarios AS db INNER JOIN db.propietarios AS pro").list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return listaPdatosB;
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
    public static List<Object[]> obtenerListaPdBconID(int idBuscar) throws HibernateException {
        List<Object[]> listaPdatosB = null;
        boolean obtenido = false;
        try {
            iniciaOperacion();
            listaPdatosB = sesion.createQuery("FROM datosbancarios AS db INNER JOIN db.propietarios AS pro "
                    + "WHERE pro.id = :idP").setParameter("idP", idBuscar).list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return listaPdatosB;
    }

    public static void buscarPropietario(Scanner sc) {
        System.out.println("Introduce el id del propietario a buscar ");
        int id = ControlData.lerInt(sc);
        try {
            Propietario encontradoP = Operaciones.obtenerP(id);
            if (!Objects.isNull(encontradoP)) {
                System.out.println("El propietario ha sido localizado ");
                System.out.println(encontradoP.toString());

                System.out.println("Quiere ver los datos Bancarios (S/N) ");
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {

                    List<Object[]> propietarioCuenta = Operaciones.obtenerListaPdBconID(id);

                    if (!Objects.isNull(propietarioCuenta)) {
                        System.out.println(propietarioCuenta.get(0)[0] + " - " + propietarioCuenta.get(0)[1]);
                    }
                }
            } else {
                System.out.println("El propietario no ha sido localizado ");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    public static void actualizarP(Scanner sc) {
        System.out.println("Introduce el id del propietario a modificar ");
        int id = ControlData.lerInt(sc);
        boolean modificado = false;
        try {
            Propietario prolocalizado = Operaciones.obtenerP(id);
            if (!Objects.isNull(prolocalizado)) {
                System.out.println("\nConfirme que el propietario a modificar es (S/N) " + prolocalizado.toString());
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                    System.out.println("Elige que propiedad quieres modificar: ");
                    switch (Menu.subMenuModificarP(sc)) {
                        case 1:
                            System.out.println("Introduce el nuevo DNI");
                            String prDNI = ControlData.lerString(sc);
                            prolocalizado.setDNI(prDNI);
                            modificado = Operaciones.actualizaP(prolocalizado);
                            break;
                        case 2:
                            System.out.println("Introduce el nuevo nombre");
                            String PrNombre = ControlData.lerString(sc);
                            prolocalizado.setNombre(PrNombre);
                            modificado = Operaciones.actualizaP(prolocalizado);
                            break;
                        case 3:
                            System.out.println("Introduce los nuevos apellidos");
                            String prApellidos = ControlData.lerString(sc);
                            prolocalizado.setApellidos(prApellidos);
                            modificado = Operaciones.actualizaP(prolocalizado);
                            break;
                        case 4:
                            System.out.println("Introduce la nueva dirección");
                            String prDireccion = ControlData.lerString(sc);
                            prolocalizado.setDireccion(prDireccion);
                            modificado = Operaciones.actualizaP(prolocalizado);
                            break;
                        case 5:
                            System.out.println("Introduce el nuevo teléfono");
                            String prTelefono = ControlData.lerString(sc);
                            prolocalizado.setTelefono(prTelefono);
                            modificado = Operaciones.actualizaP(prolocalizado);
                            break;
                        case 6:
                            Operaciones.modificarDatosBancarios(id);

                            break;
                        default:
                            System.out.println("Operación de actualización cancelada");
                    }

                    if (modificado) {
                        System.out.println("El propietario ha sido modificado correctamente");
                    }
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("El propietario no ha sido localizado");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    private static void modificarDatosBancarios(int id) {
        OperacionesPropietarios propieDAO = new OperacionesPropietarios();

        System.out.println("Introduzca el número de cuenta a modificar: ");
        String numCuenta = ControlData.lerString(sc);

        DatosBancarios encontrado = propieDAO.obtenDatosBancarios(numCuenta);

        System.out.println("Introduzca el nuevo número de cuenta: ");
        numCuenta = ControlData.lerString(sc);
        System.out.println("Introduzca un nuevo nombre de Banco: ");
        String nombreBanco = ControlData.lerString(sc);

        Propietario propietario_localizado = OperacionesPropietarios.obtenPropietario(id);
        if (!Objects.isNull(propietario_localizado)) {

            encontrado.setNumCuenta(numCuenta);
            encontrado.setNombreBanco(nombreBanco);
            encontrado.setPropietario(propietario_localizado);

            propieDAO.actualizaDatosBancarios(encontrado);

            System.out.println("Datos Banarios Actualizados: ");
            System.out.println(encontrado);
        }
    }    

    public static void mostrarListaP() {
        List<Propietario> listaPropietarios = null;
        try {
            listaPropietarios = OperacionesPropietarios.obtenListaPropietarios();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
        if (!Objects.isNull(listaPropietarios)) {
            System.out.println("Hay " + listaPropietarios.size() + " propietario en la base de datos");
            for (Propietario p : listaPropietarios) {
                System.out.println(" -id- " + p.getId() + ", DNI -> " + p.getDNI()+ ", Nombre -> " + p.getNombre()+ ", Apellidos -> " 
                        + p.getApellidos()+ ", Dirección -> " + p.getDireccion()+ ", Teléfono -> " + p.getTelefono());
            }
        }
    }    
    
}
