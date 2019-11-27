package cxt.cn.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/7
 * @描述
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("username");
        if (user == null || user.equals(""))  {
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

}
