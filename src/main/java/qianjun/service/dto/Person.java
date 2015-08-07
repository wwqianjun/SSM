package qianjun.service.dto;

import java.util.List;

public class Person {
	private String name;
	
	private int age;
	
	private List<? extends Person> girls;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<? extends Person> getGirls() {
		return girls;
	}

	public void setGirls(List<? extends Person> girls) {
		this.girls = girls;
	}
	
	
}
