package letras.controller;

import letras.domain.Artista;
import letras.repository.ArtistaRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class ArtistaController {

    private final ArtistaRepository artistaRepository;

    public ArtistaController() {
        this.artistaRepository = new ArtistaRepository();
    }

    public List<Artista> listarTodos() {
        return artistaRepository.listar();
    }
}
