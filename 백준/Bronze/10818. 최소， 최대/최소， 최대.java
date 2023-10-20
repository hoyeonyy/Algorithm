import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] ar = new int[n];
		for(int i = 0 ; i < n;i++) {
			ar[i] = scan.nextInt();
			
		}
		int max = -1000000, min = 1000000;
		for(int i = 0 ; i <n;i++) {
			if(max < ar[i])max = ar[i];
			if(min > ar[i])min = ar[i];
		}
		System.out.printf("%d %d", min, max);
	}

}