import java.io.*;
import java.util.StringTokenizer;

public class P11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] A = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) A[i][j] = 0;
                else A[i][j] = 1000000000;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[a][b] = Math.min(A[a][b], c);
        }
        for (int K = 1; K <= n; K++) {
            for (int S = 1; S <= n; S++) {
                for (int E = 1; E <= n; E++) {
                    A[S][E] = Math.min(A[S][E], A[S][K] + A[K][E]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i][j] == 1000000000) bw.write(0 + " ");
                else bw.write(A[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
