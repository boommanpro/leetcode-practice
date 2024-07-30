package template;

import java.util.Arrays;

public class MathAlgorithm {

    public static boolean[] fastCalcPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static boolean[] slowCalcPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) isPrime[i] = true;
        }
        return isPrime;
    }

    public static boolean[] getPrimeArray(int n) {
        int MX = n + 1;
        boolean[] PRIME = new boolean[MX];
        Arrays.fill(PRIME, true);
        PRIME[1] = false;
        for (int i = 2; i * i < MX; i++) {
            if (!PRIME[i]) continue;
            for (int j = i * i; j < MX; j += i) {
                PRIME[j] = false; // j 是质数 i 的倍数
            }
        }
        return PRIME;
    }

    public static long includeExclusionPrinciple(long m, int[] arr) {
        long cnt = 0;
        int n = arr.length;
        for (int i = 1; i < 1 << n; i++) {
            long lcmRes = 1;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    lcmRes = lcm(lcmRes, arr[j]);
                }
            }
            cnt += Integer.bitCount(i) % 2 == 1 ? m / lcmRes : -m / lcmRes;
        }
        return cnt;
    }


    public static boolean[] getNotPrimeArray(int n) {
        int MX = n + 1;
        boolean[] NOT_PRIME = new boolean[MX];
        NOT_PRIME[1] = true;
        for (int i = 2; i * i < MX; i++) {
            if (NOT_PRIME[i]) continue;
            for (int j = i * i; j < MX; j += i) {
                NOT_PRIME[j] = true; // j 是质数 i 的倍数
            }
        }
        return NOT_PRIME;
    }

    // 判断整数 n 是否是素数
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int powMod(int x, int y, int mod) {
        int res = 1;
        while (y != 0) {
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }


}
