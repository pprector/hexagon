package com.project.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hkpeng
 * @date 2022/2/15 - 19:53
 */
@RestController
public class TestHttp {



    @GetMapping(value = "/")
    public String test(){
        return "http";
    }
}
