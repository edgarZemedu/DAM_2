package com.mycompany.trabajoadrecufinal;

import com.mycompany.excepciones.NumeroFueraRangoException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.libreria.ControlData;
import com.mycompany.libreria.Menu;
import java.util.List;

public class Main {

    Cliente clienterecuperado = null;
    Pedido pedidorecuperado = null;
    Producto productorecuperado = null;

    static Scanner entradaTeclado = new Scanner(System.in);
    static int resp = 0;

    public static void main(String[] args) {

        boolean finalizar = false;

        do {
            
            switch (CrearMenu()) {
                case 1:

                    CambioMenuCliente();
                    break;

                case 2:

                    CambioMenuProducto();
                    break;

                case 3:

                    CambioMenuPedido();
                    break;

                case 4:

                    CambioMenuFichero();
                    break;

                case 5:

                    CambioMenuXml();
                    break;

                case 6:

                    finalizar = true;
                    break;
            }

        } while (!finalizar);

        HibernateUtil.shutdown();

    }

    //METODOS DE LOS MENUS
    static byte CrearMenu() {

        byte opcion = 0;
        boolean correcta;

        ArrayList<String> misOpciones;
        misOpciones = new ArrayList<String>() {

            {

                add("Menú de clientes");
                add("Menú de productos");
                add("Menú de pedidos");
                add("Menú de ficheros");
                add("Menú de XML/Conectores");
                add("FINALIZAR");

            }
        };

        Menu miMenu = new Menu(misOpciones);

        System.out.println("\n\n*************************GESTION DE EMPRESA*************************************");

        do {
            miMenu.printMenu();

            try {
                opcion = ControlData.lerByte(entradaTeclado);
                miMenu.rango(opcion);
                correcta = true;
            } catch (NumeroFueraRangoException e) {//Excepción personalizada
                System.out.println(e.getMessage());
                correcta = false;
            }

        } while (!correcta);

        return opcion;
    }

    public static void CambioMenuCliente() {

        int op = 0;

        do {
            System.out.println(" ");
            System.out.println("------MENÚ 1: CLIENTES------");
            System.out.println("1. INSERTAR CLIENTE");
            System.out.println("2. BUSCAR CLIENTE POR NIF");
            System.out.println("3. ELIMINAR CLIENTE");
            System.out.println("4. MODIFICAR CLIENTE");
            System.out.println("5. VOLVER AL MENU PRINCIPAL.");
            System.out.println("6. SALIR DEL PROGRAMA.");
            System.out.println("----------------------------");
            System.out.println("Opción: ");
            op = entradaTeclado.nextInt();

            switch (op) {

                case 1:

                    String nombre;
                    String nif;
                    String correoe;

                    System.out.println("Introduce el nombre del cliente: ");
                    nombre = ControlData.lerString(entradaTeclado);

                    System.out.println("Introduce el NIF del cliente: ");
                    nif = entradaTeclado.nextLine();

                    System.out.println("Introduce el correo electronico del cliente: ");
                    correoe = entradaTeclado.nextLine();

                    Cliente ncliente = new Cliente(nombre, nif, correoe);
                    OperacionesDAO.guardarCliente(ncliente);

                    System.out.println("----------------------------");
                    System.out.println("Cliente introducido con éxito");
                    System.out.println("----------------------------");

                    break;
                case 2:

                    String nifabuscar;
                    Cliente clienterecuperado = null;

                    System.out.println("Introduzca en NIF del cliente que quiera buscar: ");
                    nifabuscar = entradaTeclado.nextLine();
                    entradaTeclado.nextLine();

                    List<Cliente> listaclientes = OperacionesDAO.ObtenListaClientes();

                    for (Cliente c : listaclientes) {

                        if (c.getNif().equals(nifabuscar)) {

                            System.out.println("----------------------------");
                            System.out.println("Id: " + c.getId_cliente());
                            System.out.println("Nombre: " + c.getNombre());
                            System.out.println("NIF: " + c.getNif());
                            System.out.println("Correo electronico: " + c.getCorreoe());
                            System.out.println("----------------------------");
                        }

                    }
                    break;
                case 3:

                    int idAEliminar = 0;
                    clienterecuperado = null;

                    System.out.println("Introduzca en ID del cliente que quiera eliminar: ");
                    idAEliminar = entradaTeclado.nextInt();
                    entradaTeclado.nextInt();

                    clienterecuperado = OperacionesDAO.BuscarCliente(idAEliminar);
                    OperacionesDAO.EliminarCliente(clienterecuperado);

                    System.out.println("----------------------------");
                    System.out.println("Cliente eliminado con éxito");
                    System.out.println("----------------------------");

                    break;

                case 4:

                    clienterecuperado = null;

                    System.out.println("Introduzca en ID del cliente que quiera modificar: ");
                    idAEliminar = entradaTeclado.nextInt();

                    System.out.println("Introduce el nombre del cliente: ");
                    nombre = ControlData.lerString(entradaTeclado);

                    System.out.println("Introduce el NIF del cliente: ");
                    nif = entradaTeclado.nextLine();

                    System.out.println("Introduce el correo electronico del cliente: ");
                    correoe = entradaTeclado.nextLine();

                    clienterecuperado = OperacionesDAO.BuscarCliente(idAEliminar);
                    clienterecuperado.setNombre(nombre);
                    clienterecuperado.setNif(nif);
                    clienterecuperado.setCorreoe(correoe);
                    OperacionesDAO.actualizarCliente(clienterecuperado);

                    System.out.println("----------------------------");
                    System.out.println("Cliente modificado con éxito");
                    System.out.println("----------------------------");

                    break;
               
            }

        } while (op < 5);

    }

