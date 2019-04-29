package com.slming.api.memeber;

/**
 * <br/>
 * <p> Project: springboot-dubbo-parent </p>
 * <p> Author: Leiming She </p>
 * <p> Date: 2019-04-29 10:00 </p>
 *
 * @author itslm
 */
public interface IMemberService {

    /**
     * 获取会员
     * <br/>
     * <p>Author: Leiming She</p>
     * <p>Date: 2019-04-29 10:05:36</p>
     *
     * @param username 用户名
     * @return java.lang.String
     */
    String getMember(String username);
}
