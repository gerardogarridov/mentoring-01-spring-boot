package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inicio")
public class ServicioRest {

    @Autowired
    // inyectando con @Qualifier
    @Qualifier("holaMundoService1")
    private HolaMundoService holaMundoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicioRest.class);

    @GetMapping
    public String holaGenerico() {
        LOGGER.info("ServicioRest.holaGenerico >> START");
        String resultado = holaMundoService.holaMundo(Optional.empty());
        LOGGER.info("ServicioRest.holaGenerico >> END");
        return resultado;
    }

    @GetMapping(path = "/{nombre}")
    public String holaPersonalizado(@PathVariable("nombre") String nombre) {
        LOGGER.info("ServicioRest.holaPersonalizado >> START");
        String resultado = holaMundoService.holaMundo(Optional.of(nombre));
        LOGGER.info("ServicioRest.holaPersonalizado >> END");
        return resultado;
    }

}
