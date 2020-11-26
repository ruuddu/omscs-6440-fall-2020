package gatech.scrubs26.hypertensionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("gatech.scrubs26.hypertensionmanagement")
public class HypertensionmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypertensionmanagementApplication.class, args);
	}

}
