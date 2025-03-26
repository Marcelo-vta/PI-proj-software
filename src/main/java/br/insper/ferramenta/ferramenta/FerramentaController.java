package br.insper.ferramenta.ferramenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ferramenta")
public class FerramentaController {
    
    @Autowired
    private FerramentaService ferramentaService;
    
    @PostMapping
    public Ferramenta criarFerramenta(@RequestBody Ferramenta ferramenta, @RequestHeader(name="email") String email) {
        ferramenta.setEmailUsuario(email);
        return ferramentaService.criarFerramenta(ferramenta);
    }

    @GetMapping
    public List<Ferramenta> listarTodos() {
        return ferramentaService.listarTodos();
    }

    @DeleteMapping
    public Optional<Ferramenta> deleteFerramenta(@RequestHeader(name="email") String email){
        return ferramentaService.deletarFerramenta(email);
    }

}
