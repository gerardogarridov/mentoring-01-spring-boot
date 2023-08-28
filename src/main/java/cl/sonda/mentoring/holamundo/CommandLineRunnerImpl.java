package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerImpl implements CommandLineRunner  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerImpl.class);

    @Override
    public void run(String... args)  {
        LOGGER.info("Hola mundo desde 1");
    }
    
    
}
