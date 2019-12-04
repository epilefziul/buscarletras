package main.letras.controller;

import main.letras.domain.Album;
import main.letras.domain.Letra;
import main.letras.repository.AlbumRepository;
import main.letras.repository.LetraRepository;
import main.letras.util.PagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

import static main.letras.util.PagesUtil.*;

@ManagedBean
@ViewScoped
public class LetraController {

    private final LetraRepository letraRepository;
    private List<Letra> letras;
    private Letra letra;
    private Letra letraSelecionada;

    public LetraController() {
        this.letraRepository = new LetraRepository();
        this.letra = new Letra();
        this.letras = new ArrayList<>();
        this.letraSelecionada = new Letra();
    }

    public void listarTodasLetras() {
        letras = letraRepository.listar();
    }

    public void abrirDialogCadastrarLetra() {
        letra = new Letra();
        atualizarComponente("formCadastrarLetra");
        abrirDialog("dlgCadastrarLetra");
    }

    public void cadastrar() {
        try {
            letraRepository.cadastrar(letra);
            listarTodasLetras();
            fecharDialog("dlgCadastrarLetra");
            mensagemDeSucesso("Letra cadastrada com sucesso");
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public void abrirDialogEditarLetra(Letra letra) {
        letraSelecionada = letra;
        atualizarComponente("formEditarLetra");
        abrirDialog("dlgEditarLetra");
    }

    public void editarLetra() {
        try {
            letraRepository.alterar(letraSelecionada);
            listarTodasLetras();
            fecharDialog("dlgEditarLetra");
            mensagemDeSucesso("Letra editada com sucesso");
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public void abrirDialogExcluirLetra(Letra letra) {
        letraSelecionada = letra;
        atualizarComponente("formExcluirLetra");
        abrirDialog("dlgExcluirLetra");
    }

    public void excluirLetra() {
        try {
            letraRepository.remover(letraSelecionada);
            listarTodasLetras();
            mensagemDeSucesso("Letra excluida com sucesso!");
            fecharDialog("dlgExcluirLetra");
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public List<Album> listarTodosAlbuns() {
        return new AlbumRepository().listar();
    }

    public LetraRepository getLetraRepository() {
        return letraRepository;
    }

    public List<Letra> getLetras() {
        return letras;
    }

    public void setLetras(List<Letra> letras) {
        this.letras = letras;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public Letra getLetraSelecionada() {
        return letraSelecionada;
    }

    public void setLetraSelecionada(Letra letraSelecionada) {
        this.letraSelecionada = letraSelecionada;
    }
}