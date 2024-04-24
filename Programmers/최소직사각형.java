public class 최소직사각형 {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (x < sizes[i][0]) {
                x = sizes[i][0];
            }

            if (y < sizes[i][1]) {
                y = sizes[i][1];
            }
        }

        int result = x * y;
        return result;
    }
}
