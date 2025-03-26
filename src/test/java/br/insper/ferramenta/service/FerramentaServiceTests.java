package br.insper.ferramenta.service;

import br.insper.ferramenta.ferramenta.Ferramenta;
import br.insper.ferramenta.ferramenta.FerramentaRepository;
import br.insper.ferramenta.ferramenta.FerramentaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FerramentaServiceTests {
    @InjectMocks
    private FerramentaService ferramentaService;

    @Mock
    private FerramentaRepository ferramentaRepository;

    @Test
    void test_criarFerramentaComSucesso() {

        Ferramenta ferramenta = new Ferramenta("1", "martelo", "teste", "Mecanica", "Marcelo");

        Mockito.when(ferramentaRepository.save(ferramenta)).thenReturn(ferramenta);

        Ferramenta ferramentaCriado = ferramentaService.criarFerramenta(ferramenta);

        // confere se o objeto do service e o mock estao iguais

        Assertions.assertEquals("Mecanica", ferramentaCriado.getCategoria());
        Assertions.assertEquals("martelo", ferramentaCriado.getNome());
        Assertions.assertEquals("Marcelo", ferramentaCriado.getNomeUsuario());
        Assertions.assertEquals("teste", ferramentaCriado.getDescricao());
    }

    @Test
    void test_listarTodosQuandoNaoHaFerramentas() {

        Mockito.when(ferramentaRepository.findAll()).thenReturn(new ArrayList<>());

        List<Ferramenta> ferramentas = ferramentaService.listarTodos();

        Assertions.assertEquals(0, ferramentas.size());
    }

    @Test
    void test_buscarFerramentaPorEmailInexistente() {

        // busca na db por um criterio que nao existe e cria um mock com o retornado
        Mockito.when(ferramentaRepository.deleteByEmailUsuario("a")).thenReturn(null);

        // chama a funcao de buscar pelo criterio do service
        Optional<Ferramenta> ferramentaEncontrada = ferramentaService.deletarFerramenta("a");

        // compara as duas respostas
        Assertions.assertNull(ferramentaEncontrada);
    }

    
    
}
