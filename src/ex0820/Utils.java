package ex0820;

import java.util.Scanner;

public class Utils {
	public static String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름> ");
		String name = sc.nextLine();
		return name;
	}
}
