package RmTeam;

import java.util.*;

public class rmDTO {
	private String P_id;
	private String name;
	private String height;
	private String weight;
	private int age;
	private String position;
	private String nation;
	private Date JDate;
	public String getP_id() {
		return P_id;
	}
	public void setP_id(String p_id) {
		P_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Date getJDate() {
		return JDate;
	}
	public void setJDate(Date jDate) {
		JDate = jDate;
	}
	
	@Override
	public String toString() {
		return "rmDTO [P_id=" + P_id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", age=" + age
				 + ", position=" + position + ", nation =" + nation + ", JDate=" + JDate + "]";
	}

}
