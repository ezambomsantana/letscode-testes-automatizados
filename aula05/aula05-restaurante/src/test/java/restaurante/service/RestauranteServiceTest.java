package restaurante.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.db.RestauranteDB;
import restaurante.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RestauranteServiceTest {

    @InjectMocks
    private RestauranteService resturanteService;

    @Mock
    private RestauranteDB restauranteDB;

    @Test
    public void testCadastraResturanteCodigoNull() {
        Restaurante retorno = resturanteService.cadastrarRestaurante(null, "Pizzaria", "Rua abc", "pizza", 5);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastraResturanteNomeNull() {
        Restaurante retorno = resturanteService.cadastrarRestaurante("10", null, "Rua abc", "pizza", 5);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastraResturanteNomeVazio() {
        Restaurante retorno = resturanteService.cadastrarRestaurante("10", "", "Rua abc", "pizza", 5);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastraResturanteAvaliacaoNegativa() {
        Restaurante retorno = resturanteService.cadastrarRestaurante("10", "Pizzaria", "Rua abc", "pizza", -5);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastraResturanteAvaliacaoMaiorCinco() {
        Restaurante retorno = resturanteService.cadastrarRestaurante("10", "Pizzaria", "Rua abc", "pizza", 15);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastraRestaurante() {

        Restaurante restaurante = new Restaurante("10", "Pizzaria", null, "pizza", 5);

        Mockito.when(restauranteDB.cadastrarRestaurante(Mockito.any())).thenReturn(restaurante);

        Restaurante retorno = resturanteService
                .cadastrarRestaurante("10", "Pizzaria", null, "pizza", 5);

        Assertions.assertEquals("10", retorno.getCodigo());
        Assertions.assertEquals("Pizzaria", retorno.getNome());
        Assertions.assertNull(retorno.getEndereco());
        Assertions.assertEquals("pizza", retorno.getTipo());
        Assertions.assertEquals(5, retorno.getAvaliacao());

    }

    @Test
    public void testListaResturantesVazio() {

        Mockito.when(restauranteDB.listRestaurantes()).thenReturn(new ArrayList<>());

        List<Restaurante> lista = resturanteService.listaResturante();
        Assertions.assertEquals(0, lista.size());
        Assertions.assertTrue(lista.isEmpty());

    }

    @Test
    public void testListaRestaurantes() {

        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("1", "Pizzaria", "rua abc", "pizza", 5));
        restaurantes.add(new Restaurante("2", "Lanchonete", "rua abc", "lanche", 4));

        Mockito.when(restauranteDB.listRestaurantes()).thenReturn(restaurantes);
        List<Restaurante> lista = resturanteService.listaResturante();
        Assertions.assertEquals(2, lista.size());
        Assertions.assertFalse(lista.isEmpty());
        Assertions.assertEquals("1", lista.get(0).getCodigo());
        Assertions.assertEquals("2", lista.get(1).getCodigo());

    }

    @Test
    public void testBuscaResturantesVazio() {

        Mockito.when(restauranteDB.buscaRestaurante("codigo")).thenReturn(null);

        Restaurante retorno = resturanteService.buscaRestaurante("codigo");
        Assertions.assertNull(retorno);

    }

    @Test
    public void testBuscaResturantes() {

        Restaurante restaurante = new Restaurante("10", "Pizzaria", null, "pizza", 5);
        Mockito.when(restauranteDB.buscaRestaurante("codigo")).thenReturn(restaurante);
        Restaurante retorno = resturanteService.buscaRestaurante("codigo");
        Assertions.assertEquals("10", retorno.getCodigo());
        Assertions.assertEquals("Pizzaria", retorno.getNome());

    }


}
