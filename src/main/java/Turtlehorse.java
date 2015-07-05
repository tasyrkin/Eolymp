import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Turtlehorse {

    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][]numbers = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                numbers[i][j] = sc.nextInt();
            }
        }
        int[][]dp = new int[n][m];

        dp[0][0] = numbers[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int newi1 = i+1;
                int newj1 = j+2;
                if(newi1 < n && newj1 < m){
                    dp[newi1][newj1] = Math.max(dp[newi1][newj1], numbers[newi1][newj1]+dp[i][j]);
                }
                int newi2 = i+2;
                int newj2 = j+1;
                if(newi2 < n && newj2 < m){
                    dp[newi2][newj2] = Math.max(dp[newi2][newj2], numbers[newi2][newj2]+dp[i][j]);
                }
            }
        }

        System.out.println(dp[n-1][m-1] == 0?-1:dp[n-1][m-1]);
    }
}