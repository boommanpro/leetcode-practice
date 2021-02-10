package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest567 {
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 270 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> dict = new HashMap<>();
            for (char c : s1.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> windows = new HashMap<>();
            int target = dict.keySet().size();
            int curr = 0;
            for (int l = 0, r = 0; r < s2.length(); r++) {
                char c = s2.charAt(r);
                if (!dict.containsKey(c)) {
                    windows.clear();
                    l = r;
                    l++;
                    curr = 0;
                    continue;
                } else {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (windows.get(c).equals(dict.get(c))) {
                        curr++;
                    } else if (windows.get(c).compareTo(dict.get(c)) > 0) {
                        while (windows.get(c).compareTo(dict.get(c)) > 0) {
                            char temp = s2.charAt(l);
                            if (dict.get(temp).equals(windows.get(temp))) {
                                curr--;
                            }
                            windows.put(temp, windows.get(temp) - 1);
                            l++;
                        }
                    }
                }
                if (curr == target) {
                    return true;
                }
            }
            return false;
        }


        public boolean checkInclusion0(String s1, String s2) {
            char[] pattern = s1.toCharArray();
            char[] text = s2.toCharArray();

            int pLen = s1.length();
            int tLen = s2.length();

            int[] pFreq = new int[26];
            int[] winFreq = new int[26];

            for (int i = 0; i < pLen; i++) {
                pFreq[pattern[i] - 'a']++;
            }

            int pCount = 0;
            for (int i = 0; i < 26; i++) {
                if (pFreq[i] > 0) {
                    pCount++;
                }
            }

            int left = 0;
            int right = 0;
            // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
            int winCount = 0;
            while (right < tLen) {
                if (pFreq[text[right] - 'a'] > 0) {
                    winFreq[text[right] - 'a']++;
                    if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                        winCount++;
                    }
                }
                right++;

                while (pCount == winCount) {
                    if (right - left == pLen) {
                        System.out.printf("%d-%d%n", left, right);
                        return true;
                    }
                    if (pFreq[text[left] - 'a'] > 0) {
                        winFreq[text[left] - 'a']--;
                        if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                            winCount--;
                        }
                    }
                    left++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.checkInclusion("ab", "eidbaooo"));
            Assert.assertFalse(solution.checkInclusion("ab", "eidboaoo"));
            Assert.assertFalse(solution.checkInclusion("hello", "ooolleoooleh"));
            Assert.assertTrue(solution.checkInclusion("vuocwszndxhpilvfujnmakne",
                    "vxivzcmyxxvvlchcnbirwatjuloyulmrwfiknxqhkclnubtxbxmkngxtauarrbaxnbpobwvsvzvitycqfrpulnmivncjuxxhntxpmiuojvbfsfdwjbqdiymwbvxlrrxedtdhnyrxyijtlzwirpnfqsooedatollvosgutcxidziubcgrwxskketqaxqslfrhybltsmjyshjopblwszlcibvgvwkabrwqhjunjbjqgguxjupxphldyrzmjazqpdsxmljdxfzutgbxddrpkzkcaosuyouszqdvlrjpzywrompedzyxvvvwglftjvaxrjgfztaqxqfxgjtvmsplsvjzyizywglfcsknmpvaagetggcjzpjoklpmzvfqxlryziuggyrdcrbcgepvnwovfgtiqxgjqkvlukzcmminsghqqkzydfabvpkuegaoprkufbuoqvectqpvtunjxtdjhteoakweecnaocvsllbwrotxcigtwoehqpvalqwuhmsbdngocfnewhyypfmhfllpvcjllaqefpcyypsuevxokcujejhydbfgyinjlwhiuecpzvjmttlvxasgfpetprrbiumeroptqhfsbqrxfhvkbsecuimklqjmbvicelsxglbdctbbsxhmklwcmntodsoutdtesawojotnqfjnwbvhbbescbllmjwevqxandaxpiqscqhwcyulrxukjbdismrhhyvuwzphuvcderanzzkfqoxjcclornlkmatzpapttbkjnsjpmqyaoznrudwtqfjsnnyhhclcentngrjhaxyocmkdeobotrcjlofqdchcarwtjvwhjwnpkvvidmnfzluuxseacnomprtwpwrpkjknlagdcjhglenkmuunalbmgvjaijnasegddfsydyamgjgaujqwehbhxniwhgljshdcmhgqrjyoyltajgdxerxoqdbgrpxgriquhkextrlfhrmpkqkcwoyfwcszztdicqruwilxzqdmiggfagkacbpglqwijgohwxggfjfkmvozkzihitcniooezootwebkntcpgvhikdapbyxwfgjvhsboxodnedpcoiqndeasbyryoxetfygqqnfwikejcrgrqmeffxgcskzeyhpedjsxxxfvqjrklsdczmdhrnfnyjrukzxgqpgtxeswxqlczcfhvypkvosdutpidivzixunwynhwaizruqnnozghmwinjazrkmghdmrwmgvcaerbfwphsmiyjutsjnlgcmdsutwffxojyszaxgawjyypboztzqpjijcsqgtaavsduwjqexwhxkazaejgkchxentxjwpnjfauddhafdbqznbcfzquohewtfzdmwpcdhjxrtcduxmuuracdwkrqkbreiuoubqirjgoxkrejvoyrzmvoxpxsagkyggqesprqrtvbnptoqpmfgitkpzfchqlotdccryzwbnmyieufdhshlaycrfszvipkdlwsfntnqszftlbcoxusavav"));
        }
    }
}