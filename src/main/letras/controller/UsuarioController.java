package main.letras.controller;

import main.letras.domain.Artista;
import main.letras.domain.Usuario;
import main.letras.repository.ArtistaRepository;
import main.letras.repository.UsuarioRepository;
import main.letras.util.SessionUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.letras.util.PagesUtil.redirecionarParaPage;
import static main.letras.util.SessionUtil.OBJ_USUARIO;
import static main.letras.util.SessionUtil.adicionaObjetoUsuarioNaSessao;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private UsuarioRepository usuarioRepository;

    public UsuarioController() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public void salvar() {
        if (validarEmail()) {
            usuarioRepository.cadastrar(usuario);
        }
    }

    public Usuario obterUsuarioLogado() {
        return (Usuario) SessionUtil.recuperaObjetoDaSessao(OBJ_USUARIO);
    }

    public void remover(Usuario usuarioDeletar) {
        usuarioRepository.remover(usuarioDeletar);
    }

    public void alterar() {
        usuarioRepository.alterar(usuario);
    }

    public List<Usuario> getListar() {
        usuarios = usuarioRepository.listar();
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private Boolean validarEmail() {
        Boolean estaValido = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(usuario.getEmail());

        if (matcher.matches()) {
            estaValido = true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido", "Erro"));
        }
        return estaValido;
    }

    public void login() throws IOException {
        Usuario usuarioAutenticado = usuarioRepository.login(this.usuario.getEmail(), this.usuario.getSenha());
        if (usuarioAutenticado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou Senha inválidos.", "Erro"));
        } else {
            adicionaObjetoUsuarioNaSessao(OBJ_USUARIO, usuarioAutenticado);
            redirecionarParaPage("index");
        }
    }

}