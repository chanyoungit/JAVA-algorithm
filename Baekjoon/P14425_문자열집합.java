import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> hs = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            hs.add(input);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (hs.contains(check)) count++;
        }
        bw.write(count + "");
        bw.close();
    }
}