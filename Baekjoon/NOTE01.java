import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NOTE01 {
    static ArrayList<Integer>[] al;
    static boolean[] visit;
    static int[] check;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            al = new ArrayList[V + 1];
            visit = new boolean[V + 1];
            check = new int[V + 1];
            result = true;
            for (int j = 1; j <= V; j++) al[j] = new ArrayList<>();
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                al[u].add(v);
                al[v].add(u);
            }
            for (int j = 1; j <= V; j++) {
                if (!visit[j]) DFS(j);
            }
//            for (int t = 1; t <= V; t++) {
//                System.out.println(check[t]);
//            }
//            for (int t = 1; t <= V; t++) {
//                System.out.printf("al[%d] : ", t);
//                for(int k : al[t]){
//                    System.out.printf("%d ", k);
//                }
//                System.out.println();
//            }
            if (result) bw.write("YES\n");
            else bw.write("NO\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int i) {
        visit[i] = true;
        for (int j : al[i]) {
            if (!visit[j]) {
                check[j] = (check[i] + 1) % 2;
                DFS(j);
            } else {
                if (check[j] == check[i]) result = false;
            }
        }
    }
}