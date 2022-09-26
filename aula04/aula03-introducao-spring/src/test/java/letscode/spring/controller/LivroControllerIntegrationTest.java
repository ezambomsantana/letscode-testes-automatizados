package letscode.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import letscode.spring.model.Livro;
import letscode.spring.service.LivroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LivroControllerIntegrationTest {

    @InjectMocks
    private LivroController livroController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(livroController).build();
    }

    @Test
    @Order(1)
    public void testCadastrarLivro() throws Exception {
        Livro livro = new Livro("1", "livro 1", "autor 1");
        String livroString = new ObjectMapper().writeValueAsString(livro);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/livro")
                        .content(livroString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("{\"codigo\":\"1\",\"nome\":\"livro 1\",\"autor\":\"autor 1\"}", resposta);
    }

    @Test
    @Order(2)
    public void testListaLivros() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/livro"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("[{\"codigo\":\"1\",\"nome\":\"livro 1\",\"autor\":\"autor 1\"}]", resposta);
    }


}
