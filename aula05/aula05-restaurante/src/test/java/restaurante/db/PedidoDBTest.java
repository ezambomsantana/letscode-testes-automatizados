package restaurante.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restaurante.model.ItemPedido;
import restaurante.model.Pedido;
import restaurante.model.Restaurante;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDBTest {

    private PedidoDB pedidoDB = new PedidoDB();

    @Test
    public void testCadastrarPedido() {

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido("mussarela", 50.0));
        itens.add(new ItemPedido("calabresa", 55.0));

        Pedido pedido = new Pedido();
        pedido.setItens(itens);

        Pedido pedidoRetorno = pedidoDB.cadastrarPedido(pedido);
        Assertions.assertEquals(2, pedidoRetorno.getItens().size());
        Assertions.assertEquals("mussarela", pedidoRetorno.getItens().get(0).getItem());
        Assertions.assertEquals(50.0, pedidoRetorno.getItens().get(0).getPreco());

    }



}
