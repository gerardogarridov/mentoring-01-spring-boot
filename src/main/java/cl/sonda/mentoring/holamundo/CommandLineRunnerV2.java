package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerV2 implements CommandLineRunner  {
    
    private HolaMundoService holaMundoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerV2.class);

    public CommandLineRunnerV2(HolaMundoService holaMundoService){
        this.holaMundoService = holaMundoService;
    }

    @Override
    public void run(String... args)  {
        LOGGER.info("CommandLineRunnerV2.run >> START");
        holaMundoService.holaMundo(Optional.of(this.toString()));
        LOGGER.info("CommandLineRunnerV2.run >> END");
    }
    
    
}
