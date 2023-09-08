package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerV1 implements CommandLineRunner  {

    private HolaMundoService holaMundoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerV1.class);

    public CommandLineRunnerV1(HolaMundoService holaMundoService){
        this.holaMundoService = holaMundoService;
    }

    @Override
    public void run(String... args)  {
        LOGGER.info("CommandLineRunnerV1.run >> START");
        holaMundoService.holaMundo(Optional.of(this.toString()));
        LOGGER.info("CommandLineRunnerV1.run >> END");
    }    

}
