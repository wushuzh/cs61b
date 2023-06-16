public class Fib {
    public static int fib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println("The first 9 numbers should be 0 1 1 2 3 5 8 13 21 ");
        System.out.print("My programming produces this: ");
        for(int i = 1; i < 10; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
