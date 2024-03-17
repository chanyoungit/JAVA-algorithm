import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11438_LCA2 {
    static int N, M, K;
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 2^K의 K찾기
        K = -1;
        for (int i = 1; i <= N; i *= 2) K++;

        // LCA 관련 변수 초기화
        parent = new int[K + 1][N + 1];
        depth = new int[N + 1];

        // tree 변수 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // depth 확인
        DFS(1, 1, 0);

        // 2^K까지 parent 채우기
        fillParent();

        // LCA 진행
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int cur, int d, int p) {
        depth[cur] = d;
        parent[0][cur] = p;

        for (int i : tree[cur]) {
            if (i == p) continue;
            DFS(i, d + 1, cur);
        }
    }

    static void fillParent() {
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // depth 맞추기
        for (int i = K; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        // depth를 맞췄는데 같다면 바로 종료
        if (a == b) return a;

        for (int i = K; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }
}
