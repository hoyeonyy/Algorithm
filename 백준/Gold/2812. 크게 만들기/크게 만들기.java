import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    public String solution(String pilsu, String seq) {
//
//        String answer = "YES";
//        Queue<Character> queue = new LinkedList<>();
//        for (char c : pilsu.toCharArray()) {
//            queue.offer(c);
//        }
//        for (char c : seq.toCharArray()) {
//            if(queue.contains(c)){
//                if(queue.peek() != c) {
//                    answer = "NO";
//                    break;
//                }
//                else{
//                    queue.poll();
//                }
//            }
//        }
//        if(!queue.isEmpty())return "NO";
//
//
//        return answer;
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        int cnt = k;

        for(int i = 0; i < str.length() ; i++){
            if(!stack.empty()){
                while(!stack.empty() && cnt > 0 && stack.peek() < str.charAt(i)){
                    stack.pop();
                    cnt--;
                }
            }
            stack.push(str.charAt(i));
        }
        
        while(stack.size() != n-k){
            stack.pop();
        }


        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}