package cxt.cn.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import cxt.cn.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/7
 * @描述
 */
@Repository
public interface userDao extends BaseMapper<User> {
    @Select("select * from JhcManage.user where username = #{username} and password = #{password}")
    User findByUsernameAndPassWord(@Param("username") String username, @Param("password") String password);

    @Select("select * from JhcManage.user where name = #{name}")
    User findByName(String name);

    @Update("update JhcManage.user set password = #{password} where name = #{name} ")
    void updatePassword(@Param("name") String name, @Param("password") String password);
}
