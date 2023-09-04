package cl.sonda.mentoring.persona;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class PersonaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaController.class);
    @Value("${app.holamundo.toDelete}")
    private String eliminar;
    @Value("${app.holamundo.toUpdate}")
    private String actualizar;

    @Autowired
    private PersonaService personaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoDTO> postPersona(@RequestBody PersonaDTO personaDTO) {
        return new ResponseEntity<>(personaService.crearPersona(personaDTO),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPersona(@PathVariable String id, @RequestBody PersonaDTO personaDTO){
        try{
            LOGGER.info(String.format(actualizar, id));
            return new ResponseEntity<>(personaService.actualizarPersona(id, personaDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("{\"error\":\"Error. Por favor intente mas tarde.\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable String id) {
        try {
            LOGGER.info(String.format(eliminar, id));
            // personaService.eliminarPersona(id);
            // return ResponseEntity.status(HttpStatus.OK).body((String.format(eliminado, id)));

            return new ResponseEntity<>(personaService.eliminarPersona(id), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("{\"error\":\"Error. Verifique los datos de actualizacion.\"}", HttpStatus.BAD_REQUEST);
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonaDTO>> getPersonas() {
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }

}
