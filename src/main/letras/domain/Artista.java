package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Table(schema = "busca_letras", name = "artistas")
@Entity
public class Artista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "seq_id_artista", sequenceName ="artistas_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "artista", fetch = FetchType.EAGER)
    private List<Album> albuns;

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

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

}
