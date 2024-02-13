import java.io.*;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String sNum = br.readLine();
        StringTokenizer st = new StringTokenizer(sNum);
        int[] aa = new int[N];
        for (int i = 0; i < N; i++) {
            aa[i] = Integer.parseInt(st.nextToken());
        }

        int start_index = 0;
        int end_index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                start_index = aa[i];
                end_index = aa[j];
                if (start_index + end_index == M)
                    count++;
            }
        }
        System.out.println(count);
    }
}
