import java.io.*;

public class P2747_피보나치수 {
    static int[] A;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        for (int i = 0; i <= n; i++) A[i] = -1;
        A[0] = 0;
        A[1] = 1;
//        bw.write(Integer.toString(fibo_topdown(n)));
        bw.write(Integer.toString(fibo_bottomup(n)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int fibo_topdown(int i) {
        if (A[i] != -1) return A[i];
        return A[i] = fibo_topdown(i - 1) + fibo_topdown(i - 2);
    }

    static int fibo_bottomup(int i) {
        if (A[i] != -1) return A[i];
        for (int j = 2; j <= n; j++) {
            A[j] = A[j - 1] + A[j - 2];
        }
        return A[i];
    }
}
