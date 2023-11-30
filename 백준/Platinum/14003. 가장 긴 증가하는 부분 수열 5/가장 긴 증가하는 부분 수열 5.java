import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int ar[] = new int[n + 1];
        int dp[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = ar[i];
            int lt = 1;
            int rt = list.size() - 1;

            if(num > list.get(list.size() - 1)) {
                list.add(num);
                dp[i] = list.size() - 1;
            }
            else{
                while(lt < rt){
                    int mid = (lt + rt) /2;

                    if(list.get(mid) >= num) rt = mid;
                    else lt = mid + 1;
                }
                list.set(lt, num);
                dp[i] = lt;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1).append("\n");
        Stack<Integer> stack = new Stack();

        int index = list.size() - 1;
        for(int i = n; i > 0; i--){
            if(dp[i] == index){
                index--;
                stack.push(ar[i]);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}