import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int hour = scanner.nextInt();
		int min = scanner.nextInt();
		int time = scanner.nextInt();
		
		int i = time/60;
		
		min+=time;
		while(i >= 0){
			if(min > 59) {
				min-=60;
				hour+=1;
				if(hour > 23) hour-=24;
			}
			i--;
		}
		
		
		
		System.out.printf("%d %d%n", hour, min);
		
	}

}