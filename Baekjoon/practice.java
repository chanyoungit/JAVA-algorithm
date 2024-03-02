import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static boolean[][] visited;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(str.substring(j, j + 1));
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = num[0] + dx[k];
                int y = num[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (!visited[x][y] && A[x][y] != 0) {
                        visited[x][y] = true;
                        A[x][y] = A[num[0]][num[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
