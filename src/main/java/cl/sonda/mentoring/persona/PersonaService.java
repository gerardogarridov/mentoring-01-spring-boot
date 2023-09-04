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

    public EstadoDTO actualizarPersona(String id, PersonaDTO personaDTO) throws Exception {
        try {
            if (personaDao.existsById(id)) {
                PersonaEntity personaEntityAux = personaDao.findById(id).get();
                if ((personaDTO.getRut() == null || personaDTO.getRut().isEmpty())
                        && (personaDTO.getNombre() == null || personaDTO.getNombre().isEmpty())
                        && (personaDTO.getApellido() == null || personaDTO.getApellido().isEmpty())) {
                    return new EstadoDTO("NO SE ASIGNARON DATOS PARA ACTUALIZAR");
                } else if (personaDTO.getRut() != null && !personaDTO.getRut().isEmpty()) {
                    personaEntityAux.setRut(personaDTO.getRut());
                }
                personaEntityAux.setNombre(personaDTO.getNombre());
                personaEntityAux.setApellido(personaDTO.getApellido());
                personaDao.save(personaEntityAux);
                return new EstadoDTO("ACTUALIZADO");
            } else {
                return new EstadoDTO("NO EXISTE PARA SER ACTUALIZADO");
                // throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<PersonaDTO> findAll() {
        return personaDao.findAll().stream().map(personaEntity -> new PersonaDTO(personaEntity)).collect(Collectors.toList());
    }

    /*public boolean eliminarPersona(String id){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setRut(id);
        personaDao.deleteById(personaEntity.getRut());
        //personaDao.deleteById(id);
        return true;
    }*/

    public EstadoDTO eliminarPersona(String id) throws Exception {
        try {
            if (personaDao.existsById(id)) {
                personaDao.deleteById(id);
                return new EstadoDTO("ELIMINADO");
            } else {
                return new EstadoDTO("NO EXISTE PARA SER ELIMINADO");
                //throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
