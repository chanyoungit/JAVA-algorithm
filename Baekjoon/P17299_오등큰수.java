import java.io.*;
import java.util.*;

public class P17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (map.get(arr[stack.peek()]) < map.get(arr[i])) {
                    while (!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                        answer[stack.pop()] = arr[i];
                    }
                }
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}