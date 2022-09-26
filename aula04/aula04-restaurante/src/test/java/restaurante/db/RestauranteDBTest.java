package restaurante.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restaurante.model.Restaurante;

import java.util.List;

public class RestauranteDBTest {

    private RestauranteDB restauranteDB = new RestauranteDB();

    @Test
    public void testCadastrarRestaurante() {
        Restaurante restaurante
                = new Restaurante("1", "Pizzaria", "Rua abc", "pizza", 5);
        Restaurante retorno = restauranteDB.cadastrarRestaurante(restaurante);

        Assertions.assertEquals("1", retorno.getCodigo());
        Assertions.assertEquals("Pizzaria", retorno.getNome());
        Assertions.assertEquals("Rua abc", retorno.getEndereco());
        Assertions.assertEquals("pizza", retorno.getTipo());
        Assertions.assertEquals(5, retorno.getAvaliacao());
    }

    @Test
    public void testListaRestaurantes() {
        Restaurante restaurante
            = new Restaurante("1", "Pizzaria", "Rua abc", "pizza", 5);
        restauranteDB.cadastrarRestaurante(restaurante);

        List<Restaurante> retorno = restauranteDB.listRestaurantes();
        Assertions.assertTrue(retorno.size() > 0);
    }


    @Test
    public void testBuscaResturante() {
        Restaurante restaurante
                = new Restaurante("10", "Pizzaria", "Rua abc", "pizza", 5);
        restauranteDB.cadastrarRestaurante(restaurante);

        Restaurante retorno = restauranteDB.buscaRestaurante("10");
        Assertions.assertEquals("10", retorno.getCodigo());
        Assertions.assertEquals("Pizzaria", retorno.getNome());
        Assertions.assertEquals("Rua abc", retorno.getEndereco());
        Assertions.assertEquals("pizza", retorno.getTipo());
        Assertions.assertEquals(5, retorno.getAvaliacao());
    }

    @Test
    public void testBuscaResturanteNaoExiste() {
        Restaurante retorno = restauranteDB.buscaRestaurante("100");
        Assertions.assertNull(retorno);
    }



}
