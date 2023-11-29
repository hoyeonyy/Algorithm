import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int money = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
        StringBuilder sb = new StringBuilder();

        while (n != 0){
            int[] cal = new int[n];
            int[] cost = new int[money];
            for(int i=0; i<n; ++i){
                st = new StringTokenizer(br.readLine());
                cal[i] = Integer.parseInt(st.nextToken());
                cost[i] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }

            int[] dp = new int[money+1];
            Arrays.fill(dp, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < dp.length; j++) {
                    int tmp = j - cost[i];
                    if(tmp >= 0){
                        dp[j] = Math.max(dp[j], dp[tmp] + cal[i]);
                    }
                }
            }
            sb.append(dp[money]).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            money = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
        }

        System.out.print(sb);
    }
}