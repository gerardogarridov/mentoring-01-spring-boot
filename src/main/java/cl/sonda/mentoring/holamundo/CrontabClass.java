package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrontabClass {

    @Autowired
    // inyectando con @Qualifier
    @Qualifier("holaMundoService1")
    private HolaMundoService holaMundoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CrontabClass.class);


    @Scheduled(fixedDelay = 5000)
    public void mentodoCron(){
        LOGGER.info("CrontabClass.mentodoCron >> START");
        holaMundoService.holaMundo(Optional.of(this.toString() ));
        LOGGER.info("CrontabClass.mentodoCron >> END");
    }
}
