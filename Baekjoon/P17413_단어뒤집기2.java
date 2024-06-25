import java.io.*;
import java.util.*;

public class P17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(arr[i]);
            } else if (arr[i] == '>') {
                flag = false;
                sb.append(arr[i]);
            } else if (flag) {
                sb.append(arr[i]);
            } else if (!flag && arr[i] == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(arr[i]);
            } else if (!flag) {
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}