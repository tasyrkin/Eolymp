import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.e-olymp.com/ru/problems/1529
 * Last test: WA
 */
public class FenceRepair {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {

            char[] fence = sc.next().toCharArray();

            double[][] dp = new double[fence.length][fence.length];

            //solve(fence, dp, 0, fence.length - 1);

            for(int i = 0; i < fence.length; i++){
                if(fence[i] == 'X'){
                    dp[i][i] = 1.;
                } else {
                    dp[i][i] = 0.;
                }
            }

            for(int length = 2; length <= fence.length; length++){
                double sqrt = Math.sqrt(length);
                for(int i = 0; i+length <= fence.length; i++){
                    dp[i][i+length-1] =
                            Math.min(sqrt,
                                Math.min(dp[i][i]+dp[i+1][i+length-1],
                                         dp[i][i+length-2]+dp[i+length-1][i+length-1])
                            );
                }
            }

            System.out.println(String.format("%.04f", dp[0][fence.length - 1]));
        }

    }

    private static void solve(char[] fence, Double[][] dp, int start, int end) {


        if(start>end)return;

        if(dp[start][end] != null)return;

        if(start == end){
            if(fence[start] == 'X'){
                dp[start][start] = 1.;
            } else {
                dp[start][start] = 0.;
            }
            return;
        }

        if(start<=end-1 && dp[start][end-1]==null) {
            solve(fence, dp, start, end - 1);
        }
        if(start+1<=end && dp[start+1][end]==null) {
            solve(fence, dp, start + 1, end);
        }

        dp[start][end] = Math.min(Math.sqrt(end-start+1), Math.min(dp[start][end-1]+dp[end][end], dp[start][start]+dp[start+1][end]));

    }
}
