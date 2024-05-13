import java.io.*;
import java.util.*;

class P4615_재미있는오셀로게임 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];

            int mid = N / 2;
            arr[mid][mid] = 2;
            arr[mid + 1][mid + 1] = 2;
            arr[mid][mid + 1] = 1;
            arr[mid + 1][mid] = 1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[a][b] = c;
                change(a, b, c);
            }

            int bCount = 0;
            int wCount = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] == 1) {
                        bCount++;
                    } else {
                        wCount++;
                    }
                }
            }

            bw.write("#" + test_case + " " + bCount + " " + wCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void change(int a, int b, int col) {
        for (int i = 0; i < 8; i++) {
            boolean bl = true;

            int x = a + dx[i];
            int y = b + dy[i];

            if (x >= 1 && y >= 1 && x <= N && y <= N) {
                while (arr[x][y] != col && arr[x][y] != 0) {
                    x += dx[i];
                    y += dy[i];

                    if (x <= 0 || y <= 0 || x > N || y > N) {
                        bl = false;
                        break;
                    }
                }

                if (bl) {
                    if (i == 0) {
                        for (int k = y + 1; k < b; k++) {
                            arr[a][k] = col;
                        }
                    } else if (i == 1) {
                        int t = y + 1;
                        for (int k = x + 1; k < a; k++) {
                            arr[k][t] = col;
                            t++;
                        }
                    } else if (i == 2) {
                        for (int k = x + 1; k < a; k++) {
                            arr[k][b] = col;
                        }
                    } else if (i == 3) {
                        int t = y - 1;
                        for (int k = x + 1; k < a; k++) {
                            arr[k][t] = col;
                            t--;
                        }
                    } else if (i == 4) {
                        for (int k = y - 1; k > b; k--) {
                            arr[a][k] = col;
                        }
                    } else if (i == 5) {
                        int t = y - 1;
                        for (int k = x - 1; k > a; k--) {
                            arr[k][t] = col;
                            t--;
                        }
                    } else if (i == 6) {
                        for (int k = x - 1; k > a; k--) {
                            arr[k][b] = col;
                        }
                    } else if (i == 7) {
                        int t = y + 1;
                        for (int k = x - 1; k > a; k--) {
                            arr[k][t] = col;
                            t++;
                        }
                    }
                }
            }
        }
    }
}