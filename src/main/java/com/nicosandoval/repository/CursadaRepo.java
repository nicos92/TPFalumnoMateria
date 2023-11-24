package com.nicosandoval.repository;

import com.nicosandoval.modelo.Cursada;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursadaRepo  {

    /**
     *
     * @param cursada ingresa una clase Cursada para insertar en la base de datos
     * @return para saber si ingreso correctamente
     */
    public String insertCursada(Cursada cursada) {

        try (EntityManagerFactory EMF = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();

            EM.persist(cursada);

            EM.getTransaction().commit();


            EMF.close();
            EM.close();
            return "Cursada insertada" ;
        } catch (Exception e) {
            System.out.println("Error catch insert Cursada: " + e.getMessage());
        }

        return "Error al insertar Cursada: " + cursada;
    }



}
