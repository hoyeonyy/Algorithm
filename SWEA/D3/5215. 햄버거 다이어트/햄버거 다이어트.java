import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int limit;
    static ArrayList<Ham> list;
    static int max;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            max = 0;
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st= new StringTokenizer(br.readLine());
                list.add(new Ham(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            }
            dfs(0, 0, 0);


            System.out.println("#" + (i+1) +" " + max);
        }
    }
    static void dfs(int sumCal, int sumTaste, int i){
        if(sumCal > limit){
            return;
        }
        if(i == n){
            if(max < sumTaste){
                max = sumTaste;
            }
            return;
        }
        else{
            dfs(sumCal + list.get(i).cal, sumTaste+list.get(i).taste, i+1);
            dfs(sumCal, sumTaste, i+1);
        }


    }
    static class Ham {
        int cal;
        int taste;

        public Ham(int taste, int cal) {
            this.cal = cal;
            this.taste = taste;
        }
    }
}