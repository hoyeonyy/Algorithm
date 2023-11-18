import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int[] visitPerson;
    static int time;
    static int boong;
    static int cnt;
    static int[] timeTable;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tk = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= tk; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int flag = 0;
            time = Integer.parseInt(st.nextToken());
            boong = Integer.parseInt(st.nextToken());
            visitPerson = new int[n];
            String answer = "Possible";
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                visitPerson[i] = Integer.parseInt(st.nextToken());
                if(visitPerson[i] == 0){
                    System.out.println("#" + testCase + " " + "Impossible");
                    flag = 1;
                    break;
                }
            }
            if(flag==1){
                continue;
            }
            timeTable = new int[11111];
            int sum = 0;


            for (int i = 0; i < 11111; i++) {
                if((i+1) % time == 0){
                    sum = sum + boong;
                }
                timeTable[i] = sum;
            }
            Arrays.sort(visitPerson);
            int k = 0;
            for (int person : visitPerson) {
                if(timeTable[person-1] ==0 ){
                    answer = "Impossible";
                }
                else{
                    for (int i = person-1; i < 11111; i++) {
                        timeTable[i]--;
                    }
                }
            }


            System.out.println("#" + testCase + " " + answer);
        }

    }
}