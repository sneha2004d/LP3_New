public class FibonacciBoth {

    // 🔹 Recursive function to calculate nth Fibonacci number
    static int fibRecursive(int n) {
        if (n <= 1) // base case
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // 🔹 Non-recursive (iterative) function to print series
    static void fibIterative(int n) {
        int a = 0, b = 1;
        System.out.println("Fibonacci Series (Non-Recursive):");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10; // number of terms

        // 🔸 Non-Recursive
        fibIterative(n);

        // 🔸 Recursive
        System.out.println("Fibonacci Series (Recursive):");
        for (int i = 0; i < n; i++)
            System.out.print(fibRecursive(i) + " ");
        System.out.println();
    }
}
