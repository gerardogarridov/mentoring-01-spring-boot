package cl.sonda.mentoring.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
// Esta capa debe ser lo mas simple posible. 
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoDTO> postPersona(@RequestBody PersonaDTO personaDTO) {
        return new ResponseEntity<>(personaService.crearPersona(personaDTO),
                HttpStatus.OK);
    }

    @PutMapping("/{rut}")
    public ResponseEntity<?> putPersona(@PathVariable String rut, @RequestBody PersonaDTO personaDTO){
        return new ResponseEntity<>(personaService.actualizarPersona(rut, personaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<?> deletePersona(@PathVariable String rut) {
        return new ResponseEntity<>(personaService.eliminarPersona(rut), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonaDTO>> getPersonas() {
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }

}
