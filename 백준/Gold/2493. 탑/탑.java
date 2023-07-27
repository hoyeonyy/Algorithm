import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    public int solution(int n, int m, int[] arr) {
//
//        int answer = 0;
//
//
//
//
//
//        return answer;
//    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 n, m 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 배열 arr[n] 입력 받기
        int[] arr = new int[n+4];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] result = new int[n+4];
        for (int i = 1; i <= n; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                result[i] = 0;
            }
            else{
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result[i] = 0;
                }
                else{
                    result[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);

    }
}
