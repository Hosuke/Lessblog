package com.hosuke.controller.user;

import com.hosuke.service.WebAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Hosuke
 * 访客留言页面 调用多说的API接口
 */
@Controller
@RequestMapping("/leave")
public class LeaveMsgController {
    @Autowired
    private WebAppService  webAppService;
    //显示留言页面
    @RequestMapping(method = RequestMethod.GET)
    public String leavePage(ModelMap model){
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));

        model.addAttribute("mainPage","user/leave/detail.vm");
        return "index";
    }
}
