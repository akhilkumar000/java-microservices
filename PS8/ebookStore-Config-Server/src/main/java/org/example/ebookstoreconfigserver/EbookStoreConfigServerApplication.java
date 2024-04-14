package org.example.ebookstoreconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EbookStoreConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookStoreConfigServerApplication.class, args);
	}

}
