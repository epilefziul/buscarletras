package letras.repository;

import letras.domain.Artista;
import letras.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistaRepository {

    public void cadastrar(Artista artista) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(artista);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Artista artista) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(artista);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Artista artista) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        artista = em.merge(artista);
        em.remove(artista);
        em.getTransaction().commit();
        em.close();
    }

    public List<Artista> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Artista> artistas = em.createQuery("select a from busca_letras.artistas a").getResultList();
        em.close();
        return artistas;
    }
}

