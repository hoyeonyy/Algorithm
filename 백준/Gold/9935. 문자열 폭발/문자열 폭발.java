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


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String bomb = sc.next();
        int bomb_size = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size()>= bomb_size) {
                boolean flag = true;

                for(int j=0; j<bomb_size; j++) {
                    if(stack.get(stack.size()-bomb_size+j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<bomb_size; j++) {
                        stack.pop();
                    }
                }
            }

        }


        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        if(sb.length()==0){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb);
        }
    }
}