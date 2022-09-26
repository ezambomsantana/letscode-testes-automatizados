package restaurante.service;

import restaurante.db.RestauranteDB;
import restaurante.model.Restaurante;

import java.util.List;

public class RestauranteService {

    private RestauranteDB restauranteDB = new RestauranteDB();

    public Restaurante cadastrarRestaurante(String codigo, String nome,
                                            String endereco, String tipo, Integer avaliacao) {
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }
        if (nome == null || nome.isEmpty()) {
            return null;
        }
        if (tipo == null || tipo.isEmpty()) {
            return null;
        }
        if (avaliacao == null || avaliacao < 0 || avaliacao > 5) {
            return null;
        }

        Restaurante restaurante = new Restaurante(codigo, nome, endereco, tipo, avaliacao);
        return restauranteDB.cadastrarRestaurante(restaurante);
    }

    public List<Restaurante> listaResturante() {
        return restauranteDB.listRestaurantes();
    }

    public Restaurante buscaRestaurante(String codigo) {
        return restauranteDB.buscaRestaurante(codigo);
    }

}
