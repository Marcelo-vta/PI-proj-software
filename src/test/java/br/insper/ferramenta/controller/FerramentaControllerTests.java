package br.insper.ferramenta.controller;

import br.insper.ferramenta.ferramenta.Ferramenta;
import br.insper.ferramenta.ferramenta.FerramentaController;
import br.insper.ferramenta.ferramenta.FerramentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FerramentaControllerTests {
    @InjectMocks
    private FerramentaController ferramentaController;

    @Mock
    private FerramentaService ferramentaService;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(ferramentaController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }
    
    @Test
    void testListarTodos() throws Exception {

        List<Ferramenta> ferramentas = Arrays.asList(
            new Ferramenta("1", "chave de fenda", "teste1", "Eletronica", "Marcelo"),
            new Ferramenta("2", "martelo","teste2", "Mecanica", "Zambom")
        );

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(ferramentaService.listarTodos()).thenReturn(ferramentas);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ferramenta"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(ferramentas)));
    }
    
    @Test
    void testCriarFerramenta() throws Exception {

        // cria um objeto a partir dos campos determinados

        Ferramenta ferramenta = new Ferramenta("1", "martelo", "teste", "Mecanico", "Marcelo");
        ferramenta.setEmailUsuario("teste1@teste.com");

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(ferramentaService.criarFerramenta(Mockito.any(Ferramenta.class))).thenReturn(ferramenta);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/ferramenta")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(ferramenta))
                        .header("email", "teste1@teste.com"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(ferramenta)));
    }

    @Test
    void testDeleteFerramenta() throws Exception {
        Ferramenta ferramenta1 = new Ferramenta("1", "martelo", "teste", "Mecanico", "Marcelo");
        Ferramenta ferramenta2 = new Ferramenta("2", "chave de fenda", "teste2", "Mecanico", "Zambom");

        ferramenta1.setEmailUsuario("teste1@teste.com");
        ferramenta2.setEmailUsuario("teste2@teste.com");


        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(ferramentaService.deletarFerramenta("teste1@teste.com")).thenReturn(java.util.Optional.of(ferramenta1));

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ferramenta")
                        .header("email", "teste1@teste.com"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(ferramenta1)));
    }
}
