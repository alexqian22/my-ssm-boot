package com.enreach.ssm.service;

import com.enreach.ssm.Application;
import com.enreach.ssm.bean.dto.ArticleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void add() {

        ArticleDto dto = new ArticleDto();
        dto.setTitle("第10篇");
        dto.setContext("内容信息");
        dto.setTags(new String[]{"jdbc", "spring"});
        dto.setCreator("lizhi");

        int id = articleService.add(dto);
        System.out.println(id);

    }

}
