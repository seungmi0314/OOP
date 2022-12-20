package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService { //클래스
	//속성(필드)
	// 필드는 기본적으로 캡슐화 원칙에 의해 private이라는 접근제한자를 꼭 작성
	// 필드에 변수를 하나 작성하면, 클래스 안에서 어디에서든 사용 가능
	private Scanner sc = new Scanner(System.in);
		//System.in : 자바에서 기본적으로 지정해둔 입력장치(키보드)

	private Member memberInfo = null; // 가입한 회원의 정보를 저장 할 변수
	// 자료형 Member이며, memberInfo 라는
	
	private Member loginMember = null; // 로그인한 회원의 정보를 저장 할 변수
	
	//기능(생성자, 메서드)
	// ** 여러 기능을 하나의 메소드에 모두 작성하지 말 것!
	// 되도록 하나의 기능만 수행하도록 작성
	// 메소드는 메소드당 딱 하나의 기능만 가지고 있는게 좋다
	
	// 왜?
	// 기능별로 세분화 해놔야 필요한 기능만 호출하여 쓸 수 있다

	/*public void today() {
		//1. 밥먹는 행위
		//2. 일하는 행위
		// 밥 먹는 행위만 불러오고 싶은데 일까지 해버림
	}
	public void eat() {}
	public void work() {}
	// 두가지를 나눠서 메소드를 만들고, 
	// eat(); work(); 하나씩 불러서 쓸 수 있게 된다.
	*/
	public MemberService() {}
	//public MemberService(int a) {}
		// 기본생성자 미작성시 런에서 에러남
	
	
	// ** 메서드 작성법**
	
	// [접근제한자]	[예약어]		반환형		메소드명([매개변수]) {}
	//	public		static	  기본자료형
	// protected	final	참조형(배열, 클래스)
	// (default)   abstract		void
	// private	 static final
	
	// **반환형 void**
	// - 반환(return)이란? 메서드 수행 후 호출부로 돌아가는 것(돌려주는게 아니라 돌아가는 것)
	// - 반환 값 : 돌아가면서 가져 갈 결과 값
	// - 반환 형 : 반환 값의 자료형
	// -> void(텅빈, 없는, 무효의) : 돌려보낼 값(반환 값)이 없다.

	// 메뉴 화면 출력 기능
	public void displayMenu() {
		// 일은 하는데 결과값은 없음
		int menuNum = 0; // 지역변수
		
		do { // 한 번은 무조건 반복
			System.out.println("======회원 정보 관리 프로그램======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료"); // 왜 0번인지 알아야됨 난 모름
			
			System.out.print("매뉴 입력 >>> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용
			sc.nextLine(); // 입력버퍼에 남은 개행문자 제거
			
			switch(menuNum) {
			case 1 : System.out.println(signUp());break;
			case 2 : System.out.println(login());break; //프린트 안에 써도 되고 안써도 됨 왜? 같은지역이라서..? 대충 그런느낌 알아보기
			case 3 : System.out.println(selectMember());break;								// 리턴값이 없는 경우에만 리턴값이 있으면 프린트구문 써줘야됨
			case 4 : 
			
				// 회원 정보 수정 메소드 수행 후
				// 반환되는 결과를 result 변수에 저장
				int result = updateMember();  // -1 or 1 or 0
				
				if( result == -1) {
					System.out.println("로그인 후 이용 해주세요!");
				} else if(result == 0) {
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				} else { 
					System.out.println("회원 정보가 수정 되었습니다 :-)");
				}
				break;
				
			case 0 : System.out.println("프로그램 종료합니다..."); break;
			default : System.out.println("잘못 입력 하셧습니다. 다시 입력바랍니다");
			}
		 
		}while(menuNum != 0); // menuNum이 0이면 반복 종료
		
	}
	
	
	
	
	
	
	// 회원 가입 기능
	public String signUp() {
		// 가입 성공, 실패를 띄울거임
		// 반환형인 스트링이라서 처음엔 리턴이 없다고 에러가 뜰거임
		System.out.println("\n*****회원가입*****");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();  //user01
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		// == 이거는 주소값 비교할떄 쓰는거
		if( memberPw.equals(memberPw2)) { //일치하는경우
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			// 매개변수 사용해서 객체 하나 만들어준거임
			return "회원 가입 성공!!!";
		} else { 
			return"회원 가입 실패 (비밀번호 불일치)";
	}
	}
		
	// 로그인기능 메서드
	public String login(){
		System.out.println("******로그인******");
		
		// 회원 가입을 했는지부터 확인
		// == memberInfo가 객체를 참조하고 있는지 확인
		
		if(memberInfo == null) {//회원가입을 먼저 안한 경우
			return " 회원가입부터 진행하세요";
		}
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		// 로그인 메서드 안에 있는 멤버아이디
		if( memberId.equals(memberInfo.getMemberId()) &&
				memberPw.equals(memberInfo.getMemberPw())) {
			
			loginMember = memberInfo;
			// 로그인 지역변수 안에서 받은 아이디랑 비번을 멤버인포에 들어있는거랑 비교했는데
			//여기서 대충 추론해서 생각해보기
			
			return loginMember.getMemberName()+ "님 환영합니다!";
		} else { 
			return " 아이디 또는 비밀번호가 일치하지 않습니다";
		}
	}
		
	// 회원정보 조회기능
	// 아이디, 이름, 나이 만
	
	
	// CRUD ( C:Creat R:Read U:Update D:Delete )
	public String selectMember() {
		System.out.println("***** 회원 정보 조회 *****");
		
		// 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인
		if(loginMember == null) {
			return "로그인 후 이용해주세요";  // == 반환형이 string이라 문장 쓸 수 있는거
		}
		
		// 2) 로그인이 되어있는 경우
		//		회원정보를 출력 할 문자열을 만들어서 반환(return)
		//		단, 비밀번호는 제외
		String str = "이름 : " + loginMember.getMemberName();  // 이름 얻어오기
		str += "\n아이디 : " + loginMember.getMemberId();	  // 아이디 얻어오기
		str += "\n나이 : " + loginMember.getMemberAge();   // 나이 얻어오기
		
		// 이름 : 유저일
		// 아이디 : user1
		// 나이 : 50세
		
		return str;
	}
	// 회원 정보 수정(update) 기능
	public int updateMember() {
		
		System.out.println("\n***** 회원 정보 수정 *****");
		
		// 1) 로그인 여부 판별
		//	로그인이 되어있지않으면 -1 반환  => 그래서 지금 반환형이 int
		if(loginMember == null) {
			return -1;
		}
		// 2) 수정할 회원 정보 입력 받기(이름, 나이)
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();  // 지역변수
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		// sc.next(), sc.nextInt(), sc.nextDouble()
		// 위에 이런게 입력되어있으면
		// sc.nextLine()이걸로 정리
		sc.nextLine();
		// 입력버퍼에 정리하기
		
		// 3) 비밀번호 입력 받아서
		//		로그인 한 회원의 비밀번호와 일치한지 확인
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		// 4) 비밀번호가 같은 경우
		//		로그인 한 회원의 이름, 나이 정보를 입력받은 값으로 변경 후
		// 		정상적으로 변경 되었으면 1 반환
		if(inputPw.equals(loginMember.getMemberPw())) {
			loginMember.setMemberName(inputName);
			// 입력받은 inputName을
			// loginMember가 참조하는 Member 객체의 필드 memberName에 대입
			loginMember.setMemberAge(inputAge);
			return 1;
		} else {
		// 5) 비밀번호가 다른 경우 0 반환
			return 0;
		}
	}

}//
