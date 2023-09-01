package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrontabClass {

    @Autowired
    private HolaMundoService holaMundoService1;

    @Scheduled(fixedDelay = 5000)
    public void mentodoCron(){
        holaMundoService1.holaMundo(Optional.of(this.toString() ));
    }
}
