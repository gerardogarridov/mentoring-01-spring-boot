package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrontabClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrontabClass.class);

    @Scheduled(fixedDelay = 5000)
    public void mentodoCron(){
        LOGGER.info("Hola mundo desde crontab");
    }
}
