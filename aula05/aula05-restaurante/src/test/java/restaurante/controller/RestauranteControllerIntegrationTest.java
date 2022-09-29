package restaurante.controller;

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
import restaurante.model.Restaurante;
import restaurante.service.RestauranteService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RestauranteControllerIntegrationTest {

    @InjectMocks
    private RestauranteController restauranteController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(restauranteController).build();
    }


    @Test
    @Order(1)
    public void testCadastrarRestaurante() throws Exception {

        String content = "{" +
                "\"codigo\":\"3\"," +
                "\"nome\":\"Lanchonete\"," +
                "\"endereco\":null," +
                "\"tipo\":\"lanche\"," +
                "\"avaliacao\":5" +
                "}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/restaurante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resposta);
    }


    @Test
    @Order(2)
    public void testListarRestarantes() throws Exception {

        String content = "[{" +
                "\"codigo\":\"3\"," +
                "\"nome\":\"Lanchonete\"," +
                "\"endereco\":null," +
                "\"tipo\":\"lanche\"," +
                "\"avaliacao\":5" +
                "}]";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/restaurante"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resposta);
    }

}
