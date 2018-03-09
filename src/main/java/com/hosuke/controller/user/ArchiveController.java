package com.hosuke.controller.user;

import com.hosuke.model.dto.ArticleLiteDto;
import com.hosuke.service.ArticleService;
import com.hosuke.service.WebAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author Hosuke
 * 访客 归档页面
 */
@Controller
@RequestMapping("archive")
public class ArchiveController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebAppService webAppService;
     //显示归档页面
    @RequestMapping(method = RequestMethod.GET)
    public String archive(ModelMap model){
        List<ArticleLiteDto> articleLiteDtos = articleService.getArchive();
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));
        model.addAttribute("articles", articleLiteDtos);
        model.addAttribute("mainPage", "user/archive/detail.vm");
        return "index";
    }
}
