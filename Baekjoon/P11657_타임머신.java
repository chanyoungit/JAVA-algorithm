import java.io.*;
import java.util.StringTokenizer;

class Node_11657 {
    int start;
    int end;
    int weight;

    Node_11657(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class P11657_타임머신 {
    static int N, M;
    static Node_11657[] a;
    static long[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new Node_11657[M];
        len = new long[N + 1];
        for (int i = 1; i <= N; i++) len[i] = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            a[i] = new Node_11657(u, v, w);
        }
        if (!bellmanFord(1))
            System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (len[i] == Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(len[i]);
            }
        }
    }

    static boolean bellmanFord(int s) {
        len[s] = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int start = a[j].start;
                int end = a[j].end;
                int weight = a[j].weight;

                if (len[start] == Integer.MAX_VALUE) continue;
                else {
                    if (len[end] > len[start] + weight) {
                        len[end] = len[start] + weight;

                        if (i == N) return false;
                    }
                }
            }
        }
        return true;
    }
}
