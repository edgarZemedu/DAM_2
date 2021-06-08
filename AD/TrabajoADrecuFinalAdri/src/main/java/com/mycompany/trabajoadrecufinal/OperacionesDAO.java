/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajoadrecufinal;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperacionesDAO {
    
    static private Session sesion;
    static private Transaction transa;
    
    private static  void iniciaOperacion() throws HibernateException{
        
        sesion = HibernateUtil.getSessionFactory().openSession();
        transa = sesion.beginTransaction();
        
    }
    
    private static void manejaExcepcion(HibernateException he)
            throws HibernateException{
       
        transa.rollback();
        throw new HibernateException("Error en OperacionesDAO", he);
        
    }
    
    public static int guardarCliente (Cliente cliente)throws HibernateException{
        
        int id = 0;
        
        try{
            iniciaOperacion();
            id = (int) sesion.save(cliente);
            transa.commit();
            
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
            
        }finally {
            sesion.close();
        }
        return id;
    }
    
    public static int guardarProducto (Producto producto)throws HibernateException{
        
        int id = 0;
        
        try{
            iniciaOperacion();
            id = (int) sesion.save(producto);
            transa.commit();
            
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
            
        }finally {
            sesion.close();
        }
        return id;
    }
    
    public static int guardarPedido (Pedido pedido)throws HibernateException{
        
        int id = 0;
        
        try{
            iniciaOperacion();
            id = (int) sesion.save(pedido);
            transa.commit();
            
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
            
        }finally {
            sesion.close();
        }
        return id;
    }
    
    public static void actualizarCliente(Cliente cliente) throws HibernateException {
        
        try {
            iniciaOperacion();
            sesion.update(cliente);
            transa.commit();
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
            
        } finally {
            
            sesion.close();
        }
    }
    
    public static void actualizarProducto(Producto producto) throws HibernateException {
        
        try {
            iniciaOperacion();
            sesion.update(producto);
            transa.commit();
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
            
        } finally {
            
            sesion.close();
        }
    }
    
    public static void actualizarPedido(Pedido pedido) throws HibernateException {
        
        try {
            iniciaOperacion();
            sesion.update(pedido);
            transa.commit();
            
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
            listacliente = sesion.createQuery("from com.mycompany.trabajoadrecufinal.Cliente").list();

        } finally {
            sesion.close();
        }

        return listacliente;
    }
    
    public static List<Pedido> ObtenListaPedidos() throws HibernateException {
      
        List<Pedido> listapedido = null;

        try {
            iniciaOperacion();
            listapedido = sesion.createQuery("from com.mycompany.trabajoadrecufinal.Pedido").list();

        } finally {
            sesion.close();
        }

        return listapedido;
    }
    
    public static void EliminarCliente (Cliente cliente) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(cliente);
            transa.commit();

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {

            sesion.close();

        }
    }
    
    public static void EliminarProducto (Producto producto) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(producto);
            transa.commit();

        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {

            sesion.close();

        }
    }
    
    public static void EliminarPedido (Pedido pedido) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.delete(pedido);
            transa.commit();
                
        } catch (HibernateException he) {

            manejaExcepcion(he);
            throw he;

        } finally {

            sesion.close();

        }
    }
    
    public static Cliente BuscarCliente(int idcliente) throws HibernateException {
        
        Cliente cliente = null;

        try {
            iniciaOperacion();
            cliente = (Cliente) sesion.get(Cliente.class, idcliente);

        } finally {

            sesion.close();
        }

        return cliente;
    }
    
    public static Producto BuscarProducto(int idproducto) throws HibernateException {
        
        Producto producto = null;

        try {
            iniciaOperacion();
            producto = (Producto) sesion.get(Producto.class, idproducto);

        } finally {

            sesion.close();
        }

        return producto;
    }
    
    public static Pedido BuscarPedido(int idpedido) throws HibernateException {
        
        Pedido pedido = null;

        try {
            iniciaOperacion();
            pedido = (Pedido) sesion.get(Pedido.class, idpedido);

        } finally {

            sesion.close();
        }

        return pedido;
    }
    
    
    public static List<Producto> ObtenListaProductos() throws HibernateException {
      
        List<Producto> listaproducto = null;

        try {
            iniciaOperacion();
            listaproducto = sesion.createQuery("from com.mycompany.trabajoadrecufinal.Producto").list();

        } finally {
            sesion.close();
        }

        return listaproducto;
    }
    
}
