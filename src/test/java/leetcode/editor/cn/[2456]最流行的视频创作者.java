package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

class SolutionTest2456 {
//给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] 
//，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。 
//
// 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。 
//
// 
// 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。 
// 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。 
// 
//
// 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的
//视频 id 是 idi ，可以按任何顺序返回该结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three",
//"four"], views = [5,10,5,4]
//输出：[["alice","one"],["bob","two"]]
//解释：
//alice 的流行度是 5 + 5 = 10 。
//bob 的流行度是 10 。
//chris 的流行度是 4 。
//alice 和 bob 是流行度最高的创作者。
//bob 播放量最高的视频 id 为 "two" 。
//alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 
//"one" 。
// 
//
// 示例 2： 
//
// 
//输入：creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]
//输出：[["alice","b"]]
//解释：
//id 为 "b" 和 "c" 的视频都满足播放量最高的条件。
//由于 "b" 的字典序比 "c" 更小，所以结果中返回的 id 是 "b" 。
// 
//
// 
//
// 提示： 
//
// 
// n == creators.length == ids.length == views.length 
// 1 <= n <= 10⁵ 
// 1 <= creators[i].length, ids[i].length <= 5 
// creators[i] 和 ids[i] 仅由小写英文字母组成 
// 0 <= views[i] <= 10⁵ 
// 
//
// 👍 6 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Creator{
            private String name;

            private long sumViews;

            private TreeSet<View> views;

            private class View{
                private String id;
                private Integer view;

                public View(String id, Integer view) {
                    this.id = id;
                    this.view = view;
                }
            }

            public Creator(String name) {
                this.name = name;
                this.views = new TreeSet<>(new Comparator<View>() {
                    @Override
                    public int compare(View o1, View o2) {
                        if (o1.view.equals(o2.view)) {
                            return o1.id.compareTo(o2.id);
                        }
                        return o2.view - o1.view;
                    }
                });
            }

            public String topIds(){
                return views.first().id;
            }

            public void addView(String id,Integer view){
                this.views.add(new View(id,view));
                this.sumViews+=view;
            }
        }

        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
            int n = creators.length;
            Map<String, Creator> map = new HashMap<String, Creator>();
            for (int i = 0; i < n; i++) {
                String creator = creators[i];
                Creator current = map.getOrDefault(creator, new Creator(creator));
                current.addView(ids[i], views[i]);
                map.put(creator, current);
            }
            List<Creator> list = map.values().stream().sorted((o1, o2) -> (int) (o2.sumViews - o1.sumViews)).collect(Collectors.toList());
            List<List<String>> result = new ArrayList<>();
            long maxView = list.get(0).sumViews;
            for (Creator creator : list) {
                if (creator.sumViews != maxView) {
                    return result;
                }
                result.add(Arrays.asList(creator.name, creator.topIds()));
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[bob, two], [alice, one]]",solution.mostPopularCreator(new String[]{"alice","bob","alice","chris"},new String[]{"one","two","three","four"},new int[]{5,10,5,4}).toString());
            Assert.assertEquals("[[alice, b]]",solution.mostPopularCreator(new String[]{"alice","alice","alice"},new String[]{"a","b","c"},new int[]{1,2,2}).toString());
        }

    }
}