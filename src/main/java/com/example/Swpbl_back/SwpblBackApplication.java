package com.example.Swpbl_back;

import com.example.Swpbl_back.crawling.*;
import com.example.Swpbl_back.repository.FstvlRepositoryImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwpblBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwpblBackApplication.class, args) ;
		//Go go = new Go();



		//FstvlRepositoryImp fstvlRepositoryImp = new FstvlRepositoryImp();

		//detailcrawling test
		//FestivalCrawling bot1 = new FestivalCrawling();
		//bot1.detailRun("https://cdn.visitkorea.or.kr/kfes/upload/contents/db/300_268ee267-d483-4e3b-9e27-3594f6d9c5f6_1.jpg");
	}
}
