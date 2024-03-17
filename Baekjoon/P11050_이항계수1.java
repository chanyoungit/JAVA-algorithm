import java.io.*;
import java.util.StringTokenizer;

public class P11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        bw.write(D[N][K]+"");
        bw.close();
    }
}
