import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P9934_완전이진트리 {
    static ArrayList<Integer>[] al;
    static int[] value;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());                //깊이
        int size = (int) Math.pow(2, K) - 1;                // 이진 트리 노드 개수
        al = new ArrayList[K + 1];                          // 깊이고려하여 배열
        value = new int[size + 1];                          // 인덱스 숫자 고려(0제외)하여 배열 선언
        for (int i = 1; i <= K; i++) al[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < value.length; i++) value[i] = Integer.parseInt(st.nextToken());
        search(1, 1, size);
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < al[i].size(); j++) {
                bw.write(al[i].get(j) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;
        al[depth].add(value[mid]);
        if (depth == K) return;
        search(depth + 1, start, mid - 1);
        search(depth + 1, mid + 1, end);
    }
}