import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for (int i = 0; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ar[] = new int[3];
            ar[0] = Integer.parseInt(st.nextToken());
            ar[1] = Integer.parseInt(st.nextToken());
            ar[2] = Integer.parseInt(st.nextToken());
            if(ar[0] == 0 && ar[1] == 0 && ar[2] == 0)break;

            Arrays.sort(ar);
            int a = ar[0] * ar[0];
            int b = ar[1] * ar[1];
            int c = ar[2] * ar[2];

            if(a + b == c){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
        }

    }
}