import java.io.*;
import java.util.StringTokenizer;

public class P1018_체스판다시칠하기 {
    static boolean[][] bl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bl = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == 'W') bl[i][j] = true; // 화이트이면 true
                else bl[i][j] = false;
            }
        }
        int end_x = N - 7;
        int end_y = M - 7;
        int count = 0;
        int min = 64;
        for (int i = 0; i < end_x; i++) {
            for (int j = 0; j < end_y; j++) {
                count = find(i, j);
                if (min > count) min = count;
            }
        }
        bw.write(min + "");
        bw.close();
    }

    public static int find(int a, int b) {
        int end_x = a + 8;
        int end_y = b + 8;
        boolean TF = true; // 화이트
        int count = 0;
        for (int i = a; i < end_x; i++) {
            for (int j = b; j < end_y; j++) {
                if (bl[i][j] != TF) count++;
                TF = !TF;
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count);
        return count;
    }
}
