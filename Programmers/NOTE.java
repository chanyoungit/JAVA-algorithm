public class NOTE {
    public static void main(String[] args) {
        int a = 1;
        while (true) {
            if (a == 1) {
                a++;
                continue;
            }
            System.out.println("a = " + a);
            a++;

            if (a == 4) break;
        }
    }
}