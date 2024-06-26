import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    private static void solution(int n, int mod) {
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        solution(N, 15746);
        System.out.println(dp[N]);
    }
}