import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (hm.get(a) != null && hm.get(a) == 1) bw.write(1 + " ");
            else if (hm.get(a) == null) bw.write(0 + " ");
        }
        bw.close();
    }
}
