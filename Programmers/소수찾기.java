import java.util.HashSet;

public class 소수찾기 {
    static boolean[] visit = new boolean[7];
    static HashSet<Integer> set;

    public int solution(String numbers) {
        set = new HashSet<>();

        dfs(numbers, "", 0);


        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    public static void dfs(String numbers, String s, int depth) {
        if (depth >= numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visit[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}