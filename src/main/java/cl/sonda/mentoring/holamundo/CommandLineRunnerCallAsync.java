package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerCallAsync implements CommandLineRunner  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerCallAsync.class);

    @Override
    public void run(String... args)  {
        LOGGER.info("llamando async");
        asyncMethod();
        LOGGER.info("fin async");
    }

    @Async
    public void asyncMethod (){
        try {
            Thread.sleep(7000);
            LOGGER.info("Hola mundo desde async");
        } catch (InterruptedException e) {
            LOGGER.error("ups !", e);
        }
    }
}
