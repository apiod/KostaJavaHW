package ex0821.profile.view;

import java.util.List;

import ex0821.profile.info.Profile;

public class SuccessView {
	public static void printAll(List<Profile> list) {
		System.out.println("총 "+ list.size()+"명");
		for (Profile profile : list) {
			System.out.println(profile);
		}
		System.out.println();
	}
	public static void printWeight(Profile profile) {
		System.out.println("---------------");
		System.out.println(profile.getName()+"님의 몸무게는 "+profile.getWeight()+"kg입니다.");
		System.out.println("---------------");
	}
}
