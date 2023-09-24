package com.example.Swpbl_back;

import com.example.Swpbl_back.crawling.Festival;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwpblBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwpblBackApplication.class, args) ;
		Festival bot1 = new Festival();
		//Train train = new Train();
		bot1.activateBot();
		//train.activateBot();

	}

}
