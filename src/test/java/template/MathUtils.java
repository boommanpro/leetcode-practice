package template;

public class MathUtils {

    public static int min(int... numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int max(int... numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // 计算阶乘的方法
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 计算组合数 C(n, k)
    public static long combination(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
}
