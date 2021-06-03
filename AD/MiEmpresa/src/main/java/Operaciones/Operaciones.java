/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.Cliente;
import Clases.Producto;
import Clases.Pedidos;
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
    public static Cliente añadirCliente(Scanner sc) {

        
        System.out.println("Dime el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Dime el NIF: ");
        String apellidos = sc.nextLine();
        System.out.println("Dime el correo: ");
        String direccion = sc.nextLine();
        Cliente c = new Cliente(nombre, apellidos, direccion);

        return c;
    } 
    public static long gurdarCliente(Cliente c) {
        
        int id = -1;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aqu� no se usa, pero se podr�a utilizar*/
            id = (int) sesion.save(c);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }
    
    
    public static Producto añadirProducto(Scanner sc) {

        
        System.out.println("Dime el nombre: ");
        String nombre = ControlData.lerString(sc);
        System.out.println("Dime el stock: ");
        int stock = ControlData.lerInt(sc);
        
        Producto pro = new Producto(nombre, stock);

        return pro;
    }  

    public static long gurdarProducto(Producto pro) {
        
        int id = -1;
        try {
            //abre la sesi�n e inicia la transici�n
            iniciaOperacion();
            /*guarda el contacto en la base de datos y devuelve el id generado
            aqu� no se usa, pero se podr�a utilizar*/
            id = (int) sesion.save(pro);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }
   
    
    public static Pedidos añadirPedidos(Scanner sc) {
        
        Pedidos pedidos = new Pedidos();
        System.out.println("");
        try {
            System.out.println("Introduce la cantidad: ");
            int unidades = ControlData.lerInt(sc);
            System.out.println("Introduce la direccion: ");
            String direccion = ControlData.lerNome(sc);
            System.out.println("Introduce una fecha: ");
            String fecha = ControlData.lerNome(sc);
            System.out.println("Introduce una estado(-2,-1,0,1,2): ");
            int estado = ControlData.lerInt(sc);
            //pedidos = new Pedidos(unidades, direccion, fecha, estado);

            //nuevoDB.setPropietario(nuevoPropietario);
            //long id = gurdarDB(pedidos);
            //System.out.println("Se han guardado los datos bancarios del propietario que tiene el id " + id);

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

        return pedidos;
    }
    
     
    
}
