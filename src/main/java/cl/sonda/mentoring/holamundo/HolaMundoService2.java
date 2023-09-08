package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HolaMundoService2 implements HolaMundoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HolaMundoService2.class);
    // Spring expression language SPEL
    @Value("${app.holamundo.service2.default}")
    private String defaultHola;
    @Value("${app.holamundo.service2.format}")
    private String formatHola;

    public String holaMundo(Optional<String> nombre){
        if (!nombre.isPresent()) {
            LOGGER.info("HolaMundoService2.holaMundo >> {}", defaultHola);
            return defaultHola;
        }
        final String resultado = String.format(formatHola, nombre.get());
        LOGGER.info("HolaMundoService2.holaMundo >> {}", resultado);
        return resultado;
    }
}
