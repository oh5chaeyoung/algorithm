import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	static char[][] map;
	static boolean[] visited;
	static int[] dr, dc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[26];
		dr = new int[]{1, 0, -1, 0};
		dc = new int[]{0, 1, 0, -1};
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		ans = 1;
		visited[map[0][0] - 65] = true;
		go(0, 0, 1);
		System.out.println(ans);
	}

	private static void go(int r, int c, int cnt) {
	
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!outOfRange(nr, nc) && !visited[map[nr][nc] - 65]) {
				visited[map[nr][nc] - 65] = true;
				go(nr, nc, cnt + 1);
				visited[map[nr][nc] - 65] = false;
			}

		}
		
		ans = Math.max(ans, cnt);
		
	}

	private static boolean outOfRange(int nr, int nc) {
		if(nr < 0 || nr >= R || nc < 0 || nc >= C)
			return true;
		return false;
	}

}