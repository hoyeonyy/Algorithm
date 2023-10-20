import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i]= Integer.parseInt(st.nextToken());
        }
        
        int max = -1000000, min = 1000000;
        for(int i = 0 ; i <n;i++) {
            if(max < ar[i])max = ar[i];
            if(min > ar[i])min = ar[i];
        }
        System.out.printf("%d %d", min, max);
    }

}