package com.victornieto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by victornc83 on 21/04/2017.
 */
@SpringBootApplication
public class SbPostgresqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbPostgresqlApplication.class, args) ;
    }
}
