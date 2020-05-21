package jbit.web;

import jbit.pojo.DevUser;
import jbit.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("dev")
public class DevUserController {

    @Resource
    private DevUserService devUserService;

    @PostMapping("dologin")
    public String dologin(String devCode, String devPassword, HttpSession session, Model model){
        DevUser devUser = devUserService.queryByUser(devCode, devPassword);
        if (devUser != null){
            session.setAttribute("devUserSession",devUser);
            return "redirect:/developer/main.jsp";
        }
        model.addAttribute("error","输入的用户名或密码有误！");
        return "dologin";
    }


    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/devlogin.jsp";
    }


}
