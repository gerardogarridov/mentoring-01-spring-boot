package cl.sonda.mentoring.holamundo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerV2 implements CommandLineRunner  {
    @Autowired
    private HolaMundoService holaMundoService2;

    @Override
    public void run(String... args)  {
        holaMundoService2.holaMundo(Optional.of(this.toString()));
    }
    
    
}
