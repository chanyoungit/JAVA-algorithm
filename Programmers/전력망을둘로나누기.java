import java.util.ArrayList;

public class 전력망을둘로나누기 {

    class Solution {
        static boolean[] visited;
        static ArrayList<Integer>[] al;

        public int solution(int n, int[][] wires) {
            int min = Integer.MAX_VALUE;
            visited = new boolean[n + 1];

            al = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];

                al[a].add(b);
                al[b].add(a);
            }

            for (int i = 0; i < wires.length; i++) {

                int a = wires[i][0];
                int b = wires[i][1];

                al[a].remove(Integer.valueOf(b));
                al[b].remove(Integer.valueOf(a));

                int count = dfs(1);
                int count2 = n - count;
                int gap = Math.abs(count - count2);
                min = Math.min(min, gap);

                al[a].add(b);
                al[b].add(a);
            }
            return min;
        }

        public int dfs(int v) {
            visited[v] = true;
            int count = 1;

            for (int num : al[v]) {
                if (!visited[num]) {
                    count += dfs(num);
                }
            }

            visited[v] = false;

            return count;
        }
    }
}