import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[][] dp = new int[n][n];
        int mod = 10007;
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        
        for (int i = 1; i < n; i++){
            dp[i - 1][i] = 2;
            if (s.charAt(i) == s.charAt(i - 1))
                dp[i - 1][i]++;
        }
        
        for (int i = 2; i < n; i++){
            for (int j = i; j < n; j++){
                if (s.charAt(j) == s.charAt(j - i)){
                    dp[j - i][j] = (dp[j - i][j - 1] + dp[j - i + 1][j] + 1) % mod;
                } else{
                    dp[j - i][j] = (mod + dp[j - i][j - 1] + dp[j - i + 1][j] - dp[j - i + 1][j - 1]) % mod;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}