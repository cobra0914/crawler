package com.cobra.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobra on 2016/6/1.
 */
public class ListCutter {
    public static List<List<?>> cut(List<?> target, int length) {
        List<List<?>> list = null;
        if (target != null || target.size() > 0) {
            list = new ArrayList<List<?>>();
            int count = target.size() / length;
            int mod = target.size() % length;
            for (int i = 0; i < length; i++) {
                List<?> subList = new ArrayList<>();
                if (i < length - 1) {
                    subList = target.subList(i * count, (i + 1) * count);
                } else {
                    subList = target.subList(i * count, (i + 1) * count + mod);
                }
                list.add(subList);
            }
        }
        return list;
    }


}
