package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/9 15:04
 */
@RestController
public class web {


    @Resource
    private UserExamService userExamService;

    @RequestMapping("/e")
    public List<UserExam> l(){
        List<UserExam> query = userExamService.query(new HashMap());
        return query;
    }

    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody PagePram pageQuery) {
        return userExamService.findPage(pageQuery);
    }
}
