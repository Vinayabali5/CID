package uk.ac.reigate

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(value="uk.ac.reigate")
@EnableAutoConfiguration
class ScriptsApp {
    
    static main(args) {
        SpringApplication app = new SpringApplication(ScriptsApp.class)
		app.setWebEnvironment(false);
        app.run(args)
    }

}
