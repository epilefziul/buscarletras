package main.letras.repository;

import main.letras.domain.Album;
import main.letras.domain.Artista;
import main.letras.util.JPAUtil;

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
        List<Artista> artistas = em.createQuery("select a from Artista a").getResultList();
        em.close();
        return artistas;
    }

    public Boolean verificaSeArtistaPossuiAlbum(Artista artista) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Album> albuns = em.createQuery("select a from Album a where a.artista.id = :id", Album.class)
                .setParameter("id", artista.getId())
                .getResultList();

        if (albuns == null || albuns.isEmpty() || albuns.size() == 0) {
            return false;
        }
        return true;
    }
}

