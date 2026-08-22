package ex0821.profile.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ex0821.profile.exception.DuplicateNameException;
import ex0821.profile.exception.NotMatchNameException;
import ex0821.profile.exception.NotMatchPasswordException;
import ex0821.profile.info.Profile;

public class ProfileServiceImpl implements ProfileService{
	String path = "src/source/"; //파일 저장 경로
	List<Profile> list = new ArrayList<>();
	String[] nameList=null;
	File file = new File(path);
	
	
	public ProfileServiceImpl(){
		if(checkFile()) {
			System.out.println("정보 불러오는 중");
			nameList = this.file.list(); //이름 목록 불러오기
			for(String name : nameList) {
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+name))){
					list.add((Profile) ois.readObject());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			System.out.println(list);
			System.out.println("정보 불러오기 완료");
		}
	}
	
	public boolean checkFile() {	
		if(!this.file.exists()) {//파일이 없을때
			return this.file.mkdir();//파일 없으면 생성
		}
		return true;
	}
	/**
	 * 이름 중복 확인하는 메소드
	 * @return boolean 중복이면 true,
	 */
	public boolean checkName(String name) throws NotMatchNameException{
		for(Profile pro:list) {
			if(pro.getName().equals(name)) {
				return true;
			}
		}
		throw new NotMatchNameException("이름이 일치하지 않습니다.");
	}
	
	public void saveProfile(Profile profile) throws DuplicateNameException,NotMatchNameException, IOException{
		if(checkName(profile.getName())) {
			throw new DuplicateNameException("이름이 중복입니다.");
		}else {//저장 가능
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+profile.getName()+".txt"))){
				oos.writeObject(profile);
				list.add(profile);
				System.out.println(profile.getName()+".txt 파일 저장 완료");
			}
		}
	}
	public List<Profile> printAll() {
		return list;
	}
	/**
	 * id, pw를 확인하는 메소드
	 */
	public Profile checkPassword(String name, String password) throws NotMatchPasswordException{
		for(Profile pro: list) {
			if(pro.getName().equals(name)&&pro.getPassword().equals(password)) {
				return pro;
			}
		}
		throw new NotMatchPasswordException("비밀번호가 일치하지 않습니다. ");
	}
	public Profile checkIdPassword(String name, String password) throws NotMatchPasswordException, NotMatchNameException{
		if(checkName(name)) {
			Profile profile = checkIdPassword(name, password);
			if(profile!=null) {
				return profile;
			}else {
				throw new NotMatchPasswordException("비밀번호가 일치하지 않습니다.");
			}
		}else {
			throw new NotMatchNameException("이름이 일치하지 않습니다.");
		}
	}
	
	/**
	 * 몸무게 업데이트
	 */
	public void updateWeight(int weight) {
		
	}
	
	/**
	 * 비밀번호 수정
	 */
	public void updatePw(String id,String pw) {
		
	}
	
	/**
	 * 프로필 정보를 파일로 저장하는 메소드
	 */
	public void saveFile(Profile profile) throws IOException{
		if(checkFile()) {//source파일이 있는지 여부 확인 
			//이름별 파일 저장
			
		}
		
	}
	
}
