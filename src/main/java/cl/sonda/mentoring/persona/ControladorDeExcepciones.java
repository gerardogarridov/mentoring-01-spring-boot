package cl.sonda.mentoring.persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
// Manipulador de excepciones
public class ControladorDeExcepciones {
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(final RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
    }

    @ExceptionHandler(PersonaDatosInvalidos.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(final PersonaDatosInvalidos ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
    }

    @ExceptionHandler(PersonaExisteEnDB.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(final PersonaExisteEnDB ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
    }
        
    @ExceptionHandler(PersonaNoExisteEnDB.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(final PersonaNoExisteEnDB ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
    }
}
