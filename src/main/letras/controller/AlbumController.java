package main.letras.controller;

import main.letras.domain.Album;
import main.letras.domain.Artista;
import main.letras.repository.AlbumRepository;
import main.letras.repository.ArtistaRepository;
import main.letras.util.PagesUtil;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

import static main.letras.util.PagesUtil.*;

@ManagedBean
@ViewScoped
public class AlbumController {

    private final AlbumRepository albumRepository;
    private List<Album> albuns;
    private Album album;
    private Album albumSelecionado;

    public AlbumController() {
        this.albumRepository = new AlbumRepository();
        this.albuns = new ArrayList<>();
        this.albumSelecionado = new Album();
        this.album = new Album();
    }

    public void listarTodosAlbuns() {
        albuns = albumRepository.listar();
    }

    public void abrirDialogExcluirAlbum(Album album) {
        albumSelecionado = album;
        atualizarComponente("formExcluirAlbum");
        abrirDialog("dlgExcluirAlbum");
    }

    public void excluirAlbum() {
        try {
            albumRepository.remover(albumSelecionado);
            mensagemDeSucesso("Album excluído com sucesso!");
            fecharDialog("dlgExcluirAlbum");
            listarTodosAlbuns();
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public void abrirDialogEditarAlbum(Album album) {
        albumSelecionado = album;
        atualizarComponente("formEditarAlbum");
        abrirDialog("dlgEditarAlbum");
    }

    public void editarAlbum() {
        try {
            albumRepository.alterar(albumSelecionado);
            mensagemDeSucesso("Album editado com sucesso!");
            fecharDialog("dlgEditarAlbum");
            listarTodosAlbuns();
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public void abrirDialogCadastrarAlbum() {
        album = new Album();
        atualizarComponente("formCadastrarAlbum");
        abrirDialog("dlgCadastrarAlbum");
    }

    public void cadastrarAlbum() {
        try {
            albumRepository.alterar(album);
            mensagemDeSucesso("Album cadastrado com sucesso!");
            fecharDialog("dlgCadastrarAlbum");
            listarTodosAlbuns();
        } catch (Exception e) {
            mensagemDeErro(e);
        }
    }

    public Boolean verificaSeAlbumPossuiLetras(Album album) {
        return albumRepository.verificaSeAlbumPossuiLetras(album);
    }

    public List<Artista> listaTodosArtistas() {
        return new ArtistaRepository().listar();
    }

    public AlbumRepository getAlbumRepository() {
        return albumRepository;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbumSelecionado() {
        return albumSelecionado;
    }

    public void setAlbumSelecionado(Album albumSelecionado) {
        this.albumSelecionado = albumSelecionado;
    }
}