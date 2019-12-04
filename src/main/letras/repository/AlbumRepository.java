package main.letras.repository;

import main.letras.domain.Album;
import main.letras.domain.Letra;
import main.letras.util.JPAUtil;

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
        List<Album> albuns = em.createQuery("select a from Album a").getResultList();
        em.close();
        return albuns;
    }

    public Boolean verificaSeAlbumPossuiLetras(Album album) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Letra> letras = em.createQuery("select l from Letra l where l.album.id = :id", Letra.class)
                .setParameter("id", album.getId())
                .getResultList();
        if (letras == null || letras.isEmpty() || letras.size() == 0) {
            return false;
        }
        return true;
    }
}