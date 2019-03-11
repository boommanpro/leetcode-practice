package hashTable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode30Test {
    @Test
    public void leetcode30Test() {

        //     Input:
        //       s = "barfoothefoobarman",
        //       words = ["foo","bar"]
        //     Output: [0,9]
        //     Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
        //     The output order does not matter, returning [9,0] is fine too.


        //    "wordgoodgoodgoodbestword"

        //    "word","good","best","word"

        //   []


        //    "barfoofoobarthefoobarman"


        //
        //   ["bar","foo","the"]

        //   [6,9,12]


        //   "wordgoodgoodgoodbestword"
        //    ["word","good","best","good"]

        //    [8]


        //   "lingmindraboofooowingdingbarrwingmonkeypoundcake"
        //   ["fooo","barr","wing","ding","wing"]

        //   [13]


        List<Integer> barfoothefoobarman = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"});

        System.out.println(String.format("result:%s", barfoothefoobarman));
    }


//


    public List<Integer> findSubstring(String s, String[] words) {
        // 结果list
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        //统计
        Map<String, Integer> dictMap = new HashMap<>();
        for (String word : words) {
            dictMap.put(word, dictMap.getOrDefault(word, 0) + 1);
        }

        int length = words[0].length();

        for (int i = 0; i < length; ++i) {
            //slider window
            Map<String, Integer> window = new HashMap<>();
            int left = i;
            int right = i;
            while (right <= s.length() - length && left <= s.length() - length * words.length) {
                String word = s.substring(right, right + length);
                window.put(word, window.getOrDefault(word, 0) + 1);
                //如果window不包含这个单词 因为要求是连续的,需要清空
                if (!dictMap.containsKey(word)) {
                    window.clear();
                    right += length;
                    left = right;
                    continue;
                }
                while (window.get(word) > dictMap.get(word)) {
                    String leftWord = s.substring(left, left + length);

                    window.put(leftWord, window.get(leftWord) - 1);
                    left += length;
                }
                right += length;
                if (right - left == length * words.length) {
                    result.add(left);
                }
            }
        }
        return result;
    }


}
