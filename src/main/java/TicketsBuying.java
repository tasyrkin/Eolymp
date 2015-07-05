import java.util.Scanner;

public class TicketsBuying {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[]a = new int[n];
        int[]b = new int[n];
        int[]c = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int[][]dp = new int[n+1][4];

        for(int i = 1; i <= n; i++){
            int prevOne = a[i-1]+dp[i-1][1];
            int prevTwo = i>1?(b[i-2]+dp[i-2][2]):Integer.MAX_VALUE;
            int prevThree = i>2?(c[i-3]+dp[i-3][3]):Integer.MAX_VALUE;

            dp[i][1] = Math.min(prevOne, Math.min(prevTwo, prevThree));
            dp[i][2] = Math.min(prevOne, Math.min(prevTwo, prevThree));
            dp[i][3] = Math.min(prevOne, Math.min(prevTwo, prevThree));
            dp[i][0] = Math.min(b[i-1]+dp[i-1][2], i>1?c[i-2]+dp[i-2][3]:Integer.MAX_VALUE);
        }

        System.out.println(Math.min(dp[n][1], dp[n][0]));
    }
}
