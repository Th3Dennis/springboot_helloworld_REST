package ch.noseryoung.uk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class UkApplication {

	public static void main(String[] args) {
		SpringApplication.run(UkApplication.class, args);
	}

}
