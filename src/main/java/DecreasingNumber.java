
import java.util.Arrays;
import java.util.Scanner;

public class DecreasingNumber {
    public static void main(String[] args) {

        int[]dp = new int[1000001];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i = 1; i < dp.length; i++){
            if(i*2<dp.length){
                dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
            }
            if(i*3<dp.length){
                dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
            }
            if(i+1<dp.length){
                dp[i+1] = Math.min(dp[i] + 1, dp[i+1]);
            }
        }

        final Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
