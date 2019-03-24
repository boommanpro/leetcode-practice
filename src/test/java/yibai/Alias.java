package yibai;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Alias {


    /**
     * 如果存在起别名
     */
    @Test
    public void alias(){
        String alias = getAlias(new String[]{"a","b","a","a"});

        System.out.println(alias);
    }

    public String getAlias(String[] parms) {
        Map<String, Integer> dict = new HashMap<>();
        String curr;
        for (int i = 0; i < parms.length; i++) {
            curr = parms[i];
            if (dict.containsKey(curr)) {
                parms[i] = curr + dict.get(curr);
                dict.put(curr, dict.get(curr) + 1);
            }else {
                dict.put(curr, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : parms) {
            sb.append(s).append(",");
        }
        return   sb.toString().substring(0,sb.length()-1);
    }
}
