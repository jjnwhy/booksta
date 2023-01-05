package org.booksta;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EntityScan
//@EnableJpaRepositories
@SpringBootApplication
public class BookstaAplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BookstaAplication.class, args);
    }
}
