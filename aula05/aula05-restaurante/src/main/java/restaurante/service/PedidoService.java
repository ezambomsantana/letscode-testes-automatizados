package restaurante.service;

import restaurante.db.PedidoDB;
import restaurante.model.ItemPedido;
import restaurante.model.Pedido;
import restaurante.model.Restaurante;

import java.util.List;

public class PedidoService {

    private PedidoDB pedidoDB = new PedidoDB();
    private RestauranteService restauranteService = new RestauranteService();

    //assinatura -> nome (cadastrarPedido), lista de parametros (restaurante, itens),
    // tipo retorno (Pedido)
    public Pedido cadastrarPedido(Restaurante restaurante, List<ItemPedido> itens) {
        return null;
    }


}
