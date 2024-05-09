import java.io.*;
import java.util.*;

public class P1954_달팽이숫자 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            int x = 0;
            int y = 0;

            int cnt = 1;
            int value = 1;
            while (value <= N * N) {
                if (cnt == 1) {
                    while (true) {
                        if (y >= N) {
                            y--;
                            x++;
                            break;
                        }

                        if (arr[x][y] != 0) {
                            y--;
                            x++;
                            break;
                        }

                        arr[x][y] = value;
                        value++;
                        y++;
                    }
                } else if (cnt == 2) {
                    while (true) {
                        if (x >= N) {
                            x--;
                            y--;
                            break;
                        }

                        if (arr[x][y] != 0) {
                            x--;
                            y--;
                            break;
                        }

                        arr[x][y] = value;
                        value++;
                        x++;
                    }
                } else if (cnt == 3) {
                    while (true) {
                        if (y < 0) {
                            y = 0;
                            x--;
                            break;
                        }

                        if (arr[x][y] != 0) {
                            y++;
                            x--;
                            break;
                        }

                        arr[x][y] = value;
                        value++;
                        y--;
                    }
                } else if (cnt == 4) {
                    while (true) {
                        if (x < 0) {
                            x = 0;
                            y++;
                            break;
                        }

                        if (arr[x][y] != 0) {
                            x++;
                            y++;
                            break;
                        }

                        arr[x][y] = value;
                        value++;
                        x--;
                    }
                }

                cnt++;
                if (cnt == 5) {
                    cnt = 1;
                }
            }

            bw.write("#" + test_case + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int max(int start, int[] arr) {
        int max = start;
        for (int i = start; i < N; i++) {
            if (arr[max] <= arr[i]) {
                max = i;
            }
        }

        return max;
    }
}