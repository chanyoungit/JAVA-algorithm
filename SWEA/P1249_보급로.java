import java.io.*;
import java.util.*;

class P1249_보급로 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int N;
    static int answer;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            sum = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    arr[i][j] = (char) (ch[j] - '0');
                }
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(sum[i], Integer.MAX_VALUE);
            }

            answer = Integer.MAX_VALUE;
            sum[0][0] = 0;
            dfs(0, 0);
            bw.write("#" + test_case + " " + sum[N - 1][N - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int a, int b) {
        if (a == N - 1 && b == N - 1) {
            answer = Math.min(answer, sum[a][b]);
            return;
        }

        if (answer < sum[a][b]) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 0 && y >= 0 && x < N && y < N) {
                if (sum[x][y] > sum[a][b] + arr[x][y]) {
                    sum[x][y] = sum[a][b] + arr[x][y];
                    dfs(x, y);
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (sum[x][y] > sum[now[0]][now[1]] + arr[x][y]) {
                        sum[x][y] = sum[now[0]][now[1]] + arr[x][y];
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}