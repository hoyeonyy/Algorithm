import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    public int[] solution(int n, int[] arr) {
//
//        ArrayList<Integer> answer = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            if(stack.isEmpty()) stack.push(i);
//            else {
//                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
//                    int tmp_i = stack.pop();
//                    arr[tmp_i] = arr[i];
//                }
//                stack.push(i);
//            }
//        }
//        while (!stack.isEmpty()){
//            arr[stack.pop()] = -1;
//        }
//
//        return arr;
//    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) stack.push(i);
            else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    int tmp_i = stack.pop();
                    arr[tmp_i] = arr[i];
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int answer : arr) {
            sb.append(answer).append(' ');
        }
        System.out.println(sb);
    }
}