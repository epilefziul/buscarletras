package letras.controller;

import letras.domain.Letra;
import letras.repository.LetraRepository;

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