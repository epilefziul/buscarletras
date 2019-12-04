package main.letras.controller;

import main.letras.domain.Artista;
import main.letras.domain.Letra;
import main.letras.repository.ArtistaRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

import static main.letras.util.PagesUtil.*;

@ManagedBean
@ViewScoped
public class ArtistaController {

    private final ArtistaRepository artistaRepository;
    private List<Artista> artistas;
    private Letra letraSelecionada;
    private Artista artistaSelecionado;
    private Artista artista;

    public ArtistaController() {
        this.artistaRepository = new ArtistaRepository();
        this.artistas = new ArrayList<>();
        this.letraSelecionada = new Letra();
        this.artistaSelecionado = new Artista();
        this.artista = new Artista();
    }

    public void abrirDialogVisualizarLetra(Letra letra) {
        letraSelecionada = letra;
        atualizarComponente("dlgVisualizarLetra");
        atualizarComponente("formVisualizarLetra");
        abrirDialog("dlgVisualizarLetra");
    }

    public void abrirDialogExcluirArtista(Artista artista) {
        artistaSelecionado = artista;
        atualizarComponente("formExcluirArtista");
        abrirDialog("dlgExcluirArtista");
    }

    public void excluirArtista() {
        try {
            artistaRepository.remover(artistaSelecionado);
            fecharDialog("dlgExcluirArtista");
            mensagemDeSucesso("Artista excluído com sucesso!");
            carregarDadosTela();
        } catch (Exception e) {
            mensagemDeSucesso(e);
        }
    }

    public void abrirDialogEditarArtista(Artista artista) {
        artistaSelecionado = artista;
        atualizarComponente("formEditarArtista");
        abrirDialog("dlgEditarArtista");
    }

    public void editarArtista() {
        try {
            artistaRepository.alterar(artistaSelecionado);
            fecharDialog("dlgEditarArtista");
            mensagemDeSucesso("Artista editado com sucesso!");
            carregarDadosTela();
        } catch (Exception e) {
            mensagemDeSucesso(e);
        }
    }

    public void abrirDialogCadastrarArtista() {
        artista = new Artista();
        atualizarComponente("formCadastrarArtista");
        abrirDialog("dlgCadastrarArtista");
    }

    public void cadastrarArtista() {
        try {
            artistaRepository.cadastrar(artista);
            fecharDialog("dlgCadastrarArtista");
            mensagemDeSucesso("Artista cadastrado com sucesso!");
            carregarDadosTela();
        } catch (Exception e) {
            mensagemDeSucesso(e);
        }
    }

    public Boolean verificaSeArtistaPossuiAlbum(Artista artista) {
        return artistaRepository.verificaSeArtistaPossuiAlbum(artista);
    }

    public void carregarDadosTela() {
        this.artistas = artistaRepository.listar();
    }

    public ArtistaRepository getArtistaRepository() {
        return artistaRepository;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public Letra getLetraSelecionada() {
        return letraSelecionada;
    }

    public void setLetraSelecionada(Letra letraSelecionada) {
        this.letraSelecionada = letraSelecionada;
    }

    public Artista getArtistaSelecionado() {
        return artistaSelecionado;
    }

    public void setArtistaSelecionado(Artista artistaSelecionado) {
        this.artistaSelecionado = artistaSelecionado;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
