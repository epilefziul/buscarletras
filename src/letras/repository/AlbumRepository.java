package letras.repository;

import letras.domain.Album;
import letras.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {

    public void cadastrar(Album album) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Album album) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(album);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Album album) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        album = em.merge(album);
        em.remove(album);
        em.getTransaction().commit();
        em.close();
    }

    public List<Album> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Album> albuns = em.createQuery("select a from busca_letras.albuns a").getResultList();
        em.close();
        return albuns;
    }
}