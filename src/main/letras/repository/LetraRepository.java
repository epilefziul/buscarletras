package main.letras.repository;

import main.letras.domain.Letra;
import main.letras.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class LetraRepository {

    public void cadastrar(Letra letra) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(letra);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Letra letra) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(letra);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Letra letra) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        letra = em.merge(letra);
        em.remove(letra);
        em.getTransaction().commit();
        em.close();
    }

    public List<Letra> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Letra> letras = em.createQuery("select a from busca_letras.letras a").getResultList();
        em.close();
        return letras;
    }
}
