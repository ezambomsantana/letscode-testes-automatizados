package restaurante.db;

import restaurante.model.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestauranteDB {

    public static List<Restaurante> restaurantes = new ArrayList<>();

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
        return restaurante;
    }

    public List<Restaurante> listRestaurantes() {
        return restaurantes;
    }

    public Restaurante buscaRestaurante(String codigo) {
        Optional<Restaurante> op = restaurantes
                .stream()
                .filter(r -> r.getCodigo().equals(codigo))
                .findFirst();

        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

}
