package com.example.SW_PBL;

import com.example.SW_PBL.Festival.Fstvl;
import com.example.SW_PBL.Festival.FstvlRepositoryImp;
import com.example.SW_PBL.Festival.FstvlService;
import com.example.SW_PBL.Festival.ListSort;
import com.example.SW_PBL.Train.Train;
import com.example.SW_PBL.Train.TrainRepositoryImp;
import com.example.SW_PBL.Train.TrainService;
import com.example.SW_PBL.User.User;
import com.example.SW_PBL.User.UserRepositoryImp;
import com.example.SW_PBL.User.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SwPblApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(SwPblApplication.class, args);
		/*
		User user = new User();
		UserRepositoryImp userRepositoryImp = new UserRepositoryImp();
		UserService userService = new UserService(userRepositoryImp);
		String user_location = "경기도 김포시";
		String user_ip = "192.168.0.1";
		String user_name = "이계승";
		user.setUser_location(user_location);
		user.setUser_ip(user_ip);
		user.setUser_name(user_name);
		userService.UserInputSave(user);

		Scanner sc = new Scanner(System.in);
		String date = "";
		int one, two, check = 0;
		while (check == 0) {
			System.out.println("기간을 입력하세요 (ex.2023.03.18~2023.04.20): ");
			date = sc.nextLine();
			one = Integer.parseInt(date.substring(5, 7));
			two = Integer.parseInt(date.substring(16, 18));
			if (one == two - 1 || one == two) {
				System.out.println("입력한 기간: " + date);
				check = 1;
			}
			else {
				System.out.println("입력한 기간이 한 달을 초과하거나 입력 형태가 올바르지 않습니다.");
			}
		}
		FstvlRepositoryImp fstvlRepositoryImp = new FstvlRepositoryImp();
		FstvlService fstvlService = new FstvlService(fstvlRepositoryImp);
		List<Fstvl> fstvlList = fstvlService.findDateFstvl(date);
		int length = fstvlService.length;
		for (int i = 0; i < length; i++) {
			System.out.println(fstvlList.get(i).getTitle());
		}

		TrainRepositoryImp trainRepositoryImp = new TrainRepositoryImp();
		TrainService trainService = new TrainService(trainRepositoryImp, userRepositoryImp, fstvlRepositoryImp);
		List<Train> trainList = trainService.getTrainTable(1, 1);
		int length1 = trainService.length;
		for (int i = 0; i < length1; i++) {
			System.out.println(trainList.get(i).getEta());
		}

		TrainRepositoryImp trainRepositoryImp4 = new TrainRepositoryImp();
		FstvlRepositoryImp fstvlRepositoryImp4 = new FstvlRepositoryImp();
		TrainService trainService4 = new TrainService(trainRepositoryImp4, userRepositoryImp, fstvlRepositoryImp4);
		Train train4 = trainService4.getTrainObj(1);
		System.out.println(train4.getDep());
		*/
	}
}
