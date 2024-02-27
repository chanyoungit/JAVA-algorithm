import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20920_영단어암기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] word = new String[N];
        for (int i = 0; i < N; i++) word[i] = br.readLine();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (word[i].length() >= M) count++;
        }
        String[] c_word = new String[count];
        int a = 0;
        for (int i = 0; i < N; i++) {
            if (word[i].length() >= M) {
                c_word[a] = word[i];
                a++;
            }
        }

    }
}
