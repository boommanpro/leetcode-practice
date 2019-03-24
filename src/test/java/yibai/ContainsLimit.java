package yibai;

public class ContainsLimit {

    /**
     * 题目的意思是 查看一条sql语句是否尾部可以追加 limit分页
     * @param args
     */

    public static void main(String[] args) {
        String[] strings = refTest(new String[]{"select * (limit 100)"});
        System.out.println(strings[0]);
    }

    public static String[] refTest(String [] cas){
        String[] result = new String[cas.length];
        for (int i = 0; i < cas.length; i++) {
            int limit = cas[i].lastIndexOf("limit");
            if (limit == -1) {
                result[i] = "yes";
                continue;
            }

            boolean flag = true;
            for (int j = limit+5; j < cas[i].length(); j++) {
                if (notDigitOrSpace(cas[i].charAt(j))){
                    result[i] = "yes";
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result[i] = "no";
            }
        }
        return result;
    }

    public static boolean notDigitOrSpace(char c) {
        return c != ' ' && (c < '0' || c > '9');
    }
}
