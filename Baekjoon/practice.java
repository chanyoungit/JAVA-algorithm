import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_pra {
    int end;
    int weight;

    public Node_pra(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[V + 1];
        int[] result = new int[V + 1];
        ArrayList<Node_pra>[] al = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            al[i] = new ArrayList<Node_pra>();
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            al[u].add(new Node_pra(v, w));
        }
        PriorityQueue<Node_pra> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        result[K] = 0;
        queue.add(new Node_pra(K, 0));

        while (!queue.isEmpty()) {
            Node_pra now = queue.poll();
            if (!visit[now.end]) visit[now.end] = true;
            for (int i = 0; i < al[now.end].size(); i++) {
                Node_pra next = al[now.end].get(i);
                if (!visit[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    queue.add(new Node_pra(next.end, result[next.end]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(result[i]);
        }
    }
}
