import java.util.*;

public class Main {

	public static void main(String[] args) {
		// command shift l -> 단축기 전체 목
		// command +, - -> 확대, 축소
		// command d -> 한줄 삭제
		// command option down -> 행단위 복사
		// option up, down -> 행단위 이동
		// command i -> 들여쓰기 맞춰주기
		// command / -> 주석
		// control command space -> 자동완성
		
		//import java.util.* -> 스캐너를 쓰기위한 임포트코드
		//Scanner scanner = new Scanner(System.in); ->입력받는
		//Math.round(4.52) -> 소수점 첫쨰자리에서 반올림
		int a, b;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(a+b);
		
	}

}