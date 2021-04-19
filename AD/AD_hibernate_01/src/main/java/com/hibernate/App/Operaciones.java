/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.App;

import Clases.Propietario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author A C E R
 */
public class Operaciones {

    private Session sesion;
    private Transaction transa;

    //Crea una sesión y transacción en la BD. 1 por cada operación
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        transa = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        transa.rollback();
        throw new HibernateException(" Error en Operaciones", he);
    }

    public int guardaContacto(Propietario pro) {
        int id = 0;
        try {
            iniciaOperacion();
            //guarda el contacto en la BD y devuelve el id generado
            id = (int) sesion.save(pro);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }

    public void actualizaContacto(Propietario pro) throws HibernateException {
        try {
            iniciaOperacion();
        //actualiza el contacto en la base de datos
            sesion.update(pro);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaContacto(Propietario pro) throws HibernateException {
        try {
            iniciaOperacion();
            //elimina el contacto en la base de datos
            sesion.delete(pro);
            transa.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Propietario obtenContacto(int idPro) throws HibernateException {
        Propietario pro = null;
        try {
            iniciaOperacion();
        //Obtiene un contacto de la BD por su id
            pro = (Propietario) sesion.get(Propietario.class, idPro);
        } finally {
            sesion.close();
        }
        return pro;
    }

    public List<Propietario> obtenListaContactos() throws HibernateException {
        List<Propietario> listaPro = null;
        try {
            iniciaOperacion();
        //Obtiene una lista de contactos utilizando el lenguaje HQL
            listaPro = sesion.createQuery("from Propietario").list();
        } finally {
            sesion.close();
        }
        return listaPro;
    }
}
