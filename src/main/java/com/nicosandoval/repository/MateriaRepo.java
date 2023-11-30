package com.nicosandoval.repository;

import com.nicosandoval.modeloEntity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class MateriaRepo {


    /**
     *
     * @param idMateria para obtener el id del Materia para su busqueda
     * @return valor buscado o null
     */
    public Materia findMateria(int idMateria) {

        Materia materia = null;
        try  (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")){
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            materia = em.find(Materia.class, idMateria);
            em.getTransaction().commit();

            emf.close();
            em.close();
            return materia;
        } catch (Exception e) {
            System.out.println("catch Find Materia: " + materia + " - " + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @param nomMateria ingresa un nombre para insertar en la base de datos
     * @return para saber si ingreso correctamente
     */
    public String insertMateria(String nomMateria) {
        Materia materia = new Materia();
        materia.setNombreMateria(nomMateria);

        try (EntityManagerFactory EMF = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();

            EM.persist(materia);

            EM.getTransaction().commit();


            EMF.close();
            EM.close();
            return "Materia insertada" ;
        } catch (Exception e) {
            System.out.println("catch insert Materia: " + e.getMessage());
        }

        return "Error al insertar Materia: " + materia;
    }

    /**
     *
     * @param idMateria para buscar al Materia a remover
     * @return para saber si se removio correctamente
     */
    public String removeMateria(int idMateria) {

        Materia materia = null;
        try (
                EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            materia = em.find(Materia.class, idMateria);
            System.out.println(materia);


            em.remove(materia);

            em.getTransaction().commit();

            emf.close();
            em.close();
            return " Materia Remove: " + materia;
        } catch (Exception e) {
            System.out.println("catch remove Materia: " + materia + " - " + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @param idMateria es para aidentificar al Materia
     * @param newNombre String que se envia para modificar el nombre
     * @return  para saber si se modifico correctamente
     */
    public Materia updateNameMateria(int idMateria, String newNombre) {
        Materia materia = null;
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            materia = em.find(Materia.class, idMateria);
            materia.setNombreMateria(newNombre);

            em.persist(materia);

            em.getTransaction().commit();

            emf.close();
            em.close();
            return materia;
        } catch (Exception e) {
            System.out.println("catch update Materia: " + materia + " " + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @return lista de entity MATERIA si puede traer, sino NULL
     */
    @SuppressWarnings("unchecked")
    public List<Materia> getAllMateria() {

        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            Query query = em.createNativeQuery("SELECT * FROM materias WHERE idMateria <> 15 ORDER BY idMateria", Materia.class);

            return query.getResultList();

        } catch (Exception e) {
            System.out.println("catch get all Materia: " + e.getMessage());
        }
        return null;
    }

    public Materia updateIdCorrelativa(int i, String nuevoID) {
        Materia materia = null;
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            materia = em.find(Materia.class, i);
            materia.setIdMateriaCorreletiva(Integer.parseInt(nuevoID));


            System.out.println("materia repo: " + materia);
            em.persist(materia);

            em.getTransaction().commit();

            emf.close();
            em.close();
            return materia;
        } catch (Exception e) {
            System.out.println("catch update Materia: " + materia + " " + e.getMessage());
        }

        return null;
    }
}
