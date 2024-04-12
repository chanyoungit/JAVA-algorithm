import java.io.*;
import java.util.StringTokenizer;

public class P11315_오목판정 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            boolean bl = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 'o') {
                        bl = check_row(arr, i, j) || check_col(arr, i, j) || check_cross1(arr, i, j)
                                || check_cross2(arr, i, j);
                        if (bl) {
                            break;
                        }
                    }
                }
                if (bl) {
                    break;
                }
            }
            if (bl) {
                bw.write("#" + test_case + " YES\n");
            } else {
                bw.write("#" + test_case + " NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check_row(char[][] arr, int a, int b) {
        int count = 0;
        while (count != 5) {
            count++;
            if (arr[a][b] != 'o') {
                return false;
            }
            b++;
            if (count != 5 && b == N) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_col(char[][] arr, int a, int b) {
        int count = 0;
        while (count != 5) {
            count++;
            if (arr[a][b] != 'o') {
                return false;
            }
            a++;
            if (count != 5 && a == N) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_cross1(char[][] arr, int a, int b) {
        int count = 0;
        while (count != 5) {
            count++;
            if (arr[a][b] != 'o') {
                return false;
            }
            a++;
            b++;
            if (count != 5 && a == N) {
                return false;
            }
            if (count != 5 && b == N) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_cross2(char[][] arr, int a, int b) {
        int count = 0;
        while (count != 5) {
            count++;
            if (arr[a][b] != 'o') {
                return false;
            }
            a++;
            b--;
            if (count != 5 && a == N) {
                return false;
            }
            if (count != 5 && b == -1) {
                return false;
            }
        }
        return true;
    }
}