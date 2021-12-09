package uk.ac.reigate

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages="uk.ac.reigate")
class EmailApp {
    
    static main(args) {
        ApplicationContext ctx = new SpringApplication(EmailApp.class).run(args)
    }
    
    //	@Bean
    //	JavaMailSender mailSender() {
    //		return new JavaMailSenderImpl()
    //	}
    
}
