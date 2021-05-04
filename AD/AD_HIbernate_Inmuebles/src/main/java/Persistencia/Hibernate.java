/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author a18zemedufc
 */
public class Hibernate {
      /**
     * Atributos privados y finales
     */
    private final SessionFactory laSessionFactory;

    /**
     * atributo privado y estático de la misma clase
     */
    private static Hibernate elHibernateUtil;

    /**
     * Para obtener la instancia de la clase ya creada o crearla de nuevo y
     * devolver el atributo de tipo SessionFactory
     *
     * @return Objeto de tipo SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(elHibernateUtil)) {
            elHibernateUtil = new Hibernate();
        }
        return elHibernateUtil.laSessionFactory;
    }

    /**
     * constructor privado que da valor a los atributos
     */
    private Hibernate() {
        try {
            // carga el fichero de configuración hibernate.cfg.xml y crea un objeto SessionFactory
            laSessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Close caches and connection pools
     */
    public static void shutdown() {
        if (getSessionFactory().isOpen()) {
            getSessionFactory().close();
        }
    }
}
