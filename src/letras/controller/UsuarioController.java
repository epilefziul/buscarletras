package letras.controller;

import letras.domain.Usuario;
import letras.repository.UsuarioRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public void salvar() {
        new UsuarioRepository().cadastrar(usuario);
    }

    public void remover(Usuario usuarioDeletar) {
        new UsuarioRepository().remover(usuarioDeletar);
    }

    public void alterar() {
        new UsuarioRepository().alterar(usuario);
    }

    public List<Usuario> getListar() {
        usuarios = new UsuarioRepository().listar();
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}












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