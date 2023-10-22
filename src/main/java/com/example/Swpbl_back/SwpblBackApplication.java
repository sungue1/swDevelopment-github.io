package com.example.Swpbl_back;

import com.example.Swpbl_back.crawling.FestivalCrawling;
import com.example.Swpbl_back.crawling.FestivalCrawling2;
import com.example.Swpbl_back.crawling.TrainCrawling;
import com.example.Swpbl_back.crawling.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwpblBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwpblBackApplication.class, args) ;
		//Go go = new Go();


		//FestivalCrawling bot1 = new FestivalCrawling();
		//FstvlRepositoryImp fstvlRepositoryImp = new FstvlRepositoryImp();
		//bot1.Run();
	}

}
