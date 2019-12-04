package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Table(name = "albuns", schema = "busca_letras")
@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_album")
    @SequenceGenerator(name = "seq_id_album", sequenceName ="albuns_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "id_artista")
    @ManyToOne(fetch = FetchType.EAGER)
    private Artista artista;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Letra> letras;

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
