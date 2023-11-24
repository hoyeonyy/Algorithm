import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n+2];
        for (int i = 1; i <= n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        int answer = 0;
        for (int i = 1; i <= n+1; i++) {
            while (!stack.isEmpty()){
                if(ar[stack.peek()] <= ar[i]){
                    stack.push(i);
                    break;
                }
                Integer pop = stack.pop();
                int sum = ar[pop] * (i - stack.peek() - 1);
                if(sum > answer){
                    answer = sum;
                }
            }
        }
        System.out.println(answer);
    }
}