    public static void CambioMenuProducto() {

        int modif = 0;
        int op = 0;

        do {
            System.out.println(" ");
            System.out.println("------MENÚ 2: PRODUCTOS------");
            System.out.println("1. INSERTAR PRODUCTOS");
            System.out.println("2. BUSCAR PRODUCTOS POR CÓDIGO");
            System.out.println("4. ELIMINAR PRODUCTOS");
            System.out.println("5. VOLVER AL MENU PRINCIPAL.");
            System.out.println("6. SALIR DEL PROGRAMA.");
            System.out.println("----------------------------");
            System.out.println("Opción: ");
            op = entradaTeclado.nextInt();

            switch (op) {

                case 1:

                    String nompro;
                    int stock;

                    System.out.println("Introduce el nombre del producto: ");
                    nompro = ControlData.lerString(entradaTeclado);

                    System.out.println("Introduce la cantidad de stock: ");
                    stock = entradaTeclado.nextInt();

                    Producto nproducto = new Producto(nompro, stock);
                    OperacionesDAO.guardarProducto(nproducto);

                    System.out.println("----------------------------");
                    System.out.println("Producto introducido con éxito");
                    System.out.println("----------------------------");

                    break;
                case 2:

                    int idprod;
                    Producto productorecuperado = null;

                    System.out.println("Introduzca en ID del producto que quiera buscar: ");
                    idprod = entradaTeclado.nextInt();
                    entradaTeclado.nextLine();

                    List<Producto> listaproductos = OperacionesDAO.ObtenListaProductos();

                    for (Producto p : listaproductos) {

                        if (p.getId_producto() == idprod) {

                            System.out.println("----------------------------");
                            System.out.println("Id: " + p.getId_producto());
                            System.out.println("Nombre: " + p.getNombre());
                            System.out.println("Stock: " + p.getStock());
                            System.out.println("----------------------------");
                        }
                    }

                    break;

                case 3:

                    int idAEliminar = 0;
                    productorecuperado = null;

                    System.out.println("Introduzca en ID del producto que quiera modificar: ");
                    idAEliminar = entradaTeclado.nextInt();

                    System.out.println("Introduce el nombre del producto: ");
                    nompro = ControlData.lerString(entradaTeclado);

                    System.out.println("Introduce la cantidad de stock: ");
                    stock = entradaTeclado.nextInt();

                    Producto nproduct = new Producto(nompro, stock);
                    productorecuperado = OperacionesDAO.BuscarProducto(idAEliminar);
                    productorecuperado.setNombre(nompro);
                    productorecuperado.setStock(stock);
                    OperacionesDAO.actualizarProducto(nproduct);

                    System.out.println("----------------------------");
                    System.out.println("Producto modificado con éxito");
                    System.out.println("----------------------------");

                    break;
                case 4:

                    idAEliminar = 0;
                    productorecuperado = null;

                    System.out.println("Introduzca en ID del producto que quiera eliminar: ");
                    idAEliminar = entradaTeclado.nextInt();

                    productorecuperado = OperacionesDAO.BuscarProducto(idAEliminar);
                    OperacionesDAO.EliminarProducto(productorecuperado);

                    System.out.println("----------------------------");
                    System.out.println("Producto eliminado con éxito");
                    System.out.println("----------------------------");

                    break;
                
            }

        } while (op < 5);

    }

