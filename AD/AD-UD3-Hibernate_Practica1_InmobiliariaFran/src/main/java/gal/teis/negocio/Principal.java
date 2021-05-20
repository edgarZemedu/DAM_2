/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.negocio;

import gal.teis.excepciones.NumeroFueraRangoException;
import gal.teis.libreriadam.ControlData;
import gal.teis.libreriadam.Menu;
import gal.teis.presistencia.HibernateUtil;
import gal.teis.presistencia.InmueblesDAO;
import gal.teis.presistencia.PropietariosDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.hibernate.HibernateException;

/**
 *
 * @author Fran
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Variables de control de operaciones
        boolean finalizar = false;
        boolean correcta = false;

        //Obtenemos la lista de contactos de la base de datos
        do {
            switch (pintarMenu()) {
                case 1://Ver el contenido de la tabla
                    System.out.println("\n************************************************************\n"
                            + "PROPIETARIOS");
                    menuPropietarios();
                    break;

                case 2://Guardar un contacto
                    System.out.println("\n************************************************************\n"
                            + "INMUEBLES");
                    menuInmuebles();
                    break;

                case 3:
                    System.out.println("Hasta luego!!!");
                    finalizar = true;
                    //Cierra la sesión de Hibernate
                    HibernateUtil.shutdown();

            }
        } while (!finalizar);
    }

    /**
     * Dibuja un menú en la consola a partir con unas opciones determinadas
     */
    static byte pintarMenu() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("Propietarios");
                add("Inmuebles");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    /**
     * MENU PROPIETARIOS
     */
    static void menuPropietarios() {

        //Variables de control de operaciones
        boolean finalizar = false;
        boolean correcta = false;

        //Obtenemos la lista de contactos de la base de datos
        do {
            int opcion = 0;
            switch (pintarMenuPropietarios()) {
                case 1: //Buscar / Mostrar un propietario por su id
                    System.out.println("Buscar / Mostrar un propietario por su id");
                    menuBuscarPropietario();

                    break;

                case 2: //Agregar Propietario 
                    System.out.println("Agregar Propietario");
                    menuGuardarPropietario();

                    break;

                case 3://Eliminar Propietario
                    System.out.println("Eliminar Propietario");
                    menuEliminarPropietario();

                    break;

                case 4: //Modificar Propietario
                    System.out.println("Modificar Propietario");
                    menuActualizarPropietario();

                    break;

                case 5: //Listar Propietarios
                    System.out.println("Listar Propietarios");
                    mostrarListaPropietarios();

                    break;

                case 6: //Listar Propietarios con sus Inmuebles
                    System.out.println("Listar Propietarios con sus Inmuebles");
                    listarPropietariosInmuebles();

                    break;

//                case 7: //Guardar Datos Bancarios
//                    System.out.println("Solo para probar Guardar Datos Bancarios");
//                    menuGuardarDatosBancarios();
//                    break;
                case 7:
                    System.out.println("Hasta luego!!!");
                    finalizar = true;

            }
        } while (!finalizar);
    }

    /**
     * Pregunta qué datos se quiere modificar
     *
     * @return el dato a modificar
     */
    static byte pintarMenuPropietarios() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("Buscar / Mostrar un propietario por su id");
                add("Agregar Propietario");
                add("Eliminar Propietario");
                add("Modificar Propietario");
                add("Listar Propietarios");
                add("Listar Propietarios con sus Inmuebles");
                //add("Solo para probar Guardar Datos Bancarios");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    /**
     * MENU PROPIETARIOS
     */
    static void menuInmuebles() {

        //Variables de control de operaciones
        boolean finalizar = false;
        boolean correcta = false;

        //Obtenemos la lista de contactos de la base de datos
        do {
            int opcion = 0;
            switch (pintarMenuInmuebles()) {
                case 1: //Buscar Inmueble por su id
                    System.out.println("Buscar Inmueble por su id");
                    menuBuscarInmueble();

                    break;

                case 2: //Agregar Inmueble 
                    System.out.println("Agregar Inmueble");
                    menuGuardarInmueble();

                    break;

                case 3://Eliminar Inmueble
                    System.out.println("Eliminar Inmueble");
                    EliminarInmueble();

                    break;

                case 4: //Modificar Inmueble
                    System.out.println("Modificar Inmueble");
                    menuActualizarInmueble();
                    break;

                case 5: //Listar Inmueble con sus Propietarios
                    System.out.println("Listar todos los Inmuebles con sus Propietarios");
                    listarInmueblesPropietarios();

                    break;

                case 6:
                    System.out.println("Hasta luego!!!");
                    finalizar = true;

            }
        } while (!finalizar);
    }

    /**
     * Pregunta qué datos se quiere modificar
     *
     * @return el dato a modificar
     */
    static byte pintarMenuInmuebles() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("Buscar Inmueble por su id");
                add("Agregar Inmueble");
                add("Eliminar Inmueble");
                add("Modificar Inmueble");
                add("Listar Inmueble con sus Propietarios");
                add("Finalizar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    /**
     * Muestra todos los propietarios de una tabla
     */
    static void mostrarListaPropietarios() {
        List<Propietarios> listaPropietarios = null;
        try {

            listaPropietarios = PropietariosDAO.obtenListaPropietarios();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
        if (!Objects.isNull(listaPropietarios)) {
            System.out.println("Hay " + listaPropietarios.size() + " propietario en la base de datos");
            for (Propietarios p : listaPropietarios) {
                System.out.println(" -id- " + p.getId() + ", DNI -> " + p.getPrDNI() + ", Nombre -> " + p.getPrNombre() + ", Apellidos -> " + p.getPrApellidos() + ", Dirección -> " + p.getPrDireccion() + ", Teléfono -> " + p.getPrTelefono());
            }
        }
    }

    /**
     * Solicita los datos de un propietario y los guarda en la tabla así como
     * los datos Bancarios
     */
    static void menuGuardarPropietario() {
        //Pide los datos por teclado
        System.out.println("Introduce el DNI del propietario");
        String prDNI = ControlData.lerString(sc);
        System.out.println("Introduce el nombre del propietario");
        String prNombre = ControlData.lerNome(sc);
        System.out.println("Introduce los apellidos del propietario");
        String prApellidos = ControlData.lerString(sc);
        System.out.println("Introduce la dirección del propietario");
        String prDireccion = ControlData.lerString(sc);
        System.out.println("Introduce el teléfono del contacto");
        String prTelefono = ControlData.lerString(sc);

        //Crea un contacto con los datos introducidos
        Propietarios nuevoPropietario = new Propietarios(prDNI, prNombre, prApellidos, prDireccion, prTelefono);

        try {
            long id = PropietariosDAO.guardaPropietario(nuevoPropietario);
            System.out.println("Se ha guardado el propietario que tendrá el id " + id);

            System.out.println("Quiere agregar datos Bancarios (S/N) ");
            char siModificar = ControlData.lerLetra(sc);
            if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                //Pide los datos por teclado
                System.out.println("Introduce el Número de Cuenta");
                String numCuenta = ControlData.lerString(sc);
                System.out.println("Introduce el nombre del Banco");
                String nombreBanco = ControlData.lerNome(sc);
                DatosBancarios nuevosDatosBancarios = new DatosBancarios(numCuenta, nombreBanco, nuevoPropietario);

                nuevosDatosBancarios.setPropietario(nuevoPropietario);
                PropietariosDAO.guardaDatosBancarios(nuevosDatosBancarios);
                System.out.println("Se han guardado los datos bancarios del propietario que tiene el id " + id);

            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    /**
     * Buca un propietario a partir de un id que se pide por teclado
     */
    static void menuBuscarPropietario() {
        System.out.println("Introduce el id del propietario a buscar ");
        Long id = ControlData.lerLong(sc);
        try {
            Propietarios propietario_localizado = PropietariosDAO.obtenPropietario(id);
            if (!Objects.isNull(propietario_localizado)) {
                System.out.println("El propietario ha sido localizado ");
                System.out.println(propietario_localizado.toString());

                System.out.println("Quiere ver los datos Bancarios (S/N) ");
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                    //Al acceder a dos tablas relacionadas, el resultado será un listado de 
                    //arrays de objetos List<Object[]>
                    List<Object[]> propietarioCuenta = PropietariosDAO.obtenPropietarioCuentaBancaria(id);
                    if (!Objects.isNull(propietarioCuenta)) {
                        //Solo se accede a un elemento con la orden HQL, por lo tanto solo 
                        //se tiene en cuenta la primera posición de la lista.

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

    /**
     * Actualiza datos del propietario y cuentas bancarias
     */
    static void menuActualizarPropietario() {
        System.out.println("Introduce el id del propietario a modificar ");
        long id = ControlData.lerLong(sc);
        boolean modificado = false;
        try {
            Propietarios propietario_localizado = PropietariosDAO.obtenPropietario(id);
//            DatosBancarios datosBancarios_localizado = PropietariosDAO.obtenDatosBancarios(id);
            if (!Objects.isNull(propietario_localizado)) {
                System.out.println("Confirme que el propietario a modificar es (S/N) " + propietario_localizado.toString());
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                    byte opcion = pintarMenuModificarPropietario();
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduce el nuevo DNI");
                            String prDNI = ControlData.lerString(sc);
                            propietario_localizado.setPrDNI(prDNI);
                            modificado = PropietariosDAO.actualizaPropietario(propietario_localizado);
                            break;
                        case 2:
                            System.out.println("Introduce el nuevo nombre");
                            String PrNombre = ControlData.lerString(sc);
                            propietario_localizado.setPrNombre(PrNombre);
                            modificado = PropietariosDAO.actualizaPropietario(propietario_localizado);
                            break;
                        case 3:
                            System.out.println("Introduce los nuevos apellidos");
                            String prApellidos = ControlData.lerString(sc);
                            propietario_localizado.setPrApellidos(prApellidos);
                            modificado = PropietariosDAO.actualizaPropietario(propietario_localizado);
                            break;
                        case 4:
                            System.out.println("Introduce la nueva dirección");
                            String prDireccion = ControlData.lerString(sc);
                            propietario_localizado.setPrDireccion(prDireccion);
                            modificado = PropietariosDAO.actualizaPropietario(propietario_localizado);
                            break;
                        case 5:
                            System.out.println("Introduce el nuevo teléfono");
                            String prTelefono = ControlData.lerString(sc);
                            propietario_localizado.setPrTelefono(prTelefono);
                            modificado = PropietariosDAO.actualizaPropietario(propietario_localizado);
                            break;
                        case 6:
                            modificarDatosBancarios(id);

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

    /**
     * Pregunta qué datos se quiere modificar
     *
     * @return el dato a modificar
     */
    static byte pintarMenuModificarPropietario() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("DNI");
                add("Nombre");
                add("Apellidos");
                add("Dirección");
                add("Teléfono");
                add("Modificar Datos Bancarios");
                add("cancelar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    /**
     * Elimina un propietario de la tabla en función de su id
     */
    static void menuEliminarPropietario() {
        System.out.println("Introduce el id del elemento a eliminar ");
        Long id = ControlData.lerLong(sc);
        boolean eliminado = false;
        try {
            Propietarios propietario_localizado = PropietariosDAO.obtenPropietario(id);
            if (!Objects.isNull(propietario_localizado)) {
                System.out.println("El Propietario ha sido localizado");
                System.out.println(propietario_localizado.toString());
                System.out.println("¿Está seguro de que desea eliminarlo y sus inmuebles (si los tiene) (S/N)?");
                char siEliminar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siEliminar) == 'S') {//Realizamos la operación
                    eliminado = PropietariosDAO.eliminaPropietario(propietario_localizado.getId());
                    if (eliminado) {
                        System.out.println("El objeto ha sido eliminado correctamente");
                    }
                }
            } else {
                System.out.println("El propietario no ha sido localizado");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }

    /**
     * Solicita los datos BANCARIOS y los guarda en la tabla
     */
    static void menuGuardarDatosBancarios() {

        //Pide los datos por teclado
        System.out.println("Introduce el Número de Cuenta");
        String numCuenta = ControlData.lerString(sc);
        System.out.println("Introduce el nombre del Banco");
        String nombreBanco = ControlData.lerNome(sc);
        System.out.println("Introduce el ID del propietario");
        long idPropietario = ControlData.lerLong(sc);

        List<Propietarios> listaPropietarios = null;
        listaPropietarios = PropietariosDAO.obtenListaPropietarios();
        try {
            //Crea nuevo registro de datos Bancarios con los datos introducidos

            Propietarios propietario = PropietariosDAO.obtenPropietario(idPropietario);
            DatosBancarios nuevosDatosBancarios = new DatosBancarios(numCuenta, nombreBanco, propietario);

            System.out.println(propietario);

            if (!Objects.isNull(propietario)) {

                nuevosDatosBancarios.setPropietario(propietario);
                PropietariosDAO.guardaDatosBancarios(nuevosDatosBancarios);
                System.out.println("Se han guardado los datos bancarios del propietario que tiene el id " + idPropietario);
            } else {
                System.out.println("No hay un propietario con el id introducido ");
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    /**
     * Solicita los datos de un inmueble y los guarda en la tabla
     */
    static void menuGuardarInmueble() {
        //Pide los datos por teclado
        System.out.println("Introduce el ID");
        char id = ControlData.lerChar(sc);
        System.out.println("Introduce la Dirección del Inmueble");
        String inDireccion = ControlData.lerString(sc);
        System.out.println("Introduce el código de la zona");
        String inCodZona = ControlData.lerString(sc);
        System.out.println("Introduce el estado del Inmueble");
        String inEstado = ControlData.lerString(sc);
        System.out.println("Introduce el ID del propietario");
        long idPropietario = ControlData.lerLong(sc);

        List<Propietarios> listaPropietarios = null;
        listaPropietarios = PropietariosDAO.obtenListaPropietarios();

        try {
            Propietarios propietario = PropietariosDAO.obtenPropietario(idPropietario);

            //Crea un un inmueble con los datos introducidos
            Inmuebles nuevoInmueble = new Inmuebles(id, inDireccion, inCodZona, inEstado, propietario);
            InmueblesDAO.guardaInmueble(nuevoInmueble);
            System.out.println("Se ha guardado el Inmueble que tendrá el id " + id);
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    /**
     * Buca un inmueble a partir de un id que se pide por teclado
     */
    static void menuBuscarInmueble() {
        System.out.println("Introduce el id del inmueble a buscar ");
        char id = ControlData.lerChar(sc);

        try {
            List<Object[]> inmueble_localizado = InmueblesDAO.obtenInmueblePropietario(id);
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
     * Modificar datos Bancarios
     */
    static void modificarDatosBancarios(long id) {
        PropietariosDAO propieDAO = new PropietariosDAO();

        System.out.println("Introduzca el número de cuenta a modificar: ");
        String numCuenta = ControlData.lerString(sc);

        DatosBancarios encontrado = propieDAO.obtenDatosBancarios(numCuenta);

        System.out.println("Introduzca el nuevo número de cuenta: ");
        numCuenta = ControlData.lerString(sc);
        System.out.println("Introduzca un nuevo nombre de Banco: ");
        String nombreBanco = ControlData.lerString(sc);

        Propietarios propietario_localizado = PropietariosDAO.obtenPropietario(id);
        if (!Objects.isNull(propietario_localizado)) {

            encontrado.setNumCuenta(numCuenta);
            encontrado.setNombreBanco(nombreBanco);
            encontrado.setPropietario(propietario_localizado);

            propieDAO.actualizaDatosBancarios(encontrado);

            System.out.println("Datos Banarios Actualizados: ");
            System.out.println(encontrado);

        }
    }

    /**
     * Listar propietarios con sus inmuebles
     */
    static void listarPropietariosInmuebles() {

        int i = 0;

        try {
            List<Object[]> InmueblesPropietarios =  PropietariosDAO.listarPropietariosInmuebles();


            if (!Objects.isNull(InmueblesPropietarios)) {

                Iterator it = InmueblesPropietarios.iterator();

                while (it.hasNext()) {
                    it.next();
                    

                    //System.out.println(InmueblesPropietarios.get(i)[0] + " - " + InmueblesPropietarios.get(i)[1]);
                    System.out.println("Propietario: "+InmueblesPropietarios.get(i)[1] + " Inmueble: " + InmueblesPropietarios.get(i)[0]);
                    i++;
                }
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }
    
    /**
     * Listar propietarios con sus inmuebles
     */
    static void listarInmueblesPropietarios() {

        int i = 0;

        try {
            List<Object[]> InmueblesPropietarios =  InmueblesDAO.obtenInmueblesYPropietarios();


            if (!Objects.isNull(InmueblesPropietarios)) {

                Iterator it = InmueblesPropietarios.iterator();

                while (it.hasNext()) {
                    it.next();
                    

                    //System.out.println(InmueblesPropietarios.get(i)[0] + " - " + InmueblesPropietarios.get(i)[1]);
                    System.out.println("Inmueble: "+InmueblesPropietarios.get(i)[0] + " Propietario: " + InmueblesPropietarios.get(i)[1]);
                    i++;
                }
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }
    
     /**
     * Elimina un propietario de la tabla en función de su id
     */
    static void EliminarInmueble() {
        System.out.println("Introduce el id del inmueble a eliminar ");
        char id = ControlData.lerChar(sc);
        boolean eliminado = false;
        try {
            Inmuebles inmueble_localizado = InmueblesDAO.obtenInmueble(id);
            if (!Objects.isNull(inmueble_localizado)) {
                System.out.println("El Inmueble ha sido localizado");
                System.out.println(inmueble_localizado.toString());
                System.out.println("¿Está seguro de que desea eliminarlo (S/N)?");
                char siEliminar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siEliminar) == 'S') {//Realizamos la operación
                    eliminado = InmueblesDAO.eliminaInmueble(inmueble_localizado.getId());
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
     * Actualiza datos del propietario y cuentas bancarias
     */
    static void menuActualizarInmueble() {
        System.out.println("Introduce el id del inmueble a modificar ");
        char id = ControlData.lerChar(sc);
        boolean modificado = false;
        try {
            Inmuebles inmueble_localizado = InmueblesDAO.obtenInmueble(id);
            if (!Objects.isNull(inmueble_localizado)) {
                System.out.println("Confirme que el inmueble a modificar es (S/N) " + inmueble_localizado.toString());
                char siModificar = ControlData.lerLetra(sc);
                if (Character.toUpperCase(siModificar) == 'S') {//Realizamos la operación
                    byte opcion = pintarMenuModificarInmueble();
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduce el nuevo ID");
                            char idn = ControlData.lerChar(sc);
                            inmueble_localizado.setId(idn);
                            modificado = InmueblesDAO.actualizaInmueble(inmueble_localizado);
                            break;
                        case 2:
                            System.out.println("Introduce la nueva dirección");
                            String inDireccion = ControlData.lerString(sc);
                            inmueble_localizado.setInDireccion(inDireccion);
                            modificado = InmueblesDAO.actualizaInmueble(inmueble_localizado);
                            break;
                        case 3:
                            System.out.println("Introduce el nuevo código de zona");
                            String inCodZona = ControlData.lerString(sc);
                            inmueble_localizado.setInCodZona(inCodZona);
                            modificado = InmueblesDAO.actualizaInmueble(inmueble_localizado);
                            break;
                        case 4:
                            System.out.println("Introduce el nuevo estado");
                            String inEstado = ControlData.lerString(sc);
                            inmueble_localizado.setInEstado(inEstado);
                            modificado = InmueblesDAO.actualizaInmueble(inmueble_localizado);
                            break;
                        case 5:
                            System.out.println("Introduce el nuevo propietario");
                            long idPropietario = ControlData.lerLong(sc);
                            Propietarios propietario = PropietariosDAO.obtenPropietario(idPropietario);
                            inmueble_localizado.setPropietarios(propietario);
                            modificado = InmueblesDAO.actualizaInmueble(inmueble_localizado);
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
     * Pregunta qué datos se quiere modificar
     *
     * @return el dato a modificar
     */
    static byte pintarMenuModificarInmueble() {
        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones = new ArrayList<String>() {
            {
                add("ID");
                add("Dirección");
                add("Código Zona");
                add("Estado");
                add("Propietario");
                add("cancelar");
            }
        };

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*******************************************************************************************************");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            try {
                opcion = ControlData.lerByte(sc);
                /*miMenu.rango() lanza una excepción propia en el caso de que 
                el parámetro opcion esté fuera del rango posible */
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }
    
    

}
