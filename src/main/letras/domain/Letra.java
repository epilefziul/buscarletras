package main.letras.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(schema = "busca_letras", name = "letras")
@Entity(name = "letra")
public class Letra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
