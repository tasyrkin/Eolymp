import java.util.Scanner;

public class AskWalli {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int ex = sc.nextInt();
        int ey = sc.nextInt();

        final int MOD = 1000000007;

        int[][]dp = new int[ex+1][ey+1];

        dp[0][0] = 1;

        for(int i = 0; i <= ex; i++){
            for(int j = 0; j <= ey; j++){
                if(i+1<=ex && ((i+1)*j)%2==0 && i+1>=j){
                    dp[i+1][j] = (dp[i+1][j] + dp[i][j])%MOD;
                }
                if(j+1<=ey && ((j+1)*i)%2 == 0 && i>=j+1){
                    dp[i][j+1] = (dp[i][j+1] + dp[i][j])%MOD;
                }
            }
        }
        System.out.println(dp[ex][ey]);
    }
}
