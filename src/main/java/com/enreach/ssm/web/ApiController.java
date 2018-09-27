package com.enreach.ssm.web;

import com.enreach.ssm.bean.dto.ArticleDto;
import com.enreach.ssm.bean.vo.ArticleVO;
import com.enreach.ssm.infrastructure.PagedList;
import com.enreach.ssm.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public PagedList<ArticleVO> list(int pageNum, @RequestParam(name = "pageSize", defaultValue = "20", required = false) int pageSize) throws Exception {
        LOG.debug("p:" + pageNum + "; s:" + pageSize);

        if (pageNum > 10) {
            throw new Exception("模拟全局错误");
        }

        return articleService.list(pageNum, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody @Valid ArticleDto dto, BindingResult result) {
        LOG.debug(dto.toString());
        return articleService.add(dto);
    }

    @RequestMapping("/log")
    public String log() {

        LOG.debug("debug");
        LOG.info("info");
        LOG.warn("warn");
        LOG.error("error", new RuntimeException("RuntimeException"));

        return "success 成功";
    }

}
