package template;

public class StringOperationUtils {


    //lps函数的i位置是以i结尾的最长前缀的长度
    public static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1;
        int j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    //z函数的i位置是以i开始的最长前缀的长度
    public static int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int L = 0;
        int R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                R = L = i;
            } else {
                int k = i - L;
                if (z[k] < R - i + 1) {
                    z[i] = z[k];
                    continue;
                }
                L = i;
            }
            z[i] = extendCompute(s, L, R);
            R = z[i] + L - 1;
        }
        return z;
    }

    private static int extendCompute(String s, int l, int r) {
        int n = s.length();
        while (r < n && s.charAt(r - l) == s.charAt(r)) {
            r++;
        }
        return r - l;
    }

    //z函数的i位置是以i开始的最长前缀的长度
    public static int[] calcZ(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] z = new int[n];
        int boxL = 0;
        int boxR = 0; // z-box 左右边界
        for (int i = 1; i < n; i++) {
            if (i <= boxR) {
                z[i] = Math.min(z[i - boxL], boxR - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                boxL = i;
                boxR = i + z[i];
                z[i]++;
            }
        }
        return z;
    }

}
