package ex0820;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProfileInfo {
	
	public void printProfile() {
		FileInputStream fis=null;
		String name = Utils.getName();
		String path = "src/source/"+name+".txt";
		File file = new File(path);
		if(file.exists()) {
			try {
				fis = new FileInputStream(path);
				byte[] bs = new byte[fis.available()];
				fis.read(bs);//bs에 데이터 담기
				String info = new String(bs);//정보 저장
				String[] infoArray = info.split(":");//반환타입이 String[]
				//출력구문
				System.out.printf("%s님 몸무게는 %s kg이고 비번은 %s입니다.\n",name, infoArray[0],infoArray[1]);
			} catch (IOException e) {
				e.getStackTrace();
			}finally {
				try {
					if(fis!=null)fis.close();		
				} catch (IOException e) {
					e.getStackTrace();
				}
			}
		}else {
			System.out.println(name+"에 해당하는정보는 없습니다.");
		}
	}
}
