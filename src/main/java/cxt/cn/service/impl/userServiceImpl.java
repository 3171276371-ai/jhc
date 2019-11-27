package cxt.cn.service.impl;

import cxt.cn.config.MD5Utils;
import cxt.cn.dao.userDao;
import cxt.cn.domain.User;
import cxt.cn.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/7
 * @描述
 */
@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDao userDao;

    @Override
    public User findByUsernameAndPassWord(String username, String password) {
        String password2 = MD5Utils.string2MD5(password);
        return userDao.findByUsernameAndPassWord(username,password2);
    }

    @Override
    public void save(User user) {
        userDao.insert(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public void updatePassword(String name,String password) {
        userDao.updatePassword(name,password);
    }
}
