package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerV3 implements CommandLineRunner  {

    @Autowired
    private ClaseAsincrona claseAsincrona;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerV3.class);

    @Override
    public void run(String... args)  {
        LOGGER.info("CommandLineRunner llamando asincrono");
        claseAsincrona.asyncMethod();
        LOGGER.info("CommandLineRunner fin llamado asincrono");
    }    
}
