public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if (x < sizes[i][0]) {
                x = sizes[i][0];
            }

            if (y < sizes[i][1]) {
                y = sizes[i][1];
            }
        }

        int answer = x * y;
        return answer;
    }
}
