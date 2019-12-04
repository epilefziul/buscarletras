package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "albuns", schema = "busca_letras")
@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "id_artista")
    @ManyToOne(fetch = FetchType.EAGER)
    private Artista artista;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Letra> letras;

    public Album() {
        this.artista = new Artista();
        this.letras = new ArrayList<>();
    }

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

    public List<Letra> getLetras() {
        return letras;
    }

    public void setLetras(List<Letra> letras) {
        this.letras = letras;
    }

}