    public static void CambioMenuPedido() {

        int modif = 0;
        int op = 0;

        do {
            System.out.println(" ");
            System.out.println("------MENÚ 3: PEDIDOS------");
            System.out.println("1. INSERTAR PEDIDO");
            System.out.println("2. VER ESTADO DEL PEDIDO");
            System.out.println("3. MODIFICAR PEDIDO");
            System.out.println("4. ELIMINAR PEDIDO");
            System.out.println("5. CAMBIAR ESTADO DEL PEDIDO");
            System.out.println("6. VOLVER AL MENÚ PRINCIPAL");
            System.out.println("7. SALIR DEL PROGRAMA.");
            System.out.println("-----------------------------");
            System.out.println("Opción: ");
            op = entradaTeclado.nextInt();

            switch (op) {

                case 1:

                    int uni; String direccion; String fecha;
                    int estado;int idprod;int idclien;

                    System.out.println("Introduce unidades del pedido: ");
                    uni = entradaTeclado.nextInt();

                    System.out.println("Introduce la direccion: ");
                    direccion = entradaTeclado.nextLine();
                    entradaTeclado.nextLine();

                    System.out.println("Introduce la fecha del pedido: ");
                    fecha = entradaTeclado.nextLine();

                    System.out.println("Introduce el estado pedido: ");
                    estado = entradaTeclado.nextInt();

                    System.out.println("Introduce el id del producto: ");
                    idprod = entradaTeclado.nextInt();

                    System.out.println("Introduce el id del cliente: ");
                    idclien = entradaTeclado.nextInt();

                    Pedido npedido = new Pedido(idprod, uni, idclien,
                            direccion, fecha, estado);

                    OperacionesDAO.guardarPedido(npedido);

                    System.out.println("----------------------------");
                    System.out.println("Pedido introducido con éxito");
                    System.out.println("----------------------------");

                    break;
                case 2:
                    
                    System.out.println("Introduzca el id del pedido para ver su estado: ");
                    int idAEliminar = entradaTeclado.nextInt();
                    
                    List<Pedido> listapedidos = OperacionesDAO.ObtenListaPedidos();
                    
                    for (Pedido p : listapedidos) {

                        if (p.getId() == idAEliminar) {

                            System.out.println("----------------------------");
                            System.out.println("Estado del pedido: " + p.getEstado());
                            System.out.println("----------------------------");
                        }
                    }

                    break;
                case 3:
                    
                    Pedido pedidorecuperado = null;
                    idAEliminar = 0;
                    
                    System.out.println("Introduzca el id del pedido a modificar: ");
                    idAEliminar = entradaTeclado.nextInt();
                    
                    System.out.println("Introduce unidades del pedido: ");
                    uni = entradaTeclado.nextInt();

                    System.out.println("Introduce la direccion: ");
                    direccion = entradaTeclado.nextLine();
                    entradaTeclado.nextLine();

                    System.out.println("Introduce la fecha del pedido: ");
                    fecha = entradaTeclado.nextLine();

                    System.out.println("Introduce el estado pedido: ");
                    estado = entradaTeclado.nextInt();

                    Pedido npedid = new Pedido (uni,direccion, fecha, estado);
                    pedidorecuperado = OperacionesDAO.BuscarPedido(idAEliminar);
                    pedidorecuperado.setUnipedido(uni);
                    pedidorecuperado.setDireccion(direccion);
                    pedidorecuperado.setFecha(fecha);
                    pedidorecuperado.setEstado(estado);
                    OperacionesDAO.actualizarPedido(pedidorecuperado);
                    
                    System.out.println("----------------------------");
                    System.out.println("Pedido modificado con éxito");
                    System.out.println("----------------------------");
                    
                    break;
                case 4:
                    
                    pedidorecuperado = null;
                    idAEliminar = 0;
                    
                    System.out.println("Introduzca el id del pedido a eliminar: ");
                    idAEliminar = entradaTeclado.nextInt();
                    
                    pedidorecuperado = OperacionesDAO.BuscarPedido(idAEliminar);
                    OperacionesDAO.EliminarPedido(pedidorecuperado);

                    System.out.println("----------------------------");
                    System.out.println("Pedido eliminado con éxito");
                    System.out.println("----------------------------");

                    break;

                case 5:

                    pedidorecuperado = null;
                    idAEliminar = 0;
                    
                    System.out.println("Introduzca el id del pedido para modificar el estado: ");
                    idAEliminar = entradaTeclado.nextInt();
                    
                    System.out.println("Introduce el estado nuevo del pedido: ");
                    estado = entradaTeclado.nextInt();
                    
                    pedidorecuperado = OperacionesDAO.BuscarPedido(idAEliminar);
                    pedidorecuperado.setEstado(estado);
                    OperacionesDAO.actualizarPedido(pedidorecuperado);
                    
                    System.out.println("----------------------------");
                    System.out.println("Estado del pedido modificado con éxito");
                    System.out.println("----------------------------");
                    
                    break;
                    
            }

        } while (op < 6);

    }

