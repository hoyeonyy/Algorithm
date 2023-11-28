import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
    static int n;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int answer = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        dy=new int[answer+1];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;

        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=answer; j++){
                int tmp =Math.min(dy[j], dy[j-coin[i]]+1);
                if(tmp >= 0){
                    dy[j] = tmp;
                }
            }
        }
        if(dy[answer] == Integer.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(dy[answer]);
        }
    }
}