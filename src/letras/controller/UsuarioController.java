package letras.controller;

import letras.domain.Usuario;
import letras.repository.UsuarioRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private Usuario usuario;

    public UsuarioController() {
        this.usuarioRepository = new UsuarioRepository();
        this.usuario = new Usuario();
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listar();
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}