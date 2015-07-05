import java.util.*;

/**
 * http://www.e-olymp.com/ru/problems/798
 */
public class Platforms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]platforms = new int[n];
        for(int i = 0; i < platforms.length; i++){
            platforms[i] = sc.nextInt();
        }
        int[]dp = new int[n];
        int[]prev = new int[n];
        prev[0] = -1;
        for(int i = 1; i < n; i++){

            int prevDelta = platforms[i]-platforms[i-1];
            if(prevDelta < 0)prevDelta*=-1;

            int prevPrevDelta = i>1?platforms[i]-platforms[i-2]:0;
            if(prevPrevDelta<0)prevPrevDelta*=-1;

            int prevEnergy = dp[i-1]+prevDelta;
            int prevPrevEnergy = i>1?(dp[i-2]+3*prevPrevDelta):Integer.MAX_VALUE;

            if(prevEnergy < prevPrevEnergy){
                dp[i] = prevEnergy;
                prev[i] = i-1;
            } else {
                dp[i] = prevPrevEnergy;
                prev[i] = i-2;
            }
        }

        LinkedList<Integer> used = new LinkedList<Integer>();
        int curr = n-1;
        while(curr != -1){
            used.addFirst(curr);
            curr = prev[curr];
        }
        StringBuilder sb = new StringBuilder();
        for(Integer idxUsed : used){
            if(sb.length() > 0)sb.append(" ");
            sb.append(idxUsed+1);
        }
        System.out.println(dp[n-1] + "\n" + used.size()+"\n" + sb.toString());
    }
}
