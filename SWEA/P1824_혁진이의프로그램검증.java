import java.io.*;
import java.util.*;

class P1824_혁진이의프로그램검증 {
    static char[][] arr;
    static int R;
    static int C;
    static String answer;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new char[R][C];
            for (int i = 0; i < R; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            visited = new boolean[16][R][C][4];
            answer = "NO";
            dfs(0, 0, 0, 0);

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // dir == 0 이면 오른쪽, dir == 1 이면 왼쪽
    // dir == 2 이면 위쪽, dir == 3 이면 아래쪽
    public static void dfs(int value, int x, int y, int dir) {
        if (visited[value][x][y][dir]) {
            return;
        } else {
            visited[value][x][y][dir] = true;
        }
        if (arr[x][y] >= '0' && arr[x][y] <= '9') {
            value = arr[x][y] - '0';
            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '<') {
            y -= 1;
            if (y == -1) {
                y = C - 1;
            }

            dir = 1;
            dfs(value, x, y, dir);
        } else if (arr[x][y] == '>') {
            y += 1;
            if (y == C) {
                y = 0;
            }

            dir = 0;
            dfs(value, x, y, dir);
        } else if (arr[x][y] == '^') {
            x -= 1;
            if (x == -1) {
                x = R - 1;
            }

            dir = 2;
            dfs(value, x, y, dir);
        } else if (arr[x][y] == 'v') {
            x += 1;
            if (x == R) {
                x = 0;
            }

            dir = 3;
            dfs(value, x, y, dir);
        } else if (arr[x][y] == '+') {
            value++;
            if (value == 16) {
                value = 0;
            }

            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '-') {
            value--;
            if (value == -1) {
                value = 15;
            }

            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '@') {
            answer = "YES";
            return;
        } else if (arr[x][y] == '.') {
            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '_') {
            if (value == 0) {
                dir = 0;
            } else {
                dir = 1;
            }

            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '|') {
            if (value == 0) {
                dir = 3;
            } else {
                dir = 2;
            }

            if (dir == 0) {
                y += 1;
                if (y == C) {
                    y = 0;
                }
            } else if (dir == 1) {
                y -= 1;
                if (y == -1) {
                    y = C - 1;
                }
            } else if (dir == 2) {
                x -= 1;
                if (x == -1) {
                    x = R - 1;
                }
            } else if (dir == 3) {
                x += 1;
                if (x == R) {
                    x = 0;
                }
            }

            dfs(value, x, y, dir);
        } else if (arr[x][y] == '?') {
            int a = 0;
            int ay = y + 1;
            if (ay == C) {
                ay = 0;
            }

            int b = 1;
            int by = y - 1;
            if (by == -1) {
                by = C - 1;
            }

            int c = 2;
            int cx = x - 1;
            if (cx == -1) {
                cx = R - 1;
            }

            int d = 3;
            int dx = x + 1;
            if (dx == R) {
                dx = 0;
            }
            if (!visited[value][x][ay][a]) {
                dfs(value, x, ay, a);
            }
            if (!visited[value][x][by][b]) {
                dfs(value, x, by, b);
            }
            if (!visited[value][cx][y][c]) {
                dfs(value, cx, y, c);
            }
            if (!visited[value][dx][y][d]) {
                dfs(value, dx, y, d);
            }
        }
    }
}