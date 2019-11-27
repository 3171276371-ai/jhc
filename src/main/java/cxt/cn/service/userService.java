package cxt.cn.service;

import cxt.cn.domain.User;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/7
 * @描述
 */

public interface userService {
    /**
     * 根据用户名密码查找是否存在
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassWord(String username, String password);

    /**
     * 保存账户
     * @param user
     */
    void save(User user);

    /**
     * 根据姓名查找
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 更改密码
     * @param name
     * @param password
     */
    void updatePassword(String name,String password);
}
