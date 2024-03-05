import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] al;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            al = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) al[j] = new ArrayList<Integer>();
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                al[s].add(e);
                al[e].add(s);
            }
            for (int j = 1; j <= V; j++) {
                if (isEven) DFS(j);
                else break;
            }

            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (int i : al[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else {
                if (check[node] == check[i]) {
                    isEven = false;
                }
            }
        }
    }
}
