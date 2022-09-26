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
public class LivroControllerTest {

    @InjectMocks
    private LivroController livroController;

    @Mock
    private LivroService livroService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(livroController).build();
    }

    @Test
    @Order(3)
    public void testListaLivrosVazio() throws Exception {

        Mockito.when(livroService.listarLivros()).thenReturn(new ArrayList<>());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/livro"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("[]", resposta);

    }


    @Test
    @Order(1)
    public void testListaLivros() throws Exception {

        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("1", "livro 1", "autor 1"));
        livros.add(new Livro("2", "livro 2", "autor 2"));

        Mockito.when(livroService.listarLivros()).thenReturn(livros);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/livro"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("[{\"codigo\":\"1\",\"nome\":\"livro 1\",\"autor\":\"autor 1\"},{\"codigo\":\"2\",\"nome\":\"livro 2\",\"autor\":\"autor 2\"}]", resposta);

    }

    @Test
    @Order(2)
    public void cadastrarLivro() throws Exception {

        Livro livro = new Livro("1", "livro 1", "autor 1");
        String livroString = new ObjectMapper().writeValueAsString(livro);

        Mockito.when(livroService.cadastrarLivro("livro 1", "autor 1", "1"))
                .thenReturn(livro);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/livro")
                .content(livroString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("{\"codigo\":\"1\",\"nome\":\"livro 1\",\"autor\":\"autor 1\"}", resposta);

    }




}
