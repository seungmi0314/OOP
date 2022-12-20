package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
	
	private Snack s = new Snack();  // 필드로 쓰이는거
	
	public SnackController() {} // 기본 생성자
	
	// 데이터를 setter를 이용하여 저장하고, 저장완료 결과 반환하는 메소드
	public String saveData(String kind, String name,
			String flavor, int numOf, int price
			) {
		
		s.setKind(kind);
		s.setFlavor(flavor);
		s.setName(name);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다"
					+ " \n저장한 정보를 확인하시겠습니까?(y/n) : ";
					
	}
	
	public String confirmData() {
		// 저장된 데이터를 반환함
		return s.infomation();
	}/// 사실상 굳이 필요는 없음 근데 문제에 있으니까 해논거임
		// == return + "(" ..... 그냥 문자 열만 전달 해 준거
	
	
	
	
	
/*
 	public void practice() {
		
		public SnackController() {}
		
		private Scanner sc = new Scanner(System.in);
		
		
		
	public String bread() {
		
	
		// 1) 입력창 기능
		System.out.println("스낵류를 입력하세요");
		
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("맛");
		String flavor = sc.next();
		
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
	}	
		
	
		// 2) 가격까지 치고나면 저장 완료되었습니다 저장한 정보 확인할거?
		// 		2-1) yes -> 입력 한 정보 보여주기
		//		2-2) no -> 그냥 종료
		
		
		
		
		
	
		
		
	}*/
}
