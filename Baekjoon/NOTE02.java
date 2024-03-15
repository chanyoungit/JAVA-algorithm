public class NOTE02 {
    static int sum;
    public static void main(String[] args) {
        sum = 0;
        union(2);
        System.out.println(sum);
    }
    public static void union(int a){
        sum += a;
    }
}