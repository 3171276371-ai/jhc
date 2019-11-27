package cxt.cn.service;

import java.io.File;
import java.util.List;

/**
 * @Author:陈啸掭
 * @Description:
 * @Date:Create in 2019/11/13 19:14
 */
public interface MailService {

    /**
     *普通文本邮件
     * @param to
     * @param title
     * @param content
     */
    void sendSimpleMail(String to,String title,String content);

    /**
     * 带附件的邮件
     * @param to
     * @param title
     * @param cotent
     * @param fileList
     */
    void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList);

    /**
     * HTML格式发送邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);
}
