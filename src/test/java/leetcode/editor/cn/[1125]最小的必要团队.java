package leetcode.editor.cn;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1125 {
//作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员
// people[i] 含有一份该备选人员掌握的技能列表）。 
//
// 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。 
//
// 我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 p
//eople[3] 的备选人员。 
//
// 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。 
//
// 
//
// 示例 1： 
//
// 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["
//nodejs","reactjs"]]
//输出：[0,2]
// 
//
// 示例 2： 
//
// 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people
// = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp
//","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= req_skills.length <= 16 
// 1 <= people.length <= 60 
// 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16 
// req_skills 和 people[i] 中的元素分别各不相同 
// req_skills[i][j], people[i][j][k] 都由小写英文字母组成 
// 本题保证「必要团队」一定存在 
// 
// Related Topics 位运算 动态规划 
// 👍 46 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] smallestSufficientTeam(String[] nums, List<List<String>> links) {
            Map<String, Integer> dict = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                dict.put(nums[i], 1 << i);
            }
            int target = dict.values().stream().mapToInt(Integer::intValue).sum();
            int[][] people = new int[links.size()][2];
            for (int i = 0; i < links.size(); i++) {
                people[i][0] = links.get(i).stream().map(dict::get).mapToInt(Integer::intValue).sum();
                people[i][1] = i;
            }
            //请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
            Arrays.sort(people, (o1, o2) -> o2[0] - o1[0]);
            Set<Integer> set = new HashSet<>();
            List<int[]> waitSelect = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                if (i > 0) {
                    if (people[i][0] == people[i - 1][0]) {
                        continue;
                    }
                    if (exits(set, people[i][0])) {
                        continue;
                    }
                }
                set.add(people[i][0]);
                waitSelect.add(people[i]);
            }
            //先找出独一无二的人
            List<int[]> mustContain = new ArrayList<>();
            for (int i = 0; i < waitSelect.size(); i++) {
                boolean must = true;
                int curr = waitSelect.get(i)[0];
                for (int j = 0; j < waitSelect.size(); j++) {
                    if (i != j) {
                        if ((curr & waitSelect.get(j)[0]) != 0) {
                            must = false;
                            break;
                        }
                    }
                }
                if (must) {
                    mustContain.add(waitSelect.get(i));
                }
            }
            if (!mustContain.isEmpty()) {
                Set<Integer> filters = mustContain.stream().map(ints -> ints[0]).collect(Collectors.toSet());
                waitSelect = waitSelect.stream().filter(ints -> !filters.contains(ints[0])).collect(Collectors.toList());
            }

            Integer mustValue = mustContain.stream().map(ints -> ints[0]).reduce(0, (integer, integer2) -> integer | integer2);
            int need = mustValue ^ target;
            List<Integer> res = new ArrayList<>();
            int time = 1;
            if (need != 0) {
                while (res.isEmpty()) {
                    findResult(need, waitSelect, res, time, 0);
                    time++;
                }
            }

            res.addAll(mustContain.stream().map(new Function<int[], Integer>() {
                @Override
                public Integer apply(int[] ints) {
                    return ints[1];
                }
            }).collect(Collectors.toList()));
            return res.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        private boolean findResult(int target, List<int[]> selectPath, List<Integer> path, int time, int idx) {
            if (time == 0 && target == 0) {
                return true;
            }
            if (time == 0) {
                return false;
            }
            int n = selectPath.size();
            for (int i = idx; i < n; i++) {
                int[] curr = selectPath.get(i);
                path.add(curr[1]);
                if (findResult(target ^ (curr[0] & target), selectPath, path, time - 1, i)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
            return false;
        }

        private boolean exits(Set<Integer> set, int person) {
            for (Integer v : set) {
                if ((v & person) == person) {
                    return true;
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
            Assert.assertEquals("[0, 2]", Arrays.toString(solution.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                    Arrays.asList(
                            Collections.singletonList("java"),
                            Collections.singletonList("nodejs"),
                            Arrays.asList("nodejs", "reactjs")))));
//            Assert.assertEquals("[1, 2]", Arrays.toString(solution.smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"}, Arrays.asList(
//                    Arrays.asList("algorithms", "math", "java"),
//                    Arrays.asList("algorithms", "math", "reactjs"),
//                    Arrays.asList("java", "csharp", "aws"),
//                    Arrays.asList("reactjs", "csharp"),
//                    Arrays.asList("csharp", "math"),
//                    Arrays.asList("aws", "java")
//            ))));
        }
    }
}