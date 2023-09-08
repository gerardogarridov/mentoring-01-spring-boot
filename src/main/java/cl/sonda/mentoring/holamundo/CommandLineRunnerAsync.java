package cl.sonda.mentoring.holamundo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerAsync implements CommandLineRunner  {

    @Autowired
    private ClaseAsincrona claseAsincrona;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerAsync.class);

    @Override
    public void run(String... args)  {
        LOGGER.info("CommandLineRunnerAsync.run >> START");
        claseAsincrona.asyncMethod();
        LOGGER.info("CommandLineRunnerAsync.run >> END");
    }    
}
