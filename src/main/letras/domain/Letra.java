package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(schema = "busca_letras", name = "letras")
@Entity
public class Letra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "texto")
    private String texto;

    @JoinColumn(name = "id_album")
    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;

    public Letra() {
        this.album = new Album();
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
