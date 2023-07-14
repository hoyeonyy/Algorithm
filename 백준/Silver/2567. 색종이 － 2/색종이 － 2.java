import java.util.Scanner;

public class Main {

//    public ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
//
//
//
//
//
//        return answer;
//
//    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[][] a = new int[102][102];
        for (int k = 0; k < n; k++) {
            int p=sc.nextInt();
            int q=sc.nextInt();
            for (int i = q+1; i <= q+10; i++) {
                for (int j = p+1; j <= p+10; j++) {
                    a[i][j]=1;
                }
            }
        }


        int cnt=0;
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                if(a[i][j]==1) {
                    for (int k = 0; k < 4; k++) {
                        int y=i+ dy[k];
                        int x=j+ dx[k];
                        if(x<0 || y<0 || x>=102 || y>=102)continue;
                        if(a[y][x]==0) {
                            cnt+=1;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}