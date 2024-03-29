package ru.local.dnevnik;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexandra on 03.02.15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("ru")
public class Application {
	
    public static void main (String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        app.run(args);

    }
}
