package main.letras.repository;

import main.letras.domain.Usuario;
import main.letras.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioRepository {

    public void cadastrar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios = em.createQuery("select a from Usuario a").getResultList();
        em.close();
        return usuarios;
    }

    public Usuario login(String email, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Usuario usuarioLogado = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class)
                .setParameter("email", email)
                .setParameter("senha", senha)
                .getSingleResult();
        em.close();
        return usuarioLogado;
    }


}

