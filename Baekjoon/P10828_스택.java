import java.util.*;
import java.io.*;

public class P10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (str.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (str.equals("empty")) {
                if (stack.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (str.equals("top")) {
                if (stack.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}