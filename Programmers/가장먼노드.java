import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    static boolean[] visited;
    static ArrayList<Integer>[] al;
    static int depth = 0;
    static int maxDepth = 0;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        visited = new boolean[n + 1];
        al = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            al[a].add(b);
            al[b].add(a);
        }

        bfs(1, 1);
        System.out.println("maxDepth = " + maxDepth);
        System.out.println("depth = " + depth);
    }

    public static void bfs(int a, int cnt) {
        visited[a] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, cnt});

        while (!queue.isEmpty()) {
            int[] num = queue.poll();

            if (maxDepth < num[1]) {
                maxDepth = num[1];
                depth = 1;
            } else if (maxDepth == num[1]) {
                depth++;
            }

            for (int i : al[num[0]]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, num[1] + 1});
                }
            }
        }
    }
}
