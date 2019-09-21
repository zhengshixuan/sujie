package com.sujie.common.config;

public class Trans {
    /**
     * 代码转换,必须为1和2,若为其他则默认为0
     *
     * @param a
     * @return
     */
    public static Integer trans(Integer a) {
        if ("1".equals(a.toString())) {
            return 0;
        } else if ("2".equals(a.toString())) {
            return 1;
        }else {
            return 0;
        }
    }
}
