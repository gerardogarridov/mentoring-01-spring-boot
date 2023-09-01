package cl.sonda.mentoring.holamundo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
public class Configuraciones {
    
    @Bean
    @Profile("v1")
    @Scope("prototype")
    public CommandLineRunner commandLineRunnerV1(){
        return new CommandLineRunnerV1();
    }

    @Bean
    @Profile("v2")
    @Scope("singleton")
    public CommandLineRunner commandLineRunnerV2(){
        return new CommandLineRunnerV2();
    }

}
