import java.util.ArrayList;

public class 네트워크 {
    static ArrayList<Integer>[] al;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        al = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    al[i].add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    public static void dfs(int i) {
        visited[i] = true;

        for (int num : al[i]) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}
