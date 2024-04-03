import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P19003_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<String> al = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                al.add(st.nextToken());
            }

            int count1 = 0;
            int count2 = 0;

            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder(al.get(i));
                String reverseStr = sb.reverse().toString();
                for (int j = i; j < N; j++) {
                    if (reverseStr.compareTo(al.get(j)) == 0) {
                        if (i == j)
                            count1 = 1;
                        else
                            count2 += 2;
                    }
                }
            }

            int result = (count1 + count2) * M;

            int index = t + 1;
            bw.write("#" + index + " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}