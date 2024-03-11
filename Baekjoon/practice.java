import java.io.*;
import java.util.StringTokenizer;

public class practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] A = new int[101][101];
        int width = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s + 1; j <= s + 10; j++) {
                if (j >= 101) break;
                for (int k = e + 1; k <= e + 10; k++) {
                    if (k >= 101) break;
                    if (A[j][k] == 1) continue;
                    A[j][k] = 1;
                    width++;
                }
            }
        }
        bw.write(width + "");
        bw.close();
    }
}