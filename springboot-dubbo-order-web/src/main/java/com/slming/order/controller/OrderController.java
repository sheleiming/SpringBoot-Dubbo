package com.slming.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.slming.api.memeber.IMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itslm
 */
@RestController
public class OrderController {

    @Reference
    private IMemberService memberService;

    @GetMapping("getMember/{username}")
    public String getMember(@PathVariable("username") String username){
        return memberService.getMember(username);
    }
}
