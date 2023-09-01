package cl.sonda.mentoring.persona;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaDao personaDao;

    public EstadoDTO crearPersona(PersonaDTO personaDTO){
        PersonaEntity personaEntity = new PersonaEntity(personaDTO);
        personaDao.save(personaEntity);
        return new EstadoDTO("OK");
    }

    public List<PersonaDTO> findAll() {
        return personaDao.findAll().stream().map(personaEntity -> new PersonaDTO(personaEntity)).collect(Collectors.toList());
    }


}
