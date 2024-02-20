import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2018_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = 1;

        while (end != N) {
            if (sum == N) {
                result++;
                end++;
                sum += end;
            } else if (sum <= N) {
                end++;
                sum += end;
            } else if (sum >= N) {
                sum -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}

