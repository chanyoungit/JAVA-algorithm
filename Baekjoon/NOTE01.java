import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NOTE01 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 코드 시작
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j = 1; j <= M; j++) arr[i][j] = ch[j - 1] - '0';
        }

        BFS(1, 1);
        bw.write(arr[N][M] + "");

        // 코드 끝
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            visit[a][b] = true;
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];
                if (x >= 1 && y >= 1 && x <= N && y <= M) {
                    if (arr[x][y] != 0 && !visit[x][y]) {
                        visit[x][y] = true;
                        arr[x][y] = arr[a][b] + 1;
                        queue.add(x);
                        queue.add(y);
                    }
                }
            }
        }
    }
}