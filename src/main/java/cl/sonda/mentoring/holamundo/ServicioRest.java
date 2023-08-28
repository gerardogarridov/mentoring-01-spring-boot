package cl.sonda.mentoring.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inicio")
public class ServicioRest {

    @Autowired
    private HolaMundoService holaMundoService;

    @GetMapping
    public String holamundo() {
        return holaMundoService.holaMundo(null);
    }

    @GetMapping(path = "/{nombre}")
    public String hola(@PathVariable("nombre") String nombre) {
        return holaMundoService.holaMundo(nombre);
    }

}
