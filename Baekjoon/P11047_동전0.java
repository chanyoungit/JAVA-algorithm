import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            al.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        while (K != 0) {
            for (int i = al.size() - 1; i >= 0; i--) {
                if (K >= al.get(i)) {
                    count += K / al.get(i);
                    K = K % al.get(i);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
