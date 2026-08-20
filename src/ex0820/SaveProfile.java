package ex0820;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SaveProfile {
	public void saveProfile() {
		Scanner sc = new Scanner(System.in);
		String name =Utils.getName();
		String path = "src/source/";
		File file = new File(path);
		if(!file.exists()) file.mkdir();//해당 폴더 없을 경우 폴더 생성
		System.out.print("몸무게> ");
		String weight = sc.nextLine();
		System.out.print("비밀번호> ");
		String pw = sc.nextLine();
		if (weight==null && pw==null)return;//예외처리
		byte[] info =(weight+":"+pw).getBytes();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path+name+".txt");
			fos.write(info);
			System.out.println("프로필 저장 완료");
		} catch (IOException e) {
			e.getStackTrace();
		}finally {
			try {
				if(fos!=null)fos.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
		
		
	}
}
