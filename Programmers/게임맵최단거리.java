import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps, 0, 0);

        int answer = maps[maps.length - 1][maps[0].length - 1];

        if (answer == 0 || answer == 1) {
            return -1;
        } else {
            return answer;
        }
    }

    public void bfs(int[][] maps, int t, int k) {
        visited[t][k] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{t, k});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int a = arr[0];
            int b = arr[1];

            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];

                if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        maps[x][y] += maps[a][b];
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
