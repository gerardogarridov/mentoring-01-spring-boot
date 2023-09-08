package cl.sonda.mentoring.persona;

public class PersonaNoExisteEnDB extends RuntimeException {

    public PersonaNoExisteEnDB(String mensaje) {
        super(mensaje);
    }

}
