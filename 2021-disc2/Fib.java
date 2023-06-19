public class Fib {
    public static int fib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n-2);
    }
    
    public static int fib2(int n, int k, int f0, int f1) {
        if (n - 1 == k) {
            return f0;
        } else {
            return fib2(n, k+1, f1, f0 + f1);
        }
    }

    public static void main(String[] args) {
        System.out.println("The first 9 numbers should be 0 1 1 2 3 5 8 13 21 ");
        System.out.print("My programmer fib1 produces : ");
        for(int i = 1; i < 10; i++) {
            System.out.print(fib(i) + " ");
        }

        System.out.println();
        System.out.print("My programmer fib2 produces : ");
        for(int i = 1; i < 10; i++) {
            System.out.print(fib2(i, 0, 0, 1) + " ");
        }
    }
}
