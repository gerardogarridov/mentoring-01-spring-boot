package cl.sonda.mentoring.holamundo;

import org.springframework.stereotype.Service;

@Service
public class HolaMundoService {

    public String holaMundo(String nombre){
        if (nombre == null) {
            return "Hola mundo Rest";
        }
        return String.format("Hola %s from rest", nombre);
    }
}
