import java.io.*;
import java.util.StringTokenizer;

public class P14413_격자판칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] arr = new char[N][M];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            boolean bl;
            if (arr[0][0] == '#') {
                bl = check(arr, '#');
            } else if (arr[0][0] == '.') {
                bl = check(arr, '.');
            } else {
                bl = check(arr,'#') ? true : check(arr, '.');
            }

            if(bl)
                bw.write("#" + test_case + " possible\n");
            else
                bw.write("#" + test_case + " impossible\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(char[][] arr, char start) {
        char evenSum = start;
        char oddSum;
        if (evenSum == '#') {
            oddSum = '.';
        } else {
            oddSum = '#';
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i + j) % 2 == 0 && arr[i][j] == oddSum) {
                    return false;
                } else if ((i + j) % 2 == 1 && arr[i][j] == evenSum) {
                    return false;
                }
            }
        }
        return true;
    }
}