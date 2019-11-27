package cxt.cn.controller;

import cxt.cn.config.MD5Utils;
import cxt.cn.domain.User;
import cxt.cn.service.userService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/6
 * @描述
 */
@Controller
public class userController {
    @Autowired
    private userService userService;


    /**
     * 用户登录验证
     * @param user
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping("login")
    public String login(User user, Map<String, Object> map, HttpSession httpSession) {
        User user1 = userService.findByUsernameAndPassWord(user.getUsername(),user.getPassword());
        if (user1 == null) {
            map.put("msg", "您的用户名或密码错误");
            return "login";
        } else {
            httpSession.setAttribute("username", user1.getUsername());
            httpSession.setAttribute("name", user1.getName());
            return "index";
        }
    }

    /**
     * 注册账号
     * @param user
     * @return
     */
    @RequestMapping("register")
    public ModelAndView save(User user,@Param("checkCode") String checkCode,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (checkCode.equals(session.getAttribute("MailCode"))){
            String passwords = MD5Utils.string2MD5(user.getPassword());
            user.setPassword(passwords);
            userService.save(user);
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.setViewName("register");
        modelAndView.addObject("error","您输入的邮箱验证码错误");
        return modelAndView;
    }


    /**
     * 查询更改的密码用户信息
     * @param name
     * @return modelAndView
     */
    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(@RequestParam(name = "name", required = true) String name) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByName(name);
        modelAndView.setViewName("updatePassword");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /**
     * 更改用户密码
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/update")
    public String update(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "password", required = true) String password) {
        userService.updatePassword(name, MD5Utils.string2MD5(password));
        return "index";
    }


}
