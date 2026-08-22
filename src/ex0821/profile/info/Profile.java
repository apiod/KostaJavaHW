package ex0821.profile.info;

import java.io.Serializable;

public class Profile implements Serializable{
	
	private static final long serialVersionUID = 20260821;
	private String name;
	private int weight;
	private String password;
	
	public Profile() {}
	
	public Profile(String name, int weight, String password) {
		this.name = name;
		this.weight = weight;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [name=");
		builder.append(name);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", pw=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	
}
