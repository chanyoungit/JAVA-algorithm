import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725_트리부모찾기 {
    static ArrayList<Integer>[] A;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            parent[i] = i;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        DFS(1);
        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + " \n");
        }
        bw.close();
    }

    public static void DFS(int a) {
        visit[a] = true;
        for (int i : A[a]) {
            if (!visit[i]) {
                parent[i] = a;
                DFS(i);
            }
        }
    }
}
