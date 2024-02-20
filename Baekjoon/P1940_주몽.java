import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (num[i] + num[j] == M) count++;
            }
        }
        System.out.println(count);
    }
}