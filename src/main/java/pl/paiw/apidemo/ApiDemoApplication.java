package pl.paiw.apidemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableCircuitBreaker
public class ApiDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
