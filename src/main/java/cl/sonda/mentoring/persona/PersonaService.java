package cl.sonda.mentoring.persona;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PersonaService {

    @Autowired
    private PersonaDao personaDao;
    @Value("${app.persona.mensaje.invalido}")
    private String mensajeInvalido;
    @Value("${app.persona.mensaje.rutexiste}")
    private String mensajeExiste;
    @Value("${app.persona.mensaje.rutnoexiste}")
    private String mensajeNoExiste;


    public EstadoDTO crearPersona(PersonaDTO personaDTO){
        if(!personaDTO.isValid()){
            throw new PersonaDatosInvalidos(mensajeInvalido);
        }
        if(personaDao.existsById(personaDTO.getRut())){
            throw new PersonaExisteEnDB(String.format(mensajeExiste, personaDTO.getRut()));
        }
        PersonaEntity personaEntity = new PersonaEntity(personaDTO);
        personaDao.save(personaEntity);
        return new EstadoDTO("CREADO OK");
    }

    public EstadoDTO actualizarPersona(String rut, PersonaDTO personaDTO){
        // truco por si no viene en personaDTO
        personaDTO.setRut(rut);
        if(!personaDTO.isValid()){
            throw new PersonaDatosInvalidos(mensajeInvalido);
        }
        if (!personaDao.existsById(rut)) {
            throw new PersonaNoExisteEnDB(String.format(mensajeNoExiste, personaDTO.getRut()));
        }
        PersonaEntity personaEntity = personaDao.findById(rut).get();
        personaEntity.setNombre(personaDTO.getNombre());
        personaEntity.setApellido(personaDTO.getApellido());
        personaDao.save(personaEntity);
        return new EstadoDTO("ACTUALIZADO OK");
    }

    public List<PersonaDTO> findAll() {
        return personaDao.findAll().stream().map(personaEntity -> new PersonaDTO(personaEntity)).collect(Collectors.toList());
    }

    public EstadoDTO eliminarPersona(String rut) {
        if (!personaDao.existsById(rut)) {
            throw new PersonaNoExisteEnDB(String.format(mensajeNoExiste, rut));
        }
        personaDao.deleteById(rut);
        return new EstadoDTO("ELIMINADO OK");
    }

}
