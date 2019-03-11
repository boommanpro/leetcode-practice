package hashTable;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode204Test {


    @Test
    public void leetcode204Test() {

        // 质数又称素数。指整数在一个大于1的自然数中，除了1和此整数自身外，没法被其他自然数整除的数。
        // 换句话说，只有两个正因数（1和自己）的自然数即为素数。比1大但不是素数的数称为合数。1和0既非素数也非合数。素数在数论中有着很重要的作用。


        // Eratosthenes筛选法求解质数


        int i = countPrimes(10);
        System.out.println(String.format("result:%s", i));
    }

    public int countPrimes(int n) {

        //Sieve
        if (n <= 2) return 0;
        boolean[] sieve = new boolean[n + 1];
        sieve[2] = true;
        for (int i = 3; i < n; i += 2) {
            sieve[i] = true;
        }

        for (int p = 3; p * p <= n; p++) {
            if (sieve[p]) {
                for (int i = p + p; i <= n; i += p) {
                    sieve[i] = false;
                }
            }
        }
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            count += sieve[i] ? 1 : 0;
        }
        return count;

    }


    public boolean checkPrimes(int a)
    {
        for (int i = 2;i < a;i++)
        {
            if (0 == a%i)
            {
                return false;
            }
        }
        return true;
    }
}
