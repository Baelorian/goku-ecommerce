package goku.ecommerce.gokuecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GokuECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GokuECommerceApplication.class, args);
	}

}
