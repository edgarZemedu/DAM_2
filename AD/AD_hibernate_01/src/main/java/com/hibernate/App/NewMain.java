/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.App;

import Clases.Propietario;
import java.util.List;

/**
 *
 * @author A C E R
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Operaciones operaciones = new Operaciones();
        Propietario propietarioRecuperado = null;
        int idAEliminar = 7;

        //Creamos tres instancias de Contacto
        Propietario pro1 = new Propietario("12345612","Propietario1", "juan","juan", "756438456");
        Propietario pro2 = new Propietario("12345644","Propietario2", "juan","juan", "756345456");
        Propietario pro3 = new Propietario("12345633","Propietario2", "juan", "juan","153438456");

        //Guardamos las tres instancias
        //Guardamos el id del contacto1 para usarlo posteriormente
        idAEliminar = operaciones.guardaContacto(pro1);
        operaciones.guardaContacto(pro2);
        operaciones.guardaContacto(pro3);

        //Modificamos el contacto2 y lo actualizamos
        pro2.setNombre("pro2modificado");
        operaciones.actualizaContacto(pro2);

        //Recuperamos el contacto1 de la BD
        //idAEliminar = 1;
        propietarioRecuperado = operaciones.obtenContacto(idAEliminar);
        System.out.println("El contacto recuperado es " + propietarioRecuperado.getNombre());

        //Eliminamos el contactoRecuperado, el contacto3
        operaciones.eliminaContacto(propietarioRecuperado);

        //Obtenemos la lista de contactos de la base de datos
        List<Propietario> listaPro = operaciones.obtenListaContactos();
        System.out.println("Hay " + listaPro.size() + " contactos en la base de datos");
        for (Propietario p : listaPro) {
            System.out.println("-> " + p.getNombre());
        }
        //Cierra la sesión de Hibernate
        HibernateUtil.shutdown();
    }

}
