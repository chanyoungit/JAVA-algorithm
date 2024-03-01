import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20920_영단어암기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> words = new ArrayList<>(hm.keySet());
        Collections.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (hm.get(o1) != hm.get(o2))
                    return hm.get(o2) - hm.get(o1);
                if (o1.length() != o2.length())
                    return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : words)
            sb.append(str + "\n");
        System.out.println(sb);
    }
}
