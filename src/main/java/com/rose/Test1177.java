package com.rose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2023/6/16 09:57
 *
 * @author lakers
 */
public class Test1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            if (query[0] == query[1]) {
                result.add(true);
                continue;
            }

            String substring = s.substring(query[0], query[1] + 1);
            char[] chars = substring.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
            int count = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                result.add(count / 2 <= query[2]);
            } else {
                result.add((count - 1) / 2 <= query[2]);
            }
        }

        return result;

    }
}
