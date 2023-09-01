package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ClaseAsincrona {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClaseAsincrona.class);

    @Async
    public void asyncMethod (){
        try {
            Thread.sleep(7000);
            LOGGER.info("Hola mundo desde async ");
        } catch (InterruptedException e) {
            LOGGER.error("ups !", e);
        }
    }
}
