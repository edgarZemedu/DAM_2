/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.App;

import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author A C E R
 */
public class HibernateUtil {

    private final SessionFactory laSessionFactory; // Atributos privados y finales
    private static HibernateUtil elHibernateUtil; // atributo privado y estático de la misma clase
//Obtiene una instancia de la clase ya creada o la crea de nuevo y devuelve el atributo de tipo SessionFactory

    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(elHibernateUtil)) {
            elHibernateUtil = new HibernateUtil();
        }
        return elHibernateUtil.laSessionFactory;
    }

    private HibernateUtil() {// constructor privado que da valor a los atributos
        try {// carga el fichero de configuración hibernate.cfg.xml y crea un objeto SessionFactory
            laSessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void shutdown() {//Cierra la sesión
        if (getSessionFactory().isOpen()) {
            getSessionFactory().close();
        }
    }

}
