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
}
