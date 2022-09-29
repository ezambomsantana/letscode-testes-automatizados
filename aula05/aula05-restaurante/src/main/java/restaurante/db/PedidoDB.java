package restaurante.db;

import jdk.jshell.spi.ExecutionControl;
import restaurante.model.ItemPedido;
import restaurante.model.Pedido;
import restaurante.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class PedidoDB {

    private static List<Pedido> pedidos = new ArrayList<>();

    public Pedido cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

}
