import java.util.Scanner;

/**
 * http://www.e-olymp.com/ru/problems/263
 * 88% accepted, results are randomly TLEd
 */
public class ThreeOnes {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][][]dp = new int[n][2][3];
        dp[0][0][0] = 1;
        dp[0][1][1] = 1;

        for(int i = 1; i < n; i++){
            dp[i][0][0] += (dp[i-1][0][0] + dp[i-1][1][1] + dp[i-1][1][2]) % 12345;
            dp[i][1][1] += dp[i-1][0][0];
            dp[i][1][2] += dp[i-1][1][1];
        }

        int res = (dp[n-1][0][0] + dp[n-1][1][1] + + dp[n-1][1][2]) % 12345;

        System.out.println(res);

    }
}
