import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N+1];
        for(int i=1; i<=N; i++)
            wines[i] = Integer.parseInt(br.readLine());
        System.out.println(solution(wines, N));
    }
    private static int solution(int[] wines, int n) {
        int[] dp = new int[n+1];
        dp[1] = wines[1];
        if(n > 1)
            dp[2] = dp[1] + wines[2];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wines[i-1]) + wines[i]);
        }
        int max = -1;
        for(int i : dp)
            max = Math.max(max, i);
        return max;
    }
}