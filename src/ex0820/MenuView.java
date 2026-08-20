package ex0820;

import java.util.Scanner;

public class MenuView {
	

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		SaveProfile sp = new SaveProfile();
		ProfileInfo pi = new ProfileInfo();
		
		while(true){
	           System.out.println("----------------------------------------------------------------------------------");
	           System.out.println("1. 프로필 저장    2. 프로필 불러오기	9. 종료");
			   System.out.println("----------------------------------------------------------------------------------");
			   System.out.print("메뉴선택 > ");

			   String  menu = sc.nextLine();
			   switch(menu){
	               case "1" : 
	                 sp.saveProfile();
				   break;
				   case "2" : 
	                 pi.printProfile();
				   break;
				   
				   case "9" : 
	                 System.exit(0);
				   default:
					   System.out.println("메뉴를 다시 선택해주세요!!!!");

			   }//switch문끝

			 }//while문끝
	}

}
