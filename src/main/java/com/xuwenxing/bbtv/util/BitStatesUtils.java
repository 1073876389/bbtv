package com.xuwenxing.bbtv.util;

/**
 * 用户状态类，记录用户在平台使用系统中所有的状态。
 *
 * @author Administrator
 */
public class BitStatesUtils {
    public final static Long OP_BIND_PHONE = 1L << 0; // 用户绑定手机状态码
    public final static Long OP_BIND_EMAIL = 1L << 1; // 用户绑定邮箱状态码
    public final static Long OP_BASICINFO = 1L << 2;// 用户的个人资料状态码
    public final static Long OP_REALAUTH = 1L << 3;//用户的实名身份认证状态码
    public final static Long OP_VEDIOAUTH = 1L << 4;//用户的视频认证状态码;
    public final static Long HAS_BIDREQUEST_PROCESS = 1L << 5;//用户是否已经借款的状态码;
    /**
     * @param states 所有状态值
     * @param value  需要判断状态值
     * @return 是否存在
     */
    public static boolean hasState(long states, long value) {
        return (states & value) != 0;
    }

    /**
     * @param states 已有状态值
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static long addState(long states, long value) {
        if (hasState(states, value)) {
            return states;
        }
        return (states | value);
    }

    /**
     * @param states 已有状态值
     * @param value  需要删除状态值
     * @return 新的状态值
     */
    public static long removeState(long states, long value) {
        if (!hasState(states, value)) {
            return states;
        }
        return states ^ value;
    }
}
