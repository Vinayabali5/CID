package uk.ac.reigate

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.ApplicationPidFileWriter
import org.springframework.boot.web.context.WebServerPortFileWriter
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.env.Environment

import uk.ac.reigate.config.RootContextConfig

@SpringBootApplication
@ComponentScan(value="uk.ac.reigate")
class TemplateApp extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateApp.class);
    
    @Autowired
    private Environment env;
    
    static main(args) {
        SpringApplication ctx = new SpringApplication(RootContextConfig.class)
        ctx.addListeners(new ApplicationPidFileWriter());
        ctx.addListeners(new WebServerPortFileWriter());
        Environment env = ctx.run(args).getEnvironment();
        
        String activeProfile = env.getProperty("spring.profiles.active") != null ? env.getProperty("spring.profiles.active") : 'none selected'
        String port = env.getProperty("server.port")
        String servletPath = env.getProperty("server.servletPath") != null ? env.getProperty("server.servletPath") : '/'
        String contextPath = env.getProperty("server.contextPath") != null ? env.getProperty("server.contextPath") : '/'
        
        LOGGER.info("\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Application '" + env.getProperty("app.name") + "' is running! \n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Profile:\n" +
                "Run Profile: \t\t" + env.getProperty("spring.profiles.active") + "\n" +
                "Active Profiles: \t" + env.getActiveProfiles() + "\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Access URLs:\n" +
                "Local:\t\t\thttp://127.0.0.1:" + port + contextPath + "\n" +
                "External:\t\thttp://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + contextPath + "\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Settings:\n" +
                "API URL:\t\t" + env.getProperty("apiUrl") + "\n" +
                "Reports URL:\t\t" + env.getProperty("reportUrl") + "\n" +
                "Student Images URL:\t" + env.getProperty("studentImagesUrl") + "\n" +
                "Debug Mode:\t\t" + env.getProperty("debug") + "\n" +
                "----------------------------------------------------------------------------------------------------------"
                )
    }
    
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
    
    private static Class<TemplateApp> applicationClass = TemplateApp.class;
    
    //	@Bean
    //	public ServletRegistrationBean apiV2() {
    //		DispatcherServlet dispatcherServlet = new DispatcherServlet();
    //
    //		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    //		applicationContext.register(DevelopmentContextConfig.class);
    //		dispatcherServlet.setApplicationContext(applicationContext);
    //
    //		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api2/*");
    //		servletRegistrationBean.setName("api");
    //		return servletRegistrationBean;
    //	}
    //
}
