import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11437_LCA {
    static int[] parent;
    static int[] depth;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 노드의 개수 받기
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];
        tree = new ArrayList[N + 1];

        // 트리 배열 만들고 연결되어 있는 정점 받기
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        //DFS를 이용해서 depth, parent 데이터 설정
        DFS(1, 1, 0);

        int M = Integer.parseInt(br.readLine());
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
        parent[cur] = p;

        for (int a : tree[cur]) {
            if (a == p) continue;
            DFS(a, d + 1, cur);
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        while (ah > bh) {
            a = parent[a];
            ah--;
        }
        while (bh > ah) {
            b = parent[b];
            bh--;
        }

        while (true) {
            if (a == b)
                return a;
            a = parent[a];
            b = parent[b];
        }
    }
}
