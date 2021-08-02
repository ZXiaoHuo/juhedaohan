package com.zqh.juhedaohan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangqh
 * @date 2021/7/26 0026 10:19
 */
@Slf4j
@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "navigation";
    }

    @RequestMapping("/")
    public String index() {
        return "test";
    }

    @RequestMapping("/time")
    public String time() {
        return "component/demo2";
    }
}
