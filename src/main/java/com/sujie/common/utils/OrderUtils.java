package com.sujie.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单相关工具类
 */
public class OrderUtils {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 随机生成订单号
     * yyyyMMddhhmmss+4位随机数
     *
     * @return 订单号
     */
    public static String getOrderId() {
        String orderId;
        Random random = new Random();
        int i = random.nextInt(10000);
        String time = SDF.format(new Date());
        orderId = time + i;
        return orderId;

    }
}
