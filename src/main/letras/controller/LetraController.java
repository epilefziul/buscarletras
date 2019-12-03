package main.letras.controller;

import main.letras.domain.Letra;
import main.letras.repository.LetraRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class LetraController {

    private final LetraRepository letraRepository;

    public LetraController() {
        this.letraRepository = new LetraRepository();
    }

    public List<Letra> listarTodos() {
        return letraRepository.listar();
    }
}