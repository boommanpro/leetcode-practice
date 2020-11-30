package leetcode.editor.cn;

import java.time.Year;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_07 {
//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成
//了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 
//是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。 
//
// 在结果列表中，选择字典序最小的名字作为真实名字。 
//
// 示例： 
//
// 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], sy
//nonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//输出：["John(27)","Chris(36)"] 
//
// 提示： 
//
// 
// names.length <= 100000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 22 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] parents;

        Map<String, Integer> nameId;

        Map<Integer, String> idName;

        Map<String, Integer> frequency;

        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            int len = names.length;
            parents = new int[len];
            nameId = new HashMap<>();
            idName = new HashMap<>();
            frequency = new HashMap<>();

            for (int i = 0; i < len; i++) {
                parents[i] = i;
                String[] content = names[i].split("\\(");
                String name = content[0];
                Integer count = Integer.parseInt(content[1].substring(0, content[1].length() - 1));
                nameId.put(name, i);
                idName.put(i, name);
                frequency.put(name, count);
            }
            for (String synonym : synonyms) {
                String[] pair = synonym.substring(1, synonym.length() - 1).split(",");
                String first = pair[0];
                String second = pair[1];
                Integer firstId = nameId.get(first);
                Integer secondId = nameId.get(second);
                if (firstId == null || secondId == null) {
                    continue;
                }
                union(firstId, secondId);
            }
            return frequency.entrySet()
                    .stream()
                    .map(e -> String.format("%s(%d)", e.getKey(), e.getValue()))
                    .toArray(String[]::new);
        }

        private void union(int a, int b) {
            if (a == b) {
                return;
            }
            int pa = findParent(a);
            int pb = findParent(b);
            if (pa == pb) {
                return;
            }
            String name1 = idName.get(pa);
            String name2 = idName.get(pb);
            if (name1.compareTo(name2) < 0) {
                frequency.put(name1, frequency.get(name1) + frequency.get(name2));
                parents[pb] = pa;
                frequency.remove(name2);
                return;
            }
            frequency.put(name2, frequency.get(name1) + frequency.get(name2));
            parents[pa] = pb;
            frequency.remove(name1);
        }

        private int findParent(int x) {
            if (parents[x] == x) {
                return x;
            }
            parents[x] = findParent(parents[x]);
            return parents[x];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[Chris(36), John(27)]", ArrayUtils.toString(solution.trulyMostPopular(new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"}, new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"})));

            Assert.assertEquals("[Nzaz(51), Chycnm(253), Hfp(97), Ijveol(46), Koaak(53), Mwwvj(70), Bnea(179), Ntfr(70), Npilye(25), Fcclu(70), Gnplfi(109), Ard(82), Kgabb(236), Weusps(79), Qyqifg(85), Alrksy(69), Avmzs(39), Ibink(32), Qiy(26), Dhe(79), Ebov(96), Hljt(51), Yjc(94), Ofl(72), Okwuq(96), Hcvcgc(97), Aeax(646), Nsgbth(26), Nuq(61), Ucqh(51), Mcnef(59), Msyr(211), Gbkq(77), Gauuk(75), Axwtno(57), Chhmx(259), Mtz(72), Jfq(26), Avcp(41), Obcbxb(124), Jvqg(47), Qbmk(45), Dwifi(237), Fpaf(219), Yeekgc(11), Nekuam(17), Acohsf(86), Onnev(77), Csh(238), Oltadg(95), Fvkhz(104), Unsb(26), Uvkdpn(71), Kufa(95), Dnsay(72), Naf(3), Drzsnw(87), Kasgmw(95), Knpuq(61)]",
                    ArrayUtils.toString(solution.trulyMostPopular(
                            new String[]{"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)", "Wzyyim(34)",
                                    "Bnea(55)", "Kri(71)", "Qnaakk(76)", "Gnplfi(68)", "Hfp(97)", "Qoi(70)", "Ijveol(46)", "Iidh(64)", "Qiy(26)", "Mcnef(59)", "Hvueqc(91)", "Obcbxb(54)", "Dhe(79)",
                                    "Jfq(26)", "Uwjsu(41)", "Wfmspz(39)", "Ebov(96)", "Ofl(72)", "Uvkdpn(71)", "Avcp(41)", "Msyr(9)", "Pgfpma(95)", "Vbp(89)", "Koaak(53)", "Qyqifg(85)", "Dwayf(97)",
                                    "Oltadg(95)", "Mwwvj(70)", "Uxf(74)", "Qvjp(6)", "Grqrg(81)", "Naf(3)", "Xjjol(62)", "Ibink(32)", "Qxabri(41)", "Ucqh(51)", "Mtz(72)", "Aeax(82)", "Kxutz(5)",
                                    "Qweye(15)", "Ard(82)", "Chycnm(4)", "Hcvcgc(97)", "Knpuq(61)", "Yeekgc(11)", "Ntfr(70)", "Lucf(62)", "Uhsg(23)", "Csh(39)", "Txixz(87)", "Kgabb(80)", "Weusps(79)",
                                    "Nuq(61)", "Drzsnw(87)", "Xxmsn(98)", "Onnev(77)", "Owh(64)", "Fpaf(46)", "Hvia(6)", "Kufa(95)", "Chhmx(66)", "Avmzs(39)", "Okwuq(96)", "Hrschk(30)", "Ffwni(67)",
                                    "Wpagta(25)", "Npilye(14)", "Axwtno(57)", "Qxkjt(31)", "Dwifi(51)", "Kasgmw(95)", "Vgxj(11)", "Nsgbth(26)", "Nzaz(51)", "Owk(87)", "Yjc(94)", "Hljt(21)", "Jvqg(47)",
                                    "Alrksy(69)", "Tlv(95)", "Acohsf(86)", "Qejo(60)", "Gbclj(20)", "Nekuam(17)", "Meutux(64)", "Tuvzkd(85)", "Fvkhz(98)", "Rngl(12)", "Gbkq(77)", "Uzgx(65)", "Ghc(15)", "Qsc(48)", "Siv(47)"},
                            new String[]{"(Gnplfi,Qxabri)", "(Uzgx,Siv)", "(Bnea,Lucf)", "(Qnaakk,Msyr)", "(Grqrg,Gbclj)", "(Uhsg,Qejo)", "(Csh,Wpagta)", "(Xjjol,Lucf)", "(Qoi,Obcbxb)", "(Npilye,Vgxj)",
                                    "(Aeax,Ghc)", "(Txixz,Ffwni)", "(Qweye,Qsc)", "(Kri,Tuvzkd)", "(Ommjh,Vbp)", "(Pgfpma,Xxmsn)", "(Uhsg,Csh)", "(Qvjp,Kxutz)", "(Qxkjt,Tlv)", "(Wfmspz,Owk)", "(Dwayf,Chycnm)",
                                    "(Iidh,Qvjp)", "(Dnsay,Rngl)", "(Qweye,Tlv)", "(Wzyyim,Kxutz)", "(Hvueqc,Qejo)", "(Tlv,Ghc)", "(Hvia,Fvkhz)", "(Msyr,Owk)", "(Hrschk,Hljt)", "(Owh,Gbclj)", "(Dwifi,Uzgx)",
                                    "(Iidh,Fpaf)", "(Iidh,Meutux)", "(Txixz,Ghc)", "(Gbclj,Qsc)", "(Kgabb,Tuvzkd)", "(Uwjsu,Grqrg)", "(Vbp,Dwayf)", "(Xxmsn,Chhmx)", "(Uxf,Uzgx)"})));
        }
    }
}