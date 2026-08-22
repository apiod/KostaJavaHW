package ex0821.profile.service;

import java.io.IOException;

import ex0821.profile.exception.DuplicateNameException;
import ex0821.profile.exception.NotMatchNameException;
import ex0821.profile.exception.NotMatchPasswordException;
import ex0821.profile.info.Profile;

public interface ProfileService {
	/**
	 * 프로필 정보 src/source/`name`.txt로 저장
	 * @param profile
	 * @throws DuplicateNameException
	 * @throws IOException
	 */
	void saveProfile(Profile profile)throws DuplicateNameException, NotMatchNameException, IOException;;
	/**
	 * 이름 중복 확인하는 메소드
	 * @return boolean 중복이면 true,
	 */
	boolean checkName(String name)throws NotMatchNameException;
	Profile checkPassword(String name, String password)throws NotMatchPasswordException;
	void updateWeight(int weight);
	void updatePw(String id,String pw);
	void saveFile(Profile profile)throws IOException;
	/**
	 * src/source/파일이있는지 확인
	 * @return없으면 파일 생성하면 true 
	 */
	boolean checkFile();
}
