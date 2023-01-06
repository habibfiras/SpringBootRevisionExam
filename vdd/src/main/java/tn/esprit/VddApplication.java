package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VddApplication {

	public static void main(String[] args) {
		SpringApplication.run(VddApplication.class, args);
	}

}
