package ex0821.profile.controller;

import java.io.IOException;
import java.util.Scanner;

import ex0821.profile.view.SuccessView;
import ex0821.profile.exception.DuplicateNameException;
import ex0821.profile.exception.NotMatchNameException;
import ex0821.profile.exception.NotMatchPasswordException;
import ex0821.profile.info.Profile;
import ex0821.profile.service.ProfileServiceImpl;
import ex0821.profile.view.FailView;

public class ProfileController {
	ProfileServiceImpl service = new ProfileServiceImpl();
	Scanner sc = new Scanner(System.in);
	private static final int PASSWORDERROR = 3;//최대 오류 3회
	
	public void saveProfile() {
		System.out.println("이름을 입력하여주십시오.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.println("몸무게를 입력하여주십시오.");
		System.out.print("몸무게: ");
		int weight = Integer.parseInt(sc.nextLine());
		System.out.println("비밀번호를 입력하여주십시오.");
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		Profile profile = new Profile(name, weight, password);
		try {
			service.saveProfile(profile); 
		} catch (IOException | DuplicateNameException e) {
			FailView.failView(e.getMessage());
		} catch (NotMatchNameException e) {
			// 해당사항 없음
			//일치하는게 없으면 저장 
			//but. service.saveProfile에서 저장을 한다. 
			//따라서 해당사항 없다. 
		}
		
	}
	public void searchWeight() {
		int count = 0;
		System.out.println("이름을 입력하여주십시오.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		boolean condition= true;
		
		
		try {
			service.checkName(name) ;//매치여부 없으면 throw
			while(condition) {
				System.out.println("비밀번호를 입력하여주십시오.");
				System.out.print("비밀번호: ");
				String password = sc.nextLine();
				try {
					Profile pro = service.checkPassword(name, password);
					if(pro!=null) {
						SuccessView.printWeight(pro);
						break;
					}
				} catch (NotMatchPasswordException e) {
					if((++count)>=PASSWORDERROR) {
						FailView.failView("비밀번호가 3회 이상 틀렸습니다. 처음부터 다시 시도해주세요.");
						condition = false;
					}else {
						FailView.failView(e.getMessage());
					}
				}
			}
			
		} catch (NotMatchNameException e) {
			FailView.failView(e.getMessage());
		}
	}
	public void updateWeight() {
		
	}
	public void printAll() {
		SuccessView.printAll(service.printAll());
		
	}
}
