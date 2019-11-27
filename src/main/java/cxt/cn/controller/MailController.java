package cxt.cn.controller;

import cxt.cn.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @Author:陈啸掭
 * @Description:
 * @Date:Create in 2019/11/13 18:51
 */
@Controller
public class MailController {
    @Autowired
    private MailServiceImpl mailServiceImpl;

    @PostMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String email, HttpSession session){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        session.setAttribute("MailCode",checkCode);
        try {
            mailServiceImpl.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }

}
