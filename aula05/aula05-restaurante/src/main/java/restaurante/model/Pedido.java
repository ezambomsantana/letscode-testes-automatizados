package restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Restaurante restaurante;
    private LocalDateTime dataPedido;
    private Double precoTotal;
    private List<ItemPedido> itens = new ArrayList<>();
}
