package com.hosuke.controller;

import com.hosuke.model.WebApp;
import com.hosuke.service.ArticleService;
import com.hosuke.service.WebAppService;
import com.hosuke.utils.Pager;
import com.hosuke.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Hosuke
 * 网站首页 负责显示文章列表 分页数为4
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebAppService webAppService;

    //显示首页 分页文章列表
    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, ModelMap model, HttpServletRequest request) {
        String link = "index";
        if (webAppService.getWebAppDtos().size() == 0) {
            link = "redirect:/init";
        } else {
            Pager pager = new Pager(pageIndex, webAppService.getWebDtoWebApp(1).getUserPageArticleSize(), articleService.count());
            model.addAttribute("mainPage", "user/article/articlelist.vm");
            model.addAttribute("webAppDto", webAppService.getWebDtoWebApp(1));
            model.addAttribute("articles", articleService.getPageArticles(pager));
            model.addAttribute("pager", pager);
        }
        return link;
    }

    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String init(ModelMap model) {
        return "admin/init/init";
    }

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String initAction(ModelMap model, WebApp webApp) {
        String link = "redirect:/init";
        if (StringUtil.isNotEmpty(webApp.getWebName()) && StringUtil.isNotEmpty(webApp.getWebTitle())) {
            if (StringUtil.isNotEmpty(webApp.getAdminPageArticleSize().toString()) && StringUtil.isNotEmpty(webApp.getUserPageArticleSize().toString())) {
                webAppService.saveWebApp(webApp);
                link = "redirect:/";
            }
        }
        return link;
    }
}