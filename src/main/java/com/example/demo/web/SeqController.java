package com.example.demo.web;

import com.example.demo.SeqUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/22 16:45
 */
@RestController
@RequestMapping("/")
@Configuration
public class SeqController {

    @Resource
    private SeqUtil seqUtil;

    @RequestMapping("createTable")
    public void Seq(){
        seqUtil.init("AS",1,10,2);

    }
}
