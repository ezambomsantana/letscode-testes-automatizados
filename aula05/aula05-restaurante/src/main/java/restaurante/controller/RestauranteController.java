package restaurante.controller;

import org.springframework.web.bind.annotation.*;
import restaurante.model.Restaurante;
import restaurante.service.RestauranteService;

import java.util.List;

@RestController
@RequestMapping
public class RestauranteController {

    private RestauranteService restauranteService = new RestauranteService();

    @GetMapping("/restaurante")
    public List<Restaurante> listRestaurantes() {
        return restauranteService.listaResturante();
    }

    @PostMapping("/restaurante")
    public Restaurante cadastrarRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.cadastrarRestaurante(restaurante.getCodigo(),
                restaurante.getNome(), restaurante.getEndereco(), restaurante.getTipo(),
                restaurante.getAvaliacao());
    }


}
