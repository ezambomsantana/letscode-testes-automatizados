package restaurante.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
import restaurante.model.Restaurante;
import restaurante.service.RestauranteService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RestauranteControllerTest {

    @InjectMocks
    private RestauranteController restauranteController;

    @Mock
    private RestauranteService restauranteService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(restauranteController).build();
    }

    @Test
    public void testListarRestarantes() throws Exception {
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("1", "Pizzaria", null, "pizza", 5));
        restaurantes.add(new Restaurante("2", "Lanchonete", null, "lanche", 5));

        Mockito.when(restauranteService.listaResturante()).thenReturn(restaurantes);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/restaurante"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("[{\"codigo\":\"1\",\"nome\":\"Pizzaria\",\"endereco\":null,\"tipo\":\"pizza\",\"avaliacao\":5},{\"codigo\":\"2\",\"nome\":\"Lanchonete\",\"endereco\":null,\"tipo\":\"lanche\",\"avaliacao\":5}]", resposta);
    }

    @Test
    public void testCadastrarRestaurante() throws Exception {

        String content = "{" +
                "\"codigo\":\"3\"," +
                "\"nome\":\"Lanchonete\"," +
                "\"endereco\":null," +
                "\"tipo\":\"lanche\"," +
                "\"avaliacao\":5" +
                "}";

        Restaurante restaurante = new Restaurante("3", "Lanchonete", null, "lanche", 5);
        Mockito
                .when(restauranteService.cadastrarRestaurante("3", "Lanchonete", null, "lanche", 5))
                .thenReturn(restaurante);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/restaurante")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resposta);

    }


    @Test
    public void testCadastrarRestauranteErro() throws Exception {

        String content = "{" +
                "\"nome\":\"Lanchonete\"," +
                "\"endereco\":null," +
                "\"tipo\":\"lanche\"," +
                "\"avaliacao\":5" +
                "}";

        Mockito
                .when(restauranteService.cadastrarRestaurante(null, "Lanchonete", null, "lanche", 5))
                .thenReturn(null);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/restaurante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("", resposta);

    }


}
