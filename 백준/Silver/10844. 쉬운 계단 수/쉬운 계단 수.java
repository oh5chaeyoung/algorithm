import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long check(int N, int mod) {
      long[][] dp = new long[N+1][10];
      for(int i=1; i<=9; i++) {
          dp[1][i] = 1;
      }
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j==0)    dp[i][j] = dp[i-1][1] % mod;
                else if(j==9)    dp[i][j] = dp[i-1][8] % mod;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        long sum = 0;
        for(int i=0; i<=9; i++) {
            sum += dp[N][i];
        }
        return sum % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = check(N, 1000000000);
        System.out.println(result);
    }
}