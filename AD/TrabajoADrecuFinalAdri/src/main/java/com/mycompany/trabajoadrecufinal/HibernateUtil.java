package com.mycompany.trabajoadrecufinal;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory laSessionFactory = crearSessionFactory();

    private static SessionFactory crearSessionFactory() {

        try {

            return new Configuration().configure().
                    buildSessionFactory(new StandardServiceRegistryBuilder().
                    configure().build());

        } catch (HibernateException ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return laSessionFactory;

    }

    public static void shutdown() {

        if (getSessionFactory().isOpen()) {
            getSessionFactory().close(); // Close connection pools

        }

    }

}
