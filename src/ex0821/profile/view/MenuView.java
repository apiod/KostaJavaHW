package ex0821.profile.view;

import java.util.Scanner;

import ex0821.profile.controller.ProfileController;

public class MenuView {
	public void menuview() {
		ProfileController controller = new ProfileController();
		Scanner sc = new Scanner(System.in);
		String menu;
		while(true) {
			System.out.println("다음 사항에 맞게 입력하여 주십시요.");
			System.out.println("\t정보 입력은 1번");
			System.out.println("\t몸무게 검색은 2번");
			System.out.println("\t몸무게 변경은 3번");
			System.out.println("\t비밀번호 변경은 4번");
			System.out.println("\t프로그램 종료는 5번");
			System.out.print("입력> ");
			switch (menu= sc.nextLine()) {
			case "1": 
				controller.saveProfile();
				break;
			case "2":
				controller.searchWeight();
				break;
			case "3":
				controller.updateWeight();
				break;
			case "4":
				
				break;
			case "5":
				
				System.exit(0);
			case "6":
				System.out.println("6번");
				controller.printAll();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
	}
}
