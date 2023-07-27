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

        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < str.length(); i++) {
            if(Character.isAlphabetic(str.charAt(i))){
                sb.append(str.charAt(i));
            }
            else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')'){
                while (stack.peek() != '('){
                    char tmp = stack.pop();
                    sb.append(tmp);
                }
                stack.pop();
            }
            else{
                if(!stack.isEmpty()){
                    if(rank(str.charAt(i)) > rank(stack.peek())){
                        stack.push(str.charAt(i));
                    }
                    else{
                        while (!stack.isEmpty() && rank(str.charAt(i)) <=rank(stack.peek())){
                            char tmp = stack.pop();
                            sb.append(tmp);
                        }
                        stack.push(str.charAt(i));
                    }
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()){
            char tmp = stack.pop();
            sb.append(tmp);
        }

        System.out.println(sb);
    }
    public static int rank(char ch){

        if(ch == '+' || ch == '-'){
            return 1;
        }else if (ch == '*' || ch == '/'){
            return 2;
        }
        else return 0;
    }
}