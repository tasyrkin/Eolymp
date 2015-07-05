import java.util.Scanner;

public class Grasshopper {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        long[]dp = new long[n];
        dp[0] = 1;
        for(int i = 0; i < dp.length; i++){
            for(int j = 1; j <=k; j++){
                if(i+j<n){
                    dp[i+j] += dp[i];
                }
            }
        }

        System.out.println(dp[n-1]);
    }
}
