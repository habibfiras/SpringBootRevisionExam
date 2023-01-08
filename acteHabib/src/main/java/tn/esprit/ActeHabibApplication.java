package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActeHabibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActeHabibApplication.class, args);
	}

}
