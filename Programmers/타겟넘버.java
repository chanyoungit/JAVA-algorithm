public class 타겟넘버 {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        dfs(numbers, 0, target, 0);

        return answer;
    }

    public static void dfs(int[] numbers, int sum, int target, int depth) {
        if (depth >= numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, sum + numbers[depth], target, depth + 1);
        dfs(numbers, sum - numbers[depth], target, depth + 1);
    }
}
