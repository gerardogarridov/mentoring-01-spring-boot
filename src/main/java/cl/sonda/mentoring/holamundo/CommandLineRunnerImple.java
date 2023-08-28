package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerImple implements CommandLineRunner  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerImple.class);

    @Override
    public void run(String... args)  {
        LOGGER.info("Hola mundo desde 2");
    }
    
    
}
