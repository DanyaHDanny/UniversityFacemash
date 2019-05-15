package by.bsuir.facemash.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Runner class for spring boot application.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("by.bsuir.facemash")
@EntityScan("by.bsuir.facemash.entity")
public class UniversityFacemashApp {

    public static void main(final String[] args) {
        SpringApplication.run(UniversityFacemashApp.class, args);
    }

    /**
     * Bean for object {@link ModelMapper}.
     *
     * @return value of the object {@link ModelMapper}
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
