package cl.sonda.mentoring.holamundo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Configuraciones {
    
    @Bean
    @Profile("v1")
    public CommandLineRunner commandLineRunnerImpl(){
        return new CommandLineRunnerImpl();
    }

    @Bean
    @Profile("v2")
    public CommandLineRunner commandLineRunnerImple(){
        return new CommandLineRunnerImple();
    }

}
