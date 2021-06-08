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
import java.util.ResourceBundle;
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
        throw new HibernateException("\nHa sucedido un error en la capa de acceso a datos " + he.getMessage(), he);
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
            System.out.println("-> " + pro.toString());
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

        Pedidos pedido = new Pedidos();

        System.out.println("Introduce la cantidad: ");
        int unidades = ControlData.lerInt(sc);
        System.out.println("Introduce la direccion: ");
        String direccion = ControlData.lerNome(sc);
        System.out.println("Introduce una fecha: ");
        String fecha = ControlData.lerString(sc);
        System.out.println("Introduce un estado(-2,-1,0,1,2): ");
        int estado = ControlData.lerInt(sc);
        if (estado > 2 || estado < -2) {
            System.out.println("ERROR AL INTRODUCIR EL ESTADO");
        } else {
            int id = 0;
            try {
                //elegir el producto y el cliente

                int idclien = elegirCliente(sc);
                int idprod = elegirProducto(sc);

                pedido = new Pedidos(unidades, direccion, fecha, estado, idclien, idprod);

                iniciaOperacion();
                id = (int) sesion.save(pedido);
                transa.commit();

                System.out.println(" Éxito,se ha creado");
            } catch (HibernateException he) {
                manejaExcepcion(he);
                throw he;

            } finally {
                sesion.close();
            }
        }

        return pedido;
    }

    public static int elegirCliente(Scanner sc) {

        int id = 0;
        try {
            List<Cliente> listaclientes = Operaciones.ObtenListaClientes();

            for (Cliente c : listaclientes) {
                System.out.println("-> " + c.toString());
                System.out.println("\n*********");

            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

        System.out.println("Elige el id del cliente: ");
        id = ControlData.lerInt(sc);
        return id;

    }

    public static int elegirProducto(Scanner sc) {

        int id = 0;
        try {
            //encontrar el producto
            List<Producto> lista = Operaciones.ObtenListaProductos();

            for (Producto p : lista) {

                System.out.println("-> " + p.toString());
                System.out.println("\n*********");

            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

        System.out.println("Elige el id del producto: ");
        id = ControlData.lerInt(sc);

        return id;

    }

    public static void buscarPorNIF(Scanner sc) {

        System.out.println("Introduce el NIF ");
        String NIF = ControlData.lerString(sc);

        try {

            List<Cliente> listaclientes = Operaciones.ObtenListaClientes();

            for (Cliente c : listaclientes) {
                if (c.getNif().equals(NIF)) {
                    System.out.println("-> " + c.toString());
                    System.out.println("\n*********");
                }
            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    public static void buscarPorCodigoProducto(Scanner sc) {

        System.out.println("Introduce el cçodigo del producto a buscar ");
        int codigo = ControlData.lerInt(sc);

        try {

            List<Producto> listaProductos = Operaciones.ObtenListaProductos();

            for (Producto p : listaProductos) {
                if (p.getCodigoProducto() == (codigo)) {
                    System.out.println("-> " + p.toString());
                    System.out.println("\n*********");
                }
            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    public static void moficarCliente(Scanner sc) {

        System.out.println("Dime el id del cliente a modificar: ");
        int id = ControlData.lerInt(sc);

        try {
            //encontrar el cliente
            List<Cliente> listaclientes = Operaciones.ObtenListaClientes();

            for (Cliente c : listaclientes) {
                if (c.getId() == id) {
                    System.out.println("-> " + c.toString());
                    System.out.println("\n*********");
                    //moficar una vez encontrado el cliente
                    System.out.println("Dime que quieres modificar");

                    //  PARA HACER   *********
                }
            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    public static void moficarProducto(Scanner sc) {

        System.out.println("Dime el código del producto a modificar: ");
        int id = ControlData.lerInt(sc);

        try {
            //encontrar el cliente
            List<Producto> listaclientes = Operaciones.ObtenListaProductos();

            for (Producto p : listaclientes) {
                if (p.getCodigoProducto() == id) {
                    System.out.println("-> " + p.toString());
                    System.out.println("\n*********");
                    //moficar una vez encontrado el cliente
                    System.out.println("Dime que quieres modificar");

                    //  PARA HACER   *********
                }
            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }
    public static void moficarPedidos(Scanner sc) {

        System.out.println("Dime el código del producto a modificar: ");
        int id = ControlData.lerInt(sc);

        try {
            //encontrar el cliente
            List<Producto> listaclientes = Operaciones.ObtenListaProductos();

            for (Producto p : listaclientes) {
                if (p.getCodigoProducto() == id) {
                    System.out.println("-> " + p.toString());
                    System.out.println("\n*********");
                    //moficar una vez encontrado el cliente
                    System.out.println("Dime que quieres modificar");

                    //  PARA HACER   *********
                }
            }

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }

    }

    public static void eliminarCliente(Scanner sc) {

        System.out.println("Dime el id del cliente a eliminar: ");
        int id = ControlData.lerInt(sc);

        try {
            //encontrar el cliente
            List<Cliente> listaclientes = Operaciones.ObtenListaClientes();

            for (Cliente c : listaclientes) {
                if (c.getId() == id) {
                    System.out.println("-> " + c.toString());

                    iniciaOperacion();
                    sesion.delete(c);
                    transa.commit();

                    System.out.println("\n Cliente eliminado");
                }
            }

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {

            sesion.close();

        }

    }

    public static void eliminarProducto(Scanner sc) {

        System.out.println("Dime el código del Producto a eliminar: ");
        int id = ControlData.lerInt(sc);

        try {
            //encontrar el cliente
            List<Producto> listaclientes = Operaciones.ObtenListaProductos();

            for (Producto p : listaclientes) {
                if (p.getCodigoProducto() == id) {
                    System.out.println("-> " + p.toString());

                    iniciaOperacion();
                    sesion.delete(p);
                    transa.commit();

                    System.out.println("\n Producto eliminado");
                }
            }

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;

        } finally {
            sesion.close();
        }

    }

    public static List<Cliente> ObtenListaClientes() throws HibernateException {

        List<Cliente> listacliente = null;

        try {
            iniciaOperacion();
            listacliente = sesion.createQuery("from Clases.Cliente").list();

        } finally {
            sesion.close();
        }

        return listacliente;
    }

    public static List<Producto> ObtenListaProductos() throws HibernateException {

        List<Producto> listaProducto = null;

        try {
            iniciaOperacion();
            listaProducto = sesion.createQuery("from Clases.Producto").list();

        } finally {
            sesion.close();
        }

        return listaProducto;
    }

    public static List<Pedidos> ObtenListaPedidos() throws HibernateException {

        List<Pedidos> listapedido = null;

        try {
            iniciaOperacion();
            listapedido = sesion.createQuery("from Clases.Pedido").list();

        } finally {
            sesion.close();
        }

        return listapedido;
    }

    public static void verEstadoPedido(Scanner sc) {

        System.out.println("Introduzca el id del pedido para ver su estado: ");
        int idAEliminar = ControlData.lerInt(sc);

        List<Pedidos> listapedidos = Operaciones.ObtenListaPedidos();

        for (Pedidos p : listapedidos) {

            if (p.getCodigoPedido() == idAEliminar) {

                System.out.println("----------------------------");
                System.out.println("Estado del pedido: " + p.getEstado());
                System.out.println("----------------------------");
            }
        }

    }

}
