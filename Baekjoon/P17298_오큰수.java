import java.io.*;
import java.util.*;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (arr[stack.peek()] < arr[i]) {
                    while (arr[stack.peek()] < arr[i]) {
                        arr[stack.peek()] = arr[i];
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                }
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                arr[stack.peek()] = -1;
                stack.pop();
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}