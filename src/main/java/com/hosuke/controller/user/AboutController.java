package com.hosuke.controller.user;

import com.hosuke.service.AboutService;
import com.hosuke.service.WebAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Hosuke
 * 访客About页面
 */
@Controller
public class AboutController {
    @Autowired
    private AboutService aboutService;
    @Autowired
    private WebAppService webAppService;

    //显示about页面
    @RequestMapping("/about")
    public String aboutPage(ModelMap model){
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));
        model.addAttribute("mainPage","user/about/about.vm");
        if(aboutService.list().size() > 0) {
            model.addAttribute("about", aboutService.getAbout(aboutService.list().get(0).getId()));
        }
        return "index";
    }
}
