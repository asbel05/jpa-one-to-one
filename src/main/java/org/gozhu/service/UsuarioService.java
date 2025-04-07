package org.gozhu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gozhu.model.Usuario;

import java.util.List;

public class UsuarioService {
    private final EntityManagerFactory emf;

    public UsuarioService() {
        this.emf = Persistence.createEntityManagerFactory("oneToOneExample");
    }

    public void crearUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Usuario> obtenerUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u LEFT JOIN FETCH u.perfil", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Long contarUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public Long contarPerfiles() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(p) FROM Perfil p", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
