import java.io.*;
import java.util.*;

public class P9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char[] arr = st.nextToken().toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    stack.push(arr[j]);
                }

                while (!stack.empty()) {
                    sb.append(stack.pop());
                }

                sb.append(" ");
            }

            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}