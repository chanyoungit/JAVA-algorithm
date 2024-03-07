import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge_11657 {
    int start, end, weigth;

    public Edge_11657(int start, int end, int weigth) {
        this.start = start;
        this.end = end;
        this.weigth = weigth;
    }
}

class P11657_타임머신 {
    static int[] dist;
    static int N, M;
    static ArrayList<Edge_11657> al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList<>(N + 1);
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            al.add(new Edge_11657(s, e, w));
        }
        StringBuilder sb = new StringBuilder();

        if (bellmanFord()) {
            for (int i = 2; i <= N; i++)
                sb.append(dist[i] == Integer.MAX_VALUE ? "-1\n" : dist[i] + "\n");
        } else {
            sb.append("-1\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static boolean bellmanFord() {
        dist[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge_11657 edge = al.get(j);
                if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weigth)
                    dist[edge.end] = dist[edge.start] + edge.weigth;
            }
        }

        for (int i = 0; i < M; i++) {
            Edge_11657 edge = al.get(i);
            if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weigth)
                return false;
        }

        return true;
    }
}
