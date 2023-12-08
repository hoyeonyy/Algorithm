import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int add = 1;
            String tmp = br.readLine();
            for (char c : tmp.toCharArray()) {
                if(c == 'O'){
                    cnt = cnt + add;
                    add++;
                }
                else add = 1;
            }
            System.out.println(cnt);
        }

    }
}