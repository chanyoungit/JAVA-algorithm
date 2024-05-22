import java.io.*;
import java.util.*;

class P16940_BFS스페셜저지 {
    static ArrayList<Integer>[] al;
    static boolean[] visited;
    static int N;
    static int[] answer;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
        }

        answer = new int[N];
        index = 0;
    }

    public static void bfs (int a) {
        visited[a] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while(!queue.isEmpty()){
            int num = queue.poll();

            for (int i : al[num]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
