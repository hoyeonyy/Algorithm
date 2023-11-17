import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int limit;
    static int cnt;
    static int flag;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            cnt = 0;
            flag = 1;
            char[] chars = br.readLine().toCharArray();
            for (char aChar : chars) {
                if(flag == 1){
                    if(aChar == '1'){
                        cnt++;
                        flag = 0;
                    }
                }
                else{
                    if(aChar == '0'){
                        cnt++;
                        flag = 1;
                    }
                }
            }

            System.out.println("#" + (i+1) +" " + cnt);
        }
    }
}