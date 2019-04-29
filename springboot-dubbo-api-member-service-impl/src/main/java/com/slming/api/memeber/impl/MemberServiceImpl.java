package com.slming.api.memeber.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.slming.api.memeber.IMemberService;

/**
 * <br/>
 * <p> Project: springboot-dubbo-parent </p>
 * <p> Author: Leiming She </p>
 * <p> Date: 2019-04-29 10:00 </p>
 *
 * @author itslm
 */
@Service
public class MemberServiceImpl implements IMemberService {

    /**
     * 获取会员
     * <br/>
     * <p>Author: Leiming She</p>
     * <p>Date: 2019-04-29 10:05:36</p>
     *
     * @param username 用户名
     * @return java.lang.String
     */
    @Override
    public String getMember(String username) {
        return "Dubbo：" + username;
    }
}