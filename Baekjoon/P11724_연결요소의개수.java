import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    static boolean[] visited;
    static ArrayList<Integer>[] al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            al[s].add(e);
            al[e].add(s);
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int num : al[i]) {
            if (!visited[num]) DFS(num);
        }
    }
}
