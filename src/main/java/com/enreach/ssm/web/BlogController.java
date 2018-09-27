package com.enreach.ssm.web;

import com.enreach.ssm.bean.dto.ArticleDto;
import com.enreach.ssm.bean.vo.ArticleVO;
import com.enreach.ssm.infrastructure.BizException;
import com.enreach.ssm.infrastructure.PagedList;
import com.enreach.ssm.service.ArticleService;
import com.enreach.ssm.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
        session.setAttribute("title", "hello world");
        modelMap.addAttribute("message", "你好，世界");

        if (CheckUtil.isNotEmpty(request.getParameter("error"))) {
            throw new BizException("BizException");
        }

        return "blog/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PagedList<ArticleVO> list(int pageNum, @RequestParam(name = "pageSize", defaultValue = "20", required = false) int pageSize) {
        LOG.debug("p:" + pageNum + "; s:" + pageSize);
        return articleService.list(pageNum, pageSize);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody @Valid ArticleDto dto, BindingResult result) {
        LOG.debug(dto.toString());
        return articleService.add(dto);
    }


}
