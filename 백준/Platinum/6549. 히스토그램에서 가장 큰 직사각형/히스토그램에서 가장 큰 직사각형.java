import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)break;
            int ar[] = new int[n+2];
            for (int i = 1; i <= n; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();

            stack.add(0);
            Long answer = 0L;
            for (int i = 1; i <= n+1; i++) {
                while (!stack.isEmpty()){
                    if(ar[stack.peek()] <= ar[i]){
                        stack.push(i);
                        break;
                    }
                    Integer peek = stack.peek();
                    stack.pop();
                    Long x = (long) ar[peek];
                    Long y = (long) (i - stack.peek() - 1);
                    Long sum = x * y;
                    if(sum > answer){
                        answer = sum;
                    }
                }
            }
            System.out.println(answer);
        }



    }
}