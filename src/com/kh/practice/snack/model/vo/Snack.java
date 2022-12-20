package com.kh.practice.snack.model.vo;

public class Snack { // 필드
	
	private String kind;	// 종류
	private String name;	// 이름
	private String flavor;	// 맛
	private int numOf;		// 개수
	private int price;		// 가격
	
	public Snack() {}	// 기본 생성자
	
	// 매개변수 생성자
	public Snack(String kind, String name,
				String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}

	
	// information() : String  이건 머야  => 자료형이 String인거..?
	// : 어쩌고는 어쩌고 자료형으로 만들라는 뜻
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String infomation() {
		return kind +"(" + name + " - " + flavor + ") " + numOf + "개 " + price + "원";
	}
	
	
}
