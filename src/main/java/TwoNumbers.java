import java.util.Scanner;

/**
 * http://www.e-olymp.com/ru/problems/115
 */
public class TwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][][]dp = new int[n][2][3];

        dp[0][0][1] = 1;
        dp[0][1][1] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j][1] += dp[i-1][(j+1)%2][1] + dp[i-1][(j+1)%2][2];
                dp[i][j][2] += dp[i-1][j][1];
            }
        }
        int res = 0;
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 3; k++){
                res += dp[n-1][j][k];
            }
        }
        System.out.println(res);
    }
}
