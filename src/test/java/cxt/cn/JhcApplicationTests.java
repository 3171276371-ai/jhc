package cxt.cn;

import cxt.cn.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JhcApplicationTests {
    @Autowired
    MailServiceImpl mailSender;
    private String emailServiceCode;

    @Test
    public void test(){
        emailServiceCode = "1234";

        mailSender.sendSimpleMail("252705260@qq.com","注册验证码","注册验证码是："+emailServiceCode);
    }

}
