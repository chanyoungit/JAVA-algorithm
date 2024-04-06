import java.io.*;
import java.util.StringTokenizer;

public class P16002_합성수방정식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int seq = i + 1;

            for (int x = 2 + N; x <= 1000000000; x++) {
                if (!isPrime(x) && !isPrime(x - N)) {
                    bw.write("#" + seq + " " + x + " " + (x - N) + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPrime(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}