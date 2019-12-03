package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "albuns", schema = "busca_letras")
@Entity(name = "album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(nome, album.nome) &&
                Objects.equals(artista, album.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, artista);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", artista=" + artista +
                '}';
    }
}
