import java.io.*;
import java.util.*;

public class P1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char[] arr = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack1.push(arr[i]);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("L")) {
                if (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else if (str.equals("D")) {
                if (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else if (str.equals("B")) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else if (str.equals("P")) {
                String str1 = st.nextToken();
                stack1.push(str1.charAt(0));
            }
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb.append(stack1.pop());
        }

        bw.write(sb.reverse().toString() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}