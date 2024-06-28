import java.io.*;
import java.util.*;

public class P10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();

        int answer = 0;
        char ch = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' && ch == '(') {
                stack.pop();
                answer += stack.size();
            } else if (arr[i] == ')' && ch == ')') {
                answer += 1;
                stack.pop();
            }

            ch = arr[i];
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}