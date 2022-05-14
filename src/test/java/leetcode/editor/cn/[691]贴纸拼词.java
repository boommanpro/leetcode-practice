package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest691 {
//我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。 
//
// 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。 
//
// 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。 
//
// 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。 
//
// 
//
// 示例 1： 
//
// 
//输入： stickers = ["with","example","science"], target = "thehat"
//输出：3
//解释：
//我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
//把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
//此外，这是形成目标字符串所需的最小贴纸数量。
// 
//
// 示例 2: 
//
// 
//输入：stickers = ["notice","possible"], target = "basicbasic"
//输出：-1
//解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。 
//
// 
//
// 提示: 
//
// 
// n == stickers.length 
// 1 <= n <= 50 
// 1 <= stickers[i].length <= 10 
// 1 <= target <= 15 
// stickers[i] 和 target 由小写英文单词组成 
// 
// Related Topics 位运算 动态规划 回溯 状态压缩 👍 153 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minStickers(String[] stickers, String target) {
            //判断是否包含所有字符串
            TreeMap<Character, Integer> dict = new TreeMap<>();
            for (char c : target.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            Map<Character, Boolean> findDict = dict.keySet()
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), character -> false));
            Map<String, Map<Character, Integer>> stickerDict = new HashMap<>();
            for (String str : stickers) {
                if (stickerDict.containsKey(str)) {
                    continue;
                }
                Map<Character, Integer> curr = new HashMap<>();
                for (char c : str.toCharArray()) {
                    if (dict.containsKey(c)) {
                        curr.put(c, curr.getOrDefault(c, 0) + 1);
                    }
                    findDict.put(c, true);
                }
                stickerDict.put(str, curr);
            }
            if (findDict.containsValue(false)) {
                return -1;
            }
            target = genTarget(dict);
            stickerDict = reduceSearchVolume(stickerDict, target);
            return searchMinOperation(stickerDict, target);
        }

        private String genTarget(TreeMap<Character, Integer> target) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> characterIntegerEntry : target.entrySet()) {
                sb.append(genString(characterIntegerEntry.getKey(), characterIntegerEntry.getValue()));
            }
            return sb.toString();
        }

        private char[] genString(Character key, Integer value) {
            char[] chars = new char[value];
            for (int i = 0; i < value; i++) {
                chars[i] = key;
            }
            return chars;
        }

        private Map<String, Map<Character, Integer>> reduceSearchVolume(Map<String, Map<Character, Integer>> stickerDict, String target) {
            stickerDict = deepClone(stickerDict);
            Set<String> deleteKey = new HashSet<>();
            Set<Character> dict = new HashSet<>();
            for (char c : target.toCharArray()) {
                dict.add(c);
            }
            for (Map.Entry<String, Map<Character, Integer>> stringMapEntry : stickerDict.entrySet()) {
                boolean delete = true;
                Set<Character> deleteChars = new HashSet<>();
                for (Map.Entry<Character, Integer> entry : stringMapEntry.getValue().entrySet()) {
                    if (dict.contains(entry.getKey())) {
                        delete = false;
                    } else {
                        deleteChars.add(entry.getKey());
                    }
                }
                if (delete) {
                    deleteKey.add(stringMapEntry.getKey());
                    continue;
                }
                for (Character deleteChar : deleteChars) {
                    stringMapEntry.getValue().remove(deleteChar);
                }
            }
            for (String s : deleteKey) {
                stickerDict.remove(s);
            }
            return innerReduce(stickerDict);
        }

        private Map<String, Map<Character, Integer>> deepClone(Map<String, Map<Character, Integer>> stickerDict) {
            Map<String, Map<Character, Integer>> clone = new HashMap<>();
            for (Map.Entry<String, Map<Character, Integer>> entry : stickerDict.entrySet()) {
                clone.put(entry.getKey(), new HashMap<>(entry.getValue()));
            }
            return clone;
        }

        private Map<String, Map<Character, Integer>> innerReduce(Map<String, Map<Character, Integer>> stickerDict) {
            List<String> list = new ArrayList<>(stickerDict.keySet());
            int len = list.size();
            Set<String> deleteKeys = new HashSet<>();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (deleteKeys.contains(list.get(i)) || deleteKeys.contains(list.get(j))) {
                        continue;
                    }
                    int v = compareMap(stickerDict.get(list.get(i)), stickerDict.get(list.get(j)));
                    switch (v) {
                        case -1:
                            deleteKeys.add(list.get(i));
                            break;
                        case 1:
                            deleteKeys.add(list.get(j));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String deleteKey : deleteKeys) {
                stickerDict.remove(deleteKey);
            }
            return stickerDict;
        }

        private int compareMap(Map<Character, Integer> a, Map<Character, Integer> b) {
            if (a.keySet().size() < b.keySet().size()) {
                return -compareMap(b, a);
            }
            for (Map.Entry<Character, Integer> entry : b.entrySet()) {
                if (!a.containsKey(entry.getKey())) {
                    return 0;
                }
            }
            for (Map.Entry<Character, Integer> entry : a.entrySet()) {
                if (!b.containsKey(entry.getKey())) {
                    continue;
                }
                if (entry.getValue() < b.get(entry.getKey())) {
                    return 0;
                }
            }
            return 1;
        }


        private int searchMinOperation(Map<String, Map<Character, Integer>> stickerDict, String target) {
            if (target.length() == 0) {
                return 0;
            }
            stickerDict = reduceSearchVolume(stickerDict, target);
            char c = target.charAt(0);
            int ans = target.length();
            for (Map.Entry<String, Map<Character, Integer>> stringMapEntry : stickerDict.entrySet()) {
                if (stringMapEntry.getValue().containsKey(c)) {
                    ans = Math.min(ans, searchMinOperation(stickerDict, reduceTarget(stringMapEntry, target)) + 1);
                }
            }
            return ans;
        }

        private String reduceTarget(Map.Entry<String, Map<Character, Integer>> stringMapEntry, String target) {
            Map<Character, Integer> deleteMap = stringMapEntry.getValue();
            Map<Character, Integer> dict = new HashMap<>();
            for (char c : target.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for (Map.Entry<Character, Integer> characterIntegerEntry : dict.entrySet()) {
                int v = characterIntegerEntry.getValue();
                if (deleteMap.containsKey(characterIntegerEntry.getKey())) {
                    v = v - deleteMap.get(characterIntegerEntry.getKey());
                }
                if (v <= 0) {
                    continue;
                }
                treeMap.put(characterIntegerEntry.getKey(), v);
            }
            return genTarget(treeMap);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.minStickers(new String[]{"with", "example", "science"}, "thehat"));
//            Assert.assertEquals(-1, solution.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
        }

    }
}