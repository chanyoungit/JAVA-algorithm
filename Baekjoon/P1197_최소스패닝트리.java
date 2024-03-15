import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1197 implements Comparable<Node_1197> {
    int start;
    int end;
    int weight;

    Node_1197(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node_1197 o) {
        return this.weight - o.weight;
    }
}

public class P1197_최소스패닝트리 {
    static int[] index;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        index = new int[V + 1];
        sum = 0;
        for (int i = 1; i <= V; i++) index[i] = i;
        PriorityQueue<Node_1197> queue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Node_1197(u, v, w));
        }
        while(!queue.isEmpty()) {
            Node_1197 Node_1197 = queue.poll();
            union(Node_1197.start, Node_1197.end, Node_1197.weight);
        }
        bw.write(sum + "");
        bw.close();
    }

    public static void union(int a, int b, int c) {
        a = find(a);
        b = find(b);
        if (a != b) {
            index[b] = a;
            sum += c;
        }
    }

    public static int find(int a) {
        if (index[a] == a) return a;
        else return index[a] = find(index[a]);
    }
}