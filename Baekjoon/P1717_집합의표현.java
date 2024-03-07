import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_집합의표현 {
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new int[n + 1];
        for (int i = 0; i <= n; i++) A[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (question == 0) union(a, b);
            else {
                int result1 = 0;
                int result2 = 0;
                result1 = find(a);
                result2 = find(b);
                if (result1 == result2) System.out.println("YES");
                else if (result1 != result2) System.out.println("NO");
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a > b) A[a] = b;
            else A[b] = a;
        }
    }

    public static int find(int a) {
        if (A[a] == a) return a;
        else return A[a] = find(A[a]);
    }
}
