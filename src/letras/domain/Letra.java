package letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(schema = "busca_letras", name = "letras")
@Entity(name = "letras")
public class Letra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "letras")
    @JoinColumn(insertable = true, name = "id_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "letras")
    @JoinColumn(insertable = true, name = "id_album")
    private Album album;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letra letra = (Letra) o;
        return Objects.equals(id, letra.id) &&
                Objects.equals(usuario, letra.usuario) &&
                Objects.equals(album, letra.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, album);
    }

    @Override
    public String toString() {
        return "Letra{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", album=" + album +
                '}';
    }
}
