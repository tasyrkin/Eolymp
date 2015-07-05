import java.util.Arrays;
import java.util.Scanner;

public class Ones {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[]dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                if(i-j>=0){
                    dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
                }
                if(i%j == 0){
                    dp[i] = Math.min(dp[i], dp[i/j]+dp[j]);
                }
            }
        }

        System.out.println(dp[n]);

    }
}
