package com.hosuke.controller.admin;

import com.hosuke.model.About;
import com.hosuke.model.dto.UserDto;
import com.hosuke.service.AboutService;
import com.hosuke.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @Author Hosuke
 * 管理员 About页面
 */
@Controller
@RequestMapping("manage/about")
public class ManageAboutController {
    @Autowired
    private AboutService aboutService;

    //显示About页面
    @RequestMapping(method = RequestMethod.GET)
    public String showAbout(ModelMap model, HttpSession session){
        String path;
        //about表中 只有一条 信息 如果>0 则说明存在 关于的信息,那么跳转
        if(aboutService.count()>0){
            path="redirect:/manage/about/update";
        }else{
            model.addAttribute("user", (UserDto) session.getAttribute("currentUser"));
            model.addAttribute("mainPage","admin/about/editor.vm");
            path = "admin/index";
        }
        return path;
    }
    //显示更新About页面
    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String showUpdate(ModelMap model, HttpSession session){
        //因为数据库保持只有1个about记录超过了会出问题.
        if(aboutService.list().size()==1) {
            for (About about : aboutService.list()) {
                model.addAttribute("about",about);
            }
        }else{
            String error = "错误!关于页面太多!请到数据库中删除!";
            model.addAttribute("error",error);
        }
        model.addAttribute("mainPage","admin/about/editor.vm");
        model.addAttribute("user", (UserDto) session.getAttribute("currentUser"));
        return "admin/index";
    }

    //更新About操作
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String updateAction(ModelMap model, HttpSession session, About about){
        model.addAttribute("user", (UserDto) session.getAttribute("currentUser"));
        model.addAttribute("mainPage","admin/about/editor.vm");
        if (StringUtil.isNotEmpty(about.getMarkDown()) && StringUtil.isNotEmpty(about.getContent())) {
            //因为数据库保持只有1个about记录所以可以这样获取
            about.setId(aboutService.list().get(0).getId());
            aboutService.upDate(about);
            model.addAttribute("info","修改成功!");
        }else {
            model.addAttribute("info","修改失败,不能为空!");
        }
        return "admin/index";
    }
    //创建About操作
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String createAction(About about){
        if(StringUtil.isNotEmpty(about.getContent())&&StringUtil.isNotEmpty(about.getMarkDown())){
            aboutService.save(about);
        }
        return "redirect:/manage/about/update";
    }
}
