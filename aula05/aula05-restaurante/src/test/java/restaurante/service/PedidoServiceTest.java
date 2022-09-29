package restaurante.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurante.db.PedidoDB;
import restaurante.model.ItemPedido;
import restaurante.model.Pedido;
import restaurante.model.Restaurante;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoDB pedidoDB;

    @Mock
    private RestauranteService restauranteService;

    @Test
    public void testCadastrarPedido() {

        Restaurante restaurante = new Restaurante("1", "Pizzaria", null, "pizza", 5);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido("mussarela", 50.0));
        itens.add(new ItemPedido("calabresa", 55.0));

        Mockito
                .when(restauranteService.buscaRestaurante("1"))
                .thenReturn(restaurante);

        Mockito
                .when(pedidoDB.cadastrarPedido(Mockito.any()))
                .thenReturn(new Pedido(restaurante, LocalDateTime.now(), 100.0, itens));

        Pedido pedido = pedidoService.cadastrarPedido(restaurante, itens);
        Assertions.assertEquals(2, pedido.getItens().size());
        Assertions.assertEquals("mussarela", pedido.getItens().get(0).getItem());
        Assertions.assertEquals(50.0, pedido.getItens().get(0).getPreco());
        Assertions.assertEquals(LocalDateTime.now().getDayOfWeek(), pedido.getDataPedido().getDayOfWeek());

    }

    @Test
    public void testCadastrarPedidoErroResturanteNaoEncontrado() {
        Restaurante restaurante = new Restaurante("1", "Pizzaria", null, "pizza", 5);

        Mockito
                .when(restauranteService.buscaRestaurante("1"))
                .thenReturn(null);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido("mussarela", 50.0));
        itens.add(new ItemPedido("calabresa", 55.0));

        Pedido pedido = pedidoService.cadastrarPedido(restaurante, itens);
        Assertions.assertNull(pedido);
    }

    @Test
    public void testCadastrarPedidoErroListaItensVazio() {
        Restaurante restaurante = new Restaurante("1", "Pizzaria", null, "pizza", 5);

        Mockito
                .when(restauranteService.buscaRestaurante("1"))
                .thenReturn(restaurante);

        Pedido pedido = pedidoService.cadastrarPedido(restaurante, null);
        Assertions.assertNull(pedido);
    }

}
