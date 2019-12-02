package letras.controller;

import letras.domain.Album;
import letras.repository.AlbumRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class AlbumController {

    private final AlbumRepository albumRepository;

    public AlbumController() {
        this.albumRepository = new AlbumRepository();
    }

    public List<Album> listarTodos() {
        return albumRepository.listar();
    }
}