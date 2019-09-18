package com.sujie.common.config;

public class Trans {
    /**
     * 代码转换
     *
     * @param a
     * @return
     */
    public static Integer trans(Integer a) {
        if ("1".equals(a.toString())) {
            return 0;
        } else if ("2".equals(a.toString())) {
            return 1;
        }
        return a;
    }
}
