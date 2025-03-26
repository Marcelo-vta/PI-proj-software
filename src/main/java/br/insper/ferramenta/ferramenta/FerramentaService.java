package br.insper.ferramenta.ferramenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FerramentaService {
    @Autowired
    private FerramentaRepository ferramentaRepository;

    public Ferramenta criarFerramenta(Ferramenta ferramenta) {
        return ferramentaRepository.save(ferramenta);
    }
    
    public List<Ferramenta> listarTodos() {
        return ferramentaRepository.findAll();
    }

    public Optional<Ferramenta> deletarFerramenta(String email){
        return ferramentaRepository.deleteByEmailUsuario(email);
    }
}
