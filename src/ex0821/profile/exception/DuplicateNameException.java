package ex0821.profile.exception;

/**
 * 이름이 중복되었을때 발생한 예외..
 * */
public class DuplicateNameException extends Exception{

	public DuplicateNameException() {}
	public DuplicateNameException(String message) {
		super(message);
	}
}