    public static void CambioMenuFichero() {

        int modif = 0;
        int op = 0;

        do {
            System.out.println(" ");
            System.out.println("\nOPERACIONES CON FICHEROS");
            System.out.println("******MENÚ 4: FICHEROS******");
            System.out.println("1. CREAR FICHERO DE PRODUCTOS ENVIADOS");
            System.out.println("2. CONSULTAR UN FICHERO DE PRODUCTOS ENVIADOS");
            System.out.println("3. VOLVER AL MENU PRINCIPAL.");
            System.out.println("4. SALIR DEL PROGRAMA.");
            System.out.println("******");
            System.out.println("Opción: ");
            op = entradaTeclado.nextInt();

            switch (op) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

            }

        } while (op != 5);

    }

    public static void CambioMenuXml() {

        int modif = 0;
        int op = 0;

        do {
            System.out.println(" ");
            System.out.println("\nOPERACIONES CON XML / CONECTORES");
            System.out.println("******MENÚ 5: CONECTORES/XML******");
            System.out.println("1. CREAR XML CON LOS CLIENTES A LOS QUE\n"
                    + "SE LES HAYA ENTREGADO ALGÚN PRODUCTO. ");
            System.out.println("2. MOSTAR POR PANTALLA LOS CLIENTES A LOS QUE SE LES HAYA\n"
                    + "ENTREGADO ALGÚN PRODUCTO LEYENDO DEL FICHERO XML ANTERIOR");
            System.out.println("3. PERMITIR REALIZAR MODIFICACIONES EN LOS DATOS DE LOS\n"
                    + "ELEMENTOS DE LA TABLA CLIENTES_DEVOLUCIÓN.");
            System.out.println("4. MOSTRAR POR PANTALLA LOS DATOS DE LA TABLA\n"
                    + "CLIENTES_DEVOLUCION.");
            System.out.println("5. VOLVER AL MENU PRINCIPAL.");
            System.out.println("6. SALIR DEL PROGRAMA.");
            System.out.println("******");
            System.out.println("Opción: ");
            op = entradaTeclado.nextInt();

            switch (op) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

            }

        } while (op != 6);

    }

}
