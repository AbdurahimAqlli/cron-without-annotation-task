package uz.asz.cronwithoutannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.Entity;

@SpringBootApplication
public class CronWithoutAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CronWithoutAnnotationApplication.class, args);
    }

}
