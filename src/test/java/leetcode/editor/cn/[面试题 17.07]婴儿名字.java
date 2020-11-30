package leetcode.editor.cn;

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

        private static final int INIT_STATUS = -1;

        private int CURRENT_VALUE = 0;

        Map<String, Integer> positionCalc;

        Map<String, Integer> countDict;

        Map<String, String> synonymyDict;

        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            CURRENT_VALUE = 0;
            positionCalc = new LinkedHashMap<>();
            synonymyDict = new HashMap<>();
            countDict = new HashMap<>();
            for (String name : names) {
                String[] content = name.split("\\(");
                positionCalc.put(content[0], INIT_STATUS);
                countDict.put(content[0], Integer.parseInt(content[1].substring(0, content[1].length() - 1)));
            }
            Arrays.stream(synonyms).forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    String[] synonym = s.substring(1, s.length() - 1).split(",");
                    String first = synonym[0];
                    String second = synonym[1];
                    Integer firstPosition = positionCalc.get(first);
                    Integer secondPosition = positionCalc.get(second);
                    if (firstPosition == INIT_STATUS && secondPosition == INIT_STATUS) {
                        positionCalc.put(first, CURRENT_VALUE);
                        positionCalc.put(second, CURRENT_VALUE);
                        CURRENT_VALUE++;
                    } else {
                        Integer currPosition = firstPosition == INIT_STATUS ? secondPosition : firstPosition;
                        positionCalc.put(first, currPosition);
                        positionCalc.put(second, currPosition);
                    }
                }
            });
            for (Map.Entry<String, Integer> entry : positionCalc.entrySet()) {
                if (entry.getValue() == INIT_STATUS) {
                    positionCalc.put(entry.getKey(), CURRENT_VALUE);
                    CURRENT_VALUE++;
                }
            }
            for (int i = 0; i < CURRENT_VALUE; i++) {
                List<String> all = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : positionCalc.entrySet()) {
                    if (entry.getValue().equals(i)) {
                        all.add(entry.getKey());
                    }
                }
                String first = all.get(0);
                all.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                for (String name : all) {
                    synonymyDict.put(name, first);
                }
            }
            return countDict.entrySet().stream()
                    .collect(Collectors.groupingBy(entry -> synonymyDict.get(entry.getKey()),
                            Collectors.summingLong(Map.Entry::getValue))
                    )
                    .entrySet()
                    .stream()
                    .map(entry -> String.format("%s(%d)", entry.getKey(), entry.getValue()))
                    .toArray(String[]::new);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals("[Chris(36), John(27)]", ArrayUtils.toString(solution.trulyMostPopular(new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"}, new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"})));
//            Assert.assertEquals("[Gbkq(77), Nzaz(51), Qweye(110), Gauuk(75), Axwtno(57), Chycnm(4), Chhmx(259), Mtz(72), Koaak(53), Ijveol(46), Hfp(97), Jfq(26), Mwwvj(70), Ntfr(70), Bnea(179), Ffwni(169), Avcp(41), Obcbxb(124), Jvqg(47), Npilye(25), Fcclu(70), Qbmk(45), Gnplfi(109), Dwifi(237), Fpaf(219), Yeekgc(11), Ard(82), Weusps(79), Kgabb(236), Nekuam(17), Qyqifg(85), Alrksy(69), Avmzs(39), Acohsf(86), Ibink(32), Dhe(79), Qiy(26), Wpagta(25), Ebov(96), Onnev(77), Hljt(51), Gbclj(254), Yjc(94), Ofl(72), Wfmspz(39), Csh(213), Oltadg(95), Fvkhz(104), Okwuq(96), Unsb(26), Qxkjt(31), Hcvcgc(97), Uvkdpn(71), Aeax(82), Kufa(95), Nsgbth(26), Nuq(61), Ucqh(51), Dwayf(249), Dnsay(72), Naf(3), Mcnef(59), Drzsnw(87), Msyr(172), Kasgmw(95), Knpuq(61)]\n", ArrayUtils.toString(solution.trulyMostPopular(new String[]{"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)", "Wzyyim(34)", "Bnea(55)", "Kri(71)", "Qnaakk(76)", "Gnplfi(68)", "Hfp(97)", "Qoi(70)", "Ijveol(46)", "Iidh(64)", "Qiy(26)", "Mcnef(59)", "Hvueqc(91)", "Obcbxb(54)", "Dhe(79)", "Jfq(26)", "Uwjsu(41)", "Wfmspz(39)", "Ebov(96)", "Ofl(72)", "Uvkdpn(71)", "Avcp(41)", "Msyr(9)", "Pgfpma(95)", "Vbp(89)", "Koaak(53)", "Qyqifg(85)", "Dwayf(97)", "Oltadg(95)", "Mwwvj(70)", "Uxf(74)", "Qvjp(6)", "Grqrg(81)", "Naf(3)", "Xjjol(62)", "Ibink(32)", "Qxabri(41)", "Ucqh(51)", "Mtz(72)", "Aeax(82)", "Kxutz(5)", "Qweye(15)", "Ard(82)", "Chycnm(4)", "Hcvcgc(97)", "Knpuq(61)", "Yeekgc(11)", "Ntfr(70)", "Lucf(62)", "Uhsg(23)", "Csh(39)", "Txixz(87)", "Kgabb(80)", "Weusps(79)", "Nuq(61)", "Drzsnw(87)", "Xxmsn(98)", "Onnev(77)", "Owh(64)", "Fpaf(46)", "Hvia(6)", "Kufa(95)", "Chhmx(66)", "Avmzs(39)", "Okwuq(96)", "Hrschk(30)", "Ffwni(67)", "Wpagta(25)", "Npilye(14)", "Axwtno(57)", "Qxkjt(31)", "Dwifi(51)", "Kasgmw(95)", "Vgxj(11)", "Nsgbth(26)", "Nzaz(51)", "Owk(87)", "Yjc(94)", "Hljt(21)", "Jvqg(47)", "Alrksy(69)", "Tlv(95)", "Acohsf(86)", "Qejo(60)", "Gbclj(20)", "Nekuam(17)", "Meutux(64)", "Tuvzkd(85)", "Fvkhz(98)", "Rngl(12)", "Gbkq(77)", "Uzgx(65)", "Ghc(15)", "Qsc(48)", "Siv(47)"},
            Assert.assertEquals("", ArrayUtils.toString(solution.trulyMostPopular(new String[]{"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)", "Wzyyim(34)",
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
            //["Fcclu(70)","Dnsay(72)","Qbmk(45)","Unsb(26)","Gauuk(75)","Gnplfi(109)","Hfp(97)","Obcbxb(124)","Ijveol(46)","Fpaf(219)","Qiy(26)","Mcnef(59)","Dhe(79)","Jfq(26)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Chycnm(253)","Koaak(53)","Qyqifg(85)","Oltadg(95)","Mwwvj(70)","Naf(3)","Ibink(32)","Ucqh(51)","Mtz(72)","Ard(82)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Bnea(179)","Weusps(79)","Nuq(61)","Drzsnw(87)","Chhmx(259)","Onnev(77)","Kufa(95)","Avmzs(39)","Okwuq(96)","Hljt(51)","Npilye(25)","Axwtno(57)","Kasgmw(95)","Nsgbth(26)","Nzaz(51)","Msyr(211)","Yjc(94)","Jvqg(47)","Alrksy(69)","Aeax(646)","Acohsf(86)","Csh(238)","Nekuam(17)","Kgabb(236)","Fvkhz(104)","Gbkq(77)","Dwifi(237)"]
        }
    }
}