import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            while (true) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    break;
                } else {
                    if (prices[stack.peek()] <= prices[i]) {
                        stack.push(i);
                        break;
                    } else {
                        int time = stack.pop();
                        answer[time] = i - time;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            int time = stack.pop();
            answer[time] = prices.length - 1 - time;
        }

        return answer;
    }
}
