package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HolaMundoService1 implements HolaMundoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(HolaMundoService1.class);
    // Spring expression language SPEL
    @Value("${app.holamundo.service1.default}")
    private String defaultHola;
    @Value("${app.holamundo.service1.format}")
    private String formatHola;

    public String holaMundo(Optional<String> nombre){
        if (!nombre.isPresent()) {
            LOGGER.info("HolaMundoService1.holaMundo {}", defaultHola);
            return defaultHola;
        }
        final String resultado = String.format(formatHola, nombre.get());
        LOGGER.info("HolaMundoService1.holaMundo {}", resultado);
        return resultado;
    }
}
